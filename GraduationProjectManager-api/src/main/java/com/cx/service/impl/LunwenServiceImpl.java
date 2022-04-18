package com.cx.service.impl;

import com.cx.fluentmybatis.entity.LunwenEntity;
import com.cx.fluentmybatis.helper.LunwenMapping;
import com.cx.fluentmybatis.mapper.LunwenMapper;
import com.cx.fluentmybatis.wrapper.LunwenQuery;
import com.cx.service.LunwenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LunwenServiceImpl implements LunwenService {
    @Autowired
    LunwenMapper lunwenMapper;
    @Override
    public int addLunwen(LunwenEntity lunwen) {
        lunwen.setLunwenDate(new Date());
        return lunwenMapper.insert(lunwen);
    }

    @Override
    public int updateLunwen(LunwenEntity lunwen) {
        return lunwenMapper.updateById(lunwen);
    }

    @Override
    public int removeLunwen(Integer id) {
        return lunwenMapper.deleteById(id);
    }

    @Override
    public LunwenEntity getLunwen(Integer id) {
        LunwenQuery query=new LunwenQuery();
        query.where.lunwenId().eq(id).end();
        return lunwenMapper.findOne(query);
    }

    @Override
    public LunwenEntity getLunwenByStudentId(String studentId) {
        LunwenQuery query = new LunwenQuery();
        query.where.studentId().eq(studentId);
        return lunwenMapper.findOne(query);
    }
}
