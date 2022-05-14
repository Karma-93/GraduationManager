package com.cx.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.utils.KeyUtil;
import com.cx.fluentmybatis.entity.RolesEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.mapper.RolesMapper;
import com.cx.fluentmybatis.mapper.UserMapper;
import com.cx.fluentmybatis.wrapper.RolesQuery;
import com.cx.fluentmybatis.wrapper.UserQuery;
import com.cx.fluentmybatis.wrapper.UserUpdate;
import com.cx.model.Login;
import com.cx.model.PageReq;
import com.cx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RolesMapper rolesMapper;


    @Override
    public int delete(String userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public int insert(UserEntity userEntity) {
        userEntity.setUserId(KeyUtil.getUUIDKey(userEntity.getUserAccount()));
        userEntity.setUserPassword(SaSecureUtil.md5(userEntity.getUserPassword()));
        return userMapper.insertWithPk(userEntity);
    }

    @Override
    public StdPagedList<UserEntity> getUserList(PageReq pageReq) {
        UserQuery query = new UserQuery();
        query.selectAll().limit(pageReq.getPageSize()*pageReq.getPageNum(),pageReq.getPageSize());
        return userMapper.stdPagedEntity(query);
    }

    /**
     *
     * @param id 用户id
     * @return 返回对应的Entity,查询失败返回null
     */
    @Override
    public UserEntity getUserById(String id) {
        UserQuery query=new UserQuery();
        query.where().userId().eq(id).end();
        UserEntity res= userMapper.findOne(query);
        return res;
    }
    /**
     *
     * @param account 用户的账号
     * @return  返回UserEntiry对象，查询失败返回null
     */
    @Override
    public UserEntity getUserByAccount(String account) {
        UserQuery query=new UserQuery();
        query.where().userAccount().eq(account);
        UserEntity res=userMapper.findOne(query);
        return res;
    }

    @Override
    public int update(UserEntity user) {
        return userMapper.updateById(user);
    }

    @Override
    public String getUserRolesByUserId(String userid) {
        int rolesId=getUserById(userid).getUserRoles();
        return getUserRolesByRolesId(rolesId);
    }

    @Override
    public String getUserRolesByRolesId(Integer rolesId) {
        RolesQuery query=new RolesQuery();
        query.where().rolesId().eq(rolesId);
        return rolesMapper.findOne(query).getRolesName();
    }

    @Override
    public List<UserEntity> getExcludeList(List<String> list) {
        UserQuery query=new UserQuery();
        query.where.userId().notIn(list).end();
        return userMapper.listEntity(query);
    }
}
