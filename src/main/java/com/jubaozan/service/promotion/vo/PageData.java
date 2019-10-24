package com.jubaozan.service.promotion.vo;

import java.io.Serializable;
import java.util.List;

public class PageData<T> implements Serializable {

    private int pageSize = 10;

    private int currentPage = 1;

    private int totalCount = 0;

    private int totalPage;

    private List<T> datas;

    public PageData() {
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public List<T> getDatas() {
        return this.datas;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PageData)) return false;
        final PageData<?> other = (PageData<?>) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getPageSize() != other.getPageSize()) return false;
        if (this.getCurrentPage() != other.getCurrentPage()) return false;
        if (this.getTotalCount() != other.getTotalCount()) return false;
        if (this.getTotalPage() != other.getTotalPage()) return false;
        final Object this$datas = this.getDatas();
        final Object other$datas = other.getDatas();
        if (this$datas == null ? other$datas != null : !this$datas.equals(other$datas)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageData;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getPageSize();
        result = result * PRIME + this.getCurrentPage();
        result = result * PRIME + this.getTotalCount();
        result = result * PRIME + this.getTotalPage();
        final Object $datas = this.getDatas();
        result = result * PRIME + ($datas == null ? 43 : $datas.hashCode());
        return result;
    }

    public String toString() {
        return "PageData(pageSize=" + this.getPageSize() + ", currentPage=" + this.getCurrentPage() + ", totalCount=" + this.getTotalCount() + ", totalPage=" + this.getTotalPage() + ", datas=" + this.getDatas() + ")";
    }
}
