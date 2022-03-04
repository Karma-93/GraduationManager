package com.cx.common.utils;

import com.cx.controller.MessageSocketController;
import com.cx.fluentmybatis.entity.UserEntity;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 统一管理session、websocket、curUser
 */
public class CurPool {

    //    public static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
    public static Map<String, MessageSocketController> messageSockets = new ConcurrentHashMap<>();
    //key为UserId value为list 里面第一个存sessionId，第二个存session
    //session可以存储到redis里
    public static Map<String, List<Object>> sessionPool = new ConcurrentHashMap<>();
    // 当前登录用户x
    public static Map<String, UserEntity> curUserPool = new ConcurrentHashMap<>();
}
