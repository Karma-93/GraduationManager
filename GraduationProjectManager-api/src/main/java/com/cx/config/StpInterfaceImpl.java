package com.cx.config;

import cn.dev33.satoken.stp.StpInterface;
import com.cx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义saToken权限认证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    UserService userService;

    /*
     * @param o
     * @param s
     * @return 返回一个账号所有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object o, String s) {
        return null;
    }

    /*
     * @param o
     * @param s
     * @return 返回一个账号拥有的角色标识集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> res=new ArrayList<>();
        String roles=userService.getUserRolesByUserId((String) loginId);
        res.add(roles);
        return res;
    }
}
