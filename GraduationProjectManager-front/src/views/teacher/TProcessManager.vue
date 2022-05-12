<template>
    <a-card title="流程管理">
        <a-table :data-source="data">
            <a-table-column key="userName" title="姓名" data-index="userName" align="center" />

            <a-table-column key="projectName" title="课题名" data-index="projectName" align="center" />
            <a-table-column key="action1" title="开题报告" align="center">
                <template slot-scope="text, record">
                    <div v-if="record.ktbgId != null">
                        <a-button type="link">开题报告</a-button>
                    </div>
                    <div v-else>未提交</div>
                </template>
            </a-table-column>
            <a-table-column key="action2" title="期中小结" align="center">
                <template slot-scope="text, record">
                    <div v-if="record.qzxjId != null">
                        <a-button type="link">期中小结</a-button>
                    </div>
                    <div v-else>未提交</div>
                </template>
            </a-table-column>
            <a-table-column key="action3" title="论文" align="center">
                <template slot-scope="text, record">
                    <div v-if="record.lunwenId != null">
                        <a-button type="link">论文</a-button>
                    </div>
                    <div v-else>未提交</div>
                </template>
            </a-table-column>
        </a-table>
    </a-card>
</template>

<script>
import { requestStudentProcessList } from "@/api/student.js";
import { requestTeacherByUserId } from "@/api/teacher.js";

export default {
    name: "TProcessManager",
    data() {
        return {
            data: [],
            curUserId: "",
            curUserName: "",
            curUserTel: "",
            teacherData: [],
        };
    },
    created() {
        this.curUserId = this.$store.state.userInfo.userId;
        this.curUserName = this.$store.state.userInfo.userName;
        this.curUserTel = this.$store.state.userInfo.userTel;
        this.fetchData();
    },
    methods: {
        async fetchData() {
            const tresult = await requestTeacherByUserId(this.curUserId);
            this.teacherData = tresult.data.data;
            const dataresult = await requestStudentProcessList(
                this.teacherData.teacherId
            );
            this.data = dataresult.data.data;
        },
    },
};
</script>

<style scoped>
</style>
