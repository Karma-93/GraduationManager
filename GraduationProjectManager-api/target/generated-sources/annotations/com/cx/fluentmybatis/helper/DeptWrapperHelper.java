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
import com.cx.fluentmybatis.wrapper.DeptQuery;
import com.cx.fluentmybatis.wrapper.DeptUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * DeptWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class DeptWrapperHelper {
  /**
   * 默认设置器
   */
  private static final DeptDefaults defaults = DeptDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R deptId() {
      return this.set(DeptMapping.deptId);
    }

    default R deptName() {
      return this.set(DeptMapping.deptName);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, DeptQuery> implements ISegment<Selector> {
    public Selector(DeptQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector deptId(String _alias_) {
      return this.process(DeptMapping.deptId, _alias_);
    }

    public Selector deptName(String _alias_) {
      return this.process(DeptMapping.deptName, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, DeptQuery, DeptQuery> {
    public QueryWhere(DeptQuery query) {
      super(query);
    }

    private QueryWhere(DeptQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((DeptQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((DeptQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, DeptQuery> deptId() {
      return this.set(DeptMapping.deptId);
    }

    public StringWhere<QueryWhere, DeptQuery> deptName() {
      return this.set(DeptMapping.deptName);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, DeptUpdate, DeptQuery> {
    public UpdateWhere(DeptUpdate updater) {
      super(updater);
    }

    private UpdateWhere(DeptUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((DeptUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((DeptUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, DeptQuery> deptId() {
      return this.set(DeptMapping.deptId);
    }

    public StringWhere<UpdateWhere, DeptQuery> deptName() {
      return this.set(DeptMapping.deptName);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, DeptQuery> implements ISegment<GroupBy> {
    public GroupBy(DeptQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, DeptQuery> implements ISegment<HavingOperator<Having>> {
    public Having(DeptQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, DeptQuery> implements ISegment<OrderByApply<QueryOrderBy, DeptQuery>> {
    public QueryOrderBy(DeptQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, DeptUpdate> implements ISegment<OrderByApply<UpdateOrderBy, DeptUpdate>> {
    public UpdateOrderBy(DeptUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, DeptUpdate> implements ISegment<UpdateApply<UpdateSetter, DeptUpdate>> {
    public UpdateSetter(DeptUpdate updater) {
      super(updater);
    }
  }
}
