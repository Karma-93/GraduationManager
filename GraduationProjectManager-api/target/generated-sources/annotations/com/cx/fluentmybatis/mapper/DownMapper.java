package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.fluentmybatis.helper.DownDefaults;
import com.cx.fluentmybatis.helper.DownMapping;
import com.cx.fluentmybatis.helper.DownSqlProvider;
import com.cx.fluentmybatis.wrapper.DownQuery;
import com.cx.fluentmybatis.wrapper.DownUpdate;
import java.io.Serializable;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
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
 * DownMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("downMapper")
public interface DownMapper extends IEntityMapper<DownEntity>, IRichMapper<DownEntity>, IWrapperMapper<DownEntity>, IMapper<DownEntity> {
  String ResultMap = "DownEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = DownSqlProvider.class,
      method = "insert"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "downId",
      keyColumn = "down_id"
  )
  int insert(DownEntity entity);

  @Override
  @InsertProvider(
      type = DownSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(DownEntity entity);

  @Override
  @InsertProvider(
      type = DownSqlProvider.class,
      method = "insertBatch"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "downId",
      keyColumn = "down_id"
  )
  int insertBatch(@Param(Param_List) Collection<DownEntity> entities);

  @Override
  @InsertProvider(
      type = DownSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<DownEntity> entities);

  /**
   * @see DownSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = DownSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see DownSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = DownSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see DownSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = DownSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see DownSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = DownSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see DownSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = DownSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see DownSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = DownSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see DownSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = DownSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see DownSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = DownSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see DownSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = DownSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = DownSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) DownEntity entity);

  /**
   *  {@link DownSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = DownSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = DownSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "down_id", property = "downId", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "admin_id", property = "adminId", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "create_date", property = "createDate", javaType = Date.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "down_path", property = "downPath", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "down_title", property = "downTitle", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  DownEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = DownSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  DownEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = DownSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<DownEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = DownSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<DownEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = DownSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<DownEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = DownSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = DownSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = DownSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = DownSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default DownQuery query() {
    return new DownQuery();
  }

  default DownUpdate updater() {
    return new DownUpdate();
  }

  default DownQuery defaultQuery() {
    return DownDefaults.INSTANCE.defaultQuery();
  }

  default DownUpdate defaultUpdater() {
    return DownDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return DownMapping.downId;
  }

  @Override
  default Class<DownEntity> entityClass() {
    return DownEntity.class;
  }
}
