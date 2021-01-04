package com.meng.zpattern.strategy;

/**
 * 没有优惠
 * @author ZuoHao
 * @date 2021/1/3
 */
public class EmptyStrategy extends AbstractPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("没有优惠活动");
    }
}
