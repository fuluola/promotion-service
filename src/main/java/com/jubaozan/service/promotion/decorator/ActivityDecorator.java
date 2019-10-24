package com.jubaozan.service.promotion.decorator;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jubaozan.c3.framework.exception.BaseException;
import com.jubaozan.c3.framework.utils.PageHolder;
import com.jubaozan.c3.framework.utils.ResultHolder;
import com.jubaozan.modules.feign.knowledgepay.KpAdminFeignService;
import com.jubaozan.modules.feign.promotion.RuleFeignService;
import com.jubaozan.modules.feign.vo.KpContentSimpleVO;
import com.jubaozan.modules.feign.vo.KpCourse;
import com.jubaozan.modules.feign.vo.KpCourseColumn;
import com.jubaozan.service.promotion.constants.PromotionConstants;
import com.jubaozan.service.promotion.repository.mybatis.domain.PromotionActivity;
import com.jubaozan.service.promotion.repository.mybatis.domain.PromotionActivityDetail;
import com.jubaozan.service.promotion.repository.mybatis.mapper.PromotionActivityDetailMapper;
import com.jubaozan.service.promotion.repository.mybatis.mapper.PromotionActivityMapper;
import com.jubaozan.service.promotion.vo.ActivityCourseVO;
import com.jubaozan.service.promotion.vo.ActivityVO;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//import com.alibaba.dubbo.common.utils.CollectionUtils;

/**
 * @author xielingqiu
 * @date 2019/4/29
 */

@Service
public class ActivityDecorator {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ActivityDecorator.class);
    private  KpAdminFeignService kpAdminFeignService;
    private  PromotionActivityMapper promotionActivityMapper;
    private  PromotionActivityDetailMapper promotionActivityDetailMapper;
    private  PromotionActivityDecorator promotionActivityDecorator;
    private  RuleFeignService ruleFeignService;

    public ActivityDecorator(KpAdminFeignService kpAdminFeignService, PromotionActivityMapper promotionActivityMapper, PromotionActivityDetailMapper promotionActivityDetailMapper, PromotionActivityDecorator promotionActivityDecorator, RuleFeignService ruleFeignService) {
        this.kpAdminFeignService = kpAdminFeignService;
        this.promotionActivityMapper = promotionActivityMapper;
        this.promotionActivityDetailMapper = promotionActivityDetailMapper;
        this.promotionActivityDecorator = promotionActivityDecorator;
        this.ruleFeignService = ruleFeignService;
    }

    /**
     * 删除活动接口
     *
     * @author: xielingqiu
     * @param:
     * @return:
     * @date: 2019/4/30
     */
    public void deleteActivity(PromotionActivity promotionActivity){
        promotionActivity.setStatus(PromotionConstants.ACTIVITY_DELETE);
        promotionActivityMapper.updateById(promotionActivity);
    }

    /**
     * 活动结束接口
     *
     * @author: xielingqiu
     * @param:
     * @return:
     * @date: 2019/4/30
     */
    public void closeActivity(PromotionActivity promotionActivity){
        promotionActivity.setStatus(PromotionConstants.ACTIVITY_INVALID);
        promotionActivityMapper.updateById(promotionActivity);

        QueryWrapper<PromotionActivityDetail> queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_id",promotionActivity.getId());
        //关闭规则
        List<PromotionActivityDetail> activityDetails = promotionActivityDetailMapper.selectList(queryWrapper);
        for (PromotionActivityDetail promotionActivityDetail:activityDetails) {
            try {
            if(promotionActivityDetail!=null){
                ruleFeignService.closeRule(promotionActivityDetail.getRuleId());
                }
            }catch (Exception ex) {
                throw new BaseException("不存在此活动！");
            }
        }
    }

    /**
     * 活动课程(专栏)列表
     *
     * @author: xielingqiu
     * @param:
     * @return:
     * @date: 2019/5/5
     */
    public Page<ActivityCourseVO> getActivityList(Long sjid, long contentType,String name, PageHolder page){
        Page<ActivityCourseVO> result = new Page<>();

        PromotionActivity promotionActivity = new PromotionActivity();
        if(contentType==1){
            KpCourse course = new KpCourse();
            course.setSjid(sjid);
            ResultHolder<Page<KpCourse>> holder  = kpAdminFeignService.listPromotion(sjid,name,page.getPageSize(),page.getPageNo());
            Page<KpCourse> kpCourseIPage =holder.getBody();
            if (kpCourseIPage != null && kpCourseIPage.getRecords()!=null && kpCourseIPage.getRecords().size()>0){
                List<ActivityCourseVO> activityListVoList = new ArrayList<>();
                List<KpCourse> kpCourseList = kpCourseIPage.getRecords();
                for (KpCourse kpCourse: kpCourseList) {
                    ActivityCourseVO activityListVo = new ActivityCourseVO();
                    activityListVo.setName(kpCourse.getName());
                    activityListVo.setCoverImageUrl(kpCourse.getCoverImageUrl());
                    activityListVo.setUpdatedTime(kpCourse.getUpdatedTime());
                    activityListVo.setGoodsId(kpCourse.getGoodsId());
                    activityListVo.setGoodsType(kpCourse.getKpType());
                    activityListVo.setHasPublish(kpCourse.getHasPublish());
                    QueryWrapper<PromotionActivityDetail> queryWrapper = new QueryWrapper<>();
                    //查询课程/专栏关联的活动 只展示未开始和进行中的活动
                    queryWrapper.eq("goods_id", kpCourse.getGoodsId());
                    StringBuilder courseStr = new StringBuilder();
                    long id = 0;
                    List<PromotionActivityDetail> promotionDetailActivitys = promotionActivityDetailMapper.selectList(queryWrapper);
                    for(PromotionActivityDetail promotionActivityDetail : promotionDetailActivitys){
                        long activityId = promotionActivityDetail.getActivityId();
                        promotionActivity = promotionActivityMapper.selectById(activityId);
                        int activityStatus = promotionActivityDecorator.isEffectiveDate(promotionActivity.getStartTime(),
                                promotionActivity.getEndTime(),promotionActivity.getStatus());
                        if(activityStatus==PromotionConstants.ACTIVITY_ING
                                ||activityStatus==PromotionConstants.ACTIVITY_NOT_START){
                            courseStr.append(promotionActivity.getName()+";");
                            id = promotionActivity.getId();
                        }
                    }
                    activityListVo.setActivityName(courseStr.toString());
                    if(id==0){
                        activityListVo.setActivityId(null);
                    }else{
                        activityListVo.setActivityId(id);
                    }
                    activityListVoList.add(activityListVo);

                }
                result.setSize(page.getPageSize());
                result.setTotal(kpCourseIPage.getTotal());
                result.setCurrent(page.getPageNo());
                result.setRecords(activityListVoList);
            }
        }else if(contentType == 2){
            KpCourseColumn courseColumn = new KpCourseColumn();
            courseColumn.setSjid(sjid);
            ResultHolder<Page<KpCourseColumn>> courseColumnPage = kpAdminFeignService.listColumPromotion(sjid,name,page.getPageSize(),page.getPageNo());
            Page<KpCourseColumn> courseColumnIPage = courseColumnPage.getBody();
            if (courseColumnPage != null && courseColumnIPage.getRecords()!=null&&courseColumnIPage.getRecords().size()>0){
                List<ActivityCourseVO> activityListVoList = new ArrayList<>();
                List<KpCourseColumn> kpCourseList = courseColumnIPage.getRecords();
                for (KpCourseColumn kpCourseColumn: kpCourseList) {
                    ActivityCourseVO activityListVo = new ActivityCourseVO();

                    activityListVo.setName(kpCourseColumn.getName());
                    activityListVo.setCoverImageUrl(kpCourseColumn.getCoverImageUrl());
                    activityListVo.setUpdatedTime(kpCourseColumn.getUpdatedTime());
                    activityListVo.setGoodsId(kpCourseColumn.getGoodsId());
                    activityListVo.setGoodsType(kpCourseColumn.getKpType());
                    activityListVo.setHasPublish(kpCourseColumn.getHasPublish());
                    QueryWrapper<PromotionActivityDetail> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("goods_id", kpCourseColumn.getGoodsId());
                    StringBuilder colunmStr = new StringBuilder();
                    long id = 0;
                    List<PromotionActivityDetail> promotionDetailActivityList = promotionActivityDetailMapper.selectList(queryWrapper);
                    for(PromotionActivityDetail promotionActivityDetail : promotionDetailActivityList){
                        long activityId = promotionActivityDetail.getActivityId();
                        promotionActivity = promotionActivityMapper.selectById(activityId);
                        int activityStatus = promotionActivityDecorator.isEffectiveDate(promotionActivity.getStartTime(),
                                promotionActivity.getEndTime(),promotionActivity.getStatus());
                        if(activityStatus==PromotionConstants.ACTIVITY_ING
                                ||activityStatus==PromotionConstants.ACTIVITY_NOT_START){
                            colunmStr.append(promotionActivity.getName()+";");
                            id = promotionActivity.getId();
                        }
                    }
                    activityListVo.setActivityName(colunmStr.toString());
                    if(id==0){
                        activityListVo.setActivityId(null);
                    }else{
                        activityListVo.setActivityId(id);
                    }
                    activityListVoList.add(activityListVo);
                }
                result.setSize(page.getPageSize());
                result.setTotal(courseColumnIPage.getTotal());
                result.setCurrent(page.getPageNo());
                result.setRecords(activityListVoList);
            }
        }
        return result;
    }

        /**
         * 活动列表
         *
         * @author: xielingqiu
         * @param:
         * @return:
         * @date: 2019/5/5
         */
        public Page<ActivityVO> getActivity(PromotionActivity promotionActivity, Page page){
            QueryWrapper<PromotionActivity> queryWrapper = new QueryWrapper<>();

            queryWrapper.eq("sjid",promotionActivity.getSjid());
            if(promotionActivity.getName()!=null){
                queryWrapper.like("name",promotionActivity.getName());
            }
            if(promotionActivity.getStatus()!=null){
                //活动进行中
                if(promotionActivity.getStatus()==1){
                    queryWrapper.le("start_time", LocalDateTime.now());
                    queryWrapper.ge("end_time",LocalDateTime.now());
                    queryWrapper.lt("status",3);
                //活动未开始
                }else if(promotionActivity.getStatus()==2){
                    queryWrapper.ge("start_time",LocalDateTime.now());
                    queryWrapper.ne("status",3);
                 //活动已结束
                }else if(promotionActivity.getStatus()==4){
                    queryWrapper.le("end_time",LocalDateTime.now());
                 //活动已失效
                }else if(promotionActivity.getStatus()==3){
                    queryWrapper.eq("status",promotionActivity.getStatus());
                }
            }
            queryWrapper.ne("status", 5);
            queryWrapper.orderByDesc("updated_time");
            Page<PromotionActivity> PromotionActivityPage = (Page<PromotionActivity>) promotionActivityMapper.selectPage(page,queryWrapper);
            List<PromotionActivity> promotionActivityList = PromotionActivityPage.getRecords();
            List<PromotionActivityDetail> promotionActivityDetailList = new ArrayList<>();

            Page<ActivityVO> activityListVoPage = new Page<>();
            activityListVoPage.setTotal(PromotionActivityPage.getTotal());
            List<ActivityVO> ls=new ArrayList<>();
            for(int i = 0;i<promotionActivityList.size();i++) {
                if(promotionActivityList.get(i).getStatus()!=5)
                {
                	ArrayList<KpContentSimpleVO> list = new ArrayList<>();
                    ActivityVO activityListVo = new ActivityVO();
                    activityListVo.setStatus(promotionActivityDecorator.
                            isEffectiveDate(promotionActivityList.get(i).getStartTime(),
                                    promotionActivityList.get(i).getEndTime(), promotionActivityList.get(i).getStatus()));
                    activityListVo.setSjid(promotionActivity.getSjid());
//                    logger.info("======" + promotionActivityList.get(i).getId());
                    QueryWrapper<PromotionActivityDetail> queryWrapper1 = new QueryWrapper<>();
                    queryWrapper1.eq("activity_id", promotionActivityList.get(i).getId());
                    promotionActivityDetailList = promotionActivityDetailMapper.selectList(queryWrapper1);
                    for (PromotionActivityDetail detail : promotionActivityDetailList) {
                    	
                    	ResultHolder<KpContentSimpleVO> result = kpAdminFeignService.queryContentbyGoodsId(detail.getSjid(), detail.getGoodsId());
                    	if(!result.success()) {
                    		continue;
                    	}
                        KpContentSimpleVO kpContentSimpleVO = result.getBody();
                    	kpContentSimpleVO.setRuleId(detail.getRuleId());
                        kpContentSimpleVO.setDetailId(detail.getId());
                    	list.add(kpContentSimpleVO);
	                }
                    ResultHolder<Integer> count = kpAdminFeignService.getCompleteNum(promotionActivity.getSjid(), promotionActivityList.get(i).getId());
                    activityListVo.setCompletNum(count.getBody());
                    activityListVo.setId(promotionActivityList.get(i).getId());
                    activityListVo.setName(promotionActivityList.get(i).getName());
                    activityListVo.setStartTime(promotionActivityList.get(i).getStartTime());
                    activityListVo.setEndTime(promotionActivityList.get(i).getEndTime());
                    activityListVo.setReachNum(promotionActivityList.get(i).getReachNum());

                    activityListVo.setRuleType(promotionActivityList.get(i).getRuleType());
                    activityListVo.setRightsType(promotionActivityList.get(i).getRightsType());
                   
                    activityListVo.setCourseList(list);
                    activityListVo.setCourseCount(list.size());
                    ls.add(activityListVo);
                   }
                }
                activityListVoPage.setRecords(ls);
                return activityListVoPage;
        }
}