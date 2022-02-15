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
 * TeacherEntity: 数据映射实体定义
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
    table = "teacher"
)
public class TeacherEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键,导师id
   */
  @TableId(
      value = "teacher_id",
      auto = false
  )
  private String teacherId;

  /**
   * 外键,部门id
   */
  @TableField("dept_id")
  private Integer deptId;

  /**
   * 导师描述
   */
  @TableField("teacher_describe")
  private String teacherDescribe;

  /**
   * 导师出题数,限制在8个
   */
  @TableField("teacher_project_num")
  private String teacherProjectNum;

  /**
   * 外键,用户id
   */
  @TableField("user_id")
  private String userId;

  /**
   * 职称
   */
  @TableField("zhicheng")
  private String zhicheng;

  @Override
  public Serializable findPk() {
    return this.teacherId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return TeacherEntity.class;
  }

  @Override
  public final TeacherEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final TeacherEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
