package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.DeptEntity;
import com.cx.fluentmybatis.helper.DeptDefaults;
import com.cx.fluentmybatis.helper.DeptMapping;
import com.cx.fluentmybatis.helper.DeptSqlProvider;
import com.cx.fluentmybatis.wrapper.DeptQuery;
import com.cx.fluentmybatis.wrapper.DeptUpdate;
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
 * DeptMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("deptMapper")
public interface DeptMapper extends IEntityMapper<DeptEntity>, IRichMapper<DeptEntity>, IWrapperMapper<DeptEntity>, IMapper<DeptEntity> {
  String ResultMap = "DeptEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = DeptSqlProvider.class,
      method = "insert"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "deptId",
      keyColumn = "dept_id"
  )
  int insert(DeptEntity entity);

  @Override
  @InsertProvider(
      type = DeptSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(DeptEntity entity);

  @Override
  @InsertProvider(
      type = DeptSqlProvider.class,
      method = "insertBatch"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "deptId",
      keyColumn = "dept_id"
  )
  int insertBatch(@Param(Param_List) Collection<DeptEntity> entities);

  @Override
  @InsertProvider(
      type = DeptSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<DeptEntity> entities);

  /**
   * @see DeptSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = DeptSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see DeptSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = DeptSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see DeptSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = DeptSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see DeptSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = DeptSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see DeptSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = DeptSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see DeptSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = DeptSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see DeptSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = DeptSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see DeptSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = DeptSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see DeptSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = DeptSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = DeptSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) DeptEntity entity);

  /**
   *  {@link DeptSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = DeptSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = DeptSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "dept_id", property = "deptId", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "dept_name", property = "deptName", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  DeptEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = DeptSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  DeptEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = DeptSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<DeptEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = DeptSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<DeptEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = DeptSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<DeptEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = DeptSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = DeptSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = DeptSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = DeptSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default DeptQuery query() {
    return new DeptQuery();
  }

  default DeptUpdate updater() {
    return new DeptUpdate();
  }

  default DeptQuery defaultQuery() {
    return DeptDefaults.INSTANCE.defaultQuery();
  }

  default DeptUpdate defaultUpdater() {
    return DeptDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return DeptMapping.deptId;
  }

  @Override
  default Class<DeptEntity> entityClass() {
    return DeptEntity.class;
  }
}
