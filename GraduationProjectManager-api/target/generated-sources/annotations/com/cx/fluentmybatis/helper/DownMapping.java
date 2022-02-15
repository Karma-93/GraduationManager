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
 * DownMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface DownMapping extends IMapping {
  DownMapping MAPPING = new DownMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "down";

  /**
   * Entity名称
   */
  String Entity_Name = "DownEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  downId : down_id
   */
  FieldMapping downId = new FieldMapping("downId", "down_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  adminId : admin_id
   */
  FieldMapping adminId = new FieldMapping("adminId", "admin_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  createDate : create_date
   */
  FieldMapping createDate = new FieldMapping("createDate", "create_date");

  /**
   * 实体属性 : 数据库字段 映射
   *  downPath : down_path
   */
  FieldMapping downPath = new FieldMapping("downPath", "down_path");

  /**
   * 实体属性 : 数据库字段 映射
   *  downTitle : down_title
   */
  FieldMapping downTitle = new FieldMapping("downTitle", "down_title");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(downId.name, downId.column);
  		this.put(adminId.name, adminId.column);
  		this.put(createDate.name, createDate.column);
  		this.put(downPath.name, downPath.column);
  		this.put(downTitle.name, downTitle.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(downId.column, downId);
  		this.put(adminId.column, adminId);
  		this.put(createDate.column, createDate);
  		this.put(downPath.column, downPath);
  		this.put(downTitle.column, downTitle);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		downId.column,
  		adminId.column,
  		createDate.column,
  		downPath.column,
  		downTitle.column
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
    		return ofNullable(downId);
    	default:
    		return ofNullable(null);
    }
  }
}
