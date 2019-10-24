package com.jubaozan.service.promotion.vo.form;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EnrollFormListVO implements Serializable {

    private Long id;

    private String formName;

    private int enrollCustomerNum;

    private int status;

    private LocalDateTime createTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public EnrollFormListVO() {
    }

    public Long getId() {
        return this.id;
    }

    public String getFormName() {
        return this.formName;
    }

    public int getEnrollCustomerNum() {
        return this.enrollCustomerNum;
    }

    public int getStatus() {
        return this.status;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public void setEnrollCustomerNum(int enrollCustomerNum) {
        this.enrollCustomerNum = enrollCustomerNum;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EnrollFormListVO)) return false;
        final EnrollFormListVO other = (EnrollFormListVO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$formName = this.getFormName();
        final Object other$formName = other.getFormName();
        if (this$formName == null ? other$formName != null : !this$formName.equals(other$formName)) return false;
        if (this.getEnrollCustomerNum() != other.getEnrollCustomerNum()) return false;
        if (this.getStatus() != other.getStatus()) return false;
        final Object this$createTime = this.getCreateTime();
        final Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime))
            return false;
        final Object this$startTime = this.getStartTime();
        final Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) return false;
        final Object this$endTime = this.getEndTime();
        final Object other$endTime = other.getEndTime();
        if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EnrollFormListVO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $formName = this.getFormName();
        result = result * PRIME + ($formName == null ? 43 : $formName.hashCode());
        result = result * PRIME + this.getEnrollCustomerNum();
        result = result * PRIME + this.getStatus();
        final Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        final Object $startTime = this.getStartTime();
        result = result * PRIME + ($startTime == null ? 43 : $startTime.hashCode());
        final Object $endTime = this.getEndTime();
        result = result * PRIME + ($endTime == null ? 43 : $endTime.hashCode());
        return result;
    }

    public String toString() {
        return "EnrollFormListVO(id=" + this.getId() + ", formName=" + this.getFormName() + ", enrollCustomerNum=" + this.getEnrollCustomerNum() + ", status=" + this.getStatus() + ", createTime=" + this.getCreateTime() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ")";
    }
}
