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
 * ClassiEntity: 数据映射实体定义
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
    table = "classi"
)
public class ClassiEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   */
  @TableId(
      value = "class_id",
      auto = false
  )
  private Integer classId;

  /**
   */
  @TableField("class_name")
  private String className;

  /**
   */
  @TableField("subject_id")
  private Integer subjectId;

  @Override
  public Serializable findPk() {
    return this.classId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return ClassiEntity.class;
  }

  @Override
  public final ClassiEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final ClassiEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
