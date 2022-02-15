package com.cx.fluentmybatis.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import cn.org.atool.fluent.mybatis.functions.TableSupplier;
import java.io.Serializable;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * StudentEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings("unchecked")
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@FluentMybatis(
    table = "student"
)
public class StudentEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键,学生id
   */
  @TableId(
      value = "student_id",
      auto = false
  )
  private String studentId;

  /**
   * 外键,班级id
   */
  @TableField("class_id")
  private Integer classId;

  /**
   * 外键,课题
   */
  @TableField("project_id")
  private Integer projectId;

  /**
   * 课题数,只能选择一个课题
   */
  @TableField("project_num")
  private Integer projectNum;

  /**
   * 成绩
   */
  @TableField("student_score")
  private Integer studentScore;

  /**
   * 外键,导师id
   */
  @TableField("teacher_id")
  private String teacherId;

  /**
   * 外键,用户id
   */
  @TableField("user_id")
  private String userId;

  @Override
  public Serializable findPk() {
    return this.studentId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return StudentEntity.class;
  }

  @Override
  public final StudentEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final StudentEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
