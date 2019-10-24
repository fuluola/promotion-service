package com.jubaozan.service.promotion.vo.form;

import com.jubaozan.service.promotion.model.PromotionEnrollFormEntity;
import com.jubaozan.service.promotion.model.PromotionFormQuestionEntity;

import java.util.List;

public class EnrollFormVO extends PromotionEnrollFormEntity {

    List<PromotionFormQuestionEntity> questionList;

    public EnrollFormVO() {
    }


    public List<PromotionFormQuestionEntity> getQuestionList() {
        return this.questionList;
    }

    public void setQuestionList(List<PromotionFormQuestionEntity> questionList) {
        this.questionList = questionList;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EnrollFormVO)) return false;
        final EnrollFormVO other = (EnrollFormVO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$questionList = this.getQuestionList();
        final Object other$questionList = other.getQuestionList();
        if (this$questionList == null ? other$questionList != null : !this$questionList.equals(other$questionList))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EnrollFormVO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $questionList = this.getQuestionList();
        result = result * PRIME + ($questionList == null ? 43 : $questionList.hashCode());
        return result;
    }

    public String toString() {
        return "EnrollFormVO(questionList=" + this.getQuestionList() + ")";
    }
}
