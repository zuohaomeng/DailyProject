package com.meng.common.spring.controllerTest;

import com.meng.common.spring.pattern.strategy.ShopParam;
import com.meng.common.spring.pattern.strategy.StrategyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZuoHao
 * @date 2021/4/28
 */
@RestController
@RequestMapping("/strategy")
public class StrategyController {


    @Resource
    private StrategyFactory strategyFactory;

    @GetMapping("/shop")
    public String shop(){
        ShopParam shopParam = new ShopParam();
        shopParam.setShopId(1);
        shopParam.setName("name");
        strategyFactory.execute("shop",shopParam);
        return "SUCCESS";
    }
}
