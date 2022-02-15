package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.UserMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.UserEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * UserSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class UserSqlProvider extends BaseSqlProvider<UserEntity> {
  /**
   * 默认设置器
   */
  private static final UserDefaults defaults = UserDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(UserEntity entity) {
    return entity.getUserId() == null;
  }

  @Override
  public boolean primaryNotNull(UserEntity entity) {
    return entity.getUserId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, UserEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, userId, entity.getUserId(), null);
    }
    inserts.add(prefix, userAccount, entity.getUserAccount(), "");
    inserts.add(prefix, userName, entity.getUserName(), "");
    inserts.add(prefix, userPassword, entity.getUserPassword(), "");
    inserts.add(prefix, userRoles, entity.getUserRoles(), "");
    inserts.add(prefix, userSex, entity.getUserSex(), "");
    inserts.add(prefix, userTel, entity.getUserTel(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, UserEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", userId, entity.getUserId(), null));
    }
    values.add(el("list[" + index + "].", userAccount, entity.getUserAccount(), ""));
    values.add(el("list[" + index + "].", userName, entity.getUserName(), ""));
    values.add(el("list[" + index + "].", userPassword, entity.getUserPassword(), ""));
    values.add(el("list[" + index + "].", userRoles, entity.getUserRoles(), ""));
    values.add(el("list[" + index + "].", userSex, entity.getUserSex(), ""));
    values.add(el("list[" + index + "].", userTel, entity.getUserTel(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    UserEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), userAccount, entity.getUserAccount(), "")
    	.add(this.dbType(), userName, entity.getUserName(), "")
    	.add(this.dbType(), userPassword, entity.getUserPassword(), "")
    	.add(this.dbType(), userRoles, entity.getUserRoles(), "")
    	.add(this.dbType(), userSex, entity.getUserSex(), "")
    	.add(this.dbType(), userTel, entity.getUserTel(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(userId.el(this.dbType(), Param_ET));
    return sql.toString();
  }

  @Override
  public List<String> updateDefaults(Map<String, String> updates, boolean ignoreLockVersion) {
    UpdateDefault defaults = new UpdateDefault(updates);
    return defaults.getUpdateDefaults();
  }

  @Override
  public String tableName() {
    return defaults.table().get();
  }

  @Override
  protected IMapping mapping() {
    return MAPPING;
  }

  @Override
  public List<String> allFields(boolean withPk) {
    if (withPk) {
    	return Arrays.asList("user_id", "user_account", "user_name", "user_password", "user_roles", "user_sex", "user_tel");
    } else {
    	return Arrays.asList("user_account", "user_name", "user_password", "user_roles", "user_sex", "user_tel");
    }
  }

  @Override
  protected void setEntityByDefault(IEntity entity) {
    defaults.setEntityByDefault(entity);
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  @Override
  protected boolean longTypeOfLogicDelete() {
    return false;
  }
}
