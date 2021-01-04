package com.meng.zpattern.strategy;

/**
 * 返现活动
 * @author ZuoHao
 * @date 2021/1/3
 */
public class CashbackStrategy extends AbstractPromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现活动，直接返现抵用卷");
    }
}
