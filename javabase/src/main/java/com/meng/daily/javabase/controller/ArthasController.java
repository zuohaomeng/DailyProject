package com.meng.daily.javabase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/24 19:15
 */
@RestController
@RequestMapping("arthas")
public class ArthasController {
    @GetMapping("get")
    public Object get() {
        return "success";
    }

}
