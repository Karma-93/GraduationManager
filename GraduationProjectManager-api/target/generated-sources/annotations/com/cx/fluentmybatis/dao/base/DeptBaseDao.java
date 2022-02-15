package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.DeptDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.DeptEntity;
import com.cx.fluentmybatis.mapper.DeptMapper;
import com.cx.fluentmybatis.wrapper.DeptQuery;
import com.cx.fluentmybatis.wrapper.DeptUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * DeptBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class DeptBaseDao extends BaseDao<DeptEntity> {
  @Resource(
      name = "deptMapper"
  )
  protected DeptMapper mapper;

  @Override
  public DeptMapper mapper() {
    return mapper;
  }

  @Override
  protected DeptQuery query() {
    return new DeptQuery();
  }

  @Override
  protected DeptQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected DeptUpdate updater() {
    return new DeptUpdate();
  }

  @Override
  protected DeptUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
