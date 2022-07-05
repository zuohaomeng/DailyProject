package com.meng.daily.javabase.controller;

import com.meng.daily.javabase.service.AspectService;
import com.meng.daily.javabase.service.impl.LazyInitServiceImpl;
import com.meng.daily.javabase.strategy.SeatStrategyFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZuoHao
 * @date 2020/9/24 19:15
 */
@RestController
@RequestMapping("arthas")
public class ArthasController implements ApplicationContextAware {
    @Resource
    private SeatStrategyFactory seatStrategyFactory;

    private ApplicationContext applicationContext;

    @Resource
    private AspectService aspectService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    @GetMapping("get")
    public Object get() {
        seatStrategyFactory.getSeat(300);
        seatStrategyFactory.getStrategy(300).getSeat(300);

        return "success";
    }

    @GetMapping("lazyInit")
    public Object lazyInit() {
        System.out.println("开始获取LazyInitServiceImpl");
        applicationContext.getBean(LazyInitServiceImpl.class);
        System.out.println();
        return "success";
    }
    @GetMapping("successReturn")
    public Object successReturn(){
        aspectService.successReturn();
        return "success";
    }
    @GetMapping("returnException")
    private Object returnException(){
        try {
            aspectService.returnException();
        }catch (Exception e){
            System.out.println("error");
        }
        return "success";
    }
}
