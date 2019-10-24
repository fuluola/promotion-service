package com.juabaozan.service.test;

import com.alibaba.fastjson.JSONObject;
import com.jubaozan.service.promotion.decorator.EnrollFormDecorator;
import com.jubaozan.service.promotion.model.PromotionEnrollCustomerInfoEntity;
import com.jubaozan.service.promotion.vo.PageData;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class EnrollCustomerFormTest extends SpringBootTestAbstract {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(EnrollCustomerFormTest.class);
    @Autowired
    EnrollFormDecorator enrollFormDecorator;

//    @Test
//    public void testCommitCustomerInfo(){
//
//        PromotionEnrollCustomerInfoEntity customerInfo = new PromotionEnrollCustomerInfoEntity();
//        customerInfo.setMobile("16687951212");
//        customerInfo.setFullName("zengxinjian");
//        customerInfo.setCustomerNo(112233);
//        customerInfo.setFormId(2L);
//        customerInfo.setSjid(1234);
//
//        List<PromotionCustomerAnswerEntity> list = new ArrayList<>();
//        PromotionCustomerAnswerEntity answerEntity = new PromotionCustomerAnswerEntity();
//        answerEntity.setSjid(1234);
//        answerEntity.setCustomerNo(556677);
//        answerEntity.setQuestionId(1L);
//        answerEntity.setAnswer("3");
//        answerEntity.setFormId(customerInfo.getFormId());
//        PromotionCustomerAnswerEntity answerEntity2 = new PromotionCustomerAnswerEntity();
//        answerEntity2.setSjid(1234);
//        answerEntity2.setCustomerNo(556677);
//        answerEntity2.setQuestionId(3L);
//        answerEntity2.setAnswer("3");
//        answerEntity2.setFormId(customerInfo.getFormId());
//        list.add(answerEntity);
//        list.add(answerEntity2);
//        customerInfo.setAnswerEntityList(list);
//        enrollFormDecorator.customerCommitForm(customerInfo);
//    }

    @Test
    public void testCustomerInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("formId",2);
        PageData<PromotionEnrollCustomerInfoEntity> pageData = enrollFormDecorator.pageQueryEnrollCustomer(1,10,map);
        log.info(">>>>>{}", JSONObject.toJSONString(pageData));
    }
}
