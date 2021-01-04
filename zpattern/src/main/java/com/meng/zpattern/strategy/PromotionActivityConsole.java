package com.meng.zpattern.strategy;

/**
 * @author ZuoHao
 * @date 2021/1/3
 */
public class PromotionActivityConsole {
    public static void main(String[] args) {
        //1。普通策略模式，使用if-else选择具体策略算法
        String strategy = "COUPON";
        AbstractPromotionStrategy promotionStrategy = null;
        if("COUPON".equals(strategy)){
            promotionStrategy = new CouponStrategy();
        }else if("CASHBACK".equals(strategy)){
            promotionStrategy = new CashbackStrategy();
        }else {
            promotionStrategy = new EmptyStrategy();
        }

        PromotionActivity promotionActivity = new PromotionActivity(promotionStrategy);
        promotionActivity.promotion();

        //2。使用工厂方法来获取策略类
        AbstractPromotionStrategy promotion = PromotionActivityFactory.getPromotion(strategy);
        PromotionActivity promotionActivity2 = new PromotionActivity(promotion);
        promotionActivity2.promotion();
    }
}
