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
 * DeptMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface DeptMapping extends IMapping {
  DeptMapping MAPPING = new DeptMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "dept";

  /**
   * Entity名称
   */
  String Entity_Name = "DeptEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  deptId : dept_id
   */
  FieldMapping deptId = new FieldMapping("deptId", "dept_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  deptName : dept_name
   */
  FieldMapping deptName = new FieldMapping("deptName", "dept_name");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(deptId.name, deptId.column);
  		this.put(deptName.name, deptName.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(deptId.column, deptId);
  		this.put(deptName.column, deptName);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		deptId.column,
  		deptName.column
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
    		return ofNullable(deptId);
    	default:
    		return ofNullable(null);
    }
  }
}
