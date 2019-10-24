package com.jubaozan.service.promotion.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jubaozan.c3.framework.constants.Constants;
import com.jubaozan.c3.framework.utils.PageHolder;
import com.jubaozan.c3.framework.utils.ResultHolder;
import com.jubaozan.service.promotion.decorator.ActivityDecorator;
import com.jubaozan.service.promotion.repository.mybatis.domain.PromotionActivity;
import com.jubaozan.service.promotion.vo.ActivityCourseVO;
import com.jubaozan.service.promotion.vo.ActivityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 邀约解锁活动
 *
 * @author xielingqiu
 * @date 2019/4/28
 */
@RestController
@RequestMapping("/admin/marketing")
@Api(value = "邀约/活动接口", description = "邀约/活动接口")
@Validated
public class ActivityController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ActivityController.class);
    ActivityDecorator activityDecorator;


    @Autowired
    public ActivityController(ActivityDecorator activityDecorator) {
        this.activityDecorator = activityDecorator;
    }

    /**
     * 活动结束接口
     *
     * @author: xielingqiu
     * @param:
     * @return:
     * @date: 2019/4/28
     */
    @ApiOperation(value = "活动结束接口")
    @PostMapping(value = "/close")
    public ResultHolder<String> close(@RequestHeader(Constants.KEY_X_C3_SJID) Long sjid, @RequestHeader(Constants.KEY_X_C3_AGENTID) String userName,
                                      long id){
        PromotionActivity promotionActivity = new PromotionActivity();
        promotionActivity.setSjid(sjid);
        promotionActivity.setUpdatedBy(userName);
        promotionActivity.setId(id);
        activityDecorator.closeActivity(promotionActivity);
        return ResultHolder.success(null);
    }

    /**
     * 活动列表
     *
     * @author: xielingqiu
     * @param:
     * @return:
     * @date: 2019/4/28
     */
    @ApiOperation(value = "活动列表接口")
    @GetMapping(value = "/list")
    public ResultHolder<Page<ActivityVO>> list(@RequestHeader(Constants.KEY_X_C3_SJID) Long sjid,
                                               PromotionActivity promotionActivity, Integer pageSize,Integer pageNo){
        promotionActivity.setSjid(sjid);
        if(pageSize==null) {
        	pageSize=10;
        }
        if(pageNo==null){
            pageNo=1;
        }
        Page page = new Page();
        page.setSize(pageSize);
        page.setCurrent(pageNo);
        Page<ActivityVO> activityListVoPage = activityDecorator.getActivity(promotionActivity,page);
        return ResultHolder.success(activityListVoPage);
    }

    /**
     * /活动课程(专栏)列表接口
     *
     * @author: xielingqiu
     * @param:
     * @return:
     * @date: 2019/4/28
     */
    @ApiOperation(value = "活动课程(专栏)列表接口")
    @GetMapping(value = "/addActivityList")
    public ResultHolder<Page<ActivityCourseVO>> addActivityList(@RequestHeader(Constants.KEY_X_C3_SJID) Long sjid, 
    		Integer contentType, Integer pageSize,Integer pageNo,String name){
        if(pageSize==null) {
            pageSize=10;
        }
        if(pageNo==null){
            pageNo=1;
        }
        PageHolder page = new PageHolder();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Page<ActivityCourseVO> activityListVoPage = activityDecorator.getActivityList(sjid,contentType,name,page);
        return ResultHolder.success(activityListVoPage);
    }

    /**
     *删除活动接口
     *
     * @author: xielingqiu
     * @param:
     * @return:
     * @date: 2019/4/28
     */
    @ApiOperation(value = "删除活动接口")
    @PostMapping(value = "/delete")
    public ResultHolder<String> delete(@RequestHeader(Constants.KEY_X_C3_SJID) Long sjid, @RequestHeader(Constants.KEY_X_C3_AGENTID) String userName,
                                       long id){
        PromotionActivity promotionActivity = new PromotionActivity();
        promotionActivity.setSjid(sjid);
        promotionActivity.setUpdatedBy(userName);
        promotionActivity.setId(id);
        activityDecorator.deleteActivity(promotionActivity);
        return ResultHolder.success(null);
    }
}
