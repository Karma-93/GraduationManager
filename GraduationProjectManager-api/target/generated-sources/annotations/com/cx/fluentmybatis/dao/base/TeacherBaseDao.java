package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.TeacherDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.fluentmybatis.mapper.TeacherMapper;
import com.cx.fluentmybatis.wrapper.TeacherQuery;
import com.cx.fluentmybatis.wrapper.TeacherUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * TeacherBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class TeacherBaseDao extends BaseDao<TeacherEntity> {
  @Resource(
      name = "teacherMapper"
  )
  protected TeacherMapper mapper;

  @Override
  public TeacherMapper mapper() {
    return mapper;
  }

  @Override
  protected TeacherQuery query() {
    return new TeacherQuery();
  }

  @Override
  protected TeacherQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected TeacherUpdate updater() {
    return new TeacherUpdate();
  }

  @Override
  protected TeacherUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
