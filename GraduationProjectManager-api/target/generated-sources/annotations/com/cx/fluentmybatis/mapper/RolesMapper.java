package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.RolesEntity;
import com.cx.fluentmybatis.helper.RolesDefaults;
import com.cx.fluentmybatis.helper.RolesMapping;
import com.cx.fluentmybatis.helper.RolesSqlProvider;
import com.cx.fluentmybatis.wrapper.RolesQuery;
import com.cx.fluentmybatis.wrapper.RolesUpdate;
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
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

/**
 *
 * RolesMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("rolesMapper")
public interface RolesMapper extends IEntityMapper<RolesEntity>, IRichMapper<RolesEntity>, IWrapperMapper<RolesEntity>, IMapper<RolesEntity> {
  String ResultMap = "RolesEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = RolesSqlProvider.class,
      method = "insert"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "rolesId",
      keyColumn = "roles_id"
  )
  int insert(RolesEntity entity);

  @Override
  @InsertProvider(
      type = RolesSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(RolesEntity entity);

  @Override
  @InsertProvider(
      type = RolesSqlProvider.class,
      method = "insertBatch"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "rolesId",
      keyColumn = "roles_id"
  )
  int insertBatch(@Param(Param_List) Collection<RolesEntity> entities);

  @Override
  @InsertProvider(
      type = RolesSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<RolesEntity> entities);

  /**
   * @see RolesSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = RolesSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see RolesSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = RolesSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see RolesSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = RolesSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see RolesSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = RolesSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see RolesSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = RolesSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see RolesSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = RolesSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see RolesSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = RolesSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see RolesSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = RolesSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see RolesSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = RolesSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = RolesSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) RolesEntity entity);

  /**
   *  {@link RolesSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = RolesSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = RolesSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "roles_id", property = "rolesId", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "roles_name", property = "rolesName", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  RolesEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = RolesSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  RolesEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = RolesSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<RolesEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = RolesSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<RolesEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = RolesSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<RolesEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = RolesSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = RolesSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = RolesSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = RolesSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default RolesQuery query() {
    return new RolesQuery();
  }

  default RolesUpdate updater() {
    return new RolesUpdate();
  }

  default RolesQuery defaultQuery() {
    return RolesDefaults.INSTANCE.defaultQuery();
  }

  default RolesUpdate defaultUpdater() {
    return RolesDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return RolesMapping.rolesId;
  }

  @Override
  default Class<RolesEntity> entityClass() {
    return RolesEntity.class;
  }
}
