package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.fluentmybatis.helper.TeacherDefaults;
import com.cx.fluentmybatis.helper.TeacherMapping;
import com.cx.fluentmybatis.helper.TeacherSqlProvider;
import com.cx.fluentmybatis.wrapper.TeacherQuery;
import com.cx.fluentmybatis.wrapper.TeacherUpdate;
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
 * TeacherMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("teacherMapper")
public interface TeacherMapper extends IEntityMapper<TeacherEntity>, IRichMapper<TeacherEntity>, IWrapperMapper<TeacherEntity>, IMapper<TeacherEntity> {
  String ResultMap = "TeacherEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = TeacherSqlProvider.class,
      method = "insert"
  )
  @SelectKey(
      resultType = String.class,
      keyProperty = "teacherId",
      keyColumn = "teacher_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insert(TeacherEntity entity);

  @Override
  @InsertProvider(
      type = TeacherSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(TeacherEntity entity);

  @Override
  @InsertProvider(
      type = TeacherSqlProvider.class,
      method = "insertBatch"
  )
  @SelectKey(
      resultType = String.class,
      keyProperty = "teacherId",
      keyColumn = "teacher_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insertBatch(@Param(Param_List) Collection<TeacherEntity> entities);

  @Override
  @InsertProvider(
      type = TeacherSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<TeacherEntity> entities);

  /**
   * @see TeacherSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = TeacherSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see TeacherSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = TeacherSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see TeacherSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = TeacherSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see TeacherSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = TeacherSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see TeacherSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = TeacherSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see TeacherSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = TeacherSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see TeacherSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = TeacherSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see TeacherSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = TeacherSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see TeacherSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = TeacherSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = TeacherSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) TeacherEntity entity);

  /**
   *  {@link TeacherSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = TeacherSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = TeacherSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "teacher_id", property = "teacherId", javaType = String.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "dept_id", property = "deptId", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "teacher_describe", property = "teacherDescribe", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "teacher_project_num", property = "teacherProjectNum", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "user_id", property = "userId", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "zhicheng", property = "zhicheng", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  TeacherEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = TeacherSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  TeacherEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = TeacherSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<TeacherEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = TeacherSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<TeacherEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = TeacherSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<TeacherEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = TeacherSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = TeacherSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = TeacherSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = TeacherSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default TeacherQuery query() {
    return new TeacherQuery();
  }

  default TeacherUpdate updater() {
    return new TeacherUpdate();
  }

  default TeacherQuery defaultQuery() {
    return TeacherDefaults.INSTANCE.defaultQuery();
  }

  default TeacherUpdate defaultUpdater() {
    return TeacherDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return TeacherMapping.teacherId;
  }

  @Override
  default Class<TeacherEntity> entityClass() {
    return TeacherEntity.class;
  }
}
