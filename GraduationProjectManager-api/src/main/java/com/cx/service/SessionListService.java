package com.cx.service;

import com.cx.fluentmybatis.entity.SessionListEntity;

import java.util.List;

public interface SessionListService {

    SessionListEntity getSessionListById(Integer id);

    void addUnReadCount(String toUserId,String userId);
    void delUnReadCount(String toUserId,String userId);
    Integer getIdByUser(String toUserId,String userId);
    Integer insert(SessionListEntity sessionListEntity);
    List<SessionListEntity> getSessionListByUserId(String UserId);
    List<String> getUserIdByUserId(String userId);
    Integer deleteById(Integer sessionId);

}
