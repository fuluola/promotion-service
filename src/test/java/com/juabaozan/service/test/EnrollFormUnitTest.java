package com.juabaozan.service.test;

import com.jubaozan.service.promotion.decorator.EnrollFormDecorator;
import com.jubaozan.service.promotion.vo.form.EnrollFormVO;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class EnrollFormUnitTest extends SpringBootTestAbstract {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(EnrollFormUnitTest.class);
    @Autowired
    EnrollFormDecorator enrollFormDecorator;

    private String testJson = "{\n" +
            "\t\"description\": \"this is a test desc\",\n" +
            "\t\"imageBottom\": \"\",\n" +
            "\t\"createTime\": \"2019-09-23 09:09:09\",\n" +
            "\t\"endTime\": \"2019-12-23 09:09:09\",\n" +
            "\t\"imageTop\": \"\",\n" +
            "\t\"jumpUrl\": \"\",\n" +
            "\t\"questionList\": [{\n" +
            "\t\t\"choiceOptionList\": [{\n" +
            "\t\t\t\"choiceOption\": \"百度\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"choiceOption\": \"谷歌\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"choiceOption\": \"搜狗\"\n" +
            "\t\t}],\n" +
            "\t\t\"questionTitle\": \"最喜欢互联网公司\",\n" +
            "\t\t\"questionType\": 1,\n" +
            "\t\t\"sjid\": 1234,\n" +
            "\t}],\n" +
            "\t\"sjid\": 1234,\n" +
            "\t\"status\": 0,\n" +
            "\t\"title\": \"最喜欢互联网公司\"\n" +
            "}";

//    @Test
//    public void testSavaForm(){
//        JSONObject jsonObject = JSONObject.parseObject(testJson);
//        EnrollFormVO formVO = JSONObject.parseObject(testJson,EnrollFormVO.class);
//        enrollFormDecorator.saveEnrollForm(formVO);
//    }

//    @Test
//    public void testPageQuery(){
//
//        PageData<EnrollFormListVO> result = enrollFormDecorator.pageQueryEnrollList(1234,10,1,null);
//        log.info(">>>>>{}",result);
//    }
//
//    @Test
//    public void testGetOne(){
//        EnrollFormVO formVO = enrollFormDecorator.getWholeEnrollForm(2L);
//        log.info(">>>>>{}",JSONObject.toJSONString(formVO));
//    }

    @Test
    public void testEditForm(){
        EnrollFormVO formVO = enrollFormDecorator.getWholeEnrollForm(2L);
        formVO.getQuestionList().get(0).setQuestionTitle("你的故乡在哪");
        enrollFormDecorator.editEnrollForm(formVO);
    }


}
