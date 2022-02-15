package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.DeptMapping.*;

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
 * DeptEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class DeptEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((DeptEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((DeptEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(DeptEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(deptId, entity.getDeptId(), isNoN)
    	.put(deptName, entity.getDeptName(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    DeptEntity entity = new DeptEntity();
    if (map.containsKey(deptId.name)) {
    	entity.setDeptId((Integer) map.get(deptId.name));
    }
    if (map.containsKey(deptName.name)) {
    	entity.setDeptName((String) map.get(deptName.name));
    }
    return (E)entity;
  }

  @Override
  public DeptEntity copy(IEntity iEntity) {
    DeptEntity entity = (DeptEntity) iEntity;
    DeptEntity copy = new DeptEntity();
    {
    	copy.setDeptId(entity.getDeptId());
    	copy.setDeptName(entity.getDeptName());
    }
    return copy;
  }
}
