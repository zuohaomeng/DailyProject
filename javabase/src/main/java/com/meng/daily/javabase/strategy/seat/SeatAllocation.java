package com.meng.daily.javabase.strategy.seat;

/**
 * @author ZuoHao
 * @date 2021/1/15
 */
public interface SeatAllocation {
    /**
     * 是否支持
     */
    boolean support(long memberId);

    /**
     * 返回座位号
     */
    int getSeat(long memberId);
}
