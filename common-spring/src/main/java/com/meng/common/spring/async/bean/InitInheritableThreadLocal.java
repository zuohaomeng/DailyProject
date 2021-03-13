package com.meng.common.spring.async.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZuoHao
 * @date 2021/3/13
 */
public class InitInheritableThreadLocal<T extends Map<String, Object>> extends TransmittableThreadLocal<Map<String, Object>> {

    @Override
    protected Map<String, Object> initialValue() {
        return new HashMap<String, Object>();
    }

    @Override
    public Map<String, Object> childValue(Map<String, Object> parentValue) {
        if (parentValue == null) {
            return null;
        }
        //浅拷贝
        return (Map<String, Object>) ((HashMap<String, Object>) parentValue).clone();
    }

    @Override
    public Map<String, Object> copy(Map<String, Object> parentValue) {
        if (parentValue == null) {
            return new HashMap<>(1);
        }
        Map<String, Object> copyMap = new HashMap<>(parentValue.size());
        //深拷贝
        for (Map.Entry<String, Object> entry : parentValue.entrySet()) {
            String json = JSON.toJSONString(entry.getValue());
            System.out.println(entry.getValue().getClass());
            Object target = JSON.parseObject(json, entry.getValue().getClass());
            copyMap.put(entry.getKey(), target);
        }
        return copyMap;
    }

    /**
     * map 拷贝测试
     *
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("1", new ThreadInfo("1", "1", "1", "1"));
        map.put("2", new ThreadInfo("2", "2", "2", "2"));
        map.put("3", new ThreadInfo("3", "3", "3", "3"));
        InitInheritableThreadLocal<Map<String, Object>> threadLocal = new InitInheritableThreadLocal<>();
        Map<String, Object> copy = threadLocal.copy(map);
        System.out.println(copy.get("1") == map.get("1"));
        Map<String, Object> cloneMap = (Map<String, Object>) map.clone();
        System.out.println(1);
    }
}