package com.meng.daily.javabase.controller;

import com.meng.daily.javabase.strategy.SeatStrategyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/24 19:15
 */
@RestController
@RequestMapping("arthas")
public class ArthasController {
    @Resource
    private SeatStrategyFactory seatStrategyFactory;

    @GetMapping("get")
    public Object get() {
        seatStrategyFactory.getSeat(300);
        seatStrategyFactory.getStrategy(300).getSeat(300);

        return "success";
    }

}
