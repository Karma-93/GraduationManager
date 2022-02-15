package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.TeacherMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.TeacherQuery;
import com.cx.fluentmybatis.wrapper.TeacherUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * TeacherDefaults
 *
 * @author powered by FluentMybatis
 */
public class TeacherDefaults implements IDefaultSetter, IDefaultGetter {
  public static final TeacherDefaults INSTANCE = new TeacherDefaults();

  private TableDynamic dynamic;

  private TeacherDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public TeacherQuery query() {
    return new TeacherQuery();
  }

  @Override
  public TeacherQuery defaultQuery() {
    TeacherQuery query = new TeacherQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public TeacherUpdate updater() {
    return new TeacherUpdate();
  }

  @Override
  public TeacherUpdate defaultUpdater() {
    TeacherUpdate updater = new TeacherUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public TeacherQuery aliasQuery() {
    Parameters parameters = new Parameters();
    TeacherQuery query = new TeacherQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public TeacherQuery aliasQuery(String alias) {
    TeacherQuery query = new TeacherQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public TeacherQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    TeacherQuery query = new TeacherQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public TeacherQuery aliasWith(String alias, BaseQuery fromQuery) {
    TeacherQuery query = new TeacherQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public TeacherDefaults setTableDynamic(TableDynamic dynamic) {
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
