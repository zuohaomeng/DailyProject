package com.meng.zpattern.strategy;

/**
 * @author ZuoHao
 * @date 2021/1/3
 */
public class CouponStrategy extends AbstractPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，使用优惠券");
    }
}
