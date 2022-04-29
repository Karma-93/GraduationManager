<template>
    <div>
        <a-card :bordered="false">
      
      <a-descriptions title="用户信息">
        <a-descriptions-item label="姓名">{{curUserName}}</a-descriptions-item>
        <a-descriptions-item label="电话">{{curUserTel}}</a-descriptions-item>
        <a-descriptions-item label="部门">{{teacherData.deptId}}</a-descriptions-item>
        <a-descriptions-item label="信息">{{teacherData.teacherDescribe}}</a-descriptions-item>
        <a-descriptions-item label="职称">{{teacherData.zhicheng}}</a-descriptions-item>
      </a-descriptions>
      <a-divider style="margin-bottom: 32px"/>

    </a-card>
    </div>
</template>

<script>
import {requestTeacherByUserId} from "@/api/teacher.js"

export default {
    name: "THome",
    data(){
        return{
             curUserId: "",
            curUserName: "",
            curUserTel: "", 
            teacherData: [], 
        }
    }
    ,
    created(){
        this.curUserId = this.$store.state.userInfo.userId;
        this.curUserName = this.$store.state.userInfo.userName;
        this.curUserTel = this.$store.state.userInfo.userTel;
        this.getTeacherData();
    },
    methods: {
        getTeacherData(){
            requestTeacherByUserId(this.curUserId).then((result) => {
                this.teacherData=result.data.data;
                console.log(this.teacherData)
                console.log("tel",this.curUserTel)
                console.log("userInfo",this.$store.state.userInfo)
            }).catch((err) => {
                
            });
        },
    }

}
</script>

<style scoped>

</style>
