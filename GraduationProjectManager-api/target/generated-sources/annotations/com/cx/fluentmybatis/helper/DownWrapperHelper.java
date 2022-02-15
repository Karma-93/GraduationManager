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
import cn.org.atool.fluent.mybatis.segment.where.ObjectWhere;
import cn.org.atool.fluent.mybatis.segment.where.StringWhere;
import com.cx.fluentmybatis.wrapper.DownQuery;
import com.cx.fluentmybatis.wrapper.DownUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * DownWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class DownWrapperHelper {
  /**
   * 默认设置器
   */
  private static final DownDefaults defaults = DownDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R downId() {
      return this.set(DownMapping.downId);
    }

    default R adminId() {
      return this.set(DownMapping.adminId);
    }

    default R createDate() {
      return this.set(DownMapping.createDate);
    }

    default R downPath() {
      return this.set(DownMapping.downPath);
    }

    default R downTitle() {
      return this.set(DownMapping.downTitle);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, DownQuery> implements ISegment<Selector> {
    public Selector(DownQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector downId(String _alias_) {
      return this.process(DownMapping.downId, _alias_);
    }

    public Selector adminId(String _alias_) {
      return this.process(DownMapping.adminId, _alias_);
    }

    public Selector createDate(String _alias_) {
      return this.process(DownMapping.createDate, _alias_);
    }

    public Selector downPath(String _alias_) {
      return this.process(DownMapping.downPath, _alias_);
    }

    public Selector downTitle(String _alias_) {
      return this.process(DownMapping.downTitle, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, DownQuery, DownQuery> {
    public QueryWhere(DownQuery query) {
      super(query);
    }

    private QueryWhere(DownQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((DownQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((DownQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, DownQuery> downId() {
      return this.set(DownMapping.downId);
    }

    public StringWhere<QueryWhere, DownQuery> adminId() {
      return this.set(DownMapping.adminId);
    }

    public ObjectWhere<QueryWhere, DownQuery> createDate() {
      return this.set(DownMapping.createDate);
    }

    public StringWhere<QueryWhere, DownQuery> downPath() {
      return this.set(DownMapping.downPath);
    }

    public StringWhere<QueryWhere, DownQuery> downTitle() {
      return this.set(DownMapping.downTitle);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, DownUpdate, DownQuery> {
    public UpdateWhere(DownUpdate updater) {
      super(updater);
    }

    private UpdateWhere(DownUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((DownUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((DownUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, DownQuery> downId() {
      return this.set(DownMapping.downId);
    }

    public StringWhere<UpdateWhere, DownQuery> adminId() {
      return this.set(DownMapping.adminId);
    }

    public ObjectWhere<UpdateWhere, DownQuery> createDate() {
      return this.set(DownMapping.createDate);
    }

    public StringWhere<UpdateWhere, DownQuery> downPath() {
      return this.set(DownMapping.downPath);
    }

    public StringWhere<UpdateWhere, DownQuery> downTitle() {
      return this.set(DownMapping.downTitle);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, DownQuery> implements ISegment<GroupBy> {
    public GroupBy(DownQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, DownQuery> implements ISegment<HavingOperator<Having>> {
    public Having(DownQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, DownQuery> implements ISegment<OrderByApply<QueryOrderBy, DownQuery>> {
    public QueryOrderBy(DownQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, DownUpdate> implements ISegment<OrderByApply<UpdateOrderBy, DownUpdate>> {
    public UpdateOrderBy(DownUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, DownUpdate> implements ISegment<UpdateApply<UpdateSetter, DownUpdate>> {
    public UpdateSetter(DownUpdate updater) {
      super(updater);
    }
  }
}
