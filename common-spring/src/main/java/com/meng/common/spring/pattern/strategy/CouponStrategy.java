package com.meng.common.spring.pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * @author ZuoHao
 * @date 2021/4/28
 */
@Component
@StrategyKey(value = "shop")
public class CouponStrategy extends AbstractStrategy<ShopParam> {
    @Override
    boolean support(ShopParam shopParam) {
        return shopParam.getShopId() == 1;
    }

    @Override
    void execute(ShopParam shopParam) {
        System.out.println("coupon" + shopParam.getName());
    }
}
