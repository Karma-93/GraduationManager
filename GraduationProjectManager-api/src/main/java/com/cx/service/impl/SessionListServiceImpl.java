package com.cx.service.impl;

import com.cx.fluentmybatis.entity.SessionListEntity;
import com.cx.fluentmybatis.mapper.SessionListMapper;
import com.cx.fluentmybatis.wrapper.SessionListQuery;
import com.cx.fluentmybatis.wrapper.SessionListUpdate;
import com.cx.service.SessionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("sessionListService")
public class SessionListServiceImpl implements SessionListService {

    @Autowired
    private SessionListMapper sessionListMapper;
    @Override
    public SessionListEntity getSessionListById(Integer id) {
        return sessionListMapper.findById(id);
    }

    @Override
    public void addUnReadCount(String userId, String toUserId) {
        SessionListUpdate update=new SessionListUpdate();
        update.set.unReadCount().applyFunc("un_read_count+1").end()
                .where().toUserId().eq(toUserId).and.userId().eq(userId).end();
        sessionListMapper.updateBy(update);
    }

    @Override
    public void delUnReadCount(String toUserId, String userId) {
        SessionListUpdate update=new SessionListUpdate();
        update.update.unReadCount().is(0).end()
                .where.toUserId().eq(toUserId).and.userId().eq(userId).end();
        sessionListMapper.updateBy(update);
        return;
    }

    @Override
    public Integer getIdByUser(String userId, String toUserId) {
        SessionListQuery query=new SessionListQuery();
        query.where.toUserId().eq(toUserId).and.userId().eq(userId).end();
        SessionListEntity sessionListEntity= sessionListMapper.findOne(query);
        if(sessionListEntity==null) return -1;
        return sessionListEntity.getId();
        //return sessionListMapper.listEntity(query).get(0).getId();
    }

    @Override
    public Integer insert(SessionListEntity sessionListEntity) {
        sessionListEntity.setId(null);
        return sessionListMapper.insert(sessionListEntity);
    }

    @Override
    public List<SessionListEntity> getSessionListByUserId(String userId) {
        SessionListQuery query=new SessionListQuery();
        query.where().userId().eq(userId).end();
        return sessionListMapper.listEntity(query);
    }

    @Override
    public List<String> getUserIdByUserId(String userId) {
        List<String> res=new ArrayList<>();
        SessionListQuery query=new SessionListQuery();
        query.where.userId().eq(userId).end();
        List<SessionListEntity> sessionListEntityList=sessionListMapper.listEntity(query);
        for (SessionListEntity i:sessionListEntityList){
            res.add(i.getToUserId());
        }
        return res;
    }

    @Override
    public Integer deleteById(Integer sessionId) {
        return sessionListMapper.deleteById(sessionId);
    }
}
