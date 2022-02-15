package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.RolesDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.RolesEntity;
import com.cx.fluentmybatis.mapper.RolesMapper;
import com.cx.fluentmybatis.wrapper.RolesQuery;
import com.cx.fluentmybatis.wrapper.RolesUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * RolesBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class RolesBaseDao extends BaseDao<RolesEntity> {
  @Resource(
      name = "rolesMapper"
  )
  protected RolesMapper mapper;

  @Override
  public RolesMapper mapper() {
    return mapper;
  }

  @Override
  protected RolesQuery query() {
    return new RolesQuery();
  }

  @Override
  protected RolesQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected RolesUpdate updater() {
    return new RolesUpdate();
  }

  @Override
  protected RolesUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
