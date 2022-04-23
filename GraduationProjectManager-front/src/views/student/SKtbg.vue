<template>
<div>
<a-divider orientation="left">开题报告</a-divider>
  <a-row type="flex">
    <a-col :span="6" :order="4"> 姓名：{{studentName}}</a-col>
    <a-col :span="6" :order="3">学号：{{studentData.studentId}}</a-col>
    <a-col :span="6" :order="2">班级：{{studentData.classId}}</a-col>
    <a-col :span="6" :order="1">选题名称：{{projectName}}</a-col>
  </a-row>
</div>
</template>

<script>
import { requestCurrentStudentData } from "@/api/student.js"
import  { requestProjectById} from "@/api/project.js"
export default {
    name: "SKtbg",
    data(){
        return{
            studentData:[],
            studentName:this.$store.state.userInfo.userName,
            projectName:"",
            class:""
        }
    },
    created(){
        this.getStudentData()
    },
    methods: {
        getStudentData(){
            requestCurrentStudentData().then((response)=>{
                this.studentData=response.data.data;
                if(this.studentData.projectId!=null & this.studentData.projectId!==""){
                    this.getStudentProject(this.studentData.projectId);
                }else{
                    this.projectName="未选择选题";
                }
            });
        },
        getStudentProject(projectId){
            requestProjectById(projectId).then((response)=>{
                this.projectName=response.data.data.projectName;
            });
        }
    }
}
</script>

<style scoped>

</style>
