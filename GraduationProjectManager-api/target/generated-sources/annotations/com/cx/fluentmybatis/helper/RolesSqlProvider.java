package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.RolesMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.RolesEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * RolesSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class RolesSqlProvider extends BaseSqlProvider<RolesEntity> {
  /**
   * 默认设置器
   */
  private static final RolesDefaults defaults = RolesDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(RolesEntity entity) {
    return entity.getRolesId() == null;
  }

  @Override
  public boolean primaryNotNull(RolesEntity entity) {
    return entity.getRolesId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, RolesEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, rolesId, entity.getRolesId(), null);
    }
    inserts.add(prefix, rolesName, entity.getRolesName(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, RolesEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", rolesId, entity.getRolesId(), null));
    }
    values.add(el("list[" + index + "].", rolesName, entity.getRolesName(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    RolesEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), rolesName, entity.getRolesName(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(rolesId.el(this.dbType(), Param_ET));
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
    	return Arrays.asList("roles_id", "roles_name");
    } else {
    	return Arrays.asList("roles_name");
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
