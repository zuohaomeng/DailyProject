package com.meng.zmysql.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author ZuoHao
 * @date 2021/1/27
 */
@Service
public class PhoneFactory implements FactoryBean<PhoneService>, InitializingBean {
    private PhoneService phoneService;
    @Override
    public PhoneService getObject() throws Exception {
        return phoneService;
    }

    @Override
    public Class<?> getObjectType() {
        return PhoneService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        phoneService = new PhoneService();
        phoneService.setId(3);
        phoneService.setName("小米");
    }
}
