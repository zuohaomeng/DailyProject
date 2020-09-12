package com.meng.feature.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/7 20:52
 */
@Data
@AllArgsConstructor
public class Trader {
    private final String name;
    private final String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trader trader = (Trader) o;

        if (!name.equals(trader.name)) return false;
        return city.equals(trader.city);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }
}
