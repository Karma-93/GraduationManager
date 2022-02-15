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
import com.cx.fluentmybatis.wrapper.StudentQuery;
import com.cx.fluentmybatis.wrapper.StudentUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * StudentWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class StudentWrapperHelper {
  /**
   * 默认设置器
   */
  private static final StudentDefaults defaults = StudentDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R studentId() {
      return this.set(StudentMapping.studentId);
    }

    default R classId() {
      return this.set(StudentMapping.classId);
    }

    default R projectId() {
      return this.set(StudentMapping.projectId);
    }

    default R projectNum() {
      return this.set(StudentMapping.projectNum);
    }

    default R studentScore() {
      return this.set(StudentMapping.studentScore);
    }

    default R teacherId() {
      return this.set(StudentMapping.teacherId);
    }

    default R userId() {
      return this.set(StudentMapping.userId);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, StudentQuery> implements ISegment<Selector> {
    public Selector(StudentQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector studentId(String _alias_) {
      return this.process(StudentMapping.studentId, _alias_);
    }

    public Selector classId(String _alias_) {
      return this.process(StudentMapping.classId, _alias_);
    }

    public Selector projectId(String _alias_) {
      return this.process(StudentMapping.projectId, _alias_);
    }

    public Selector projectNum(String _alias_) {
      return this.process(StudentMapping.projectNum, _alias_);
    }

    public Selector studentScore(String _alias_) {
      return this.process(StudentMapping.studentScore, _alias_);
    }

    public Selector teacherId(String _alias_) {
      return this.process(StudentMapping.teacherId, _alias_);
    }

    public Selector userId(String _alias_) {
      return this.process(StudentMapping.userId, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, StudentQuery, StudentQuery> {
    public QueryWhere(StudentQuery query) {
      super(query);
    }

    private QueryWhere(StudentQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((StudentQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((StudentQuery) super.wrapper);
      return super.and;
    }

    public StringWhere<QueryWhere, StudentQuery> studentId() {
      return this.set(StudentMapping.studentId);
    }

    public NumericWhere<QueryWhere, StudentQuery> classId() {
      return this.set(StudentMapping.classId);
    }

    public NumericWhere<QueryWhere, StudentQuery> projectId() {
      return this.set(StudentMapping.projectId);
    }

    public NumericWhere<QueryWhere, StudentQuery> projectNum() {
      return this.set(StudentMapping.projectNum);
    }

    public NumericWhere<QueryWhere, StudentQuery> studentScore() {
      return this.set(StudentMapping.studentScore);
    }

    public StringWhere<QueryWhere, StudentQuery> teacherId() {
      return this.set(StudentMapping.teacherId);
    }

    public StringWhere<QueryWhere, StudentQuery> userId() {
      return this.set(StudentMapping.userId);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, StudentUpdate, StudentQuery> {
    public UpdateWhere(StudentUpdate updater) {
      super(updater);
    }

    private UpdateWhere(StudentUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((StudentUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((StudentUpdate) super.wrapper);
      return super.and;
    }

    public StringWhere<UpdateWhere, StudentQuery> studentId() {
      return this.set(StudentMapping.studentId);
    }

    public NumericWhere<UpdateWhere, StudentQuery> classId() {
      return this.set(StudentMapping.classId);
    }

    public NumericWhere<UpdateWhere, StudentQuery> projectId() {
      return this.set(StudentMapping.projectId);
    }

    public NumericWhere<UpdateWhere, StudentQuery> projectNum() {
      return this.set(StudentMapping.projectNum);
    }

    public NumericWhere<UpdateWhere, StudentQuery> studentScore() {
      return this.set(StudentMapping.studentScore);
    }

    public StringWhere<UpdateWhere, StudentQuery> teacherId() {
      return this.set(StudentMapping.teacherId);
    }

    public StringWhere<UpdateWhere, StudentQuery> userId() {
      return this.set(StudentMapping.userId);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, StudentQuery> implements ISegment<GroupBy> {
    public GroupBy(StudentQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, StudentQuery> implements ISegment<HavingOperator<Having>> {
    public Having(StudentQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, StudentQuery> implements ISegment<OrderByApply<QueryOrderBy, StudentQuery>> {
    public QueryOrderBy(StudentQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, StudentUpdate> implements ISegment<OrderByApply<UpdateOrderBy, StudentUpdate>> {
    public UpdateOrderBy(StudentUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, StudentUpdate> implements ISegment<UpdateApply<UpdateSetter, StudentUpdate>> {
    public UpdateSetter(StudentUpdate updater) {
      super(updater);
    }
  }
}
