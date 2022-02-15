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
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * DownEntity: 数据映射实体定义
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
    table = "down"
)
public class DownEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 公共资源下载
   */
  @TableId("down_id")
  private Integer downId;

  /**
   * 外键,管理员id
   */
  @TableField("admin_id")
  private String adminId;

  /**
   * 创建时间
   */
  @TableField("create_date")
  private Date createDate;

  /**
   * 资源下载地址
   */
  @TableField("down_path")
  private String downPath;

  /**
   * 资源标题
   */
  @TableField("down_title")
  private String downTitle;

  @Override
  public Serializable findPk() {
    return this.downId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return DownEntity.class;
  }

  @Override
  public final DownEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final DownEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
