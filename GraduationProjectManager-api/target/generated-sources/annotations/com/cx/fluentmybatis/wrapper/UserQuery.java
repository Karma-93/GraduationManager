package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;
import static cn.org.atool.fluent.mybatis.mapper.StrConstant.EMPTY;

import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.helper.UserDefaults;
import com.cx.fluentmybatis.helper.UserMapping;
import com.cx.fluentmybatis.helper.UserWrapperHelper.GroupBy;
import com.cx.fluentmybatis.helper.UserWrapperHelper.Having;
import com.cx.fluentmybatis.helper.UserWrapperHelper.QueryOrderBy;
import com.cx.fluentmybatis.helper.UserWrapperHelper.QueryWhere;
import com.cx.fluentmybatis.helper.UserWrapperHelper.Selector;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * UserQuery: 查询构造
 *
 * @author powered by FluentMybatis
 */
public class UserQuery extends BaseQuery<UserEntity, UserQuery> {
  /**
   * 默认设置器
   */
  private static final UserDefaults defaults = UserDefaults.INSTANCE;

  /**
   * 指定查询字段, 默认无需设置
   */
  public final Selector select = new Selector(this);

  /**
   * 分组：GROUP BY 字段, ...
   * 例: groupBy('id', 'name')
   */
  public final GroupBy groupBy = new GroupBy(this);

  /**
   * 分组条件设置 having...
   */
  public final Having having = new Having(this);

  /**
   * 排序设置 order by ...
   */
  public final QueryOrderBy orderBy = new QueryOrderBy(this);

  /**
   * 查询条件 where ...
   */
  public final QueryWhere where = new QueryWhere(this);

  public UserQuery() {
    this(defaults.table(), null);
  }

  public UserQuery(String alias) {
    this(defaults.table(), alias);
  }

  public UserQuery(Supplier<String> table, String alias) {
    super(table, alias, UserEntity.class, UserQuery.class);
  }

  public UserQuery(String alias, Parameters parameters) {
    this(alias);
    this.sharedParameter(parameters);
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return UserMapping.Column2Mapping;
  }

  @Override
  public QueryWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return UserMapping.MAPPING;
  }

  @Override
  public List<String> allFields() {
    return UserMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static UserQuery query() {
    return new UserQuery();
  }

  public static UserQuery query(String alias) {
    return new UserQuery(alias);
  }

  public static UserQuery query(Supplier<String> table) {
    return new UserQuery(table, null);
  }

  public static UserQuery query(Supplier<String> table, String alias) {
    return new UserQuery(table, alias);
  }

  public static UserQuery defaultQuery() {
    return defaults.defaultQuery();
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  public static UserQuery aliasQuery() {
    return defaults.aliasQuery();
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  public static UserQuery aliasQuery(String alias) {
    return defaults.aliasQuery(alias);
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  public static UserQuery aliasWith(BaseQuery fromQuery) {
    return defaults.aliasWith(fromQuery);
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  public static UserQuery aliasWith(String alias, BaseQuery fromQuery) {
    return defaults.aliasWith(alias, fromQuery);
  }
}
