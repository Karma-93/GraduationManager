package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.DownDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.fluentmybatis.mapper.DownMapper;
import com.cx.fluentmybatis.wrapper.DownQuery;
import com.cx.fluentmybatis.wrapper.DownUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * DownBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class DownBaseDao extends BaseDao<DownEntity> {
  @Resource(
      name = "downMapper"
  )
  protected DownMapper mapper;

  @Override
  public DownMapper mapper() {
    return mapper;
  }

  @Override
  protected DownQuery query() {
    return new DownQuery();
  }

  @Override
  protected DownQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected DownUpdate updater() {
    return new DownUpdate();
  }

  @Override
  protected DownUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
