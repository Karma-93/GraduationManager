package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.fluentmybatis.helper.DownDefaults;
import com.cx.fluentmybatis.helper.DownMapping;
import com.cx.fluentmybatis.helper.DownWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.DownWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.DownWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * DownUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class DownUpdate extends BaseUpdate<DownEntity, DownUpdate, DownQuery> {
  /**
   * 默认设置器
   */
  private static final DownDefaults defaults = DownDefaults.INSTANCE;

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

  public DownUpdate() {
    this(defaults.table(), null);
  }

  public DownUpdate(Supplier<String> table, String alias) {
    super(table, alias, DownEntity.class, DownQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return DownMapping.MAPPING;
  }

  protected List<String> allFields() {
    return DownMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static DownUpdate updater() {
    return new DownUpdate();
  }

  public static DownUpdate updater(Supplier<String> table) {
    return new DownUpdate(table, null);
  }

  public static DownUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return DownMapping.Column2Mapping;
  }
}
