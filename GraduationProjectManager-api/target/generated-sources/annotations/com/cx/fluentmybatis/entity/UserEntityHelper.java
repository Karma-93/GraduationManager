package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.UserMapping.*;

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
 * UserEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class UserEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((UserEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((UserEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(UserEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(userId, entity.getUserId(), isNoN)
    	.put(userAccount, entity.getUserAccount(), isNoN)
    	.put(userName, entity.getUserName(), isNoN)
    	.put(userPassword, entity.getUserPassword(), isNoN)
    	.put(userRoles, entity.getUserRoles(), isNoN)
    	.put(userSex, entity.getUserSex(), isNoN)
    	.put(userTel, entity.getUserTel(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    UserEntity entity = new UserEntity();
    if (map.containsKey(userId.name)) {
    	entity.setUserId((String) map.get(userId.name));
    }
    if (map.containsKey(userAccount.name)) {
    	entity.setUserAccount((String) map.get(userAccount.name));
    }
    if (map.containsKey(userName.name)) {
    	entity.setUserName((String) map.get(userName.name));
    }
    if (map.containsKey(userPassword.name)) {
    	entity.setUserPassword((String) map.get(userPassword.name));
    }
    if (map.containsKey(userRoles.name)) {
    	entity.setUserRoles((Integer) map.get(userRoles.name));
    }
    if (map.containsKey(userSex.name)) {
    	entity.setUserSex((Integer) map.get(userSex.name));
    }
    if (map.containsKey(userTel.name)) {
    	entity.setUserTel((String) map.get(userTel.name));
    }
    return (E)entity;
  }

  @Override
  public UserEntity copy(IEntity iEntity) {
    UserEntity entity = (UserEntity) iEntity;
    UserEntity copy = new UserEntity();
    {
    	copy.setUserId(entity.getUserId());
    	copy.setUserAccount(entity.getUserAccount());
    	copy.setUserName(entity.getUserName());
    	copy.setUserPassword(entity.getUserPassword());
    	copy.setUserRoles(entity.getUserRoles());
    	copy.setUserSex(entity.getUserSex());
    	copy.setUserTel(entity.getUserTel());
    }
    return copy;
  }
}
