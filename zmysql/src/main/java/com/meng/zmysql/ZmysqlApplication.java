package com.meng.zmysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@MapperScan("com.meng.zmysql.mapper")
@SpringBootApplication
public class ZmysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmysqlApplication.class, args);
    }

}
