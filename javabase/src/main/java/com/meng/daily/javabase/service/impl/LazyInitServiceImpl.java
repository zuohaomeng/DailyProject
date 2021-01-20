package com.meng.daily.javabase.service.impl;

import com.meng.daily.javabase.service.LazyInitService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author ZuoHao
 * @date 2021/1/20
 */
@Service
@Lazy
public class LazyInitServiceImpl implements LazyInitService{
    static {
        System.out.println("static 初始化了");
    }
}
