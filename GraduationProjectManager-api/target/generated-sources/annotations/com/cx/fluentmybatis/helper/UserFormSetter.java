package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.assertNotNull;

import cn.org.atool.fluent.mybatis.base.crud.FormSetter;
import cn.org.atool.fluent.mybatis.functions.FormApply;
import cn.org.atool.fluent.mybatis.model.Form;
import cn.org.atool.fluent.mybatis.model.IFormApply;
import cn.org.atool.fluent.mybatis.utility.PoJoHelper;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.helper.UserWrapperHelper.ISegment;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * UserFormSetter: Form Column Setter
 *
 * @author powered by FluentMybatis
 */
public final class UserFormSetter extends FormSetter implements ISegment<IFormApply<UserEntity, UserFormSetter>> {
  private UserFormSetter(FormApply apply) {
    super.formApply = apply;
  }

  @Override
  public Class entityClass() {
    return UserEntity.class;
  }

  public static IFormApply<UserEntity, UserFormSetter> by(Object object, Form form) {
    assertNotNull("object", object);
    Map map = PoJoHelper.toMap(object);
    Function<FormApply, FormSetter> apply = UserFormSetter::new;
    return new FormApply<>(apply, map, form);
  }
}
