package cn.org.atool.fluent.mybatis.refs;

import cn.org.atool.fluent.mybatis.base.IRefs;

/**
 *
 * Refs: 
 *  o - 查询器，更新器工厂类单例引用
 *  o - 应用所有Mapper Bean引用
 *  o - Entity关联对象延迟加载查询实现
 *
 * @author powered by FluentMybatis
 */
public final class Refs extends AllRef {
  /**
   * Refs 单例
   */
  public static final Refs instance() {
    return (Refs) IRefs.instance();
  }
}
