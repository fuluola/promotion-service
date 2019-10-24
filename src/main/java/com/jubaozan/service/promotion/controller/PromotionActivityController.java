package com.jubaozan.service.promotion.controller;

import com.jubaozan.c3.framework.constants.Constants;
import com.jubaozan.c3.framework.utils.ResultHolder;
import com.jubaozan.service.promotion.decorator.PromotionActivityDecorator;
import com.jubaozan.service.promotion.vo.PromotionActivityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * 邀约活动控制器<br/>
 *
 * @author TanRuixiang
 * @date: 2019年4月29日 上午9:46:54
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/admin/promotion")
@Api(value = "邀约/活动服务", description = "邀约/活动服务")
public class PromotionActivityController {
    PromotionActivityDecorator promotionActivityDecorator;

    @Autowired
    public PromotionActivityController(PromotionActivityDecorator promotionActivityDecorator) {
        this.promotionActivityDecorator = promotionActivityDecorator;
    }

    @PostMapping("/addPro")
    @ApiOperation(value = "添加邀约/活动")
    public ResultHolder<Object> addPromotionActivity(@RequestHeader(Constants.KEY_X_C3_SJID) Long sjid,
            @RequestHeader(Constants.KEY_X_C3_AGENTID) String userName,
            @RequestBody PromotionActivityVO promotionActivityVO) {
        promotionActivityVO.setSjid(sjid);
        promotionActivityVO.setCreatedBy(userName);
        try {
            promotionActivityDecorator.addPromotionActivity(promotionActivityVO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResultHolder.error(902, e.getMessage());
        }
        return ResultHolder.success(null);
    }

    @PostMapping("/editPro")
    @ApiOperation(value = "编辑邀约/活动")
    public ResultHolder<Object> editPromotionActivity(@RequestHeader(Constants.KEY_X_C3_SJID) Long sjid,
            @RequestHeader(Constants.KEY_X_C3_AGENTID) String userName,
            @RequestBody PromotionActivityVO promotionActivityVO) {
        promotionActivityVO.setSjid(sjid);
        promotionActivityVO.setUpdatedBy(userName);
        try {
            promotionActivityDecorator.editPromotionActivity(promotionActivityVO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResultHolder.error(902, e.getMessage());
        }
        return ResultHolder.success(null);
    }

    @ApiOperation(value = "获取商品的活动状态")
    @RequestMapping(value = "/getActivityStatus", method = { RequestMethod.GET })
    public ResultHolder<Object> getActivityStatus(@RequestHeader(Constants.KEY_X_C3_SJID) Long sjid, Long goodsType,
            Long goodsId) {
        return ResultHolder.success(promotionActivityDecorator.getActivityStatus(sjid, goodsType, goodsId));
    }
}
