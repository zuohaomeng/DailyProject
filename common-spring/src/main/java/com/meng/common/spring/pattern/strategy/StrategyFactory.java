package com.meng.common.spring.pattern.strategy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author ZuoHao
 * @date 2021/4/28
 */
public class StrategyFactory implements InitializingBean {
    Map<String, List<AbstractStrategy<Object>>> strategyMap = new HashMap<>();
    @Resource
    private ApplicationContext applicationContext;

    /**
     * 只执行一个
     * @param key
     * @param object
     */
    public void execute(String key, Object object) {
        List<AbstractStrategy<Object>> strategyList = strategyMap.get(key);
        if (strategyList != null) {
            strategyList.stream()
                    .filter(strategy -> strategy.support(object))
                    .findFirst()
                    .ifPresent(strategy -> strategy.execute(object));
        }
    }

    /**
     * 只要符合都执行
     * @param key
     * @param object
     */
    public void executeList(String key, Object object) {
        List<AbstractStrategy<Object>> strategyList = strategyMap.get(key);
        if (strategyList != null) {
            strategyList.stream()
                    .filter(strategy -> strategy.support(object))
                    .forEach(strategy -> strategy.execute(object));
        }
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, AbstractStrategy> strategyBean = applicationContext.getBeansOfType(AbstractStrategy.class);
        strategyBean.values().forEach(bean -> {
            StrategyKey annotation = bean.getClass().getAnnotation(StrategyKey.class);
            if (annotation != null) {
                String value = annotation.value();
                //如果为空，就创建一个
                List<AbstractStrategy<Object>> strategyList = strategyMap.computeIfAbsent(value, k -> new ArrayList<>());
                strategyList.add(bean);
            }
        });
        strategyMap.forEach((key, value1) -> {
            System.out.println(key);
            System.out.println(Arrays.toString(value1.toArray()));
        });
    }
}
