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
 * 营销活动主表 邀约解锁、邀请助力等<br/>
 *
 * @author TanRuixiang
 * @date: 2019年4月29日 上午9:39:33
 * @version 1.0
 * @since JDK 1.8
 */
@Accessors(chain = true)
@TableName("jbz_promotion_activity")
@ApiModel(value = "PromotionActivity对象", description = "营销活动主表  邀约解锁、邀请助力等")
public class PromotionActivity extends Model<PromotionActivity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "活动名称")
    private String name;

    @ApiModelProperty(value = "活动状态  1 未开始 2 进行中 3 已结束  4 已失效  5 已删除")
    private Integer status;

    @ApiModelProperty(value = "活动规则类型 1 邀请注册  2 邀请购买 3 邀请助力")
    private Integer ruleType;

    @ApiModelProperty(value = "活动达成人数")
    private Integer reachNum;

    @ApiModelProperty(value = "活动开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "活动结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "权益类型 1 课程免费送")
    private Integer rightsType;

    @ApiModelProperty(value = "商家ID")
    private Long sjid;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "修改人")
    private String updatedBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime updatedTime;

    public PromotionActivity() {
    }

    protected Serializable pkVal() {
        // TODO Auto-generated method stub
        return this.id;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Integer getRuleType() {
        return this.ruleType;
    }

    public Integer getReachNum() {
        return this.reachNum;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public Integer getRightsType() {
        return this.rightsType;
    }

    public Long getSjid() {
        return this.sjid;
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

    public PromotionActivity setId(Long id) {
        this.id = id;
        return this;
    }

    public PromotionActivity setName(String name) {
        this.name = name;
        return this;
    }

    public PromotionActivity setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public PromotionActivity setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
        return this;
    }

    public PromotionActivity setReachNum(Integer reachNum) {
        this.reachNum = reachNum;
        return this;
    }

    public PromotionActivity setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public PromotionActivity setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public PromotionActivity setRightsType(Integer rightsType) {
        this.rightsType = rightsType;
        return this;
    }

    public PromotionActivity setSjid(Long sjid) {
        this.sjid = sjid;
        return this;
    }

    public PromotionActivity setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PromotionActivity setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public PromotionActivity setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public PromotionActivity setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    public String toString() {
        return "PromotionActivity(id=" + this.getId() + ", name=" + this.getName() + ", status=" + this.getStatus() + ", ruleType=" + this.getRuleType() + ", reachNum=" + this.getReachNum() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", rightsType=" + this.getRightsType() + ", sjid=" + this.getSjid() + ", createdBy=" + this.getCreatedBy() + ", updatedBy=" + this.getUpdatedBy() + ", createdTime=" + this.getCreatedTime() + ", updatedTime=" + this.getUpdatedTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PromotionActivity)) return false;
        final PromotionActivity other = (PromotionActivity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$ruleType = this.getRuleType();
        final Object other$ruleType = other.getRuleType();
        if (this$ruleType == null ? other$ruleType != null : !this$ruleType.equals(other$ruleType)) return false;
        final Object this$reachNum = this.getReachNum();
        final Object other$reachNum = other.getReachNum();
        if (this$reachNum == null ? other$reachNum != null : !this$reachNum.equals(other$reachNum)) return false;
        final Object this$startTime = this.getStartTime();
        final Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) return false;
        final Object this$endTime = this.getEndTime();
        final Object other$endTime = other.getEndTime();
        if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) return false;
        final Object this$rightsType = this.getRightsType();
        final Object other$rightsType = other.getRightsType();
        if (this$rightsType == null ? other$rightsType != null : !this$rightsType.equals(other$rightsType))
            return false;
        final Object this$sjid = this.getSjid();
        final Object other$sjid = other.getSjid();
        if (this$sjid == null ? other$sjid != null : !this$sjid.equals(other$sjid)) return false;
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
        return other instanceof PromotionActivity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $ruleType = this.getRuleType();
        result = result * PRIME + ($ruleType == null ? 43 : $ruleType.hashCode());
        final Object $reachNum = this.getReachNum();
        result = result * PRIME + ($reachNum == null ? 43 : $reachNum.hashCode());
        final Object $startTime = this.getStartTime();
        result = result * PRIME + ($startTime == null ? 43 : $startTime.hashCode());
        final Object $endTime = this.getEndTime();
        result = result * PRIME + ($endTime == null ? 43 : $endTime.hashCode());
        final Object $rightsType = this.getRightsType();
        result = result * PRIME + ($rightsType == null ? 43 : $rightsType.hashCode());
        final Object $sjid = this.getSjid();
        result = result * PRIME + ($sjid == null ? 43 : $sjid.hashCode());
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
