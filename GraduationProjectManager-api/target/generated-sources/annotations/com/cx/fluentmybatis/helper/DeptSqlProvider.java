package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.DeptMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.DeptEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * DeptSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class DeptSqlProvider extends BaseSqlProvider<DeptEntity> {
  /**
   * 默认设置器
   */
  private static final DeptDefaults defaults = DeptDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(DeptEntity entity) {
    return entity.getDeptId() == null;
  }

  @Override
  public boolean primaryNotNull(DeptEntity entity) {
    return entity.getDeptId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, DeptEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, deptId, entity.getDeptId(), null);
    }
    inserts.add(prefix, deptName, entity.getDeptName(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, DeptEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", deptId, entity.getDeptId(), null));
    }
    values.add(el("list[" + index + "].", deptName, entity.getDeptName(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    DeptEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), deptName, entity.getDeptName(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(deptId.el(this.dbType(), Param_ET));
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
    	return Arrays.asList("dept_id", "dept_name");
    } else {
    	return Arrays.asList("dept_name");
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
