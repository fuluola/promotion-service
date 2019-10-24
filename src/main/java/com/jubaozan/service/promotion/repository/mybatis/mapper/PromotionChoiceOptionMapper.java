package com.jubaozan.service.promotion.repository.mybatis.mapper;

import com.jubaozan.service.promotion.model.PromotionChoiceOptionEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PromotionChoiceOptionMapper {

    void insertPromotionChoiceOption(PromotionChoiceOptionEntity entity);

    List<PromotionChoiceOptionEntity> findPromotionChoiceOptionByCondition(Map<String,Object> map);

    void updatePromotionChoiceOption(Map<String ,Object> map);

    void deletePromotionChoiceOptionById(@Param(value = "id") Long id);

    PromotionChoiceOptionEntity findPromotionChoiceOptionByIds(List<Long> list);
}
