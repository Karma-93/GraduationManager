package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.helper.StudentDefaults;
import com.cx.fluentmybatis.helper.StudentMapping;
import com.cx.fluentmybatis.helper.StudentWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.StudentWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.StudentWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * StudentUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class StudentUpdate extends BaseUpdate<StudentEntity, StudentUpdate, StudentQuery> {
  /**
   * 默认设置器
   */
  private static final StudentDefaults defaults = StudentDefaults.INSTANCE;

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

  public StudentUpdate() {
    this(defaults.table(), null);
  }

  public StudentUpdate(Supplier<String> table, String alias) {
    super(table, alias, StudentEntity.class, StudentQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return StudentMapping.MAPPING;
  }

  protected List<String> allFields() {
    return StudentMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static StudentUpdate updater() {
    return new StudentUpdate();
  }

  public static StudentUpdate updater(Supplier<String> table) {
    return new StudentUpdate(table, null);
  }

  public static StudentUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return StudentMapping.Column2Mapping;
  }
}
