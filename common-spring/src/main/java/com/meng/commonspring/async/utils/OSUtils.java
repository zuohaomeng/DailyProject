package com.meng.commonspring.async.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;

/**
 * @author ZuoHao
 * @date 2021/3/12
 */
public class OSUtils {

    private static String serverIp = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(OSUtils.class);

    /**
     * 获取服务器IP地址
     *
     * @return
     */
    public static String getServerIp() {
        if (StringUtils.isNoneBlank(serverIp)) {
            return serverIp;
        }
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            LOGGER.warn("Failed to get ip address", e);
        }
        return null;
    }

}
