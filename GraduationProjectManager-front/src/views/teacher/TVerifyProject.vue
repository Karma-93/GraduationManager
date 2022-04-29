<template>
    <div>
        <a-card>
            <a-table :data-source="VerifyData">
                 
                <a-table-column
                    key="projectName"
                    title="课题名"
                    data-index="projectName"
                    align="center"
                />

                <a-table-column key="userName" title="选题学生" data-index="userName" align="center" />
                <a-table-column key="className" title="班级" data-index="className" align="center" />
                <a-table-column key="tel" title="电话" data-index="tel" align="center" />
                
                <!-- 不写template模板的话，直接显示该行数据对应的key配对的值 -->
                <a-table-column key="action" title="操作" align="center">
                    <template slot-scope="text, record">
                        <a-button type="link" @click="verifyChoose(record)">同意</a-button>
                    </template>
                </a-table-column>
            </a-table>
        </a-card>
    </div>
</template>

<script>
import {
    requestVerifyPorjectList,
    requestVerifyChoose,
} from "@/api/project.js";
import {requestTeacherByUserId} from "@/api/teacher.js"

export default {
    name: "TVerifyProject",
    data() {
        return {
            VerifyData: [],
            teacherData: [],
        };
    },
    created() {
        this.fetchData();
    },
    methods: {
        async fetchData() {
            const result = await requestTeacherByUserId(
                this.$store.state.userInfo.userId
            );
            this.teacherData = result.data.data;
            const projectresult = await requestVerifyPorjectList(
                this.teacherData.teacherId
            );
            this.VerifyData = projectresult.data.data;
            console.log(this.projectList);
            console.log(this.teacherData);
        },
        verifyChoose(record){
            requestVerifyChoose(record.projectId);
            this.fetchData();
        }
    },
};
</script>

<style scoped>
</style>
