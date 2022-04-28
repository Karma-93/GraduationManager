package com.cx;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.mapper.TeacherMapper;
import com.cx.fluentmybatis.mapper.UserMapper;
import com.cx.fluentmybatis.wrapper.TeacherQuery;
import com.cx.fluentmybatis.wrapper.TeacherUpdate;
import com.cx.fluentmybatis.wrapper.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GraduationProjectManagerApplication.class)
public class FluentMyBatisTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Test
    public void fluentInsertTest() {
        for(int i=6;i<=12;i++) {
            //当自定义主键时 使用insertWithPK
            UserEntity user = new UserEntity();
            user.setUserId("1000"+i);
            user.setUserAccount("教师"+i);
            user.setUserName("教师"+i);
            user.setUserPassword("123456");
            user.setUserTel("11111111111");
            user.setUserRoles(1);
            user.setUserPassword(SaSecureUtil.md5(user.getUserPassword()));
            //当自定义主键时 使用insertWithPK
            userMapper.insertWithPk(user);
        }
    }

    @Test
    public void SelectTest() {
        UserQuery query = new UserQuery().where.userId().eq("10001").end();
        UserEntity user = userMapper.findOne(query);
        System.out.println(user.getUserName());
    }

    @Test
    public void test1(){
        String teacherId="11001";
    }
}
