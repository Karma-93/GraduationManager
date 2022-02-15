package com.cx;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.mapper.UserMapper;
import com.cx.fluentmybatis.wrapper.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GraduationProjectManagerApplication.class)
public class FluentMyBatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void fluentInsertTest() {
        //当自定义主键时 使用insertWithPK
        UserEntity user = new UserEntity();
        user.setUserId("30001");
        user.setUserAccount("管理员");
        user.setUserName("管理员");
        user.setUserPassword("123456");
        user.setUserTel("11111111111");
        user.setUserRoles(3);
        user.setUserPassword(SaSecureUtil.md5(user.getUserPassword()));
        //当自定义主键时 使用insertWithPK
        userMapper.insertWithPk(user);
    }

    @Test
    public void SelectTest() {
        UserQuery query = new UserQuery().where.userId().eq("10001").end();
        UserEntity user = userMapper.findOne(query);
        System.out.println(user.getUserName());
    }
}
