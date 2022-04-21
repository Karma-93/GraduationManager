<template>
<div>
<a-divider orientation="left">Normal</a-divider>
  <a-row type="flex">
    <a-col :span="6" :order="4"> 姓名：{{studentData.userName}}</a-col>
    <a-col :span="6" :order="3">学号：</a-col>
    <a-col :span="6" :order="2">班级：</a-col>
    <a-col :span="6" :order="1">选题名称：</a-col>
  </a-row>
</div>
</template>

<script>
import { requestCurrentStudentData } from "@/api/student.js"
export default {
    name: "SKtbg",
    data(){
        return{
            studentData:[],
            studentName:this.$store.userInfo.userName,
            projectName:"",
            class:""
        }
    },
    created(){
        this.getStudentData()
    },
    method:{
        getStudentData(){
            requestCurrentStudentData.then((response)=>{
                this.studentData=response.data.data;
            });
        },
    }
}
</script>

<style scoped>

</style>
