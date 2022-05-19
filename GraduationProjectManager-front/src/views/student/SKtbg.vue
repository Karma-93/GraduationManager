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
        <a-card  :bordered="false">
        <a-upload-dragger

            v-model:fileList="fileList"
            name="file"
            :multiple="true"
            action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
            @change="handleChange"
            @drop="handleDrop"
        >
            <p class="ant-upload-drag-icon">
            </p>
            <p class="ant-upload-text">上传文件</p>
            <p class="ant-upload-hint">

            </p>
        </a-upload-dragger>
        </a-card>
    </div>
</template>

<script>
import ref from 'vue';
import {
    requestCurrentStudentData,
    requestStudentByUserId,
    requestClassName,
} from "@/api/student.js";
import { requestProjectById } from "@/api/project.js";
import { message } from 'ant-design-vue';
export default {
    name: "SKtbg",
    data() {
        return {
            studentData: [],
            studentName: this.$store.state.userInfo.userName,
            projectName: "",
            className: "",
            temp: "",
            column1: "",
            column2: "",
            form: this.$form.createForm(this),
        };
    },
    created() {
        this.getStudentData();
    },

    setup() {
        const handleChange = info => {
            const status = info.file.status;

            if (status !== 'uploading') {
                console.log(info.file, info.fileList);
            }

            if (status === 'done') {
                message.success(`${info.file.name} file uploaded successfully.`);
            } else if (status === 'error') {
                message.error(`${info.file.name} file upload failed.`);
            }
        };

        return {
            handleChange,
            fileList: ref([]),
            handleDrop: e => {
                console.log(e);
            },
        };
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
        handleSubmit(e) {
            e.preventDefault();
            this.form.validateFields((err, values) => {
                if (!err) {
                    console.log("Received values of form: ", values);
                }
            });
        },
    },
};
</script>

<style scoped>
</style>
