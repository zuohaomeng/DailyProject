package com.meng.commonspring.async.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZuoHao
 * @date 2021/3/12
 */
public class ControlContext {
    private static ThreadLocal<Map<String, Object>> CONTROL_LOCAL = new ThreadLocal<>();


    public static Map<String, Object> getMap() {
        return CONTROL_LOCAL.get();
    }

    public static void add(String key, Object value) {
        Map<String, Object> map = CONTROL_LOCAL.get();
        if (map == null) {
            map = new HashMap<>();
            CONTROL_LOCAL.set(map);
        }
        map.put(key, value);
    }

    public static <T> T get(String key, Class<T> clazz) {
        Map<String, Object> map = CONTROL_LOCAL.get();
        if (map == null) {
            return null;
        }
        return (T) map.get(key);
    }

    public static boolean isNull(String key) {
        return CONTROL_LOCAL.get().get(key) == null;
    }

    public static void clear() {
        CONTROL_LOCAL.remove();
    }
}
