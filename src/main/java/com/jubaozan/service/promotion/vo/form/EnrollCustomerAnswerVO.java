package com.jubaozan.service.promotion.vo.form;

import java.io.Serializable;

public class EnrollCustomerAnswerVO implements Serializable {

    private Long questionId;

    private String questionTitle;

    private Integer questionType;

    private String answer;

    public EnrollCustomerAnswerVO() {
    }

    public Long getQuestionId() {
        return this.questionId;
    }

    public String getQuestionTitle() {
        return this.questionTitle;
    }

    public Integer getQuestionType() {
        return this.questionType;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EnrollCustomerAnswerVO)) return false;
        final EnrollCustomerAnswerVO other = (EnrollCustomerAnswerVO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$questionId = this.getQuestionId();
        final Object other$questionId = other.getQuestionId();
        if (this$questionId == null ? other$questionId != null : !this$questionId.equals(other$questionId))
            return false;
        final Object this$questionTitle = this.getQuestionTitle();
        final Object other$questionTitle = other.getQuestionTitle();
        if (this$questionTitle == null ? other$questionTitle != null : !this$questionTitle.equals(other$questionTitle))
            return false;
        final Object this$questionType = this.getQuestionType();
        final Object other$questionType = other.getQuestionType();
        if (this$questionType == null ? other$questionType != null : !this$questionType.equals(other$questionType))
            return false;
        final Object this$answer = this.getAnswer();
        final Object other$answer = other.getAnswer();
        if (this$answer == null ? other$answer != null : !this$answer.equals(other$answer)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EnrollCustomerAnswerVO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $questionId = this.getQuestionId();
        result = result * PRIME + ($questionId == null ? 43 : $questionId.hashCode());
        final Object $questionTitle = this.getQuestionTitle();
        result = result * PRIME + ($questionTitle == null ? 43 : $questionTitle.hashCode());
        final Object $questionType = this.getQuestionType();
        result = result * PRIME + ($questionType == null ? 43 : $questionType.hashCode());
        final Object $answer = this.getAnswer();
        result = result * PRIME + ($answer == null ? 43 : $answer.hashCode());
        return result;
    }

    public String toString() {
        return "EnrollCustomerAnswerVO(questionId=" + this.getQuestionId() + ", questionTitle=" + this.getQuestionTitle() + ", questionType=" + this.getQuestionType() + ", answer=" + this.getAnswer() + ")";
    }
}
