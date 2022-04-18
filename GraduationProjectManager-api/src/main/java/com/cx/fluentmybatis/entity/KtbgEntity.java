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
 * KtbgEntity: 数据映射实体定义
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
    table = "ktbg"
)
public class KtbgEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键,id
   */
  @TableId("ktbg_id")
  private Integer ktbgId;

  /**
   * 综述
   */
  @TableField("column1")
  private String column1;

  /**
   * 思路及方法
   */
  @TableField("column2")
  private String column2;

  /**
   * 教师评审意见（0未通过，1通过）
   */
  @TableField("ktbg_status")
  private Integer ktbgStatus;

  /**
   * 外键,学生id
   */
  @TableField("student_id")
  private String studentId;

  @Override
  public Serializable findPk() {
    return this.ktbgId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return KtbgEntity.class;
  }

  @Override
  public final KtbgEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final KtbgEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
