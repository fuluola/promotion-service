package com.jubaozan.service.promotion.vo;

import java.io.Serializable;

public class ActivityStatusVO implements Serializable {

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;
    private Integer status;
    private Long ruleId;
    private Long activityId;
    private Integer ruleType;
    private Integer reachNum;

    public ActivityStatusVO() {
    }

    public Integer getStatus() {
        return this.status;
    }

    public Long getRuleId() {
        return this.ruleId;
    }

    public Long getActivityId() {
        return this.activityId;
    }

    public Integer getRuleType() {
        return this.ruleType;
    }

    public Integer getReachNum() {
        return this.reachNum;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    public void setReachNum(Integer reachNum) {
        this.reachNum = reachNum;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ActivityStatusVO)) return false;
        final ActivityStatusVO other = (ActivityStatusVO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$ruleId = this.getRuleId();
        final Object other$ruleId = other.getRuleId();
        if (this$ruleId == null ? other$ruleId != null : !this$ruleId.equals(other$ruleId)) return false;
        final Object this$activityId = this.getActivityId();
        final Object other$activityId = other.getActivityId();
        if (this$activityId == null ? other$activityId != null : !this$activityId.equals(other$activityId))
            return false;
        final Object this$ruleType = this.getRuleType();
        final Object other$ruleType = other.getRuleType();
        if (this$ruleType == null ? other$ruleType != null : !this$ruleType.equals(other$ruleType)) return false;
        final Object this$reachNum = this.getReachNum();
        final Object other$reachNum = other.getReachNum();
        if (this$reachNum == null ? other$reachNum != null : !this$reachNum.equals(other$reachNum)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ActivityStatusVO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $ruleId = this.getRuleId();
        result = result * PRIME + ($ruleId == null ? 43 : $ruleId.hashCode());
        final Object $activityId = this.getActivityId();
        result = result * PRIME + ($activityId == null ? 43 : $activityId.hashCode());
        final Object $ruleType = this.getRuleType();
        result = result * PRIME + ($ruleType == null ? 43 : $ruleType.hashCode());
        final Object $reachNum = this.getReachNum();
        result = result * PRIME + ($reachNum == null ? 43 : $reachNum.hashCode());
        return result;
    }

    public String toString() {
        return "ActivityStatusVO(status=" + this.getStatus() + ", ruleId=" + this.getRuleId() + ", activityId=" + this.getActivityId() + ", ruleType=" + this.getRuleType() + ", reachNum=" + this.getReachNum() + ")";
    }
}
