package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.DeptEntity;
import com.cx.fluentmybatis.helper.DeptDefaults;
import com.cx.fluentmybatis.helper.DeptMapping;
import com.cx.fluentmybatis.helper.DeptWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.DeptWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.DeptWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * DeptUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class DeptUpdate extends BaseUpdate<DeptEntity, DeptUpdate, DeptQuery> {
  /**
   * 默认设置器
   */
  private static final DeptDefaults defaults = DeptDefaults.INSTANCE;

  /**
   * same as {@link #update}
   */
  public final UpdateSetter set = new UpdateSetter(this);

  /**
   * replaced by {@link #set}
   */
  @Deprecated
  public final UpdateSetter update = set;

  public final UpdateWhere where = new UpdateWhere(this);

  public final UpdateOrderBy orderBy = new UpdateOrderBy(this);

  public DeptUpdate() {
    this(defaults.table(), null);
  }

  public DeptUpdate(Supplier<String> table, String alias) {
    super(table, alias, DeptEntity.class, DeptQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return DeptMapping.MAPPING;
  }

  protected List<String> allFields() {
    return DeptMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static DeptUpdate updater() {
    return new DeptUpdate();
  }

  public static DeptUpdate updater(Supplier<String> table) {
    return new DeptUpdate(table, null);
  }

  public static DeptUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return DeptMapping.Column2Mapping;
  }
}
