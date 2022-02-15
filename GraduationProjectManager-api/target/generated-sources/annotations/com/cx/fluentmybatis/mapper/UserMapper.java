package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.helper.UserDefaults;
import com.cx.fluentmybatis.helper.UserMapping;
import com.cx.fluentmybatis.helper.UserSqlProvider;
import com.cx.fluentmybatis.wrapper.UserQuery;
import com.cx.fluentmybatis.wrapper.UserUpdate;
import java.io.Serializable;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

/**
 *
 * UserMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("userMapper")
public interface UserMapper extends IEntityMapper<UserEntity>, IRichMapper<UserEntity>, IWrapperMapper<UserEntity>, IMapper<UserEntity> {
  String ResultMap = "UserEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = UserSqlProvider.class,
      method = "insert"
  )
  @SelectKey(
      resultType = String.class,
      keyProperty = "userId",
      keyColumn = "user_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insert(UserEntity entity);

  @Override
  @InsertProvider(
      type = UserSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(UserEntity entity);

  @Override
  @InsertProvider(
      type = UserSqlProvider.class,
      method = "insertBatch"
  )
  @SelectKey(
      resultType = String.class,
      keyProperty = "userId",
      keyColumn = "user_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insertBatch(@Param(Param_List) Collection<UserEntity> entities);

  @Override
  @InsertProvider(
      type = UserSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<UserEntity> entities);

  /**
   * @see UserSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = UserSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see UserSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = UserSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see UserSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = UserSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see UserSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = UserSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see UserSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = UserSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see UserSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = UserSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see UserSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = UserSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see UserSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = UserSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see UserSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = UserSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = UserSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) UserEntity entity);

  /**
   *  {@link UserSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = UserSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = UserSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "user_id", property = "userId", javaType = String.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "user_account", property = "userAccount", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "user_name", property = "userName", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "user_password", property = "userPassword", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "user_roles", property = "userRoles", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "user_sex", property = "userSex", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "user_tel", property = "userTel", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  UserEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = UserSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  UserEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = UserSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<UserEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = UserSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<UserEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = UserSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<UserEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = UserSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = UserSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = UserSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = UserSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default UserQuery query() {
    return new UserQuery();
  }

  default UserUpdate updater() {
    return new UserUpdate();
  }

  default UserQuery defaultQuery() {
    return UserDefaults.INSTANCE.defaultQuery();
  }

  default UserUpdate defaultUpdater() {
    return UserDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return UserMapping.userId;
  }

  @Override
  default Class<UserEntity> entityClass() {
    return UserEntity.class;
  }
}
