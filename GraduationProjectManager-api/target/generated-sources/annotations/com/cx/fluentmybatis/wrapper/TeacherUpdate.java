package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.fluentmybatis.helper.TeacherDefaults;
import com.cx.fluentmybatis.helper.TeacherMapping;
import com.cx.fluentmybatis.helper.TeacherWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.TeacherWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.TeacherWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * TeacherUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class TeacherUpdate extends BaseUpdate<TeacherEntity, TeacherUpdate, TeacherQuery> {
  /**
   * 默认设置器
   */
  private static final TeacherDefaults defaults = TeacherDefaults.INSTANCE;

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

  public TeacherUpdate() {
    this(defaults.table(), null);
  }

  public TeacherUpdate(Supplier<String> table, String alias) {
    super(table, alias, TeacherEntity.class, TeacherQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return TeacherMapping.MAPPING;
  }

  protected List<String> allFields() {
    return TeacherMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static TeacherUpdate updater() {
    return new TeacherUpdate();
  }

  public static TeacherUpdate updater(Supplier<String> table) {
    return new TeacherUpdate(table, null);
  }

  public static TeacherUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return TeacherMapping.Column2Mapping;
  }
}
