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
 * LunwenEntity: 数据映射实体定义
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
    table = "lunwen"
)
public class LunwenEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键,id
   */
  @TableId("lunwen_id")
  private Integer lunwenId;

  /**
   * 论文上传时间
   */
  @TableField("lunwen_date")
  private Date lunwenDate;

  /**
   * 论文名
   */
  @TableField("lunwen_name")
  private String lunwenName;

  /**
   * 论文上传路径
   */
  @TableField("lunwen_path")
  private String lunwenPath;

  /**
   * 论文被审核之后的状态(0退回修改1评审打分)
   */
  @TableField("lunwen_status")
  private Integer lunwenStatus;

  /**
   * 外键,学生id
   */
  @TableField("student_id")
  private String studentId;

  @Override
  public Serializable findPk() {
    return this.lunwenId;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return LunwenEntity.class;
  }

  @Override
  public final LunwenEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final LunwenEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
