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
 * ProjectFromEntity: 数据映射实体定义
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
    table = "project_from"
)
public class ProjectFromEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键,id
   */
  @TableId("project_from_id")
  private Integer projectFromId;

  /**
   * 课题来源(教师建议 学生拟定 企业和社会征集 科研单位提供)
   */
  @TableField("project_from_name")
  private String projectFromName;

  @Override
  public Serializable findPk() {
    return this.projectFromId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return ProjectFromEntity.class;
  }

  @Override
  public final ProjectFromEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final ProjectFromEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
