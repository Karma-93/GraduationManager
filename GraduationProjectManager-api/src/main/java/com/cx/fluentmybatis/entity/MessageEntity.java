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
 * MessageEntity: 数据映射实体定义
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
    table = "message"
)
public class MessageEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键,消息id
   */
  @TableId("message_id")
  private Integer messageId;

  /**
   * 创建时间
   */
  @TableField("create_date")
  private Date createDate;

  /**
   * 消息内容
   */
  @TableField("message_body")
  private String messageBody;

  /**
   * 消息类型(0留言1通知)
   */
  @TableField("message_type")
  private Integer messageType;

  /**
   * 是否已读，0未读   1已读
   */
  @TableField("state")
  private Integer state;

  /**
   * 外键,接收者的用户ID
   */
  @TableField("to_user_id")
  private String toUserId;

  /**
   * 外键,发送者的用户ID
   */
  @TableField("user_id")
  private String userId;

  @Override
  public Serializable findPk() {
    return this.messageId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return MessageEntity.class;
  }

  @Override
  public final MessageEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final MessageEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
