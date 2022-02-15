package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.StudentMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.entity.IEntityHelper;
import cn.org.atool.fluent.mybatis.base.model.EntityToMap;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 *
 * StudentEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class StudentEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((StudentEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((StudentEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(StudentEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(studentId, entity.getStudentId(), isNoN)
    	.put(classId, entity.getClassId(), isNoN)
    	.put(projectId, entity.getProjectId(), isNoN)
    	.put(projectNum, entity.getProjectNum(), isNoN)
    	.put(studentScore, entity.getStudentScore(), isNoN)
    	.put(teacherId, entity.getTeacherId(), isNoN)
    	.put(userId, entity.getUserId(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    StudentEntity entity = new StudentEntity();
    if (map.containsKey(studentId.name)) {
    	entity.setStudentId((String) map.get(studentId.name));
    }
    if (map.containsKey(classId.name)) {
    	entity.setClassId((Integer) map.get(classId.name));
    }
    if (map.containsKey(projectId.name)) {
    	entity.setProjectId((Integer) map.get(projectId.name));
    }
    if (map.containsKey(projectNum.name)) {
    	entity.setProjectNum((Integer) map.get(projectNum.name));
    }
    if (map.containsKey(studentScore.name)) {
    	entity.setStudentScore((Integer) map.get(studentScore.name));
    }
    if (map.containsKey(teacherId.name)) {
    	entity.setTeacherId((String) map.get(teacherId.name));
    }
    if (map.containsKey(userId.name)) {
    	entity.setUserId((String) map.get(userId.name));
    }
    return (E)entity;
  }

  @Override
  public StudentEntity copy(IEntity iEntity) {
    StudentEntity entity = (StudentEntity) iEntity;
    StudentEntity copy = new StudentEntity();
    {
    	copy.setStudentId(entity.getStudentId());
    	copy.setClassId(entity.getClassId());
    	copy.setProjectId(entity.getProjectId());
    	copy.setProjectNum(entity.getProjectNum());
    	copy.setStudentScore(entity.getStudentScore());
    	copy.setTeacherId(entity.getTeacherId());
    	copy.setUserId(entity.getUserId());
    }
    return copy;
  }
}
