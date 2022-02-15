package cn.org.atool.fluent.mybatis.refs;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.notFluentMybatisException;

import cn.org.atool.fluent.mybatis.functions.FormFunction;
import com.cx.fluentmybatis.entity.AdminEntity;
import com.cx.fluentmybatis.entity.DeptEntity;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.fluentmybatis.entity.InformEntity;
import com.cx.fluentmybatis.entity.RolesEntity;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.helper.AdminFormSetter;
import com.cx.fluentmybatis.helper.DeptFormSetter;
import com.cx.fluentmybatis.helper.DownFormSetter;
import com.cx.fluentmybatis.helper.InformFormSetter;
import com.cx.fluentmybatis.helper.RolesFormSetter;
import com.cx.fluentmybatis.helper.StudentFormSetter;
import com.cx.fluentmybatis.helper.TeacherFormSetter;
import com.cx.fluentmybatis.helper.UserFormSetter;

/**
 *
 * FormRef: 所有Entity Form Setter引用
 *
 * @author powered by FluentMybatis
 */
public interface FormRef {
  FormFunction<AdminEntity, AdminFormSetter> admin = (obj, form) -> AdminFormSetter.by(obj, form);

  FormFunction<DeptEntity, DeptFormSetter> dept = (obj, form) -> DeptFormSetter.by(obj, form);

  FormFunction<DownEntity, DownFormSetter> down = (obj, form) -> DownFormSetter.by(obj, form);

  FormFunction<InformEntity, InformFormSetter> inform = (obj, form) -> InformFormSetter.by(obj, form);

  FormFunction<RolesEntity, RolesFormSetter> roles = (obj, form) -> RolesFormSetter.by(obj, form);

  FormFunction<StudentEntity, StudentFormSetter> student = (obj, form) -> StudentFormSetter.by(obj, form);

  FormFunction<TeacherEntity, TeacherFormSetter> teacher = (obj, form) -> TeacherFormSetter.by(obj, form);

  FormFunction<UserEntity, UserFormSetter> user = (obj, form) -> UserFormSetter.by(obj, form);
}
