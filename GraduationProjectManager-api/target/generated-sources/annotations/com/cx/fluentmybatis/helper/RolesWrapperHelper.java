package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.assertNotNull;

import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.functions.IAggregate;
import cn.org.atool.fluent.mybatis.segment.GroupByBase;
import cn.org.atool.fluent.mybatis.segment.HavingBase;
import cn.org.atool.fluent.mybatis.segment.HavingOperator;
import cn.org.atool.fluent.mybatis.segment.OrderByApply;
import cn.org.atool.fluent.mybatis.segment.OrderByBase;
import cn.org.atool.fluent.mybatis.segment.SelectorBase;
import cn.org.atool.fluent.mybatis.segment.UpdateApply;
import cn.org.atool.fluent.mybatis.segment.UpdateBase;
import cn.org.atool.fluent.mybatis.segment.WhereBase;
import cn.org.atool.fluent.mybatis.segment.where.NumericWhere;
import cn.org.atool.fluent.mybatis.segment.where.StringWhere;
import com.cx.fluentmybatis.wrapper.RolesQuery;
import com.cx.fluentmybatis.wrapper.RolesUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * RolesWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class RolesWrapperHelper {
  /**
   * 默认设置器
   */
  private static final RolesDefaults defaults = RolesDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R rolesId() {
      return this.set(RolesMapping.rolesId);
    }

    default R rolesName() {
      return this.set(RolesMapping.rolesName);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, RolesQuery> implements ISegment<Selector> {
    public Selector(RolesQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector rolesId(String _alias_) {
      return this.process(RolesMapping.rolesId, _alias_);
    }

    public Selector rolesName(String _alias_) {
      return this.process(RolesMapping.rolesName, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, RolesQuery, RolesQuery> {
    public QueryWhere(RolesQuery query) {
      super(query);
    }

    private QueryWhere(RolesQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((RolesQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((RolesQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, RolesQuery> rolesId() {
      return this.set(RolesMapping.rolesId);
    }

    public StringWhere<QueryWhere, RolesQuery> rolesName() {
      return this.set(RolesMapping.rolesName);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, RolesUpdate, RolesQuery> {
    public UpdateWhere(RolesUpdate updater) {
      super(updater);
    }

    private UpdateWhere(RolesUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((RolesUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((RolesUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, RolesQuery> rolesId() {
      return this.set(RolesMapping.rolesId);
    }

    public StringWhere<UpdateWhere, RolesQuery> rolesName() {
      return this.set(RolesMapping.rolesName);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, RolesQuery> implements ISegment<GroupBy> {
    public GroupBy(RolesQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, RolesQuery> implements ISegment<HavingOperator<Having>> {
    public Having(RolesQuery query) {
      super(query);
    }

    protected Having(Having having, IAggregate aggregate) {
      super(having, aggregate);
    }

    @Override
    protected Having aggregateSegment(IAggregate aggregate) {
      return new Having(this, aggregate);
    }
  }

  /**
   * Query OrderBy设置
   */
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, RolesQuery> implements ISegment<OrderByApply<QueryOrderBy, RolesQuery>> {
    public QueryOrderBy(RolesQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, RolesUpdate> implements ISegment<OrderByApply<UpdateOrderBy, RolesUpdate>> {
    public UpdateOrderBy(RolesUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, RolesUpdate> implements ISegment<UpdateApply<UpdateSetter, RolesUpdate>> {
    public UpdateSetter(RolesUpdate updater) {
      super(updater);
    }
  }
}
