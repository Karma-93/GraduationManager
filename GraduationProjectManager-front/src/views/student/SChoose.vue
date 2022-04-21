<template>
    <div>
        <h1>教师列表</h1>
        <a-table :dataSource="allTeacherData" :columns="columns">
            
             
        </a-table>
    </div>
</template>

<script>
import { requestAllTeacherData} from "@/api/teacher.js";
import {requestUserById} from "@/api/user.js"

export default {
    name: "SChoose",
    data() {
        return {
            allTeacherData: [],
            columns: [
                {
                    //name
                    dataIndex: "userName",
                    key: "userName",
                },
                {
                    //研究方向
                    dataIndex: "describe",
                    key: "describe",
                },
                {
                    //可选课题数
                    dataIndex: "project_num",
                    key: "project_num",
                },
                {
                    //职称
                    dataIndex: "zhicheng",
                    key: "zhicheng",
                },
                {
                    //操作
                    key: "teacherId",
                    dataIndex:"teacherId"
                },
            ],
        };
    },
    created() {
        this.getAllTeacherData();
    },
    methods: {
        getAllTeacherData() {
            requestAllTeacherData().then((response) => {
                this.allTeacherData = response.data.data;
            });
        }, 
    },
};
</script>

<style scoped>
</style>
