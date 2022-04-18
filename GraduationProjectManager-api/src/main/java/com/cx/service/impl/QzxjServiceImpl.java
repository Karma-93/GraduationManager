package com.cx.service.impl;

import com.cx.fluentmybatis.entity.QzxjEntity;
import com.cx.fluentmybatis.helper.QzxjMapping;
import com.cx.fluentmybatis.mapper.QzxjMapper;
import com.cx.fluentmybatis.wrapper.QzxjQuery;
import com.cx.service.QzxjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QzxjServiceImpl implements QzxjService {
    @Autowired
    QzxjMapper qzxjMapper;
    @Override
    public int addQzxj(QzxjEntity qzxj) {
        return qzxjMapper.insert(qzxj);
    }

    @Override
    public int updateQzxj(QzxjEntity qzxj) {
        return qzxjMapper.updateById(qzxj);
    }

    @Override
    public int removeQzxj(Integer id) {
        return qzxjMapper.deleteById(id);
    }

    @Override
    public QzxjEntity getQzxj(Integer id) {
        QzxjQuery query=new QzxjQuery();
        query.where.qzxjId().eq(id);
        return qzxjMapper.findOne(query);
    }

    @Override
    public QzxjEntity getQzxjByStudentId(String studentId) {
        QzxjQuery query = new QzxjQuery();
        query.where.studentId().eq(studentId);
        return qzxjMapper.findOne(query);
    }
}
