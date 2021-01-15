package com.meng.daily.javabase.strategy;

import com.meng.daily.javabase.strategy.seat.SeatAllocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ZuoHao
 * @date 2021/1/15
 */
@Component
public class SeatStrategyFactory {
    private final List<SeatAllocation> seatAllocations;


    @Autowired
    public SeatStrategyFactory(List<SeatAllocation> seatAllocations) {
        this.seatAllocations = seatAllocations;
    }

    /**
     * 如果这里直接返回座位号就是策略模式
     *
     * @param memberId
     * @return
     */
    public int getSeat(long memberId) {
        for (SeatAllocation target : seatAllocations) {
            if (target.support(memberId)) {
                return target.getSeat(memberId);
            }
        }
        throw new RuntimeException("获取座位失败");
    }

    /**
     * 返回具体算法类就是工厂+策略模式。
     */
    public SeatAllocation getStrategy(long memberId) {
        for (SeatAllocation target : seatAllocations) {
            if (target.support(memberId)) {
                return target;
            }
        }
        throw new RuntimeException("获取座位失败");
    }
}
