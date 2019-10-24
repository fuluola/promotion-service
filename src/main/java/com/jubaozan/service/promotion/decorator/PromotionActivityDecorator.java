package com.jubaozan.service.promotion.decorator;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jubaozan.c3.framework.exception.BaseException;
import com.jubaozan.c3.framework.utils.ObjectUtil;
import com.jubaozan.c3.framework.utils.ResultHolder;
import com.jubaozan.modules.feign.promotion.RuleFeignService;
import com.jubaozan.modules.feign.vo.ConstraintVO;
import com.jubaozan.modules.feign.vo.RuleResponseVO;
import com.jubaozan.modules.feign.vo.RuleVO;
import com.jubaozan.service.promotion.constants.PromotionConstants;
import com.jubaozan.service.promotion.repository.mybatis.domain.PromotionActivity;
import com.jubaozan.service.promotion.repository.mybatis.domain.PromotionActivityDetail;
import com.jubaozan.service.promotion.repository.mybatis.mapper.PromotionActivityDetailMapper;
import com.jubaozan.service.promotion.repository.mybatis.mapper.PromotionActivityMapper;
import com.jubaozan.service.promotion.vo.ActivityStatusVO;
import com.jubaozan.service.promotion.vo.PromotionActivityDetailVO;
import com.jubaozan.service.promotion.vo.PromotionActivityVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 新建/编辑邀约活动服务<br/>
 *
 * @author TanRuixiang
 * @date: 2019年4月29日 上午10:02:15
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class PromotionActivityDecorator {
    private final PromotionActivityMapper promotionActivityMapper;
    private final PromotionActivityDetailMapper promotionActivityDetailMapper;
    private final RuleFeignService ruleFeignService;

    @Autowired
    public PromotionActivityDecorator(PromotionActivityMapper promotionActivityMapper,
            PromotionActivityDetailMapper promotionActivityDetailMapper, RuleFeignService ruleFeignService) {
        this.promotionActivityMapper = promotionActivityMapper;
        this.promotionActivityDetailMapper = promotionActivityDetailMapper;
        this.ruleFeignService = ruleFeignService;
    }

    /**
     * 
     * 创建邀约任务活动<br/>
     * 
     * @param promotionActivityVO
     * @author TanRuixiang
     * @date 2019年4月30日 上午11:43:24
     */
    @Transactional
    public void addPromotionActivity(PromotionActivityVO promotionActivityVO) throws Exception {
        checkPromotionActivity(promotionActivityVO);
        PromotionActivity promotionActivity = new PromotionActivity();
        BeanUtils.copyProperties(promotionActivityVO, promotionActivity);
        promotionActivityMapper.insert(promotionActivity);

        if (promotionActivity.getId() != null && promotionActivityVO.getDetail().size() > 0) {
            for (PromotionActivityDetail promotionActivityDetail : promotionActivityVO.getDetail()) {
                ResultHolder<RuleResponseVO> rHolder = createRule(promotionActivity,
                        promotionActivityDetail.getGoodsId(), null);
                RuleResponseVO tRule = (RuleResponseVO) rHolder.getBody();
                if (rHolder.success() && ObjectUtil.isNotEmpty(tRule)) {
                    promotionActivityDetail.setActivityId(promotionActivity.getId());
                    promotionActivityDetail.setSjid(promotionActivity.getSjid());
                    promotionActivityDetail.setCreatedBy(promotionActivity.getCreatedBy());
                    promotionActivityDetail.setUpdatedBy(promotionActivity.getCreatedBy());
                    promotionActivityDetail.setRuleId(tRule.getRuleId());
                    promotionActivityDetailMapper.insert(promotionActivityDetail);
                }
            }
        }
    }

    /**
     * 
     * 编辑邀约任务活动<br/>
     * 
     * @param promotionActivityVO
     * @author TanRuixiang
     * @date 2019年4月30日 上午11:43:51
     */
    @Transactional
    public void editPromotionActivity(PromotionActivityVO promotionActivityVO) throws Exception {
        checkPromotionActivity(promotionActivityVO);
        if (promotionActivityVO.getId() == null) {
            throw new BaseException("活动Id不能为空");
        }
        PromotionActivity promotionActivity = new PromotionActivity();
        BeanUtils.copyProperties(promotionActivityVO, promotionActivity);
        UpdateWrapper<PromotionActivity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", promotionActivity.getId());
        updateWrapper.eq("sjid", promotionActivity.getSjid());
        promotionActivityMapper.update(promotionActivity, updateWrapper);
        if (promotionActivity.getId() != null && promotionActivityVO.getDetail().size() > 0) {
            for (PromotionActivityDetailVO pDetailVO : promotionActivityVO.getDetail()) {
                if ( PromotionConstants.ACTIVITY_DELETE.equals(pDetailVO.getDelete())) {
                    ruleFeignService.deleteRule(pDetailVO.getRuleId());
                    this.deleteDetail(pDetailVO.getSjid(), pDetailVO.getId());
                }
                PromotionActivityDetail pDetail = new PromotionActivityDetail();
                BeanUtils.copyProperties(pDetailVO, pDetail);
                ResultHolder<RuleResponseVO> rHolder = createRule(promotionActivity, pDetail.getGoodsId(),
                        pDetail.getRuleId());
                RuleResponseVO tRule = (RuleResponseVO) rHolder.getBody();
                if (rHolder.success() && ObjectUtil.isNotEmpty(tRule)) {
                    if (pDetailVO.getId() == null) {
                        pDetail.setActivityId(promotionActivity.getId());
                        pDetail.setSjid(promotionActivity.getSjid());
                        pDetail.setCreatedBy(promotionActivity.getUpdatedBy());
                        pDetail.setUpdatedBy(promotionActivity.getUpdatedBy());
                        pDetail.setRuleId(tRule.getRuleId());
                        promotionActivityDetailMapper.insert(pDetail);
                    }
                }
            }
        }
    }

    /**
     * 
     * 获取活动状态<br/>
     * 
     * @param sjid
     * @param goodsType
     * @param goodsId
     * @return
     * @author TanRuixiang
     * @date 2019年4月30日 上午11:44:26
     */
    public ActivityStatusVO getActivityStatus(Long sjid, Long goodsType, Long goodsId) {
        if (sjid == null || goodsType == null || goodsId == null) {
            throw new BaseException("缺少相应参数");
        }
        ActivityStatusVO aStatusVO = new ActivityStatusVO();
        QueryWrapper<PromotionActivityDetail> qw = new QueryWrapper<PromotionActivityDetail>();
        qw.eq("sjid", sjid);
        qw.eq("goods_type", goodsType);
        qw.eq("goods_id", goodsId);
        List<PromotionActivityDetail> pDetails = promotionActivityDetailMapper.selectList(qw);
        if (pDetails.size() <= 0) {
            // 已删除
            aStatusVO.setStatus(PromotionConstants.ACTIVITY_DELETE);
            return aStatusVO;
        }
        for (PromotionActivityDetail promotionActivityDetail : pDetails) {
            QueryWrapper<PromotionActivity> pWrapper = new QueryWrapper<PromotionActivity>();
            pWrapper.eq("sjid", sjid);
            pWrapper.eq("id", promotionActivityDetail.getActivityId());
            PromotionActivity pActivity = promotionActivityMapper.selectOne(pWrapper);
            if (pActivity == null) {
                continue;
            }
            Integer status = isEffectiveDate(pActivity.getStartTime(), pActivity.getEndTime(), pActivity.getStatus());
            if (status <= PromotionConstants.ACTIVITY_NOT_START) {
                aStatusVO.setStatus(status);
                aStatusVO.setRuleId(promotionActivityDetail.getRuleId());
                aStatusVO.setActivityId(promotionActivityDetail.getActivityId());
                aStatusVO.setRuleType(pActivity.getRuleType());
                aStatusVO.setReachNum(pActivity.getReachNum());
                return aStatusVO;
            }
        }
        aStatusVO.setStatus(PromotionConstants.ACTIVITY_DELETE);
        return aStatusVO;

    }

    /**
     * 
     * 判断活动状态<br/>
     * 
     * @param startTime
     * @param endTime
     * @return
     * @author TanRuixiang
     * @date 2019年4月30日 上午11:44:57
     */
    public Integer isEffectiveDate(LocalDateTime startTime, LocalDateTime endTime, Integer status) {
        if (status >= PromotionConstants.ACTIVITY_INVALID) {
            return status;
        } else {
            LocalDateTime nowTime = LocalDateTime.now();
            // 活动未开始
            if (nowTime.isBefore(startTime)) {
                return PromotionConstants.ACTIVITY_NOT_START;
            }
            // 活动已结束
            if (nowTime.isAfter(endTime)) {
                return PromotionConstants.ACTIVITY_END;
            }
            // 正在进行中
            else if (nowTime.isAfter(startTime) && nowTime.isBefore(endTime)) {
                return PromotionConstants.ACTIVITY_ING;
            }
            return PromotionConstants.ACTIVITY_END;
        }

    }

    /**
     * 
     * 创建邀约任务活动字段校验<br/>
     * 
     * @param promotionActivityVO
     * @author TanRuixiang
     * @date 2019年4月30日 上午11:45:34
     */
    private void checkPromotionActivity(PromotionActivityVO promotionActivityVO) {
        if (StringUtils.isEmpty(promotionActivityVO.getName())) {
            throw new BaseException("活动名称不能为空");
        }
        if (promotionActivityVO.getStartTime() == null) {
            throw new BaseException("开始时间不能为空");
        }
        if (promotionActivityVO.getEndTime() == null) {
            throw new BaseException("结束时间不能为空");
        }
        if (promotionActivityVO.getStartTime().isAfter(promotionActivityVO.getEndTime())) {
            throw new BaseException("结束时间不能在开始时间之前");
        }
        if (promotionActivityVO.getStartTime().isEqual(promotionActivityVO.getEndTime())) {
            throw new BaseException("开始时间不能等于结束时间");
        }
        if (promotionActivityVO.getDetail().size() == 0) {
            throw new BaseException("请选择商品");
        }
        if (promotionActivityVO.getReachNum() == null || promotionActivityVO.getReachNum() == 0
                || promotionActivityVO.getReachNum() < 0) {
            throw new BaseException("人数不能小于1");
        }
    }

    /**
     * 
     * 创建规则<br/>
     * 
     * @param promotionActivity
     * @param promotionActivityDetail
     * @return
     * @author TanRuixiang
     * @date 2019年5月6日 上午11:33:17
     */
    private ResultHolder<RuleResponseVO> createRule(PromotionActivity promotionActivity, Long goodsId, Long ruleId) {
        RuleVO ruleVO = new RuleVO();
        if (ruleId != null) {
            ruleVO.setRuleId(ruleId);
        }
        ruleVO.setSjid(promotionActivity.getSjid());
        ruleVO.setExtend(String.valueOf(goodsId));
        Date startDate = Date.from(promotionActivity.getStartTime().atZone(ZoneId.systemDefault()).toInstant());
        ruleVO.setStartDate(startDate);
        Date endDate = Date.from(promotionActivity.getEndTime().atZone(ZoneId.systemDefault()).toInstant());
        ruleVO.setEndDate(endDate);
        List<ConstraintVO> cList = new ArrayList<ConstraintVO>();
        ConstraintVO cVo = new ConstraintVO();
        cVo.setGoodsId(String.valueOf(goodsId));
        switch (promotionActivity.getRuleType()) {
            case PromotionConstants.ACTIVITY_REGISTER:
                cVo.setConstraintId(ConstraintVO.KEY_COUNT_INVITE_REGISTER_FROM_SOURCE);
                break;
            case PromotionConstants.ACTIVITY_BUY:
                cVo.setConstraintId(ConstraintVO.KEY_COUNT_INVITE_BUY_GOODS);
                break;
            default:
                cVo.setConstraintId(ConstraintVO.KEY_COUNT_INVITE_REGISTER_FROM_SOURCE);
                break;
        }
        cVo.setMinNum(promotionActivity.getReachNum());
        cList.add(cVo);
        ruleVO.setConstraints(cList);
        ResultHolder<RuleResponseVO> rHolder;
        if (ruleId != null) {
            rHolder = ruleFeignService.updateRule(ruleVO);
        } else {
            rHolder = ruleFeignService.createRule(ruleVO);
        }
        return rHolder;
    }

    private void deleteDetail(Long sjid, Long id) {
        QueryWrapper<PromotionActivityDetail> deleteQWrapper = new QueryWrapper<PromotionActivityDetail>();
        deleteQWrapper.eq("id", id);
        promotionActivityDetailMapper.delete(deleteQWrapper);
    }
}
