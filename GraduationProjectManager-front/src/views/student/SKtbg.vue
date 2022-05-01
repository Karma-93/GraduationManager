<template>
    <div>
        <a-card style="margin-top: 24px" :bordered="false" title="开题报告">
            <a-descriptions bordered>
                <a-descriptions-item label="姓名">{{studentName}}</a-descriptions-item>
                <a-descriptions-item label="学号">{{studentData.studentId}}</a-descriptions-item>
                <a-descriptions-item label="班级">{{className}}</a-descriptions-item>
                <a-descriptions-item label="选题">{{projectName}}</a-descriptions-item>
            </a-descriptions>
        </a-card>
            
    </div>
</template>

<script>
import {
    requestCurrentStudentData,
    requestStudentByUserId,
    requestClassName,
} from "@/api/student.js";
import { requestProjectById } from "@/api/project.js";
export default {
    name: "SKtbg",
    data() {
        return {
            studentData: [],
            studentName: this.$store.state.userInfo.userName,
            projectName: "",
            className: "",
            temp: "", 
        };
    },
    created() {
        this.getStudentData();
    },
    methods: {
        async getStudentData() {
            const result = await requestCurrentStudentData();
            this.studentData = result.data.data;
            if (
                (this.studentData.projectId != null) &
                (this.studentData.projectId !== "")
            ) {
                requestProjectById(this.studentData.projectId).then(
                    (response) => {
                        this.projectName = response.data.data.projectName;
                    }
                );
            } else {
                this.projectName = "未选择选题";
            }
            const result2 = await requestClassName(this.studentData.studentId);
            this.className = result2.data.data;
        },
    },
};
</script>

<style scoped>
</style>
