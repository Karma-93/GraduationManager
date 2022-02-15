package cn.org.atool.fluent.mybatis.refs;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import com.cx.fluentmybatis.entity.AdminEntity;
import com.cx.fluentmybatis.entity.DeptEntity;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.fluentmybatis.entity.InformEntity;
import com.cx.fluentmybatis.entity.RolesEntity;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.mapper.AdminMapper;
import com.cx.fluentmybatis.mapper.DeptMapper;
import com.cx.fluentmybatis.mapper.DownMapper;
import com.cx.fluentmybatis.mapper.InformMapper;
import com.cx.fluentmybatis.mapper.RolesMapper;
import com.cx.fluentmybatis.mapper.StudentMapper;
import com.cx.fluentmybatis.mapper.TeacherMapper;
import com.cx.fluentmybatis.mapper.UserMapper;
import java.lang.Class;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * MapperRef: 应用所有Mapper Bean引用
 *
 * @author powered by FluentMybatis
 */
public class MapperRef {
  private static final Map<Class<? extends IEntity>, IRichMapper> allMappers = new HashMap<>();

  private static final Set<Class<? extends IEntity>> allEntityClass = new HashSet<>();

  private static MapperRef instance;

  public final AdminMapper adminMapper;

  public final DeptMapper deptMapper;

  public final DownMapper downMapper;

  public final InformMapper informMapper;

  public final RolesMapper rolesMapper;

  public final StudentMapper studentMapper;

  public final TeacherMapper teacherMapper;

  public final UserMapper userMapper;

  private MapperRef(MapperFactory factory) {
    this.adminMapper = factory.getBean(AdminMapper.class);
    this.deptMapper = factory.getBean(DeptMapper.class);
    this.downMapper = factory.getBean(DownMapper.class);
    this.informMapper = factory.getBean(InformMapper.class);
    this.rolesMapper = factory.getBean(RolesMapper.class);
    this.studentMapper = factory.getBean(StudentMapper.class);
    this.teacherMapper = factory.getBean(TeacherMapper.class);
    this.userMapper = factory.getBean(UserMapper.class);
    allMappers.put(AdminEntity.class, this.adminMapper);
    allMappers.put(DeptEntity.class, this.deptMapper);
    allMappers.put(DownEntity.class, this.downMapper);
    allMappers.put(InformEntity.class, this.informMapper);
    allMappers.put(RolesEntity.class, this.rolesMapper);
    allMappers.put(StudentEntity.class, this.studentMapper);
    allMappers.put(TeacherEntity.class, this.teacherMapper);
    allMappers.put(UserEntity.class, this.userMapper);
    allEntityClass.addAll(allMappers.keySet());
  }

  public static final synchronized MapperRef instance(MapperFactory factory) {
    if (instance == null) {
      instance = new MapperRef(factory);
    }
    return instance;
  }

  public static final IRichMapper mapper(Class<? extends IEntity> entityClass) {
    return allMappers.get(entityClass);
  }

  public static final Set<Class<? extends IEntity>> allEntityClass() {
    return allEntityClass;
  }
}
