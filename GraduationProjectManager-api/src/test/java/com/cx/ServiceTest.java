package com.cx;


import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.*;
import com.cx.fluentmybatis.mapper.SessionListMapper;
import com.cx.model.PageReq;
import com.cx.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = GraduationProjectManagerApplication.class)
public class ServiceTest {
    @Autowired
    public UserService userService;
    @Autowired
    public DownService downService;
    @Autowired
    public InformService informService;
    @Autowired
    public PaperlibService paperlibService;
    @Autowired
    private SessionListService sessionListService;
    @Autowired
    private SessionListMapper sessionListMapper;
    @Autowired
    private MessageService messageService;

    @Test
    public void userServiceTest(){
        System.out.println(userService.getUserById("10001"));
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

    @Test
    public void paperlibServiceTest(){
        PaperlibEntity temp=new PaperlibEntity();
        temp.setInfo("论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-");
        temp.setName("论文名称");
        paperlibService.insert(temp);

    }


    @Test
    public void SessionListServiceInsertTest(){
        SessionListEntity sessionListEntity=new SessionListEntity();
        sessionListEntity.setUserId("10001");
        sessionListEntity.setToUserId("20003");
        sessionListEntity.setListName("20003");
        sessionListEntity.setUnReadCount(1);
        sessionListService.insert(sessionListEntity);
        //System.out.println(sessionListMapper.insert(sessionListEntity));
    }

    @Test
    public void SessionListServiceTest(){
        //sessionListService.addUnReadCount("20001","10001");
        //System.out.println(sessionListService.getIdByUser("20001","10001"));
        //System.out.println(sessionListService.getSessionListByUserId("10001"));
        //sessionListService.delUnReadCount("20001","10001");

        List<String> list=sessionListService.getUserIdByUserId("10001");
        System.out.println(list);
        System.out.println(userService.getExcludeList(list));

    }

    @Test
    public void MessageServiceTest(){
        /*
        MessageEntity entity=new MessageEntity();
        entity.setUserId("10001");
        entity.setToUserId("20002");
        entity.setMessageBody("hello1");
        entity.setCreateDate(new Date());
        for (int i=0;i<3;i++) {
            messageService.insertMessage(entity);
        }
        */

        //System.out.println(messageService.getMessageList("20001","10001"));
        //messageService.messageRead("20001","10001");

    }


}

