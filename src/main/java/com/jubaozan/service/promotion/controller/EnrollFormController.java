package com.jubaozan.service.promotion.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.c3.weixin.api.IWeixinCache;
import com.jubaozan.c3.framework.constants.Constants;
import com.jubaozan.c3.framework.utils.ResultHolder;
import com.jubaozan.modules.feign.shortlinks.ShortLinksFeignService;
import com.jubaozan.service.promotion.api.ApiBeikeResponse;
import com.jubaozan.service.promotion.api.BeikeDataSyncService;
import com.jubaozan.service.promotion.constants.PromotionConstants;
import com.jubaozan.service.promotion.decorator.EnrollFormDecorator;
import com.jubaozan.service.promotion.model.PromotionEnrollCustomerInfoEntity;
import com.jubaozan.service.promotion.model.PromotionFormQuestionEntity;
import com.jubaozan.service.promotion.vo.PageData;
import com.jubaozan.service.promotion.vo.form.EnrollCustomerListVO;
import com.jubaozan.service.promotion.vo.form.EnrollFormListVO;
import com.jubaozan.service.promotion.vo.form.EnrollFormVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "分享表单Controller")
@RequestMapping("/enroll")
public class EnrollFormController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(EnrollFormController.class);
    @Autowired
    EnrollFormDecorator enrollFormDecorator;

    @Autowired
    ShortLinksFeignService shortLinksFeignService;
    
    @Reference(check = false, version = "1.0", group = "weixin")
    IWeixinCache iweixinCache;

    @Autowired
    BeikeDataSyncService beikeDataSyncService;
    
    @ApiOperation(value = "分享表单列表")
    @GetMapping(value="listForm")
    public ResultHolder<PageData<EnrollFormListVO>> listEnrollForm(@RequestHeader(Constants.KEY_X_C3_SJID) Long sjid,
                                         Integer pageSize, Integer pageNo, String formName){

        if(pageNo==null || pageNo<=0) pageNo = 1;
        if(pageSize==null || pageSize<=0) pageSize = 10;
        PageData<EnrollFormListVO> pageData = enrollFormDecorator.pageQueryEnrollList(sjid.intValue(),pageSize,pageNo,formName);
        return ResultHolder.success(pageData);
    }

    @ApiOperation(value = "保存分享表单")
    @PostMapping(value="saveForm")
    public ResultHolder<Object> saveEnrollForm(@RequestHeader(Constants.KEY_X_C3_SJID) Long sjid,
                                               @RequestBody EnrollFormVO enrollVO){

        log.info("新增表单请求参数sjid={},requestBody={}",sjid,enrollVO);
        String errorMsg = checkSaveEnrollForm(enrollVO);
        if(errorMsg!=null)
            return ResultHolder.error(1004,errorMsg);
        enrollVO.setSjid(sjid.intValue());
        enrollFormDecorator.saveEnrollForm(enrollVO);
        return ResultHolder.success("");
    }


    @ApiOperation(value = "编辑分享表单")
    @PostMapping(value="editForm")
    public ResultHolder<Object> editEnrollForm(@RequestHeader(Constants.KEY_X_C3_SJID) Integer sjid,
                                               @RequestBody EnrollFormVO enrollVO){

        log.info("编辑表单请求参数sjid={},requestBody={}",sjid,enrollVO);
        String errorMsg = checkEditEnrollForm(enrollVO);
        if(errorMsg!=null)
            return ResultHolder.error(1004,errorMsg);
        enrollVO.setSjid(sjid);
        enrollFormDecorator.editEnrollForm(enrollVO);
        return ResultHolder.success("");
    }

    @ApiOperation(value = "查询分享表单")
    @GetMapping(value="getForm")
    public ResultHolder<EnrollFormVO> getEnrollForm(@RequestHeader(Constants.KEY_X_C3_SJID) Long sjid,
                                               Long formId){

        if(formId==null || formId<=0){
            return ResultHolder.error(2003,"请求参数为空");
        }
        EnrollFormVO formVO = enrollFormDecorator.getWholeEnrollForm(formId);
        if(formVO==null){
            return ResultHolder.error(1002,"没有数据");
        }
        return ResultHolder.success(formVO);
    }

    @ApiOperation(value = "客户数据列表")
    @PostMapping(value="customerInfoList")
    public ResultHolder<PageData<PromotionEnrollCustomerInfoEntity>> listCustomerInfo(@RequestHeader(Constants.KEY_X_C3_SJID) Integer sjid,
                                                                                      @RequestBody EnrollCustomerListVO customerListVO){
        Integer pageNo = customerListVO.getPageNo();
        Integer pageSize = customerListVO.getPageSize();
        if(pageNo==null || pageNo<=0) customerListVO.setPageNo(1);
        if(pageSize==null || pageSize<=0) customerListVO.setPageSize(10);

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("formId",customerListVO.getFormId());
        paramMap.put("sjid",sjid);
        paramMap.put("startEnrollTime",customerListVO.getStartEnrollTime());
        paramMap.put("endEnrollTime",customerListVO.getEndEnrollTime());
        PageData<PromotionEnrollCustomerInfoEntity> pageData = enrollFormDecorator.pageQueryEnrollCustomer(customerListVO.getPageNo(),customerListVO.getPageSize(),paramMap);
        return ResultHolder.success(pageData);
    }

    /**
     * --客户填写表单提交数据  并调用贝壳网接口
     * @param sjid
     * @param agentid
     * @param customerInfo
     * @return
     */
    @ApiOperation(value = "客户提交表单")
    @PostMapping(value="customerCommitForm")
    public ResultHolder<Object> customerCommitForm(@RequestHeader(Constants.KEY_X_C3_SJID) Integer sjid,
                                               @RequestHeader(Constants.KEY_X_C3_AGENTID)  Integer agentid,
                                               @RequestBody PromotionEnrollCustomerInfoEntity customerInfo){

        log.info("客户提交表单请求参数sjid={},requestBody={}",sjid,customerInfo);
        if(customerInfo.getFormId()==null || customerInfo.getFormId()==0){
            return ResultHolder.error(1002,"表单ID不能为空");
        }
        if(customerInfo.getFullName()==null || customerInfo.getMobile()==null){
            return ResultHolder.error(1001,"姓名或手机号不能为空哦");
        }
        customerInfo.setSjid(sjid);
        customerInfo.setCustomerNo(agentid);
        String resultMsg = enrollFormDecorator.customerCommitForm(customerInfo);
        if("EXIST".equals(resultMsg)){
            return ResultHolder.error(1002,"您已经提交过啦，谢谢你的参与~");
        }
        try {
            ResponseEntity<ApiBeikeResponse> resp = beikeDataSyncService.callBeikeApi(customerInfo.getFullName(), customerInfo.getMobile());
            if(resp.getStatusCodeValue()==200) {
            	log.info("请求贝壳接口同步数据返回结果:{}",resp.getBody());
            }else {
            	log.info("请求贝壳接口同步数据 异常:{}",resp);
            }
        }catch (Exception e) {
			e.printStackTrace();
		}
        
        return ResultHolder.success("");
    }

	@ApiOperation(value = "获取表单海报链接")
    @RequestMapping(value = "/getPosterUrl", method = { RequestMethod.GET })
    public ResultHolder<Object> getPosterUrl(@RequestHeader(Constants.KEY_X_C3_SJID) Long sjid,
                                             @RequestHeader(Constants.KEY_X_C3_AGENTID) Long agentid,
                                             String formUrl) throws UnsupportedEncodingException {

		
		if(StringUtils.isEmpty(formUrl)){
			return ResultHolder.error(1002, "表单链接不能为空");
		}
		formUrl = URLDecoder.decode(formUrl,"UTF-8");
		log.info("====用户传过来的表单链接,formUrl={}",formUrl);
		String shortUrl = shortLinksFeignService.getShortUrl(formUrl).unpack();
		log.info("获取短链接,sjid={},agentid={},shorturl={}",sjid,agentid,shortUrl);
		String qrcodeURL = iweixinCache.generateCustomPersonalPoster(agentid, sjid, shortUrl);
		log.info("获取表单海报链接,qrcodeURL={}",qrcodeURL);
		Map<String,String> result = new HashMap<>();
        result.put("qrcodeURL",qrcodeURL);
        result.put("shortURL",shortUrl);
        return ResultHolder.success(result);
    }
    
    private String  checkSaveEnrollForm(EnrollFormVO enrollVO) {
        if(StringUtils.isBlank(enrollVO.getTitle())){
            return "表单名称不能为空";
        }
        if(enrollVO.getStartTime()==null || enrollVO.getEndTime()==null){
            return "表单有效时间不能为空";
        }
        for(PromotionFormQuestionEntity question:enrollVO.getQuestionList()){

            if(question.getQuestionType()==null || question.getQuestionType()<1 || question.getQuestionType()>2){
                return "表单问题只能为1或2";
            }
            if(PromotionConstants.QuestionType.CHOICE.equals(question.getQuestionType()) && StringUtils.isBlank(question.getQuestionTitle())){
                return "表单问题题干不能为空";
            }
        }
        return null;
    }

    private String checkEditEnrollForm(EnrollFormVO enrollVO) {

        if(enrollVO.getId()==null){
            return "表单ID不能为空";
        }
        if(StringUtils.isBlank(enrollVO.getTitle())){
            return "表单名称不能为空";
        }
        if(enrollVO.getStartTime()==null || enrollVO.getEndTime()==null){
            return "表单有效时间不能为空";
        }
        for(PromotionFormQuestionEntity question:enrollVO.getQuestionList()){

            if(question.getQuestionType()==null || question.getQuestionType()<1 || question.getQuestionType()>2){
                return "表单问题只能为1或2";
            }
        }
        return null;
    }
}

