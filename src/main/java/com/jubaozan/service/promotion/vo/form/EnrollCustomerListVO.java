package com.jubaozan.service.promotion.vo.form;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EnrollCustomerListVO implements Serializable {

    private Long formId;

    private LocalDateTime startEnrollTime;

    private LocalDateTime endEnrollTime;

    private Integer pageSize;

    private Integer pageNo;

    public EnrollCustomerListVO() {
    }

    public Long getFormId() {
        return this.formId;
    }

    public LocalDateTime getStartEnrollTime() {
        return this.startEnrollTime;
    }

    public LocalDateTime getEndEnrollTime() {
        return this.endEnrollTime;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public void setStartEnrollTime(LocalDateTime startEnrollTime) {
        this.startEnrollTime = startEnrollTime;
    }

    public void setEndEnrollTime(LocalDateTime endEnrollTime) {
        this.endEnrollTime = endEnrollTime;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EnrollCustomerListVO)) return false;
        final EnrollCustomerListVO other = (EnrollCustomerListVO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$formId = this.getFormId();
        final Object other$formId = other.getFormId();
        if (this$formId == null ? other$formId != null : !this$formId.equals(other$formId)) return false;
        final Object this$startEnrollTime = this.getStartEnrollTime();
        final Object other$startEnrollTime = other.getStartEnrollTime();
        if (this$startEnrollTime == null ? other$startEnrollTime != null : !this$startEnrollTime.equals(other$startEnrollTime))
            return false;
        final Object this$endEnrollTime = this.getEndEnrollTime();
        final Object other$endEnrollTime = other.getEndEnrollTime();
        if (this$endEnrollTime == null ? other$endEnrollTime != null : !this$endEnrollTime.equals(other$endEnrollTime))
            return false;
        final Object this$pageSize = this.getPageSize();
        final Object other$pageSize = other.getPageSize();
        if (this$pageSize == null ? other$pageSize != null : !this$pageSize.equals(other$pageSize)) return false;
        final Object this$pageNo = this.getPageNo();
        final Object other$pageNo = other.getPageNo();
        if (this$pageNo == null ? other$pageNo != null : !this$pageNo.equals(other$pageNo)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EnrollCustomerListVO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $formId = this.getFormId();
        result = result * PRIME + ($formId == null ? 43 : $formId.hashCode());
        final Object $startEnrollTime = this.getStartEnrollTime();
        result = result * PRIME + ($startEnrollTime == null ? 43 : $startEnrollTime.hashCode());
        final Object $endEnrollTime = this.getEndEnrollTime();
        result = result * PRIME + ($endEnrollTime == null ? 43 : $endEnrollTime.hashCode());
        final Object $pageSize = this.getPageSize();
        result = result * PRIME + ($pageSize == null ? 43 : $pageSize.hashCode());
        final Object $pageNo = this.getPageNo();
        result = result * PRIME + ($pageNo == null ? 43 : $pageNo.hashCode());
        return result;
    }

    public String toString() {
        return "EnrollCustomerListVO(formId=" + this.getFormId() + ", startEnrollTime=" + this.getStartEnrollTime() + ", endEnrollTime=" + this.getEndEnrollTime() + ", pageSize=" + this.getPageSize() + ", pageNo=" + this.getPageNo() + ")";
    }
}
