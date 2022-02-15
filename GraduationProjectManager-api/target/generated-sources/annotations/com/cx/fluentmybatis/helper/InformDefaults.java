package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.InformMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.InformQuery;
import com.cx.fluentmybatis.wrapper.InformUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * InformDefaults
 *
 * @author powered by FluentMybatis
 */
public class InformDefaults implements IDefaultSetter, IDefaultGetter {
  public static final InformDefaults INSTANCE = new InformDefaults();

  private TableDynamic dynamic;

  private InformDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public InformQuery query() {
    return new InformQuery();
  }

  @Override
  public InformQuery defaultQuery() {
    InformQuery query = new InformQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public InformUpdate updater() {
    return new InformUpdate();
  }

  @Override
  public InformUpdate defaultUpdater() {
    InformUpdate updater = new InformUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public InformQuery aliasQuery() {
    Parameters parameters = new Parameters();
    InformQuery query = new InformQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public InformQuery aliasQuery(String alias) {
    InformQuery query = new InformQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public InformQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    InformQuery query = new InformQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public InformQuery aliasWith(String alias, BaseQuery fromQuery) {
    InformQuery query = new InformQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public InformDefaults setTableDynamic(TableDynamic dynamic) {
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
