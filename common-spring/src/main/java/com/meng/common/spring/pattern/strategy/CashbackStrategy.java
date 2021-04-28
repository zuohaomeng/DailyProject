package com.meng.common.spring.pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * 现金返现策略
 *
 * @author ZuoHao
 * @date 2021/4/28
 */
@Component
@StrategyKey(value = "shop")
public class CashbackStrategy extends AbstractStrategy<ShopParam> {

    @Override
    public boolean support(ShopParam shopParam) {
        return shopParam.getShopId() == 2;
    }

    @Override
    public void execute(ShopParam shopParam) {
        System.out.println("cashback"+shopParam.getName());
    }
}
