package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.StudentDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.mapper.StudentMapper;
import com.cx.fluentmybatis.wrapper.StudentQuery;
import com.cx.fluentmybatis.wrapper.StudentUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * StudentBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class StudentBaseDao extends BaseDao<StudentEntity> {
  @Resource(
      name = "studentMapper"
  )
  protected StudentMapper mapper;

  @Override
  public StudentMapper mapper() {
    return mapper;
  }

  @Override
  protected StudentQuery query() {
    return new StudentQuery();
  }

  @Override
  protected StudentQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected StudentUpdate updater() {
    return new StudentUpdate();
  }

  @Override
  protected StudentUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
