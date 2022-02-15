package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.TeacherMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.TeacherEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * TeacherSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class TeacherSqlProvider extends BaseSqlProvider<TeacherEntity> {
  /**
   * 默认设置器
   */
  private static final TeacherDefaults defaults = TeacherDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(TeacherEntity entity) {
    return entity.getTeacherId() == null;
  }

  @Override
  public boolean primaryNotNull(TeacherEntity entity) {
    return entity.getTeacherId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, TeacherEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, teacherId, entity.getTeacherId(), null);
    }
    inserts.add(prefix, deptId, entity.getDeptId(), "");
    inserts.add(prefix, teacherDescribe, entity.getTeacherDescribe(), "");
    inserts.add(prefix, teacherProjectNum, entity.getTeacherProjectNum(), "");
    inserts.add(prefix, userId, entity.getUserId(), "");
    inserts.add(prefix, zhicheng, entity.getZhicheng(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, TeacherEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", teacherId, entity.getTeacherId(), null));
    }
    values.add(el("list[" + index + "].", deptId, entity.getDeptId(), ""));
    values.add(el("list[" + index + "].", teacherDescribe, entity.getTeacherDescribe(), ""));
    values.add(el("list[" + index + "].", teacherProjectNum, entity.getTeacherProjectNum(), ""));
    values.add(el("list[" + index + "].", userId, entity.getUserId(), ""));
    values.add(el("list[" + index + "].", zhicheng, entity.getZhicheng(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    TeacherEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), deptId, entity.getDeptId(), "")
    	.add(this.dbType(), teacherDescribe, entity.getTeacherDescribe(), "")
    	.add(this.dbType(), teacherProjectNum, entity.getTeacherProjectNum(), "")
    	.add(this.dbType(), userId, entity.getUserId(), "")
    	.add(this.dbType(), zhicheng, entity.getZhicheng(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(teacherId.el(this.dbType(), Param_ET));
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
    	return Arrays.asList("teacher_id", "dept_id", "teacher_describe", "teacher_project_num", "user_id", "zhicheng");
    } else {
    	return Arrays.asList("dept_id", "teacher_describe", "teacher_project_num", "user_id", "zhicheng");
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
