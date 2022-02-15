package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.assertNotNull;

import cn.org.atool.fluent.mybatis.base.crud.FormSetter;
import cn.org.atool.fluent.mybatis.functions.FormApply;
import cn.org.atool.fluent.mybatis.model.Form;
import cn.org.atool.fluent.mybatis.model.IFormApply;
import cn.org.atool.fluent.mybatis.utility.PoJoHelper;
import com.cx.fluentmybatis.entity.DeptEntity;
import com.cx.fluentmybatis.helper.DeptWrapperHelper.ISegment;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * DeptFormSetter: Form Column Setter
 *
 * @author powered by FluentMybatis
 */
public final class DeptFormSetter extends FormSetter implements ISegment<IFormApply<DeptEntity, DeptFormSetter>> {
  private DeptFormSetter(FormApply apply) {
    super.formApply = apply;
  }

  @Override
  public Class entityClass() {
    return DeptEntity.class;
  }

  public static IFormApply<DeptEntity, DeptFormSetter> by(Object object, Form form) {
    assertNotNull("object", object);
    Map map = PoJoHelper.toMap(object);
    Function<FormApply, FormSetter> apply = DeptFormSetter::new;
    return new FormApply<>(apply, map, form);
  }
}
