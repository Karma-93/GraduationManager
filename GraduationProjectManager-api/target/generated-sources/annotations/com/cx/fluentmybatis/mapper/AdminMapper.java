package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.AdminEntity;
import com.cx.fluentmybatis.helper.AdminDefaults;
import com.cx.fluentmybatis.helper.AdminMapping;
import com.cx.fluentmybatis.helper.AdminSqlProvider;
import com.cx.fluentmybatis.wrapper.AdminQuery;
import com.cx.fluentmybatis.wrapper.AdminUpdate;
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
 * AdminMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("adminMapper")
public interface AdminMapper extends IEntityMapper<AdminEntity>, IRichMapper<AdminEntity>, IWrapperMapper<AdminEntity>, IMapper<AdminEntity> {
  String ResultMap = "AdminEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = AdminSqlProvider.class,
      method = "insert"
  )
  @SelectKey(
      resultType = String.class,
      keyProperty = "adminId",
      keyColumn = "admin_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insert(AdminEntity entity);

  @Override
  @InsertProvider(
      type = AdminSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(AdminEntity entity);

  @Override
  @InsertProvider(
      type = AdminSqlProvider.class,
      method = "insertBatch"
  )
  @SelectKey(
      resultType = String.class,
      keyProperty = "adminId",
      keyColumn = "admin_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insertBatch(@Param(Param_List) Collection<AdminEntity> entities);

  @Override
  @InsertProvider(
      type = AdminSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<AdminEntity> entities);

  /**
   * @see AdminSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = AdminSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see AdminSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = AdminSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see AdminSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = AdminSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see AdminSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = AdminSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see AdminSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = AdminSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see AdminSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = AdminSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see AdminSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = AdminSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see AdminSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = AdminSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see AdminSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = AdminSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = AdminSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) AdminEntity entity);

  /**
   *  {@link AdminSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = AdminSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = AdminSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "admin_id", property = "adminId", javaType = String.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "user_id", property = "userId", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  AdminEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = AdminSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  AdminEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = AdminSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<AdminEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = AdminSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<AdminEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = AdminSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<AdminEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = AdminSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = AdminSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = AdminSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = AdminSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default AdminQuery query() {
    return new AdminQuery();
  }

  default AdminUpdate updater() {
    return new AdminUpdate();
  }

  default AdminQuery defaultQuery() {
    return AdminDefaults.INSTANCE.defaultQuery();
  }

  default AdminUpdate defaultUpdater() {
    return AdminDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return AdminMapping.adminId;
  }

  @Override
  default Class<AdminEntity> entityClass() {
    return AdminEntity.class;
  }
}
