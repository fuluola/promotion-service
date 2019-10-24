package com.juabaozan.service.test;

import com.alibaba.fastjson.JSONObject;
import com.jubaozan.service.promotion.api.ApiBeikeResponse;
import com.jubaozan.service.promotion.api.BeikeDataSyncService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class BeikeApiTest extends SpringBootTestAbstract {

    @Autowired
    BeikeDataSyncService beikeDataSyncService;

    @Test
    public void test(){
        ResponseEntity<ApiBeikeResponse> resp = beikeDataSyncService.callBeikeApi("付小五","15308488008");
        System.out.println(">>>>>>====="+JSONObject.toJSONString(resp.getBody()));
    }
}
