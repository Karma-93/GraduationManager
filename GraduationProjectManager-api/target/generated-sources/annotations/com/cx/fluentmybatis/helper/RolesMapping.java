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
 * RolesMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface RolesMapping extends IMapping {
  RolesMapping MAPPING = new RolesMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "roles";

  /**
   * Entity名称
   */
  String Entity_Name = "RolesEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  rolesId : roles_id
   */
  FieldMapping rolesId = new FieldMapping("rolesId", "roles_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  rolesName : roles_name
   */
  FieldMapping rolesName = new FieldMapping("rolesName", "roles_name");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(rolesId.name, rolesId.column);
  		this.put(rolesName.name, rolesName.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(rolesId.column, rolesId);
  		this.put(rolesName.column, rolesName);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		rolesId.column,
  		rolesName.column
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
    		return ofNullable(rolesId);
    	default:
    		return ofNullable(null);
    }
  }
}
