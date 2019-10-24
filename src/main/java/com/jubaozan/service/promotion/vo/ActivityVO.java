package com.jubaozan.service.promotion.vo;

import com.jubaozan.modules.feign.vo.KpContentSimpleVO;
import com.jubaozan.service.promotion.repository.mybatis.domain.PromotionActivity;

import java.util.List;

/**
 * @author xielingqiu
 * @date 2019/5/5
 */
public class ActivityVO extends PromotionActivity {
    private List<KpContentSimpleVO> courseList;
    /**
     * 关联课程数
     */
    private Integer courseCount;
    /**
     * 已完成活动的人数
     */
    private Integer completNum;

    public ActivityVO() {
    }

    public List<KpContentSimpleVO> getCourseList() {
        return this.courseList;
    }

    public Integer getCourseCount() {
        return this.courseCount;
    }

    public Integer getCompletNum() {
        return this.completNum;
    }

    public void setCourseList(List<KpContentSimpleVO> courseList) {
        this.courseList = courseList;
    }

    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    public void setCompletNum(Integer completNum) {
        this.completNum = completNum;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ActivityVO)) return false;
        final ActivityVO other = (ActivityVO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$courseList = this.getCourseList();
        final Object other$courseList = other.getCourseList();
        if (this$courseList == null ? other$courseList != null : !this$courseList.equals(other$courseList))
            return false;
        final Object this$courseCount = this.getCourseCount();
        final Object other$courseCount = other.getCourseCount();
        if (this$courseCount == null ? other$courseCount != null : !this$courseCount.equals(other$courseCount))
            return false;
        final Object this$completNum = this.getCompletNum();
        final Object other$completNum = other.getCompletNum();
        if (this$completNum == null ? other$completNum != null : !this$completNum.equals(other$completNum))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ActivityVO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $courseList = this.getCourseList();
        result = result * PRIME + ($courseList == null ? 43 : $courseList.hashCode());
        final Object $courseCount = this.getCourseCount();
        result = result * PRIME + ($courseCount == null ? 43 : $courseCount.hashCode());
        final Object $completNum = this.getCompletNum();
        result = result * PRIME + ($completNum == null ? 43 : $completNum.hashCode());
        return result;
    }

    public String toString() {
        return "ActivityVO(courseList=" + this.getCourseList() + ", courseCount=" + this.getCourseCount() + ", completNum=" + this.getCompletNum() + ")";
    }
}
