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
import cn.org.atool.fluent.mybatis.segment.where.StringWhere;
import com.cx.fluentmybatis.wrapper.AdminQuery;
import com.cx.fluentmybatis.wrapper.AdminUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * AdminWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class AdminWrapperHelper {
  /**
   * 默认设置器
   */
  private static final AdminDefaults defaults = AdminDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R adminId() {
      return this.set(AdminMapping.adminId);
    }

    default R userId() {
      return this.set(AdminMapping.userId);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, AdminQuery> implements ISegment<Selector> {
    public Selector(AdminQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector adminId(String _alias_) {
      return this.process(AdminMapping.adminId, _alias_);
    }

    public Selector userId(String _alias_) {
      return this.process(AdminMapping.userId, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, AdminQuery, AdminQuery> {
    public QueryWhere(AdminQuery query) {
      super(query);
    }

    private QueryWhere(AdminQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((AdminQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((AdminQuery) super.wrapper);
      return super.and;
    }

    public StringWhere<QueryWhere, AdminQuery> adminId() {
      return this.set(AdminMapping.adminId);
    }

    public StringWhere<QueryWhere, AdminQuery> userId() {
      return this.set(AdminMapping.userId);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, AdminUpdate, AdminQuery> {
    public UpdateWhere(AdminUpdate updater) {
      super(updater);
    }

    private UpdateWhere(AdminUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((AdminUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((AdminUpdate) super.wrapper);
      return super.and;
    }

    public StringWhere<UpdateWhere, AdminQuery> adminId() {
      return this.set(AdminMapping.adminId);
    }

    public StringWhere<UpdateWhere, AdminQuery> userId() {
      return this.set(AdminMapping.userId);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, AdminQuery> implements ISegment<GroupBy> {
    public GroupBy(AdminQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, AdminQuery> implements ISegment<HavingOperator<Having>> {
    public Having(AdminQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, AdminQuery> implements ISegment<OrderByApply<QueryOrderBy, AdminQuery>> {
    public QueryOrderBy(AdminQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, AdminUpdate> implements ISegment<OrderByApply<UpdateOrderBy, AdminUpdate>> {
    public UpdateOrderBy(AdminUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, AdminUpdate> implements ISegment<UpdateApply<UpdateSetter, AdminUpdate>> {
    public UpdateSetter(AdminUpdate updater) {
      super(updater);
    }
  }
}
