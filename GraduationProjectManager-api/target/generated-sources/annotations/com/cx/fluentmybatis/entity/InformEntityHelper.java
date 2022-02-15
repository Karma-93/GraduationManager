package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.InformMapping.*;

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
 * InformEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class InformEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((InformEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((InformEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(InformEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(informId, entity.getInformId(), isNoN)
    	.put(adminId, entity.getAdminId(), isNoN)
    	.put(attachmentPath, entity.getAttachmentPath(), isNoN)
    	.put(createDate, entity.getCreateDate(), isNoN)
    	.put(informBody, entity.getInformBody(), isNoN)
    	.put(informTitle, entity.getInformTitle(), isNoN)
    	.put(isAttachment, entity.getIsAttachment(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    InformEntity entity = new InformEntity();
    if (map.containsKey(informId.name)) {
    	entity.setInformId((Integer) map.get(informId.name));
    }
    if (map.containsKey(adminId.name)) {
    	entity.setAdminId((String) map.get(adminId.name));
    }
    if (map.containsKey(attachmentPath.name)) {
    	entity.setAttachmentPath((String) map.get(attachmentPath.name));
    }
    if (map.containsKey(createDate.name)) {
    	entity.setCreateDate((Date) map.get(createDate.name));
    }
    if (map.containsKey(informBody.name)) {
    	entity.setInformBody((String) map.get(informBody.name));
    }
    if (map.containsKey(informTitle.name)) {
    	entity.setInformTitle((String) map.get(informTitle.name));
    }
    if (map.containsKey(isAttachment.name)) {
    	entity.setIsAttachment((Integer) map.get(isAttachment.name));
    }
    return (E)entity;
  }

  @Override
  public InformEntity copy(IEntity iEntity) {
    InformEntity entity = (InformEntity) iEntity;
    InformEntity copy = new InformEntity();
    {
    	copy.setInformId(entity.getInformId());
    	copy.setAdminId(entity.getAdminId());
    	copy.setAttachmentPath(entity.getAttachmentPath());
    	copy.setCreateDate(entity.getCreateDate());
    	copy.setInformBody(entity.getInformBody());
    	copy.setInformTitle(entity.getInformTitle());
    	copy.setIsAttachment(entity.getIsAttachment());
    }
    return copy;
  }
}
