package com.cx.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.model.Login;
import com.cx.model.PageReq;

import java.util.List;

public interface UserService {


    int delete(String userId);
    int insert(UserEntity userEntity);
    StdPagedList<UserEntity> getUserList(PageReq pageReq);
    /**
     *
     * @param id 用户id
     * @return 返回用户的信息
     */
    UserEntity getUserById(String id);

    /**
     *
     * @param account 用户的账号
     * @return 用户的所有信息
     */
    UserEntity getUserByAccount(String account);

    /**
     * 更新用户信息
     * @param user
     * @return >1为成功
     */
    int update(UserEntity user);

    /**
     * 通过用户id获取用户角色
     * @param userid
     * @return
     */
    String getUserRolesByUserId(String userid);

    /**
     * 通过rolesId获得角色名
     * @param rolesId
     * @return
     */
    String getUserRolesByRolesId(Integer rolesId);

    List<UserEntity> getExcludeList(List<String> list);


}
