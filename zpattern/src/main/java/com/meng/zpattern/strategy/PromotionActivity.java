package com.meng.zpattern.strategy;

/**
 * @author ZuoHao
 * @date 2021/1/3
 */
public class PromotionActivity {
    private AbstractPromotionStrategy promotionStrategy;

    public PromotionActivity(AbstractPromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void promotion(){
        promotionStrategy.doPromotion();
    }
}
