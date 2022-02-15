package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.TeacherMapping.*;

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
 * TeacherEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class TeacherEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((TeacherEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((TeacherEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(TeacherEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(teacherId, entity.getTeacherId(), isNoN)
    	.put(deptId, entity.getDeptId(), isNoN)
    	.put(teacherDescribe, entity.getTeacherDescribe(), isNoN)
    	.put(teacherProjectNum, entity.getTeacherProjectNum(), isNoN)
    	.put(userId, entity.getUserId(), isNoN)
    	.put(zhicheng, entity.getZhicheng(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    TeacherEntity entity = new TeacherEntity();
    if (map.containsKey(teacherId.name)) {
    	entity.setTeacherId((String) map.get(teacherId.name));
    }
    if (map.containsKey(deptId.name)) {
    	entity.setDeptId((Integer) map.get(deptId.name));
    }
    if (map.containsKey(teacherDescribe.name)) {
    	entity.setTeacherDescribe((String) map.get(teacherDescribe.name));
    }
    if (map.containsKey(teacherProjectNum.name)) {
    	entity.setTeacherProjectNum((String) map.get(teacherProjectNum.name));
    }
    if (map.containsKey(userId.name)) {
    	entity.setUserId((String) map.get(userId.name));
    }
    if (map.containsKey(zhicheng.name)) {
    	entity.setZhicheng((String) map.get(zhicheng.name));
    }
    return (E)entity;
  }

  @Override
  public TeacherEntity copy(IEntity iEntity) {
    TeacherEntity entity = (TeacherEntity) iEntity;
    TeacherEntity copy = new TeacherEntity();
    {
    	copy.setTeacherId(entity.getTeacherId());
    	copy.setDeptId(entity.getDeptId());
    	copy.setTeacherDescribe(entity.getTeacherDescribe());
    	copy.setTeacherProjectNum(entity.getTeacherProjectNum());
    	copy.setUserId(entity.getUserId());
    	copy.setZhicheng(entity.getZhicheng());
    }
    return copy;
  }
}
