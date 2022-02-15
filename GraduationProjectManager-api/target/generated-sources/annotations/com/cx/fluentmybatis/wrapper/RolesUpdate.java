package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.RolesEntity;
import com.cx.fluentmybatis.helper.RolesDefaults;
import com.cx.fluentmybatis.helper.RolesMapping;
import com.cx.fluentmybatis.helper.RolesWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.RolesWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.RolesWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * RolesUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class RolesUpdate extends BaseUpdate<RolesEntity, RolesUpdate, RolesQuery> {
  /**
   * 默认设置器
   */
  private static final RolesDefaults defaults = RolesDefaults.INSTANCE;

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

  public RolesUpdate() {
    this(defaults.table(), null);
  }

  public RolesUpdate(Supplier<String> table, String alias) {
    super(table, alias, RolesEntity.class, RolesQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return RolesMapping.MAPPING;
  }

  protected List<String> allFields() {
    return RolesMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static RolesUpdate updater() {
    return new RolesUpdate();
  }

  public static RolesUpdate updater(Supplier<String> table) {
    return new RolesUpdate(table, null);
  }

  public static RolesUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return RolesMapping.Column2Mapping;
  }
}
