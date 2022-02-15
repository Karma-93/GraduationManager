package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.AdminMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.AdminQuery;
import com.cx.fluentmybatis.wrapper.AdminUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * AdminDefaults
 *
 * @author powered by FluentMybatis
 */
public class AdminDefaults implements IDefaultSetter, IDefaultGetter {
  public static final AdminDefaults INSTANCE = new AdminDefaults();

  private TableDynamic dynamic;

  private AdminDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public AdminQuery query() {
    return new AdminQuery();
  }

  @Override
  public AdminQuery defaultQuery() {
    AdminQuery query = new AdminQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public AdminUpdate updater() {
    return new AdminUpdate();
  }

  @Override
  public AdminUpdate defaultUpdater() {
    AdminUpdate updater = new AdminUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public AdminQuery aliasQuery() {
    Parameters parameters = new Parameters();
    AdminQuery query = new AdminQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public AdminQuery aliasQuery(String alias) {
    AdminQuery query = new AdminQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public AdminQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    AdminQuery query = new AdminQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public AdminQuery aliasWith(String alias, BaseQuery fromQuery) {
    AdminQuery query = new AdminQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public AdminDefaults setTableDynamic(TableDynamic dynamic) {
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
