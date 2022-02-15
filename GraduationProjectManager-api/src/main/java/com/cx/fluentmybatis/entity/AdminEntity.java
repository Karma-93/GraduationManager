package com.cx.fluentmybatis.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import cn.org.atool.fluent.mybatis.functions.TableSupplier;
import java.io.Serializable;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * AdminEntity: 数据映射实体定义
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
    table = "admin"
)
public class AdminEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键,管理员id
   */
  @TableId(
      value = "admin_id",
      auto = false
  )
  private String adminId;

  /**
   * 外键,用户id
   */
  @TableField("user_id")
  private String userId;

  @Override
  public Serializable findPk() {
    return this.adminId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return AdminEntity.class;
  }

  @Override
  public final AdminEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final AdminEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
