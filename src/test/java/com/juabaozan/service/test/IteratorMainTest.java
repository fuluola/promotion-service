package com.juabaozan.service.test;

import com.alibaba.fastjson.JSONObject;
import com.jubaozan.service.promotion.model.PromotionChoiceOptionEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorMainTest {

    public static void main(String[] args) {
        PromotionChoiceOptionEntity entity = new PromotionChoiceOptionEntity();
        PromotionChoiceOptionEntity entity1 = new PromotionChoiceOptionEntity();
        PromotionChoiceOptionEntity entity2 = new PromotionChoiceOptionEntity();
        PromotionChoiceOptionEntity entity3 = new PromotionChoiceOptionEntity();
        entity.setId(1L);
        entity.setChoiceOption("aabb");
        entity1.setId(1L);
        entity1.setChoiceOption("ccdd");
        entity2.setId(2L);
        entity2.setChoiceOption("rrss");
        entity3.setId(3L);
        entity3.setChoiceOption("ggtt");
        List<PromotionChoiceOptionEntity> list0 = new ArrayList<>();
        List<PromotionChoiceOptionEntity> list2 = new ArrayList<>();

        list0.add(entity);
        list2.add(entity1);
        list2.add(entity2);
        list2.add(entity3);
        for(PromotionChoiceOptionEntity option:list2){
            Iterator<PromotionChoiceOptionEntity> it = list0.iterator();
            while (it.hasNext()){
                if(it.next().getId().equals(option.getId())){
                    it.remove();
                }
            }
        }

        System.out.println(JSONObject.toJSONString(list0));
    }

}
