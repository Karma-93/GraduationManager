package com.cx.fluentmybatis.helper;

import static java.util.Optional.ofNullable;

import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldType;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * InformMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface InformMapping extends IMapping {
  InformMapping MAPPING = new InformMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "inform";

  /**
   * Entity名称
   */
  String Entity_Name = "InformEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  informId : inform_id
   */
  FieldMapping informId = new FieldMapping("informId", "inform_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  adminId : admin_id
   */
  FieldMapping adminId = new FieldMapping("adminId", "admin_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  attachmentPath : attachment_path
   */
  FieldMapping attachmentPath = new FieldMapping("attachmentPath", "attachment_path");

  /**
   * 实体属性 : 数据库字段 映射
   *  createDate : create_date
   */
  FieldMapping createDate = new FieldMapping("createDate", "create_date");

  /**
   * 实体属性 : 数据库字段 映射
   *  informBody : inform_body
   */
  FieldMapping informBody = new FieldMapping("informBody", "inform_body");

  /**
   * 实体属性 : 数据库字段 映射
   *  informTitle : inform_title
   */
  FieldMapping informTitle = new FieldMapping("informTitle", "inform_title");

  /**
   * 实体属性 : 数据库字段 映射
   *  isAttachment : is_attachment
   */
  FieldMapping isAttachment = new FieldMapping("isAttachment", "is_attachment");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(informId.name, informId.column);
  		this.put(adminId.name, adminId.column);
  		this.put(attachmentPath.name, attachmentPath.column);
  		this.put(createDate.name, createDate.column);
  		this.put(informBody.name, informBody.column);
  		this.put(informTitle.name, informTitle.column);
  		this.put(isAttachment.name, isAttachment.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(informId.column, informId);
  		this.put(adminId.column, adminId);
  		this.put(attachmentPath.column, attachmentPath);
  		this.put(createDate.column, createDate);
  		this.put(informBody.column, informBody);
  		this.put(informTitle.column, informTitle);
  		this.put(isAttachment.column, isAttachment);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		informId.column,
  		adminId.column,
  		attachmentPath.column,
  		createDate.column,
  		informBody.column,
  		informTitle.column,
  		isAttachment.column
  );

  /**
   * 数据库所有字段列表用逗号分隔
   */
  String ALL_JOIN_COLUMNS = String.join(", ", ALL_COLUMNS);

  @Override
  default String findColumnByField(String field) {
    return Property2Column.get(field);
  }

  @Override
  default Optional<FieldMapping> findField(FieldType type) {
    switch (type) {
    	case PRIMARY_ID:
    		return ofNullable(informId);
    	default:
    		return ofNullable(null);
    }
  }
}
