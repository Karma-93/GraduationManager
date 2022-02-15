package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.AdminMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.entity.IEntityHelper;
import cn.org.atool.fluent.mybatis.base.model.EntityToMap;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 *
 * AdminEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class AdminEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((AdminEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((AdminEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(AdminEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(adminId, entity.getAdminId(), isNoN)
    	.put(userId, entity.getUserId(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    AdminEntity entity = new AdminEntity();
    if (map.containsKey(adminId.name)) {
    	entity.setAdminId((String) map.get(adminId.name));
    }
    if (map.containsKey(userId.name)) {
    	entity.setUserId((String) map.get(userId.name));
    }
    return (E)entity;
  }

  @Override
  public AdminEntity copy(IEntity iEntity) {
    AdminEntity entity = (AdminEntity) iEntity;
    AdminEntity copy = new AdminEntity();
    {
    	copy.setAdminId(entity.getAdminId());
    	copy.setUserId(entity.getUserId());
    }
    return copy;
  }
}
