package cn.org.atool.fluent.mybatis.refs;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.IRefs;
import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.util.Set;

/**
 *
 * AllRef: 应用所有Mapper Bean引用
 *
 * @author powered by FluentMybatis
 */
abstract class AllRef extends IRefs {
  private static MapperRef mappers;

  public AllRef() {
    super.setDefaultDbType(DbType.MYSQL);
  }

  public static MapperRef mapper() {
    if (mappers == null) {
      throw springNotInitException();
    }
    return mappers;
  }

  protected final IRichMapper getMapper(Class<? extends IEntity> clazz) {
    Class<? extends IEntity> entityClass = super.findFluentEntityClass(clazz);
    return MapperRef.mapper(entityClass);
  }

  @Override
  public final String findColumnByField(Class clazz, String field) {
    return FieldRef.findColumnByField(clazz, field);
  }

  @Override
  public final String findPrimaryColumn(Class clazz) {
    return FieldRef.findPrimaryColumn(clazz);
  }

  @Override
  public final IQuery defaultQuery(Class clazz) {
    Class entityClass = this.findFluentEntityClass(clazz);
    return QueryRef.defaultQuery(entityClass);
  }

  @Override
  public final IQuery emptyQuery(Class clazz) {
    Class entityClass = this.findFluentEntityClass(clazz);
    return QueryRef.emptyQuery(entityClass);
  }

  @Override
  public final IUpdate defaultUpdater(Class clazz) {
    Class entityClass = this.findFluentEntityClass(clazz);
    return QueryRef.defaultUpdater(entityClass);
  }

  @Override
  public final IUpdate emptyUpdater(Class clazz) {
    Class entityClass = this.findFluentEntityClass(clazz);
    return QueryRef.emptyUpdater(entityClass);
  }

  @Override
  protected final Set<Class<? extends IEntity>> allEntityClass() {
    return MapperRef.allEntityClass();
  }

  @Override
  protected final void initEntityMapper() {
    mappers = MapperRef.instance(super.mapperFactory);
  }

  public static final class Field extends FieldRef {
  }

  public static final class Query extends QueryRef {
  }

  public static final class Form implements FormRef {
  }
}
