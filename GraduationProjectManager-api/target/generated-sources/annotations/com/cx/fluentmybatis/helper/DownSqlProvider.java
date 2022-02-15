package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.DownMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.DownEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * DownSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class DownSqlProvider extends BaseSqlProvider<DownEntity> {
  /**
   * 默认设置器
   */
  private static final DownDefaults defaults = DownDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(DownEntity entity) {
    return entity.getDownId() == null;
  }

  @Override
  public boolean primaryNotNull(DownEntity entity) {
    return entity.getDownId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, DownEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, downId, entity.getDownId(), null);
    }
    inserts.add(prefix, adminId, entity.getAdminId(), "");
    inserts.add(prefix, createDate, entity.getCreateDate(), "");
    inserts.add(prefix, downPath, entity.getDownPath(), "");
    inserts.add(prefix, downTitle, entity.getDownTitle(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, DownEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", downId, entity.getDownId(), null));
    }
    values.add(el("list[" + index + "].", adminId, entity.getAdminId(), ""));
    values.add(el("list[" + index + "].", createDate, entity.getCreateDate(), ""));
    values.add(el("list[" + index + "].", downPath, entity.getDownPath(), ""));
    values.add(el("list[" + index + "].", downTitle, entity.getDownTitle(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    DownEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), adminId, entity.getAdminId(), "")
    	.add(this.dbType(), createDate, entity.getCreateDate(), "")
    	.add(this.dbType(), downPath, entity.getDownPath(), "")
    	.add(this.dbType(), downTitle, entity.getDownTitle(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(downId.el(this.dbType(), Param_ET));
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
    	return Arrays.asList("down_id", "admin_id", "create_date", "down_path", "down_title");
    } else {
    	return Arrays.asList("admin_id", "create_date", "down_path", "down_title");
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
