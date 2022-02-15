package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.assertNotNull;

import cn.org.atool.fluent.mybatis.base.crud.FormSetter;
import cn.org.atool.fluent.mybatis.functions.FormApply;
import cn.org.atool.fluent.mybatis.model.Form;
import cn.org.atool.fluent.mybatis.model.IFormApply;
import cn.org.atool.fluent.mybatis.utility.PoJoHelper;
import com.cx.fluentmybatis.entity.RolesEntity;
import com.cx.fluentmybatis.helper.RolesWrapperHelper.ISegment;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * RolesFormSetter: Form Column Setter
 *
 * @author powered by FluentMybatis
 */
public final class RolesFormSetter extends FormSetter implements ISegment<IFormApply<RolesEntity, RolesFormSetter>> {
  private RolesFormSetter(FormApply apply) {
    super.formApply = apply;
  }

  @Override
  public Class entityClass() {
    return RolesEntity.class;
  }

  public static IFormApply<RolesEntity, RolesFormSetter> by(Object object, Form form) {
    assertNotNull("object", object);
    Map map = PoJoHelper.toMap(object);
    Function<FormApply, FormSetter> apply = RolesFormSetter::new;
    return new FormApply<>(apply, map, form);
  }
}
