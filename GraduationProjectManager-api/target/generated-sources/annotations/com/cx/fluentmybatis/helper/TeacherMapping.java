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
 * TeacherMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface TeacherMapping extends IMapping {
  TeacherMapping MAPPING = new TeacherMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "teacher";

  /**
   * Entity名称
   */
  String Entity_Name = "TeacherEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  teacherId : teacher_id
   */
  FieldMapping teacherId = new FieldMapping("teacherId", "teacher_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  deptId : dept_id
   */
  FieldMapping deptId = new FieldMapping("deptId", "dept_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  teacherDescribe : teacher_describe
   */
  FieldMapping teacherDescribe = new FieldMapping("teacherDescribe", "teacher_describe");

  /**
   * 实体属性 : 数据库字段 映射
   *  teacherProjectNum : teacher_project_num
   */
  FieldMapping teacherProjectNum = new FieldMapping("teacherProjectNum", "teacher_project_num");

  /**
   * 实体属性 : 数据库字段 映射
   *  userId : user_id
   */
  FieldMapping userId = new FieldMapping("userId", "user_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  zhicheng : zhicheng
   */
  FieldMapping zhicheng = new FieldMapping("zhicheng", "zhicheng");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(teacherId.name, teacherId.column);
  		this.put(deptId.name, deptId.column);
  		this.put(teacherDescribe.name, teacherDescribe.column);
  		this.put(teacherProjectNum.name, teacherProjectNum.column);
  		this.put(userId.name, userId.column);
  		this.put(zhicheng.name, zhicheng.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(teacherId.column, teacherId);
  		this.put(deptId.column, deptId);
  		this.put(teacherDescribe.column, teacherDescribe);
  		this.put(teacherProjectNum.column, teacherProjectNum);
  		this.put(userId.column, userId);
  		this.put(zhicheng.column, zhicheng);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		teacherId.column,
  		deptId.column,
  		teacherDescribe.column,
  		teacherProjectNum.column,
  		userId.column,
  		zhicheng.column
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
    		return ofNullable(teacherId);
    	default:
    		return ofNullable(null);
    }
  }
}
