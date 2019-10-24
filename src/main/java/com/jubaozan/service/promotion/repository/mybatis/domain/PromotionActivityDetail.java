package com.jubaozan.service.promotion.repository.mybatis.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * 营销活动详情表 参与活动课程<br/>
 *
 * @author TanRuixiang
 * @date: 2019年4月29日 上午9:39:59
 * @version 1.0
 * @since JDK 1.8
 */
@Accessors(chain = true)
@TableName("jbz_promotion_activity_detail")
@ApiModel(value = "PromotionActivityDetail对象", description = "营销活动详情表  参与活动课程")
public class PromotionActivityDetail extends Model<PromotionActivityDetail> {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "活动ID")
    private Long activityId;

    @ApiModelProperty(value = "参与活动商品类型 1 知识付费课程 2 知识付费专栏 3 实物商品")
    private Integer goodsType;

    @ApiModelProperty(value = "活动商品ID")
    private Long goodsId;

    @ApiModelProperty(value = "商家ID")
    private Long sjid;

    @ApiModelProperty(value = "规则ID")
    private Long ruleId;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "修改人")
    private String updatedBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime updatedTime;

    public PromotionActivityDetail() {
    }

    protected Serializable pkVal() {
        // TODO Auto-generated method stub
        return this.id;
    }

    public Long getId() {
        return this.id;
    }

    public Long getActivityId() {
        return this.activityId;
    }

    public Integer getGoodsType() {
        return this.goodsType;
    }

    public Long getGoodsId() {
        return this.goodsId;
    }

    public Long getSjid() {
        return this.sjid;
    }

    public Long getRuleId() {
        return this.ruleId;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return this.updatedTime;
    }

    public PromotionActivityDetail setId(Long id) {
        this.id = id;
        return this;
    }

    public PromotionActivityDetail setActivityId(Long activityId) {
        this.activityId = activityId;
        return this;
    }

    public PromotionActivityDetail setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
        return this;
    }

    public PromotionActivityDetail setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public PromotionActivityDetail setSjid(Long sjid) {
        this.sjid = sjid;
        return this;
    }

    public PromotionActivityDetail setRuleId(Long ruleId) {
        this.ruleId = ruleId;
        return this;
    }

    public PromotionActivityDetail setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PromotionActivityDetail setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public PromotionActivityDetail setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public PromotionActivityDetail setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    public String toString() {
        return "PromotionActivityDetail(id=" + this.getId() + ", activityId=" + this.getActivityId() + ", goodsType=" + this.getGoodsType() + ", goodsId=" + this.getGoodsId() + ", sjid=" + this.getSjid() + ", ruleId=" + this.getRuleId() + ", createdBy=" + this.getCreatedBy() + ", updatedBy=" + this.getUpdatedBy() + ", createdTime=" + this.getCreatedTime() + ", updatedTime=" + this.getUpdatedTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PromotionActivityDetail))
            return false;
        final PromotionActivityDetail other = (PromotionActivityDetail) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$activityId = this.getActivityId();
        final Object other$activityId = other.getActivityId();
        if (this$activityId == null ? other$activityId != null : !this$activityId.equals(other$activityId))
            return false;
        final Object this$goodsType = this.getGoodsType();
        final Object other$goodsType = other.getGoodsType();
        if (this$goodsType == null ? other$goodsType != null : !this$goodsType.equals(other$goodsType)) return false;
        final Object this$goodsId = this.getGoodsId();
        final Object other$goodsId = other.getGoodsId();
        if (this$goodsId == null ? other$goodsId != null : !this$goodsId.equals(other$goodsId)) return false;
        final Object this$sjid = this.getSjid();
        final Object other$sjid = other.getSjid();
        if (this$sjid == null ? other$sjid != null : !this$sjid.equals(other$sjid)) return false;
        final Object this$ruleId = this.getRuleId();
        final Object other$ruleId = other.getRuleId();
        if (this$ruleId == null ? other$ruleId != null : !this$ruleId.equals(other$ruleId)) return false;
        final Object this$createdBy = this.getCreatedBy();
        final Object other$createdBy = other.getCreatedBy();
        if (this$createdBy == null ? other$createdBy != null : !this$createdBy.equals(other$createdBy)) return false;
        final Object this$updatedBy = this.getUpdatedBy();
        final Object other$updatedBy = other.getUpdatedBy();
        if (this$updatedBy == null ? other$updatedBy != null : !this$updatedBy.equals(other$updatedBy)) return false;
        final Object this$createdTime = this.getCreatedTime();
        final Object other$createdTime = other.getCreatedTime();
        if (this$createdTime == null ? other$createdTime != null : !this$createdTime.equals(other$createdTime))
            return false;
        final Object this$updatedTime = this.getUpdatedTime();
        final Object other$updatedTime = other.getUpdatedTime();
        if (this$updatedTime == null ? other$updatedTime != null : !this$updatedTime.equals(other$updatedTime))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PromotionActivityDetail;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $activityId = this.getActivityId();
        result = result * PRIME + ($activityId == null ? 43 : $activityId.hashCode());
        final Object $goodsType = this.getGoodsType();
        result = result * PRIME + ($goodsType == null ? 43 : $goodsType.hashCode());
        final Object $goodsId = this.getGoodsId();
        result = result * PRIME + ($goodsId == null ? 43 : $goodsId.hashCode());
        final Object $sjid = this.getSjid();
        result = result * PRIME + ($sjid == null ? 43 : $sjid.hashCode());
        final Object $ruleId = this.getRuleId();
        result = result * PRIME + ($ruleId == null ? 43 : $ruleId.hashCode());
        final Object $createdBy = this.getCreatedBy();
        result = result * PRIME + ($createdBy == null ? 43 : $createdBy.hashCode());
        final Object $updatedBy = this.getUpdatedBy();
        result = result * PRIME + ($updatedBy == null ? 43 : $updatedBy.hashCode());
        final Object $createdTime = this.getCreatedTime();
        result = result * PRIME + ($createdTime == null ? 43 : $createdTime.hashCode());
        final Object $updatedTime = this.getUpdatedTime();
        result = result * PRIME + ($updatedTime == null ? 43 : $updatedTime.hashCode());
        return result;
    }
}
