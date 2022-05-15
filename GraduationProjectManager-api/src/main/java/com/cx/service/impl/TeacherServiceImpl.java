package com.cx.service.impl;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.utils.KeyUtil;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.mapper.DeptMapper;
import com.cx.fluentmybatis.mapper.TeacherMapper;
import com.cx.fluentmybatis.mapper.UserMapper;
import com.cx.fluentmybatis.wrapper.DeptQuery;
import com.cx.fluentmybatis.wrapper.TeacherQuery;
import com.cx.model.PageReq;
import com.cx.model.TeacherData;
import com.cx.service.TeacherService;
import com.cx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    DeptMapper deptMapper;

    @Override
    public int insert(TeacherEntity entity) {
        entity.setTeacherId(KeyUtil.getUUIDKey(""));
        return teacherMapper.insertWithPk(entity);
    }

    @Override
    public int update(TeacherEntity entity) {
        return teacherMapper.updateById(entity);
    }

    @Override
    public int delete(String teacherId) {
        String userId=getTeacherById(teacherId).getUserId();
        userService.delete(userId);
        return teacherMapper.deleteById(teacherId);
    }

    @Override
    public String getNameByTeacherId(String teacherId) {
        TeacherEntity entity=getTeacherById(teacherId);
        if (entity.getUserId()==null) return null;
        UserEntity userEntity=userService.getUserById(entity.getUserId());
        if (userEntity==null) return null;
        return userEntity.getUserName();
    }

    @Override
    public StdPagedList<TeacherEntity> getTeacherList(PageReq pageReq) {
        TeacherQuery query=new TeacherQuery().selectAll().limit(pageReq.getPageSize()*pageReq.getPageNum(),pageReq.getPageSize());
        return teacherMapper.stdPagedEntity(query);
    }



    @Override
    public TeacherEntity getTeacherById(String teacherid) {
        TeacherQuery query=new TeacherQuery().where().teacherId().eq(teacherid).end();
        return teacherMapper.findOne(query);
    }

    @Override
    public TeacherEntity getTeacherByUserId(String userId) {
        TeacherQuery query=new TeacherQuery();
        query.where.userId().eq(userId);
        return teacherMapper.findOne(query);
    }

    @Override
    public List<TeacherEntity> getAllTeacherList() {
        TeacherQuery query=new TeacherQuery();
        query.selectAll();
        return teacherMapper.listEntity(query);
    }

    @Override
    public List<TeacherData> getAllTeacherData() {
        List<TeacherData> res=new ArrayList<>();
        List<TeacherEntity> entities=getAllTeacherList();
        for (TeacherEntity entity:entities){
            DeptQuery deptQuery = new DeptQuery().where.deptId().eq(entity.getDeptId()).end();
            String dept=deptMapper.findOne(deptQuery).getDeptName();
            TeacherData temp = new TeacherData();
            UserEntity user=userService.getUserById(entity.getUserId());
            temp.setUserId(user.getUserId());
            temp.setTeacherId(entity.getTeacherId());
            temp.setUserName(user.getUserName());
            temp.setZhicheng(entity.getZhicheng());
            temp.setProject_num(entity.getTeacherProjectNum());
            temp.setDescribe(entity.getTeacherDescribe());
            temp.setDept(dept);
            res.add(temp);
        }
        return res;
    }
    @Override
    public StdPagedList<TeacherData> getTeacherData(PageReq pageReq) {
        StdPagedList<TeacherEntity> teacherEntityStdPagedList=getTeacherList(pageReq);
        StdPagedList<TeacherData> teacherDataStdPagedList=new StdPagedList<>();
        teacherDataStdPagedList.setTotal(teacherEntityStdPagedList.getTotal());
        List<TeacherData> res=new ArrayList<>();
        for (TeacherEntity entity:teacherEntityStdPagedList.getData()){
            DeptQuery deptQuery = new DeptQuery().where.deptId().eq(entity.getDeptId()).end();
            String dept=deptMapper.findOne(deptQuery).getDeptName();
            TeacherData temp = new TeacherData();
            UserEntity user=userService.getUserById(entity.getUserId());
            temp.setUserId(user.getUserId());
            temp.setTeacherId(entity.getTeacherId());
            temp.setUserName(user.getUserName());
            temp.setZhicheng(entity.getZhicheng());
            temp.setProject_num(entity.getTeacherProjectNum());
            temp.setDescribe(entity.getTeacherDescribe());
            temp.setDept(dept);
            res.add(temp);
        }
        teacherDataStdPagedList.setData(res);
        return teacherDataStdPagedList;
    }
}
