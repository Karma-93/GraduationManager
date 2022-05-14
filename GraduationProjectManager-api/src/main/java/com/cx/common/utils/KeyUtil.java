package com.cx.common.utils;

import java.util.UUID;

public class KeyUtil {
    /**
     * 生成唯一的主键
     * @param str
     * @return
     */
    public static synchronized String getUUIDKey(String str) {
        String uuid= System.currentTimeMillis()+ UUID.randomUUID().toString().replaceAll("-","").substring(0,6);
        return str + uuid;
    }
}
