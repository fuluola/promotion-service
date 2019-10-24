package com.juabaozan.service.test;

import com.jubaozan.service.promotion.PromotionServiceApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PromotionServiceApplication.class)//该class是SpringBoot项目的Application
@ActiveProfiles("test")
@WebAppConfiguration
public abstract class SpringBootTestAbstract {

}
