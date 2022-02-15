package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.helper.UserDefaults;
import com.cx.fluentmybatis.helper.UserMapping;
import com.cx.fluentmybatis.helper.UserWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.UserWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.UserWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * UserUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class UserUpdate extends BaseUpdate<UserEntity, UserUpdate, UserQuery> {
  /**
   * 默认设置器
   */
  private static final UserDefaults defaults = UserDefaults.INSTANCE;

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

  public UserUpdate() {
    this(defaults.table(), null);
  }

  public UserUpdate(Supplier<String> table, String alias) {
    super(table, alias, UserEntity.class, UserQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return UserMapping.MAPPING;
  }

  protected List<String> allFields() {
    return UserMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static UserUpdate updater() {
    return new UserUpdate();
  }

  public static UserUpdate updater(Supplier<String> table) {
    return new UserUpdate(table, null);
  }

  public static UserUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return UserMapping.Column2Mapping;
  }
}
