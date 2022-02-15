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
 * UserEntity: 数据映射实体定义
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
    table = "user"
)
public class UserEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 用户id
   */
  @TableId(
      value = "user_id",
      auto = false
  )
  private String userId;

  /**
   * 用户登录账号
   */
  @TableField("user_account")
  private String userAccount;

  /**
   * 用户名
   */
  @TableField("user_name")
  private String userName;

  /**
   * 用户密码
   */
  @TableField("user_password")
  private String userPassword;

  /**
   * 用户角色
   */
  @TableField("user_roles")
  private Integer userRoles;

  /**
   * 用户性别
   */
  @TableField("user_sex")
  private Integer userSex;

  /**
   * 用户电话
   */
  @TableField("user_tel")
  private String userTel;

  @Override
  public Serializable findPk() {
    return this.userId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return UserEntity.class;
  }

  @Override
  public final UserEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final UserEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
