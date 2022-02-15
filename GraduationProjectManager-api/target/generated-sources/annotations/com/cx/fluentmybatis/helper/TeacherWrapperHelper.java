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
import com.cx.fluentmybatis.wrapper.TeacherQuery;
import com.cx.fluentmybatis.wrapper.TeacherUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * TeacherWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class TeacherWrapperHelper {
  /**
   * 默认设置器
   */
  private static final TeacherDefaults defaults = TeacherDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R teacherId() {
      return this.set(TeacherMapping.teacherId);
    }

    default R deptId() {
      return this.set(TeacherMapping.deptId);
    }

    default R teacherDescribe() {
      return this.set(TeacherMapping.teacherDescribe);
    }

    default R teacherProjectNum() {
      return this.set(TeacherMapping.teacherProjectNum);
    }

    default R userId() {
      return this.set(TeacherMapping.userId);
    }

    default R zhicheng() {
      return this.set(TeacherMapping.zhicheng);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, TeacherQuery> implements ISegment<Selector> {
    public Selector(TeacherQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector teacherId(String _alias_) {
      return this.process(TeacherMapping.teacherId, _alias_);
    }

    public Selector deptId(String _alias_) {
      return this.process(TeacherMapping.deptId, _alias_);
    }

    public Selector teacherDescribe(String _alias_) {
      return this.process(TeacherMapping.teacherDescribe, _alias_);
    }

    public Selector teacherProjectNum(String _alias_) {
      return this.process(TeacherMapping.teacherProjectNum, _alias_);
    }

    public Selector userId(String _alias_) {
      return this.process(TeacherMapping.userId, _alias_);
    }

    public Selector zhicheng(String _alias_) {
      return this.process(TeacherMapping.zhicheng, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, TeacherQuery, TeacherQuery> {
    public QueryWhere(TeacherQuery query) {
      super(query);
    }

    private QueryWhere(TeacherQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((TeacherQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((TeacherQuery) super.wrapper);
      return super.and;
    }

    public StringWhere<QueryWhere, TeacherQuery> teacherId() {
      return this.set(TeacherMapping.teacherId);
    }

    public NumericWhere<QueryWhere, TeacherQuery> deptId() {
      return this.set(TeacherMapping.deptId);
    }

    public StringWhere<QueryWhere, TeacherQuery> teacherDescribe() {
      return this.set(TeacherMapping.teacherDescribe);
    }

    public StringWhere<QueryWhere, TeacherQuery> teacherProjectNum() {
      return this.set(TeacherMapping.teacherProjectNum);
    }

    public StringWhere<QueryWhere, TeacherQuery> userId() {
      return this.set(TeacherMapping.userId);
    }

    public StringWhere<QueryWhere, TeacherQuery> zhicheng() {
      return this.set(TeacherMapping.zhicheng);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, TeacherUpdate, TeacherQuery> {
    public UpdateWhere(TeacherUpdate updater) {
      super(updater);
    }

    private UpdateWhere(TeacherUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((TeacherUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((TeacherUpdate) super.wrapper);
      return super.and;
    }

    public StringWhere<UpdateWhere, TeacherQuery> teacherId() {
      return this.set(TeacherMapping.teacherId);
    }

    public NumericWhere<UpdateWhere, TeacherQuery> deptId() {
      return this.set(TeacherMapping.deptId);
    }

    public StringWhere<UpdateWhere, TeacherQuery> teacherDescribe() {
      return this.set(TeacherMapping.teacherDescribe);
    }

    public StringWhere<UpdateWhere, TeacherQuery> teacherProjectNum() {
      return this.set(TeacherMapping.teacherProjectNum);
    }

    public StringWhere<UpdateWhere, TeacherQuery> userId() {
      return this.set(TeacherMapping.userId);
    }

    public StringWhere<UpdateWhere, TeacherQuery> zhicheng() {
      return this.set(TeacherMapping.zhicheng);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, TeacherQuery> implements ISegment<GroupBy> {
    public GroupBy(TeacherQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, TeacherQuery> implements ISegment<HavingOperator<Having>> {
    public Having(TeacherQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, TeacherQuery> implements ISegment<OrderByApply<QueryOrderBy, TeacherQuery>> {
    public QueryOrderBy(TeacherQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, TeacherUpdate> implements ISegment<OrderByApply<UpdateOrderBy, TeacherUpdate>> {
    public UpdateOrderBy(TeacherUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, TeacherUpdate> implements ISegment<UpdateApply<UpdateSetter, TeacherUpdate>> {
    public UpdateSetter(TeacherUpdate updater) {
      super(updater);
    }
  }
}
