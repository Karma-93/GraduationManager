package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.InformDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.InformEntity;
import com.cx.fluentmybatis.mapper.InformMapper;
import com.cx.fluentmybatis.wrapper.InformQuery;
import com.cx.fluentmybatis.wrapper.InformUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * InformBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class InformBaseDao extends BaseDao<InformEntity> {
  @Resource(
      name = "informMapper"
  )
  protected InformMapper mapper;

  @Override
  public InformMapper mapper() {
    return mapper;
  }

  @Override
  protected InformQuery query() {
    return new InformQuery();
  }

  @Override
  protected InformQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected InformUpdate updater() {
    return new InformUpdate();
  }

  @Override
  protected InformUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
