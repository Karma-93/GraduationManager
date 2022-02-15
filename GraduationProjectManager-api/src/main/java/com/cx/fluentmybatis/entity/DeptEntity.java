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
 * DeptEntity: 数据映射实体定义
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
    table = "dept"
)
public class DeptEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键,部门id
   */
  @TableId("dept_id")
  private Integer deptId;

  /**
   * 部门科室名
   */
  @TableField("dept_name")
  private String deptName;

  @Override
  public Serializable findPk() {
    return this.deptId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return DeptEntity.class;
  }

  @Override
  public final DeptEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final DeptEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
