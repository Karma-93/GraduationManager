package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.DownMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.DownQuery;
import com.cx.fluentmybatis.wrapper.DownUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * DownDefaults
 *
 * @author powered by FluentMybatis
 */
public class DownDefaults implements IDefaultSetter, IDefaultGetter {
  public static final DownDefaults INSTANCE = new DownDefaults();

  private TableDynamic dynamic;

  private DownDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public DownQuery query() {
    return new DownQuery();
  }

  @Override
  public DownQuery defaultQuery() {
    DownQuery query = new DownQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public DownUpdate updater() {
    return new DownUpdate();
  }

  @Override
  public DownUpdate defaultUpdater() {
    DownUpdate updater = new DownUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public DownQuery aliasQuery() {
    Parameters parameters = new Parameters();
    DownQuery query = new DownQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public DownQuery aliasQuery(String alias) {
    DownQuery query = new DownQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public DownQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    DownQuery query = new DownQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public DownQuery aliasWith(String alias, BaseQuery fromQuery) {
    DownQuery query = new DownQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public DownDefaults setTableDynamic(TableDynamic dynamic) {
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
