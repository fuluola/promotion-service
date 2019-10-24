package com.jubaozan.service.promotion.constants;

import com.jubaozan.c3.framework.constants.Constants;

public interface PromotionConstants extends Constants {
    /**
     * 活动进行中
     */
    Integer ACTIVITY_ING = 1;

    /**
     * 活动未开始
     */
    Integer ACTIVITY_NOT_START = 2;

    /**
     * 活动失效
     */
    Integer ACTIVITY_INVALID = 3;
    /**
     * 活动已结束
     */
    Integer ACTIVITY_END = 4;

    /**
     * 已删除
     */
    Integer ACTIVITY_DELETE = 5;

    /**
     * 邀请注册
     */
    int ACTIVITY_REGISTER = 1;

    /**
     * 邀请购买
     */
    int ACTIVITY_BUY = 2;
    /**
     * 邀请助力
     */
    int ACTIVITY_HELP = 3;

   class EnrollFormStatus{

        public static final Integer DELETED = -1;

        public static final Integer UNUSED = 0;

        public static final Integer ACTIVE = 1;
    }

    class QuestionType{

        public static final Integer CHOICE = 1;

        public static final Integer FILL_IN_BLANK = 2;
    }
}
