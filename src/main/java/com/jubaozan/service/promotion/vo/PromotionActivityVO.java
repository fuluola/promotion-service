package com.jubaozan.service.promotion.vo;

import com.jubaozan.service.promotion.repository.mybatis.domain.PromotionActivity;

import java.util.List;

public class PromotionActivityVO extends PromotionActivity {

    private List<PromotionActivityDetailVO> detail;

    public PromotionActivityVO() {
    }

    public List<PromotionActivityDetailVO> getDetail() {
        return this.detail;
    }

    public void setDetail(List<PromotionActivityDetailVO> detail) {
        this.detail = detail;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PromotionActivityVO)) return false;
        final PromotionActivityVO other = (PromotionActivityVO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$detail = this.getDetail();
        final Object other$detail = other.getDetail();
        if (this$detail == null ? other$detail != null : !this$detail.equals(other$detail)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PromotionActivityVO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $detail = this.getDetail();
        result = result * PRIME + ($detail == null ? 43 : $detail.hashCode());
        return result;
    }

    public String toString() {
        return "PromotionActivityVO(detail=" + this.getDetail() + ")";
    }
}
