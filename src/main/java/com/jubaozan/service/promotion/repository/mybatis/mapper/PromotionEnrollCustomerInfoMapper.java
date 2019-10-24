package com.jubaozan.service.promotion.repository.mybatis.mapper;

import com.jubaozan.service.promotion.model.PromotionEnrollCustomerInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PromotionEnrollCustomerInfoMapper {

    int countEnrollNumByFormId(@Param(value = "sjid") Integer sjid,@Param(value = "formId") Long formId);

    void insertPromotionEnrollCustomerInfo(PromotionEnrollCustomerInfoEntity customerInfoEntity);

    List<PromotionEnrollCustomerInfoEntity> findPromotionEnrollCustomerInfoByCondition(Map<String,Object> paramMap);

    List<PromotionEnrollCustomerInfoEntity> pageQueryEnrollCustomerInfo(Map<String,Object> paramMap);

    int countEnrollCustomerInfo(Map<String,Object> paramMap);

}
