package com.jubaozan.service.promotion.repository.mybatis.mapper;

import com.jubaozan.service.promotion.model.PromotionEnrollFormEntity;
import com.jubaozan.service.promotion.vo.form.EnrollFormListVO;
import com.jubaozan.service.promotion.vo.form.EnrollFormVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PromotionEnrollFormMapper {

    void insertPromotionEnrollForm(PromotionEnrollFormEntity entity);

    List<EnrollFormListVO> findPromotionEnrollFormByCondition(Map<String,Object> paramMap);

    int findCountByCondition(@Param(value="sjid") Integer sjid,@Param(value="title") String title);

    EnrollFormVO findPromotionEnrollFormByIds(List<Long> list);

    void updatePromotionEnrollForm(Map<String,Object> paramMap);
}
