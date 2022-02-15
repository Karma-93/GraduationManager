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
 * InformEntity: 数据映射实体定义
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
    table = "inform"
)
public class InformEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键,通知公告id
   */
  @TableId("inform_id")
  private Integer informId;

  /**
   * 外键,管理员id
   */
  @TableField("admin_id")
  private String adminId;

  /**
   * 附件地址
   */
  @TableField("attachment_path")
  private String attachmentPath;

  /**
   * 创建时间
   */
  @TableField("create_date")
  private Date createDate;

  /**
   * 通知公告主体
   */
  @TableField("inform_body")
  private String informBody;

  /**
   * 通知公告标题
   */
  @TableField("inform_title")
  private String informTitle;

  /**
   * 是否有附件(0否1有)
   */
  @TableField("is_attachment")
  private Integer isAttachment;

  @Override
  public Serializable findPk() {
    return this.informId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return InformEntity.class;
  }

  @Override
  public final InformEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final InformEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
