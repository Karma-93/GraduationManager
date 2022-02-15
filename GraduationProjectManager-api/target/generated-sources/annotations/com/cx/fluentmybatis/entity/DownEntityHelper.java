package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.DownMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.entity.IEntityHelper;
import cn.org.atool.fluent.mybatis.base.model.EntityToMap;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Date;
import java.util.Map;

/**
 *
 * DownEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class DownEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((DownEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((DownEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(DownEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(downId, entity.getDownId(), isNoN)
    	.put(adminId, entity.getAdminId(), isNoN)
    	.put(createDate, entity.getCreateDate(), isNoN)
    	.put(downPath, entity.getDownPath(), isNoN)
    	.put(downTitle, entity.getDownTitle(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    DownEntity entity = new DownEntity();
    if (map.containsKey(downId.name)) {
    	entity.setDownId((Integer) map.get(downId.name));
    }
    if (map.containsKey(adminId.name)) {
    	entity.setAdminId((String) map.get(adminId.name));
    }
    if (map.containsKey(createDate.name)) {
    	entity.setCreateDate((Date) map.get(createDate.name));
    }
    if (map.containsKey(downPath.name)) {
    	entity.setDownPath((String) map.get(downPath.name));
    }
    if (map.containsKey(downTitle.name)) {
    	entity.setDownTitle((String) map.get(downTitle.name));
    }
    return (E)entity;
  }

  @Override
  public DownEntity copy(IEntity iEntity) {
    DownEntity entity = (DownEntity) iEntity;
    DownEntity copy = new DownEntity();
    {
    	copy.setDownId(entity.getDownId());
    	copy.setAdminId(entity.getAdminId());
    	copy.setCreateDate(entity.getCreateDate());
    	copy.setDownPath(entity.getDownPath());
    	copy.setDownTitle(entity.getDownTitle());
    }
    return copy;
  }
}
