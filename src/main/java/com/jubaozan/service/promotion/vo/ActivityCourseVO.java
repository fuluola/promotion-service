package com.jubaozan.service.promotion.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xielingqiu
 * @date 2019/5/5
 */

public class ActivityCourseVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String coverImageUrl;
    private String name;
    private LocalDateTime updatedTime;
    private Long goodsId;
    private Integer goodsType;

    /**
     *  "状态1:上架 0：下架",
     */
    private Integer hasPublish;

    /**
     * 关联活动名称
     */
    private String activityName;
    private Long activityId;

    public ActivityCourseVO(String coverImageUrl, String name, LocalDateTime updatedTime, Long goodsId, Integer goodsType, Integer hasPublish, String activityName, Long activityId) {
        this.coverImageUrl = coverImageUrl;
        this.name = name;
        this.updatedTime = updatedTime;
        this.goodsId = goodsId;
        this.goodsType = goodsType;
        this.hasPublish = hasPublish;
        this.activityName = activityName;
        this.activityId = activityId;
    }

    public ActivityCourseVO() {
    }

    public String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getUpdatedTime() {
        return this.updatedTime;
    }

    public Long getGoodsId() {
        return this.goodsId;
    }

    public Integer getGoodsType() {
        return this.goodsType;
    }

    public Integer getHasPublish() {
        return this.hasPublish;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public Long getActivityId() {
        return this.activityId;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public void setHasPublish(Integer hasPublish) {
        this.hasPublish = hasPublish;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ActivityCourseVO)) return false;
        final ActivityCourseVO other = (ActivityCourseVO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$coverImageUrl = this.getCoverImageUrl();
        final Object other$coverImageUrl = other.getCoverImageUrl();
        if (this$coverImageUrl == null ? other$coverImageUrl != null : !this$coverImageUrl.equals(other$coverImageUrl))
            return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$updatedTime = this.getUpdatedTime();
        final Object other$updatedTime = other.getUpdatedTime();
        if (this$updatedTime == null ? other$updatedTime != null : !this$updatedTime.equals(other$updatedTime))
            return false;
        final Object this$goodsId = this.getGoodsId();
        final Object other$goodsId = other.getGoodsId();
        if (this$goodsId == null ? other$goodsId != null : !this$goodsId.equals(other$goodsId)) return false;
        final Object this$goodsType = this.getGoodsType();
        final Object other$goodsType = other.getGoodsType();
        if (this$goodsType == null ? other$goodsType != null : !this$goodsType.equals(other$goodsType)) return false;
        final Object this$hasPublish = this.getHasPublish();
        final Object other$hasPublish = other.getHasPublish();
        if (this$hasPublish == null ? other$hasPublish != null : !this$hasPublish.equals(other$hasPublish))
            return false;
        final Object this$activityName = this.getActivityName();
        final Object other$activityName = other.getActivityName();
        if (this$activityName == null ? other$activityName != null : !this$activityName.equals(other$activityName))
            return false;
        final Object this$activityId = this.getActivityId();
        final Object other$activityId = other.getActivityId();
        if (this$activityId == null ? other$activityId != null : !this$activityId.equals(other$activityId))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ActivityCourseVO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $coverImageUrl = this.getCoverImageUrl();
        result = result * PRIME + ($coverImageUrl == null ? 43 : $coverImageUrl.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $updatedTime = this.getUpdatedTime();
        result = result * PRIME + ($updatedTime == null ? 43 : $updatedTime.hashCode());
        final Object $goodsId = this.getGoodsId();
        result = result * PRIME + ($goodsId == null ? 43 : $goodsId.hashCode());
        final Object $goodsType = this.getGoodsType();
        result = result * PRIME + ($goodsType == null ? 43 : $goodsType.hashCode());
        final Object $hasPublish = this.getHasPublish();
        result = result * PRIME + ($hasPublish == null ? 43 : $hasPublish.hashCode());
        final Object $activityName = this.getActivityName();
        result = result * PRIME + ($activityName == null ? 43 : $activityName.hashCode());
        final Object $activityId = this.getActivityId();
        result = result * PRIME + ($activityId == null ? 43 : $activityId.hashCode());
        return result;
    }

    public String toString() {
        return "ActivityCourseVO(coverImageUrl=" + this.getCoverImageUrl() + ", name=" + this.getName() + ", updatedTime=" + this.getUpdatedTime() + ", goodsId=" + this.getGoodsId() + ", goodsType=" + this.getGoodsType() + ", hasPublish=" + this.getHasPublish() + ", activityName=" + this.getActivityName() + ", activityId=" + this.getActivityId() + ")";
    }
}
