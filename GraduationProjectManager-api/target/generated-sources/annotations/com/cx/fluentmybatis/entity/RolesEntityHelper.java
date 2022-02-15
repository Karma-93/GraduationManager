package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.RolesMapping.*;

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
 * RolesEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class RolesEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((RolesEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((RolesEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(RolesEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(rolesId, entity.getRolesId(), isNoN)
    	.put(rolesName, entity.getRolesName(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    RolesEntity entity = new RolesEntity();
    if (map.containsKey(rolesId.name)) {
    	entity.setRolesId((Integer) map.get(rolesId.name));
    }
    if (map.containsKey(rolesName.name)) {
    	entity.setRolesName((String) map.get(rolesName.name));
    }
    return (E)entity;
  }

  @Override
  public RolesEntity copy(IEntity iEntity) {
    RolesEntity entity = (RolesEntity) iEntity;
    RolesEntity copy = new RolesEntity();
    {
    	copy.setRolesId(entity.getRolesId());
    	copy.setRolesName(entity.getRolesName());
    }
    return copy;
  }
}
