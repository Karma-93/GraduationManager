<template>
    <div>

  <a-card style="margin-top: 24px" :bordered="false" title="管理员信息">
      <a-descriptions>
        <a-descriptions-item label="管理员姓名">{{curUserName}}</a-descriptions-item>
        <a-descriptions-item label="联系方式">{{curUserTel}}</a-descriptions-item>
      </a-descriptions>
      
      <a-descriptions title="信息组">
        <a-descriptions-item label="选题个数">{{projectNum}}</a-descriptions-item>
        <a-descriptions-item label="可选课题个数">{{projectNoChooseNum}}</a-descriptions-item>
        <a-descriptions-item ></a-descriptions-item>
        <a-descriptions-item label="学生个数">{{studentNum}}</a-descriptions-item>
        <a-descriptions-item label="未选题学生个数">{{studentNoProjectNum}}</a-descriptions-item>
        <a-descriptions-item ></a-descriptions-item>
      </a-descriptions>

    </a-card>


    </div>
</template>

<script>

import {requestCountProject,requestCountNoChooseProject} from "@/api/project.js"
import{getStudentNum,getNoProjectStudentNum} from "@/api/student.js"
import { requestUpdateProject } from '../../api/project'

export default {
    name: "AHome",
    data(){
        return{
            curUserId: "",
            curUserName: "",
            curUserTel: "", 
            projectNum:0,
            projectNoChooseNum:0,
            studentNum:0,
            studentNoProjectNum:0,
        }
    },
    created(){
        this.curUserId = this.$store.state.userInfo.userId;
        this.curUserName = this.$store.state.userInfo.userName;
        this.curUserTel = this.$store.state.userInfo.userTel;
        this.fatchData();
    },
    methods:{
      async fatchData(){
        const result=await getStudentNum();
        this.studentNum=result.data.data;
        const result1=await getNoProjectStudentNum();
        this.studentNoProjectNum=result1.data.data;
        const result2=await requestCountProject();
        this.projectNum=result2.data.data;
        const result3=await requestCountNoChooseProject();
        this.projectNoChooseNum=result3.data.data;
      },
    }
}
</script>

<style scoped>

</style>
