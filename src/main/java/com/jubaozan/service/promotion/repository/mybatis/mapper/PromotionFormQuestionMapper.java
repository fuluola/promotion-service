package com.jubaozan.service.promotion.repository.mybatis.mapper;

import com.jubaozan.service.promotion.model.PromotionFormQuestionEntity;
import com.jubaozan.service.promotion.vo.form.EnrollCustomerAnswerVO;

import java.util.List;
import java.util.Map;

public interface PromotionFormQuestionMapper {

    void insertPromotionFormQuestion(PromotionFormQuestionEntity entity);

    List<PromotionFormQuestionEntity> findPromotionFormQuestionByCondition(Map<String,Object> map);

    void updatePromotionFormQuestion(Map<String,Object> map);

    List<EnrollCustomerAnswerVO> queryFormQuestionAnswerByCustomerNo(Map<String,Object> paramMap);
}
