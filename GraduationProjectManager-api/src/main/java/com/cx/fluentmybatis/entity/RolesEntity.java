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
 * RolesEntity: 数据映射实体定义
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
    table = "roles"
)
public class RolesEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键,角色id
   */
  @TableId("roles_id")
  private Integer rolesId;

  /**
   * 角色名（导师，学生，管理员，超级管理员）
   */
  @TableField("roles_name")
  private String rolesName;

  @Override
  public Serializable findPk() {
    return this.rolesId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return RolesEntity.class;
  }

  @Override
  public final RolesEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final RolesEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
