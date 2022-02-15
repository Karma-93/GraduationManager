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
import com.cx.fluentmybatis.wrapper.UserQuery;
import com.cx.fluentmybatis.wrapper.UserUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * UserWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class UserWrapperHelper {
  /**
   * 默认设置器
   */
  private static final UserDefaults defaults = UserDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R userId() {
      return this.set(UserMapping.userId);
    }

    default R userAccount() {
      return this.set(UserMapping.userAccount);
    }

    default R userName() {
      return this.set(UserMapping.userName);
    }

    default R userPassword() {
      return this.set(UserMapping.userPassword);
    }

    default R userRoles() {
      return this.set(UserMapping.userRoles);
    }

    default R userSex() {
      return this.set(UserMapping.userSex);
    }

    default R userTel() {
      return this.set(UserMapping.userTel);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, UserQuery> implements ISegment<Selector> {
    public Selector(UserQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector userId(String _alias_) {
      return this.process(UserMapping.userId, _alias_);
    }

    public Selector userAccount(String _alias_) {
      return this.process(UserMapping.userAccount, _alias_);
    }

    public Selector userName(String _alias_) {
      return this.process(UserMapping.userName, _alias_);
    }

    public Selector userPassword(String _alias_) {
      return this.process(UserMapping.userPassword, _alias_);
    }

    public Selector userRoles(String _alias_) {
      return this.process(UserMapping.userRoles, _alias_);
    }

    public Selector userSex(String _alias_) {
      return this.process(UserMapping.userSex, _alias_);
    }

    public Selector userTel(String _alias_) {
      return this.process(UserMapping.userTel, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, UserQuery, UserQuery> {
    public QueryWhere(UserQuery query) {
      super(query);
    }

    private QueryWhere(UserQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((UserQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((UserQuery) super.wrapper);
      return super.and;
    }

    public StringWhere<QueryWhere, UserQuery> userId() {
      return this.set(UserMapping.userId);
    }

    public StringWhere<QueryWhere, UserQuery> userAccount() {
      return this.set(UserMapping.userAccount);
    }

    public StringWhere<QueryWhere, UserQuery> userName() {
      return this.set(UserMapping.userName);
    }

    public StringWhere<QueryWhere, UserQuery> userPassword() {
      return this.set(UserMapping.userPassword);
    }

    public NumericWhere<QueryWhere, UserQuery> userRoles() {
      return this.set(UserMapping.userRoles);
    }

    public NumericWhere<QueryWhere, UserQuery> userSex() {
      return this.set(UserMapping.userSex);
    }

    public StringWhere<QueryWhere, UserQuery> userTel() {
      return this.set(UserMapping.userTel);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, UserUpdate, UserQuery> {
    public UpdateWhere(UserUpdate updater) {
      super(updater);
    }

    private UpdateWhere(UserUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((UserUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((UserUpdate) super.wrapper);
      return super.and;
    }

    public StringWhere<UpdateWhere, UserQuery> userId() {
      return this.set(UserMapping.userId);
    }

    public StringWhere<UpdateWhere, UserQuery> userAccount() {
      return this.set(UserMapping.userAccount);
    }

    public StringWhere<UpdateWhere, UserQuery> userName() {
      return this.set(UserMapping.userName);
    }

    public StringWhere<UpdateWhere, UserQuery> userPassword() {
      return this.set(UserMapping.userPassword);
    }

    public NumericWhere<UpdateWhere, UserQuery> userRoles() {
      return this.set(UserMapping.userRoles);
    }

    public NumericWhere<UpdateWhere, UserQuery> userSex() {
      return this.set(UserMapping.userSex);
    }

    public StringWhere<UpdateWhere, UserQuery> userTel() {
      return this.set(UserMapping.userTel);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, UserQuery> implements ISegment<GroupBy> {
    public GroupBy(UserQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, UserQuery> implements ISegment<HavingOperator<Having>> {
    public Having(UserQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, UserQuery> implements ISegment<OrderByApply<QueryOrderBy, UserQuery>> {
    public QueryOrderBy(UserQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, UserUpdate> implements ISegment<OrderByApply<UpdateOrderBy, UserUpdate>> {
    public UpdateOrderBy(UserUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, UserUpdate> implements ISegment<UpdateApply<UpdateSetter, UserUpdate>> {
    public UpdateSetter(UserUpdate updater) {
      super(updater);
    }
  }
}
