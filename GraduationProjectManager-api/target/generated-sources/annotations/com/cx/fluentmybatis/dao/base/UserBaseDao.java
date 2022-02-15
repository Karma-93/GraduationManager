package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.UserDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.mapper.UserMapper;
import com.cx.fluentmybatis.wrapper.UserQuery;
import com.cx.fluentmybatis.wrapper.UserUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * UserBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class UserBaseDao extends BaseDao<UserEntity> {
  @Resource(
      name = "userMapper"
  )
  protected UserMapper mapper;

  @Override
  public UserMapper mapper() {
    return mapper;
  }

  @Override
  protected UserQuery query() {
    return new UserQuery();
  }

  @Override
  protected UserQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected UserUpdate updater() {
    return new UserUpdate();
  }

  @Override
  protected UserUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
