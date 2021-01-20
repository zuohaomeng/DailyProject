package com.meng.daily.javabase.service.impl;

import com.meng.daily.javabase.service.AspectService;
import org.springframework.stereotype.Service;

/**
 * @author ZuoHao
 * @date 2021/1/20
 */
@Service
public class AspectServiceImpl implements AspectService {
    @Override
    public void successReturn() {
        System.out.println("successReturn");
    }

    @Override
    public void returnException() throws RuntimeException{
        throw new RuntimeException("抛出一个异常");
    }

}
