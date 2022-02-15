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
 * AdminMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface AdminMapping extends IMapping {
  AdminMapping MAPPING = new AdminMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "admin";

  /**
   * Entity名称
   */
  String Entity_Name = "AdminEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  adminId : admin_id
   */
  FieldMapping adminId = new FieldMapping("adminId", "admin_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  userId : user_id
   */
  FieldMapping userId = new FieldMapping("userId", "user_id");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(adminId.name, adminId.column);
  		this.put(userId.name, userId.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(adminId.column, adminId);
  		this.put(userId.column, userId);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		adminId.column,
  		userId.column
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
    		return ofNullable(adminId);
    	default:
    		return ofNullable(null);
    }
  }
}
