<template>
    <div>
        <h1>教师列表</h1>
        <a-table :dataSource="allTeacherList" :columns="columns"></a-table>
    </div>
</template>

<script>
import {requestAllTeacherList} from "@/api/teacher.js";

export default {
    name: "SChoose",
    data() {
        return {
            allTeacherList: [],
            columns: [
                {
                    //name
                    dataIndex: 'teacherId',
                    key: 'teacherId'
                },
                {
                    //科室
                    dataIndex: 'deptId',
                    key: 'deptId'
                },
                {
                    //研究方向
                    dataIndex: 'teacherDescribe',
                    key: 'teacherDescribe'
                }, {
                    //职称
                    dataIndex: 'zhicheng',
                    key: 'zhicheng'
                }, {
                    //操作
                    key:'action'
                }
            ],
        }
    },
    created() {
        this.getAllTeacherList();
    },
    methods: {
        getAllTeacherList() {
            requestAllTeacherList().then(response => {
                this.allTeacherList = response.data.data;
            });
        }
    }
}
</script>

<style scoped>

</style>
