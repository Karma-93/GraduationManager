package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.RolesMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.RolesQuery;
import com.cx.fluentmybatis.wrapper.RolesUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * RolesDefaults
 *
 * @author powered by FluentMybatis
 */
public class RolesDefaults implements IDefaultSetter, IDefaultGetter {
  public static final RolesDefaults INSTANCE = new RolesDefaults();

  private TableDynamic dynamic;

  private RolesDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public RolesQuery query() {
    return new RolesQuery();
  }

  @Override
  public RolesQuery defaultQuery() {
    RolesQuery query = new RolesQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public RolesUpdate updater() {
    return new RolesUpdate();
  }

  @Override
  public RolesUpdate defaultUpdater() {
    RolesUpdate updater = new RolesUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public RolesQuery aliasQuery() {
    Parameters parameters = new Parameters();
    RolesQuery query = new RolesQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public RolesQuery aliasQuery(String alias) {
    RolesQuery query = new RolesQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public RolesQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    RolesQuery query = new RolesQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public RolesQuery aliasWith(String alias, BaseQuery fromQuery) {
    RolesQuery query = new RolesQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public RolesDefaults setTableDynamic(TableDynamic dynamic) {
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
