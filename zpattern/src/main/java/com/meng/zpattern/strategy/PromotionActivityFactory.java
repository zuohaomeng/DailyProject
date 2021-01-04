package com.meng.zpattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZuoHao
 * @date 2021/1/3
 */
public class PromotionActivityFactory {
    private static Map<String,AbstractPromotionStrategy> promotionMap = new HashMap<>();
    static {
        //可以利用反射+容量来动态控制策略容器，方便扩展
        promotionMap.put("COUPON",new CouponStrategy());
        promotionMap.put("CASHBACK",new CashbackStrategy());
        promotionMap.put("EMPTY",new EmptyStrategy());
    }


    public static AbstractPromotionStrategy getPromotion(String strategy){
        AbstractPromotionStrategy promotionStrategy = promotionMap.get(strategy);
        if(promotionStrategy == null){
            promotionStrategy = promotionMap.get("EMPTY");
        }
        return promotionStrategy;
    }
}
