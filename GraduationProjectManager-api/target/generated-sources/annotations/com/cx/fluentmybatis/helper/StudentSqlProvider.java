package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.StudentMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.StudentEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * StudentSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class StudentSqlProvider extends BaseSqlProvider<StudentEntity> {
  /**
   * 默认设置器
   */
  private static final StudentDefaults defaults = StudentDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(StudentEntity entity) {
    return entity.getStudentId() == null;
  }

  @Override
  public boolean primaryNotNull(StudentEntity entity) {
    return entity.getStudentId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, StudentEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, studentId, entity.getStudentId(), null);
    }
    inserts.add(prefix, classId, entity.getClassId(), "");
    inserts.add(prefix, projectId, entity.getProjectId(), "");
    inserts.add(prefix, projectNum, entity.getProjectNum(), "");
    inserts.add(prefix, studentScore, entity.getStudentScore(), "");
    inserts.add(prefix, teacherId, entity.getTeacherId(), "");
    inserts.add(prefix, userId, entity.getUserId(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, StudentEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", studentId, entity.getStudentId(), null));
    }
    values.add(el("list[" + index + "].", classId, entity.getClassId(), ""));
    values.add(el("list[" + index + "].", projectId, entity.getProjectId(), ""));
    values.add(el("list[" + index + "].", projectNum, entity.getProjectNum(), ""));
    values.add(el("list[" + index + "].", studentScore, entity.getStudentScore(), ""));
    values.add(el("list[" + index + "].", teacherId, entity.getTeacherId(), ""));
    values.add(el("list[" + index + "].", userId, entity.getUserId(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    StudentEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), classId, entity.getClassId(), "")
    	.add(this.dbType(), projectId, entity.getProjectId(), "")
    	.add(this.dbType(), projectNum, entity.getProjectNum(), "")
    	.add(this.dbType(), studentScore, entity.getStudentScore(), "")
    	.add(this.dbType(), teacherId, entity.getTeacherId(), "")
    	.add(this.dbType(), userId, entity.getUserId(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(studentId.el(this.dbType(), Param_ET));
    return sql.toString();
  }

  @Override
  public List<String> updateDefaults(Map<String, String> updates, boolean ignoreLockVersion) {
    UpdateDefault defaults = new UpdateDefault(updates);
    return defaults.getUpdateDefaults();
  }

  @Override
  public String tableName() {
    return defaults.table().get();
  }

  @Override
  protected IMapping mapping() {
    return MAPPING;
  }

  @Override
  public List<String> allFields(boolean withPk) {
    if (withPk) {
    	return Arrays.asList("student_id", "class_id", "project_id", "project_num", "student_score", "teacher_id", "user_id");
    } else {
    	return Arrays.asList("class_id", "project_id", "project_num", "student_score", "teacher_id", "user_id");
    }
  }

  @Override
  protected void setEntityByDefault(IEntity entity) {
    defaults.setEntityByDefault(entity);
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  @Override
  protected boolean longTypeOfLogicDelete() {
    return false;
  }
}
