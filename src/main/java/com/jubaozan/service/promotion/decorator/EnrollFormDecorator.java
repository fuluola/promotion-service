package com.jubaozan.service.promotion.decorator;

import com.jubaozan.service.promotion.constants.PromotionConstants;
import com.jubaozan.service.promotion.model.*;
import com.jubaozan.service.promotion.repository.mybatis.mapper.*;
import com.jubaozan.service.promotion.vo.PageData;
import com.jubaozan.service.promotion.vo.form.EnrollCustomerAnswerVO;
import com.jubaozan.service.promotion.vo.form.EnrollFormListVO;
import com.jubaozan.service.promotion.vo.form.EnrollFormVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class EnrollFormDecorator {

    @Autowired
    PromotionChoiceOptionMapper promotionChoiceOptionMapper;

    @Autowired
    PromotionEnrollFormMapper promotionEnrollFormMapper;

    @Autowired
    PromotionFormQuestionMapper promotionFormQuestionMapper;

    @Autowired
    PromotionEnrollCustomerInfoMapper promotionEnrollCustomerInfoMapper;

    @Autowired
    PromotionCustomerAnswerMapper promotionCustomerAnswerMapper;

    /**
     * 保存表单及题目信息
     * @param formVO
     */
    @Transactional
    public void saveEnrollForm(EnrollFormVO formVO){

        PromotionEnrollFormEntity formEntity = new PromotionEnrollFormEntity();
        BeanUtils.copyProperties(formVO,formEntity);
        formEntity.setStatus(PromotionConstants.EnrollFormStatus.UNUSED);
        promotionEnrollFormMapper.insertPromotionEnrollForm(formEntity);

        List<PromotionFormQuestionEntity> questionList = formVO.getQuestionList();
        if(questionList!=null && !questionList.isEmpty()){
            for(PromotionFormQuestionEntity questionEntity:questionList){

                questionEntity.setSjid(formVO.getSjid());
                questionEntity.setFormId(formEntity.getId());
                promotionFormQuestionMapper.insertPromotionFormQuestion(questionEntity);
                List<PromotionChoiceOptionEntity> optionList = questionEntity.getChoiceOptionList();
                if(optionList==null || optionList.isEmpty()){
                    continue;
                }
                for(PromotionChoiceOptionEntity optionEntity:optionList){
                    if(StringUtils.isEmpty(optionEntity.getChoiceOption()))
                        continue;
                    optionEntity.setSjid(formVO.getSjid());
                    optionEntity.setFormId(formEntity.getId());
                    optionEntity.setQuestionId(questionEntity.getId());
                    promotionChoiceOptionMapper.insertPromotionChoiceOption(optionEntity);
                }
            }
        }
    }

    /**
     * 分页查询表单数据
     * @param sjid
     * @param pageSize
     * @param pageNo
     * @param title
     * @return
     */
    public PageData<EnrollFormListVO> pageQueryEnrollList(Integer sjid, int pageSize, int pageNo, String title){

        int totalCount = promotionEnrollFormMapper.findCountByCondition(sjid,title);
        Integer start = (pageNo-1)*pageSize;
        Integer offset = pageSize;
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("start",start);
        paramMap.put("offset",offset);
        paramMap.put("sjid",sjid);
        paramMap.put("title",title);
        List<EnrollFormListVO> datas = promotionEnrollFormMapper.findPromotionEnrollFormByCondition(paramMap);
        if(!datas.isEmpty()){
            for(EnrollFormListVO formListVO:datas){
                int enrollNum = promotionEnrollCustomerInfoMapper.countEnrollNumByFormId(sjid,formListVO.getId());
                formListVO.setEnrollCustomerNum(enrollNum);
                boolean isActive0 = formListVO.getStartTime()!=null && formListVO.getStartTime().isBefore(LocalDateTime.now());
                boolean isActive1 = formListVO.getEndTime()!=null && formListVO.getEndTime().isAfter(LocalDateTime.now());
                boolean isActive2 = formListVO.getEndTime().isBefore(LocalDateTime.now());
                if(isActive0&&isActive1){
                    formListVO.setStatus(PromotionConstants.EnrollFormStatus.ACTIVE);
                }else if(isActive2){
                    formListVO.setStatus(PromotionConstants.EnrollFormStatus.DELETED);
                }
            }
        }

        PageData<EnrollFormListVO> dataResult = new PageData<>();
        dataResult.setCurrentPage(pageNo);
        dataResult.setDatas(datas);
        dataResult.setPageSize(pageSize);
        dataResult.setTotalCount(totalCount);
        int totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        dataResult.setTotalPage(totalPage);
        return dataResult;
    }

    public EnrollFormVO getWholeEnrollForm(Long formId){

        List<Long> ids = new ArrayList<>();
        ids.add(formId);
        EnrollFormVO formVO = promotionEnrollFormMapper.findPromotionEnrollFormByIds(ids);
        if(formVO!=null){
            Map<String,Object> map = new HashMap<>();
            map.put("formId",formVO.getId());
            List<PromotionFormQuestionEntity> questionList = promotionFormQuestionMapper.findPromotionFormQuestionByCondition(map);
            if(questionList.isEmpty()){
                return formVO;
            }
            for(PromotionFormQuestionEntity question:questionList){

                if(PromotionConstants.QuestionType.FILL_IN_BLANK.equals(question.getQuestionType())) continue;
                map.put("questionId",question.getId());
                List<PromotionChoiceOptionEntity> optionList = promotionChoiceOptionMapper.findPromotionChoiceOptionByCondition(map);
                question.setChoiceOptionList(optionList);
            }
            formVO.setQuestionList(questionList);
            return formVO;
        }
        return null;
    }

    @Transactional
    public void editEnrollForm(EnrollFormVO formVO){

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",formVO.getId());
        paramMap.put("title",formVO.getTitle());
        paramMap.put("description",formVO.getDescription());
        paramMap.put("startTime",formVO.getStartTime());
        paramMap.put("endTime",formVO.getEndTime());
        paramMap.put("jumpUrl",formVO.getJumpUrl());
        paramMap.put("imageTop",formVO.getImageTop());
        paramMap.put("imageBottom",formVO.getImageBottom());
        promotionEnrollFormMapper.updatePromotionEnrollForm(paramMap);

        for(PromotionFormQuestionEntity question:formVO.getQuestionList()){
            paramMap.clear();
            if(question.getId()==null || question.getId()==0){
                question.setFormId(formVO.getId());
                question.setSjid(formVO.getSjid());
                promotionFormQuestionMapper.insertPromotionFormQuestion(question);
            }else {
                paramMap.put("id",question.getId());
                paramMap.put("questionTitle",question.getQuestionTitle());
                promotionFormQuestionMapper.updatePromotionFormQuestion(paramMap);
            }
            paramMap.put("id",question.getId());
            paramMap.put("questionTitle",question.getQuestionTitle());
            promotionFormQuestionMapper.updatePromotionFormQuestion(paramMap);

            if(PromotionConstants.QuestionType.CHOICE.equals(question.getQuestionType())) {
                editQuestionOption(formVO, paramMap, question);
            }
        }
    }

    /**
     * 更新选择题选项，有三种情况，1 修改 2 新增 3 删除
     * 循环对比原数据库选择项和修改后提交的选择项
     * @param formVO
     * @param paramMap
     * @param question
     */
    private void editQuestionOption(EnrollFormVO formVO, Map<String, Object> paramMap, PromotionFormQuestionEntity question) {

            paramMap.clear();
            paramMap.put("formId",formVO.getId());
            paramMap.put("questionId",question.getId());
            List<PromotionChoiceOptionEntity> originOptions = promotionChoiceOptionMapper.findPromotionChoiceOptionByCondition(paramMap);
            List<PromotionChoiceOptionEntity> optionList = question.getChoiceOptionList();
            if(optionList==null || optionList.isEmpty()){
                return;
            }

            for(PromotionChoiceOptionEntity optionEntity:optionList){
                Iterator<PromotionChoiceOptionEntity> iterator = originOptions.iterator();
                while (iterator.hasNext()){
                    PromotionChoiceOptionEntity originOption = iterator.next();
                    if(originOption.getId().equals(optionEntity.getId())){
                        iterator.remove();
                    }
                }
                paramMap.clear();
                paramMap.put("choiceOption",optionEntity.getChoiceOption());
                if(optionEntity.getId()!=null&& StringUtils.isNotEmpty(optionEntity.getChoiceOption())){
                    paramMap.put("id",optionEntity.getId());
                    promotionChoiceOptionMapper.updatePromotionChoiceOption(paramMap);
                }else if(optionEntity.getId()==null && StringUtils.isNotEmpty(optionEntity.getChoiceOption())){
                    optionEntity.setSjid(formVO.getSjid());
                    optionEntity.setFormId(formVO.getId());
                    optionEntity.setQuestionId(question.getId());
                    promotionChoiceOptionMapper.insertPromotionChoiceOption(optionEntity);
                }
            }
            if(!originOptions.isEmpty()){
                for(PromotionChoiceOptionEntity optionEntity:originOptions){
                    promotionChoiceOptionMapper.deletePromotionChoiceOptionById(optionEntity.getId());
                }
            }
    }

    /**
     * 客户提交表单数据
     * @param customerInfo
     */
    @Transactional
    public String customerCommitForm(PromotionEnrollCustomerInfoEntity customerInfo) {

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("sjid",customerInfo.getSjid());
        paramMap.put("formId",customerInfo.getFormId());
        paramMap.put("customerNo",customerInfo.getCustomerNo());
        List<PromotionEnrollCustomerInfoEntity> customerList = promotionEnrollCustomerInfoMapper.findPromotionEnrollCustomerInfoByCondition(paramMap);
        if(!customerList.isEmpty()) return "EXIST";
        promotionEnrollCustomerInfoMapper.insertPromotionEnrollCustomerInfo(customerInfo);

        for(PromotionCustomerAnswerEntity answer:customerInfo.getAnswerEntityList()){

            answer.setFormId(customerInfo.getFormId());
            answer.setCustomerNo(customerInfo.getCustomerNo());
            answer.setSjid(customerInfo.getSjid());
            promotionCustomerAnswerMapper.insertPromotionCustomerAnswer(answer);
        }
        return "SUCCESS";
    }

    /**
     * 分页查询客户及客户答题数据
     * @param pageNo
     * @param pageSize
     * @param paramMap
     * @return
     */
    public PageData<PromotionEnrollCustomerInfoEntity> pageQueryEnrollCustomer(Integer pageNo, Integer pageSize, Map<String, Object> paramMap) {

        PageData<PromotionEnrollCustomerInfoEntity> pageData = new PageData<>();
        int totalCount = promotionEnrollCustomerInfoMapper.countEnrollCustomerInfo(paramMap);
        Integer start = (pageNo-1)*pageSize;
        Integer offset = pageSize;
        paramMap.put("start",start);
        paramMap.put("offset",offset);

        List<PromotionEnrollCustomerInfoEntity> customerInfoList = promotionEnrollCustomerInfoMapper.pageQueryEnrollCustomerInfo(paramMap);
        if(!customerInfoList.isEmpty()){
//            List<PromotionEnrollCustomerInfoVO> customerInfoVOList = new ArrayList<>();
            for(PromotionEnrollCustomerInfoEntity customerInfoEntity:customerInfoList){
                paramMap.clear();
                paramMap.put("formId",customerInfoEntity.getFormId());
                paramMap.put("customerNo",customerInfoEntity.getCustomerNo());
                List<EnrollCustomerAnswerVO> questionAnswers = promotionFormQuestionMapper.queryFormQuestionAnswerByCustomerNo(paramMap);
                for(EnrollCustomerAnswerVO customerAnswerVO:questionAnswers){
                    if(PromotionConstants.QuestionType.FILL_IN_BLANK.equals(customerAnswerVO.getQuestionType())
                            || StringUtils.isBlank(customerAnswerVO.getAnswer()))
                        continue;
                    List<Long> ids = new ArrayList<>();
                    ids.add(Long.parseLong(customerAnswerVO.getAnswer()));
                    PromotionChoiceOptionEntity choiceOptionEntity = promotionChoiceOptionMapper.findPromotionChoiceOptionByIds(ids);
                    customerAnswerVO.setAnswer(choiceOptionEntity.getChoiceOption());
                }
                customerInfoEntity.setQuestionList(questionAnswers);
            }
        }
        pageData.setCurrentPage(pageNo);
        pageData.setDatas(customerInfoList);
        pageData.setPageSize(pageSize);
        pageData.setTotalCount(totalCount);
        int totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        pageData.setTotalPage(totalPage);
        return pageData;
    }
}
