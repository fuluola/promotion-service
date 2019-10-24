package com.jubaozan.service.promotion.vo;

import com.jubaozan.service.promotion.repository.mybatis.domain.PromotionActivityDetail;

import java.io.Serializable;

public class PromotionActivityDetailVO extends PromotionActivityDetail implements Serializable {
    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;
    private Integer delete;

    public PromotionActivityDetailVO() {
    }

    public Integer getDelete() {
        return this.delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PromotionActivityDetailVO)) return false;
        final PromotionActivityDetailVO other = (PromotionActivityDetailVO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$delete = this.getDelete();
        final Object other$delete = other.getDelete();
        if (this$delete == null ? other$delete != null : !this$delete.equals(other$delete)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PromotionActivityDetailVO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $delete = this.getDelete();
        result = result * PRIME + ($delete == null ? 43 : $delete.hashCode());
        return result;
    }

    public String toString() {
        return "PromotionActivityDetailVO(delete=" + this.getDelete() + ")";
    }
}
