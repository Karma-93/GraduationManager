package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.assertNotNull;

import cn.org.atool.fluent.mybatis.base.crud.FormSetter;
import cn.org.atool.fluent.mybatis.functions.FormApply;
import cn.org.atool.fluent.mybatis.model.Form;
import cn.org.atool.fluent.mybatis.model.IFormApply;
import cn.org.atool.fluent.mybatis.utility.PoJoHelper;
import com.cx.fluentmybatis.entity.AdminEntity;
import com.cx.fluentmybatis.helper.AdminWrapperHelper.ISegment;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * AdminFormSetter: Form Column Setter
 *
 * @author powered by FluentMybatis
 */
public final class AdminFormSetter extends FormSetter implements ISegment<IFormApply<AdminEntity, AdminFormSetter>> {
  private AdminFormSetter(FormApply apply) {
    super.formApply = apply;
  }

  @Override
  public Class entityClass() {
    return AdminEntity.class;
  }

  public static IFormApply<AdminEntity, AdminFormSetter> by(Object object, Form form) {
    assertNotNull("object", object);
    Map map = PoJoHelper.toMap(object);
    Function<FormApply, FormSetter> apply = AdminFormSetter::new;
    return new FormApply<>(apply, map, form);
  }
}
