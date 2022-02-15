package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.DeptMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.DeptQuery;
import com.cx.fluentmybatis.wrapper.DeptUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * DeptDefaults
 *
 * @author powered by FluentMybatis
 */
public class DeptDefaults implements IDefaultSetter, IDefaultGetter {
  public static final DeptDefaults INSTANCE = new DeptDefaults();

  private TableDynamic dynamic;

  private DeptDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public DeptQuery query() {
    return new DeptQuery();
  }

  @Override
  public DeptQuery defaultQuery() {
    DeptQuery query = new DeptQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public DeptUpdate updater() {
    return new DeptUpdate();
  }

  @Override
  public DeptUpdate defaultUpdater() {
    DeptUpdate updater = new DeptUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public DeptQuery aliasQuery() {
    Parameters parameters = new Parameters();
    DeptQuery query = new DeptQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public DeptQuery aliasQuery(String alias) {
    DeptQuery query = new DeptQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public DeptQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    DeptQuery query = new DeptQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public DeptQuery aliasWith(String alias, BaseQuery fromQuery) {
    DeptQuery query = new DeptQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public DeptDefaults setTableDynamic(TableDynamic dynamic) {
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
