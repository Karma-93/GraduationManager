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
 * SessionListEntity: 数据映射实体定义
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
    table = "sessionList"
)
public class SessionListEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   */
  @TableId("id")
  private Integer id;

  /**
   */
  @TableField("list_name")
  private String listName;

  /**
   * 接受者的ID
   */
  @TableField("to_user_id")
  private String toUserId;

  /**
   * 未读消息个数
   */
  @TableField("un_read_count")
  private Integer unReadCount;

  /**
   * 发送者的id
   */
  @TableField("user_id")
  private String userId;

  @Override
  public Serializable findPk() {
    return this.id;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return SessionListEntity.class;
  }

  @Override
  public final SessionListEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final SessionListEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
