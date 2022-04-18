package com.cx.service.impl;

import com.cx.fluentmybatis.entity.KtbgEntity;
import com.cx.fluentmybatis.mapper.KtbgMapper;
import com.cx.fluentmybatis.wrapper.KtbgQuery;
import com.cx.service.KtbgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtbgServiceImpl implements KtbgService {

    @Autowired
    KtbgMapper ktbgMapper;

    @Override
    public int addKtbg(KtbgEntity ktbg) {
        return ktbgMapper.insert(ktbg);
    }

    @Override
    public int updateKtbg(KtbgEntity ktbg) {
        return ktbgMapper.updateById(ktbg);
    }

    @Override
    public int removeKtbg(Integer id) {
        return ktbgMapper.deleteById(id);
    }

    @Override
    public KtbgEntity getKtbg(Integer id) {
        KtbgQuery query=new KtbgQuery();
        query.where.ktbgId().eq(id).end();
        return ktbgMapper.findOne(query);
    }

    @Override
    public KtbgEntity getKtbgByStudentId(String studentId) {
        KtbgQuery query = new KtbgQuery();
        query.where.studentId().eq(studentId).end();
        return ktbgMapper.findOne(query);
    }
}
