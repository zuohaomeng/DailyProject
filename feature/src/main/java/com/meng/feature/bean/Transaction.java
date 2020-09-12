package com.meng.feature.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description 交易
 * @Author ZuoHao
 * @Date 2020/9/7 20:51
 */
@AllArgsConstructor
@Data
public class Transaction {
    private final Trader traders;
    private final int year;
    private final int value;
}
