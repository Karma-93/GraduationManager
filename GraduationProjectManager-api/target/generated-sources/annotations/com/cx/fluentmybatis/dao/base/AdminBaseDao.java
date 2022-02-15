package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.AdminDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.AdminEntity;
import com.cx.fluentmybatis.mapper.AdminMapper;
import com.cx.fluentmybatis.wrapper.AdminQuery;
import com.cx.fluentmybatis.wrapper.AdminUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * AdminBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class AdminBaseDao extends BaseDao<AdminEntity> {
  @Resource(
      name = "adminMapper"
  )
  protected AdminMapper mapper;

  @Override
  public AdminMapper mapper() {
    return mapper;
  }

  @Override
  protected AdminQuery query() {
    return new AdminQuery();
  }

  @Override
  protected AdminQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected AdminUpdate updater() {
    return new AdminUpdate();
  }

  @Override
  protected AdminUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
