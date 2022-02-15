package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.helper.StudentDefaults;
import com.cx.fluentmybatis.helper.StudentMapping;
import com.cx.fluentmybatis.helper.StudentSqlProvider;
import com.cx.fluentmybatis.wrapper.StudentQuery;
import com.cx.fluentmybatis.wrapper.StudentUpdate;
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
 * StudentMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("studentMapper")
public interface StudentMapper extends IEntityMapper<StudentEntity>, IRichMapper<StudentEntity>, IWrapperMapper<StudentEntity>, IMapper<StudentEntity> {
  String ResultMap = "StudentEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = StudentSqlProvider.class,
      method = "insert"
  )
  @SelectKey(
      resultType = String.class,
      keyProperty = "studentId",
      keyColumn = "student_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insert(StudentEntity entity);

  @Override
  @InsertProvider(
      type = StudentSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(StudentEntity entity);

  @Override
  @InsertProvider(
      type = StudentSqlProvider.class,
      method = "insertBatch"
  )
  @SelectKey(
      resultType = String.class,
      keyProperty = "studentId",
      keyColumn = "student_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insertBatch(@Param(Param_List) Collection<StudentEntity> entities);

  @Override
  @InsertProvider(
      type = StudentSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<StudentEntity> entities);

  /**
   * @see StudentSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = StudentSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see StudentSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = StudentSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see StudentSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = StudentSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see StudentSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = StudentSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see StudentSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = StudentSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see StudentSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = StudentSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see StudentSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = StudentSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see StudentSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = StudentSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see StudentSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = StudentSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = StudentSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) StudentEntity entity);

  /**
   *  {@link StudentSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = StudentSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = StudentSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "student_id", property = "studentId", javaType = String.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "class_id", property = "classId", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "project_id", property = "projectId", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "project_num", property = "projectNum", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "student_score", property = "studentScore", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "teacher_id", property = "teacherId", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "user_id", property = "userId", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  StudentEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = StudentSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  StudentEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = StudentSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<StudentEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = StudentSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<StudentEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = StudentSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<StudentEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = StudentSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = StudentSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = StudentSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = StudentSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default StudentQuery query() {
    return new StudentQuery();
  }

  default StudentUpdate updater() {
    return new StudentUpdate();
  }

  default StudentQuery defaultQuery() {
    return StudentDefaults.INSTANCE.defaultQuery();
  }

  default StudentUpdate defaultUpdater() {
    return StudentDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return StudentMapping.studentId;
  }

  @Override
  default Class<StudentEntity> entityClass() {
    return StudentEntity.class;
  }
}
