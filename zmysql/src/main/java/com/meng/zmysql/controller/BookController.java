package com.meng.zmysql.controller;

import com.meng.zmysql.config.PhoneFactory;
import com.meng.zmysql.config.PhoneService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZuoHao
 * @date 2021/1/27
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    private PhoneService phoneService;

    @Resource
    private ApplicationContext applicationContext;



    @RequestMapping("/get")
    public void get(){
        phoneService.setName("23");
        PhoneFactory bean = applicationContext.getBean(PhoneFactory.class);
        System.out.println(bean);
    }
}
