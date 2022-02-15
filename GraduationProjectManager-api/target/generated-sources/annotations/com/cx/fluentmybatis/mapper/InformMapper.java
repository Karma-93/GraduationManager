package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.InformEntity;
import com.cx.fluentmybatis.helper.InformDefaults;
import com.cx.fluentmybatis.helper.InformMapping;
import com.cx.fluentmybatis.helper.InformSqlProvider;
import com.cx.fluentmybatis.wrapper.InformQuery;
import com.cx.fluentmybatis.wrapper.InformUpdate;
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
 * InformMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("informMapper")
public interface InformMapper extends IEntityMapper<InformEntity>, IRichMapper<InformEntity>, IWrapperMapper<InformEntity>, IMapper<InformEntity> {
  String ResultMap = "InformEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = InformSqlProvider.class,
      method = "insert"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "informId",
      keyColumn = "inform_id"
  )
  int insert(InformEntity entity);

  @Override
  @InsertProvider(
      type = InformSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(InformEntity entity);

  @Override
  @InsertProvider(
      type = InformSqlProvider.class,
      method = "insertBatch"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "informId",
      keyColumn = "inform_id"
  )
  int insertBatch(@Param(Param_List) Collection<InformEntity> entities);

  @Override
  @InsertProvider(
      type = InformSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<InformEntity> entities);

  /**
   * @see InformSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = InformSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see InformSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = InformSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see InformSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = InformSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see InformSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = InformSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see InformSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = InformSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see InformSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = InformSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see InformSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = InformSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see InformSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = InformSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see InformSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = InformSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = InformSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) InformEntity entity);

  /**
   *  {@link InformSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = InformSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = InformSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "inform_id", property = "informId", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "admin_id", property = "adminId", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "attachment_path", property = "attachmentPath", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "create_date", property = "createDate", javaType = Date.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "inform_body", property = "informBody", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "inform_title", property = "informTitle", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "is_attachment", property = "isAttachment", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  InformEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = InformSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  InformEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = InformSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<InformEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = InformSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<InformEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = InformSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<InformEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = InformSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = InformSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = InformSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = InformSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default InformQuery query() {
    return new InformQuery();
  }

  default InformUpdate updater() {
    return new InformUpdate();
  }

  default InformQuery defaultQuery() {
    return InformDefaults.INSTANCE.defaultQuery();
  }

  default InformUpdate defaultUpdater() {
    return InformDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return InformMapping.informId;
  }

  @Override
  default Class<InformEntity> entityClass() {
    return InformEntity.class;
  }
}
