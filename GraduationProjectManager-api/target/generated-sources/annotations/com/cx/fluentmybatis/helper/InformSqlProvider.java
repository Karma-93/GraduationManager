package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.InformMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.InformEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * InformSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class InformSqlProvider extends BaseSqlProvider<InformEntity> {
  /**
   * 默认设置器
   */
  private static final InformDefaults defaults = InformDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(InformEntity entity) {
    return entity.getInformId() == null;
  }

  @Override
  public boolean primaryNotNull(InformEntity entity) {
    return entity.getInformId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, InformEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, informId, entity.getInformId(), null);
    }
    inserts.add(prefix, adminId, entity.getAdminId(), "");
    inserts.add(prefix, attachmentPath, entity.getAttachmentPath(), "");
    inserts.add(prefix, createDate, entity.getCreateDate(), "");
    inserts.add(prefix, informBody, entity.getInformBody(), "");
    inserts.add(prefix, informTitle, entity.getInformTitle(), "");
    inserts.add(prefix, isAttachment, entity.getIsAttachment(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, InformEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", informId, entity.getInformId(), null));
    }
    values.add(el("list[" + index + "].", adminId, entity.getAdminId(), ""));
    values.add(el("list[" + index + "].", attachmentPath, entity.getAttachmentPath(), ""));
    values.add(el("list[" + index + "].", createDate, entity.getCreateDate(), ""));
    values.add(el("list[" + index + "].", informBody, entity.getInformBody(), ""));
    values.add(el("list[" + index + "].", informTitle, entity.getInformTitle(), ""));
    values.add(el("list[" + index + "].", isAttachment, entity.getIsAttachment(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    InformEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), adminId, entity.getAdminId(), "")
    	.add(this.dbType(), attachmentPath, entity.getAttachmentPath(), "")
    	.add(this.dbType(), createDate, entity.getCreateDate(), "")
    	.add(this.dbType(), informBody, entity.getInformBody(), "")
    	.add(this.dbType(), informTitle, entity.getInformTitle(), "")
    	.add(this.dbType(), isAttachment, entity.getIsAttachment(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(informId.el(this.dbType(), Param_ET));
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
    	return Arrays.asList("inform_id", "admin_id", "attachment_path", "create_date", "inform_body", "inform_title", "is_attachment");
    } else {
    	return Arrays.asList("admin_id", "attachment_path", "create_date", "inform_body", "inform_title", "is_attachment");
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
