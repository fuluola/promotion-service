package com.jubaozan.service.promotion.api;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * 贝壳数据同步
 */
@Service
public class BeikeDataSyncService {

    private static final Logger logger = LoggerFactory.getLogger(BeikeDataSyncService.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${beike.app_key:activity}")
    String appKey;

    @Value("${beike.app_secret}")
    String appSecret;

    @Value("${beike.channel_id:12000}")
    String channelId;

    @Value("${beike.url}")
    String url;

    public ResponseEntity<ApiBeikeResponse> callBeikeApi(String applicantName,String applicantPhone){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("app_key", appKey);
        jsonObj.put("channel_id",channelId);

        jsonObj.put("applicant_name", applicantName);
        jsonObj.put("applicant_phone", applicantPhone);
        jsonObj.put("expect_province_code",440000);
        jsonObj.put("expect_province_name", "广东");
        jsonObj.put("expect_city_code", 440300);
        jsonObj.put("expect_city_name","深圳");
        jsonObj.put("ts", LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        String sign = generateSign(jsonObj);
        jsonObj.put("sign",sign);
        logger.info("调用贝壳同步数据接口参数:{}",jsonObj);
        HttpEntity<JSONObject> request = new HttpEntity<>(jsonObj, headers);
        ResponseEntity<ApiBeikeResponse> response = restTemplate.postForEntity(url,request,ApiBeikeResponse.class);
        return response;
    }

    private String generateSign(JSONObject jsonObject) {

        TreeMap<String,Object> treeMap = new TreeMap<>();
        Set<String> keySet = jsonObject.keySet();
        for(String key:keySet){
            treeMap.put(key,jsonObject.get(key));
        }
        StringBuilder signSB = new StringBuilder();
        for(Map.Entry<String,Object> entry:treeMap.entrySet()){
            signSB.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        signSB.append("app_secret").append("=").append(appSecret);
        logger.info("sign加密原文:{}",signSB.toString());
        String sign = DigestUtils.md5DigestAsHex(signSB.toString().getBytes());
        return sign;
    }


}
