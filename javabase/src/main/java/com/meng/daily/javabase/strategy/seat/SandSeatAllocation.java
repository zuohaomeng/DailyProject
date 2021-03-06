package com.meng.daily.javabase.strategy.seat;

import org.springframework.stereotype.Component;

/**
 * @author ZuoHao
 * @date 2021/1/15
 */
@Component
public class SandSeatAllocation implements SeatAllocation{
    @Override
    public boolean support(long memberId) {
        return memberId<=50;
    }

    @Override
    public int getSeat(long memberId) {
        return 50;
    }
}
