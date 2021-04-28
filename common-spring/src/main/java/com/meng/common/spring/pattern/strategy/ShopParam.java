package com.meng.common.spring.pattern.strategy;

/**
 * @author ZuoHao
 * @date 2021/4/28
 */
public class ShopParam {
    /**
     * shop
     */
    private int shopId;
    /**
     * 姓名
     */
    public String name;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
