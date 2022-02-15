package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.AdminEntity;
import com.cx.fluentmybatis.helper.AdminDefaults;
import com.cx.fluentmybatis.helper.AdminMapping;
import com.cx.fluentmybatis.helper.AdminWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.AdminWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.AdminWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * AdminUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class AdminUpdate extends BaseUpdate<AdminEntity, AdminUpdate, AdminQuery> {
  /**
   * 默认设置器
   */
  private static final AdminDefaults defaults = AdminDefaults.INSTANCE;

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

  public AdminUpdate() {
    this(defaults.table(), null);
  }

  public AdminUpdate(Supplier<String> table, String alias) {
    super(table, alias, AdminEntity.class, AdminQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return AdminMapping.MAPPING;
  }

  protected List<String> allFields() {
    return AdminMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static AdminUpdate updater() {
    return new AdminUpdate();
  }

  public static AdminUpdate updater(Supplier<String> table) {
    return new AdminUpdate(table, null);
  }

  public static AdminUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return AdminMapping.Column2Mapping;
  }
}
