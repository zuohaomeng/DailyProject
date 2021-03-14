package com.meng.common.spring.async.demo;

import com.meng.common.spring.async.enable.EnableCommonAsync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZuoHao
 * @date 2021/3/14
 */
@SpringBootApplication
@EnableCommonAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

