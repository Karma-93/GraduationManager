package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.InformEntity;
import com.cx.fluentmybatis.helper.InformDefaults;
import com.cx.fluentmybatis.helper.InformMapping;
import com.cx.fluentmybatis.helper.InformWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.InformWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.InformWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * InformUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class InformUpdate extends BaseUpdate<InformEntity, InformUpdate, InformQuery> {
  /**
   * 默认设置器
   */
  private static final InformDefaults defaults = InformDefaults.INSTANCE;

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

  public InformUpdate() {
    this(defaults.table(), null);
  }

  public InformUpdate(Supplier<String> table, String alias) {
    super(table, alias, InformEntity.class, InformQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return InformMapping.MAPPING;
  }

  protected List<String> allFields() {
    return InformMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static InformUpdate updater() {
    return new InformUpdate();
  }

  public static InformUpdate updater(Supplier<String> table) {
    return new InformUpdate(table, null);
  }

  public static InformUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return InformMapping.Column2Mapping;
  }
}
