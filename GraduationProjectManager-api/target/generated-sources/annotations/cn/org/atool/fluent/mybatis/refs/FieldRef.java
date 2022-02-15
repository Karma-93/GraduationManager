package cn.org.atool.fluent.mybatis.refs;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.notFluentMybatisException;

import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import com.cx.fluentmybatis.entity.AdminEntity;
import com.cx.fluentmybatis.entity.DeptEntity;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.fluentmybatis.entity.InformEntity;
import com.cx.fluentmybatis.entity.RolesEntity;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.helper.AdminMapping;
import com.cx.fluentmybatis.helper.DeptMapping;
import com.cx.fluentmybatis.helper.DownMapping;
import com.cx.fluentmybatis.helper.InformMapping;
import com.cx.fluentmybatis.helper.RolesMapping;
import com.cx.fluentmybatis.helper.StudentMapping;
import com.cx.fluentmybatis.helper.TeacherMapping;
import com.cx.fluentmybatis.helper.UserMapping;
import java.lang.Class;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * FieldRef: Entity所有Mapping引用
 *
 * @author powered by FluentMybatis
 */
public class FieldRef {
  public static final AdminMapping Admin = AdminMapping.MAPPING;

  public static final DeptMapping Dept = DeptMapping.MAPPING;

  public static final DownMapping Down = DownMapping.MAPPING;

  public static final InformMapping Inform = InformMapping.MAPPING;

  public static final RolesMapping Roles = RolesMapping.MAPPING;

  public static final StudentMapping Student = StudentMapping.MAPPING;

  public static final TeacherMapping Teacher = TeacherMapping.MAPPING;

  public static final UserMapping User = UserMapping.MAPPING;

  private static final Map<Class, IMapping> mappings = new HashMap<>();

  static {
    mappings.put(AdminEntity.class, AdminMapping.MAPPING);
    mappings.put(DeptEntity.class, DeptMapping.MAPPING);
    mappings.put(DownEntity.class, DownMapping.MAPPING);
    mappings.put(InformEntity.class, InformMapping.MAPPING);
    mappings.put(RolesEntity.class, RolesMapping.MAPPING);
    mappings.put(StudentEntity.class, StudentMapping.MAPPING);
    mappings.put(TeacherEntity.class, TeacherMapping.MAPPING);
    mappings.put(UserEntity.class, UserMapping.MAPPING);
  }

  /**
   * 返回clazz属性field对应的数据库字段名称
   */
  public static final String findColumnByField(Class clazz, String field) {
    if (mappings.containsKey(clazz)) {
    	return mappings.get(clazz).findColumnByField(field);
    }
    throw notFluentMybatisException(clazz);
  }

  /**
   * 返回clazz属性对应数据库主键字段名称
   */
  public static final String findPrimaryColumn(Class clazz) {
    if (mappings.containsKey(clazz)) {
    	return mappings.get(clazz).findPrimaryColumn();
    }
    throw notFluentMybatisException(clazz);
  }
}
