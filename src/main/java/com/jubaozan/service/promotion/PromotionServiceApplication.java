package com.jubaozan.service.promotion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.jubaozan.c3.framework.mybatis.EnableMybatisPlugins;
import com.jubaozan.c3.framework.mybatis.plugins.pagination.PaginationPlugin;
import com.jubaozan.c3.framework.mybatis.plugins.partition.PartitionPlugin;
import com.jubaozan.c3.framework.service.EnableServicePlugins;
import com.jubaozan.c3.framework.service.plugins.swagger.SwaggerConfiguration;
import com.jubaozan.modules.feign.knowledgepay.KpAdminFeignService;
import com.jubaozan.modules.feign.promotion.RuleFeignService;
import com.jubaozan.modules.feign.shortlinks.ShortLinksFeignService;
import com.jubaozan.modules.validation.EnableValidation;

/**
 * 微服务示例工程
 *
 * @author yuanjie
 */
@EnableValidation
@EnableDiscoveryClient
@EnableFeignClients(clients = {RuleFeignService.class,KpAdminFeignService.class, ShortLinksFeignService.class})
@SpringBootApplication
@EnableDubboConfiguration
@EnableServicePlugins(plugins = { SwaggerConfiguration.class })
@EnableMybatisPlugins(plugins = { PaginationPlugin.class, PartitionPlugin.class })
@MapperScan(basePackages = { "com.jubaozan.service.promotion.repository.mybatis.mapper" })
public class PromotionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PromotionServiceApplication.class, args);
    }
}

