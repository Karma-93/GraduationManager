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
import com.cx.fluentmybatis.wrapper.InformQuery;
import com.cx.fluentmybatis.wrapper.InformUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * InformWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class InformWrapperHelper {
  /**
   * 默认设置器
   */
  private static final InformDefaults defaults = InformDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R informId() {
      return this.set(InformMapping.informId);
    }

    default R adminId() {
      return this.set(InformMapping.adminId);
    }

    default R attachmentPath() {
      return this.set(InformMapping.attachmentPath);
    }

    default R createDate() {
      return this.set(InformMapping.createDate);
    }

    default R informBody() {
      return this.set(InformMapping.informBody);
    }

    default R informTitle() {
      return this.set(InformMapping.informTitle);
    }

    default R isAttachment() {
      return this.set(InformMapping.isAttachment);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, InformQuery> implements ISegment<Selector> {
    public Selector(InformQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector informId(String _alias_) {
      return this.process(InformMapping.informId, _alias_);
    }

    public Selector adminId(String _alias_) {
      return this.process(InformMapping.adminId, _alias_);
    }

    public Selector attachmentPath(String _alias_) {
      return this.process(InformMapping.attachmentPath, _alias_);
    }

    public Selector createDate(String _alias_) {
      return this.process(InformMapping.createDate, _alias_);
    }

    public Selector informBody(String _alias_) {
      return this.process(InformMapping.informBody, _alias_);
    }

    public Selector informTitle(String _alias_) {
      return this.process(InformMapping.informTitle, _alias_);
    }

    public Selector isAttachment(String _alias_) {
      return this.process(InformMapping.isAttachment, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, InformQuery, InformQuery> {
    public QueryWhere(InformQuery query) {
      super(query);
    }

    private QueryWhere(InformQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((InformQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((InformQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, InformQuery> informId() {
      return this.set(InformMapping.informId);
    }

    public StringWhere<QueryWhere, InformQuery> adminId() {
      return this.set(InformMapping.adminId);
    }

    public StringWhere<QueryWhere, InformQuery> attachmentPath() {
      return this.set(InformMapping.attachmentPath);
    }

    public ObjectWhere<QueryWhere, InformQuery> createDate() {
      return this.set(InformMapping.createDate);
    }

    public StringWhere<QueryWhere, InformQuery> informBody() {
      return this.set(InformMapping.informBody);
    }

    public StringWhere<QueryWhere, InformQuery> informTitle() {
      return this.set(InformMapping.informTitle);
    }

    public NumericWhere<QueryWhere, InformQuery> isAttachment() {
      return this.set(InformMapping.isAttachment);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, InformUpdate, InformQuery> {
    public UpdateWhere(InformUpdate updater) {
      super(updater);
    }

    private UpdateWhere(InformUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((InformUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((InformUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, InformQuery> informId() {
      return this.set(InformMapping.informId);
    }

    public StringWhere<UpdateWhere, InformQuery> adminId() {
      return this.set(InformMapping.adminId);
    }

    public StringWhere<UpdateWhere, InformQuery> attachmentPath() {
      return this.set(InformMapping.attachmentPath);
    }

    public ObjectWhere<UpdateWhere, InformQuery> createDate() {
      return this.set(InformMapping.createDate);
    }

    public StringWhere<UpdateWhere, InformQuery> informBody() {
      return this.set(InformMapping.informBody);
    }

    public StringWhere<UpdateWhere, InformQuery> informTitle() {
      return this.set(InformMapping.informTitle);
    }

    public NumericWhere<UpdateWhere, InformQuery> isAttachment() {
      return this.set(InformMapping.isAttachment);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, InformQuery> implements ISegment<GroupBy> {
    public GroupBy(InformQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, InformQuery> implements ISegment<HavingOperator<Having>> {
    public Having(InformQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, InformQuery> implements ISegment<OrderByApply<QueryOrderBy, InformQuery>> {
    public QueryOrderBy(InformQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, InformUpdate> implements ISegment<OrderByApply<UpdateOrderBy, InformUpdate>> {
    public UpdateOrderBy(InformUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, InformUpdate> implements ISegment<UpdateApply<UpdateSetter, InformUpdate>> {
    public UpdateSetter(InformUpdate updater) {
      super(updater);
    }
  }
}
