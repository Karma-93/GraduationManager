package com.cx;


import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.fluentmybatis.entity.InformEntity;
import com.cx.model.PageReq;
import com.cx.service.DownService;
import com.cx.service.InformService;
import com.cx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = GraduationProjectManagerApplication.class)
public class ServiceTest {
    @Autowired
    public UserService userService;
    @Autowired
    public DownService downService;
    @Autowired
    public InformService informService;
    @Test
    public void userServiceTest(){
        System.out.println(userService.getUserByAccount("学生1"));
    }

    @Test
    public void downServiceTest(){
        StdPagedList<DownEntity> res;
        PageReq pageReq=new PageReq();
        pageReq.setPageNum(1);
        pageReq.setPageSize(5);
        res=downService.get(pageReq);
        System.out.println(res.getTotal());
        for (DownEntity i:res.getData()){
            System.out.println(i);
        }
    }

    @Test
    public void informServiceTest(){
        StdPagedList<InformEntity> res;
        PageReq pageReq=new PageReq();
        pageReq.setPageNum(0);
        pageReq.setPageSize(5);
        res=informService.get(pageReq);
        System.out.println(res.getTotal());
        for (InformEntity i:res.getData()){
            System.out.println(i.getInformTitle());
        }
    }
}
