package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.UserMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.UserQuery;
import com.cx.fluentmybatis.wrapper.UserUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * UserDefaults
 *
 * @author powered by FluentMybatis
 */
public class UserDefaults implements IDefaultSetter, IDefaultGetter {
  public static final UserDefaults INSTANCE = new UserDefaults();

  private TableDynamic dynamic;

  private UserDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public UserQuery query() {
    return new UserQuery();
  }

  @Override
  public UserQuery defaultQuery() {
    UserQuery query = new UserQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public UserUpdate updater() {
    return new UserUpdate();
  }

  @Override
  public UserUpdate defaultUpdater() {
    UserUpdate updater = new UserUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public UserQuery aliasQuery() {
    Parameters parameters = new Parameters();
    UserQuery query = new UserQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public UserQuery aliasQuery(String alias) {
    UserQuery query = new UserQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public UserQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    UserQuery query = new UserQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public UserQuery aliasWith(String alias, BaseQuery fromQuery) {
    UserQuery query = new UserQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public UserDefaults setTableDynamic(TableDynamic dynamic) {
    this.dynamic = dynamic;
    return this;
  }

  /**
   * 获取表名
   */
  public Supplier<String> table() {
    return dynamic == null ? () -> Table_Name : () -> dynamic.get(Table_Name);
  }
}
