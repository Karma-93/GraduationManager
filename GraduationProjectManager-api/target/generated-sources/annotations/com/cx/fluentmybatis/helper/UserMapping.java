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
 * UserMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface UserMapping extends IMapping {
  UserMapping MAPPING = new UserMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "user";

  /**
   * Entity名称
   */
  String Entity_Name = "UserEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  userId : user_id
   */
  FieldMapping userId = new FieldMapping("userId", "user_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  userAccount : user_account
   */
  FieldMapping userAccount = new FieldMapping("userAccount", "user_account");

  /**
   * 实体属性 : 数据库字段 映射
   *  userName : user_name
   */
  FieldMapping userName = new FieldMapping("userName", "user_name");

  /**
   * 实体属性 : 数据库字段 映射
   *  userPassword : user_password
   */
  FieldMapping userPassword = new FieldMapping("userPassword", "user_password");

  /**
   * 实体属性 : 数据库字段 映射
   *  userRoles : user_roles
   */
  FieldMapping userRoles = new FieldMapping("userRoles", "user_roles");

  /**
   * 实体属性 : 数据库字段 映射
   *  userSex : user_sex
   */
  FieldMapping userSex = new FieldMapping("userSex", "user_sex");

  /**
   * 实体属性 : 数据库字段 映射
   *  userTel : user_tel
   */
  FieldMapping userTel = new FieldMapping("userTel", "user_tel");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(userId.name, userId.column);
  		this.put(userAccount.name, userAccount.column);
  		this.put(userName.name, userName.column);
  		this.put(userPassword.name, userPassword.column);
  		this.put(userRoles.name, userRoles.column);
  		this.put(userSex.name, userSex.column);
  		this.put(userTel.name, userTel.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(userId.column, userId);
  		this.put(userAccount.column, userAccount);
  		this.put(userName.column, userName);
  		this.put(userPassword.column, userPassword);
  		this.put(userRoles.column, userRoles);
  		this.put(userSex.column, userSex);
  		this.put(userTel.column, userTel);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		userId.column,
  		userAccount.column,
  		userName.column,
  		userPassword.column,
  		userRoles.column,
  		userSex.column,
  		userTel.column
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
    		return ofNullable(userId);
    	default:
    		return ofNullable(null);
    }
  }
}
