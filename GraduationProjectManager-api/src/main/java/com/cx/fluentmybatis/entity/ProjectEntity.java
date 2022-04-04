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
 * ProjectEntity: 数据映射实体定义
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
    table = "project"
)
public class ProjectEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键,课题id
   */
  @TableId("project_id")
  private Integer projectId;

  /**
   * 课题表述
   */
  @TableField("project_describe")
  private String projectDescribe;

  /**
   * 外键,课题来源
   */
  @TableField("project_from_id")
  private Integer projectFromId;

  /**
   * 课题名
   */
  @TableField("project_name")
  private String projectName;

  /**
   * 该选题的状态，默认状态为0,该课题可选；为1时，待审核，不可选；选题状态2，已被选择，不可选。
   */
  @TableField("project_state")
  private Integer projectState;

  /**
   * 外键,学生id
   */
  @TableField("student_id")
  private String studentId;

  /**
   * 外键,导师id
   */
  @TableField("teacher_id")
  private String teacherId;

  @Override
  public Serializable findPk() {
    return this.projectId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return ProjectEntity.class;
  }

  @Override
  public final ProjectEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final ProjectEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
