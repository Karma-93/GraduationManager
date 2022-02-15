package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.StudentMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.StudentQuery;
import com.cx.fluentmybatis.wrapper.StudentUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * StudentDefaults
 *
 * @author powered by FluentMybatis
 */
public class StudentDefaults implements IDefaultSetter, IDefaultGetter {
  public static final StudentDefaults INSTANCE = new StudentDefaults();

  private TableDynamic dynamic;

  private StudentDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public StudentQuery query() {
    return new StudentQuery();
  }

  @Override
  public StudentQuery defaultQuery() {
    StudentQuery query = new StudentQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public StudentUpdate updater() {
    return new StudentUpdate();
  }

  @Override
  public StudentUpdate defaultUpdater() {
    StudentUpdate updater = new StudentUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public StudentQuery aliasQuery() {
    Parameters parameters = new Parameters();
    StudentQuery query = new StudentQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public StudentQuery aliasQuery(String alias) {
    StudentQuery query = new StudentQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public StudentQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    StudentQuery query = new StudentQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public StudentQuery aliasWith(String alias, BaseQuery fromQuery) {
    StudentQuery query = new StudentQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public StudentDefaults setTableDynamic(TableDynamic dynamic) {
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
