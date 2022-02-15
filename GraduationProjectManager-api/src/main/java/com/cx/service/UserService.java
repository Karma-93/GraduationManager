package com.cx.service;

import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.model.Login;

public interface UserService {

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

}
