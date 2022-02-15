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
 * StudentMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface StudentMapping extends IMapping {
  StudentMapping MAPPING = new StudentMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "student";

  /**
   * Entity名称
   */
  String Entity_Name = "StudentEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  studentId : student_id
   */
  FieldMapping studentId = new FieldMapping("studentId", "student_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  classId : class_id
   */
  FieldMapping classId = new FieldMapping("classId", "class_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  projectId : project_id
   */
  FieldMapping projectId = new FieldMapping("projectId", "project_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  projectNum : project_num
   */
  FieldMapping projectNum = new FieldMapping("projectNum", "project_num");

  /**
   * 实体属性 : 数据库字段 映射
   *  studentScore : student_score
   */
  FieldMapping studentScore = new FieldMapping("studentScore", "student_score");

  /**
   * 实体属性 : 数据库字段 映射
   *  teacherId : teacher_id
   */
  FieldMapping teacherId = new FieldMapping("teacherId", "teacher_id");

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
  		this.put(studentId.name, studentId.column);
  		this.put(classId.name, classId.column);
  		this.put(projectId.name, projectId.column);
  		this.put(projectNum.name, projectNum.column);
  		this.put(studentScore.name, studentScore.column);
  		this.put(teacherId.name, teacherId.column);
  		this.put(userId.name, userId.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(studentId.column, studentId);
  		this.put(classId.column, classId);
  		this.put(projectId.column, projectId);
  		this.put(projectNum.column, projectNum);
  		this.put(studentScore.column, studentScore);
  		this.put(teacherId.column, teacherId);
  		this.put(userId.column, userId);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		studentId.column,
  		classId.column,
  		projectId.column,
  		projectNum.column,
  		studentScore.column,
  		teacherId.column,
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
    		return ofNullable(studentId);
    	default:
    		return ofNullable(null);
    }
  }
}
