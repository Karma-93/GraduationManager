<template>
    <div>
        <a-card title="审核选题申请">
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
                        <div v-if="record.projectState==1">
                            <a-button type="link" @click="verifyChoose(record)">同意</a-button>
                            <a-button type="link" @click="disagree(record)">拒绝</a-button>
                        </div>
                        <div v-else>已同意选择</div>
                    </template>
                </a-table-column>
                <a-table-column key="action1" title="发送消息" align="center">
                    <template slot-scope="text, record">
                        <a-button type="link" @click="createSessionClick(record)">发送消息</a-button>
                    </template>
                </a-table-column>
            </a-table>
        </a-card>
    </div>
</template>

<script>
import { createSession } from "@/api/message.js";
import NewMessage from "@/views/message/NewMessage";
import {
    requestVerifyPorjectList,
    requestVerifyChoose,
    reqeustChangeNoSelect,
} from "@/api/project.js";
import { requestTeacherByUserId } from "@/api/teacher.js";
import { message } from "ant-design-vue";

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
        verifyChoose(record) {
            requestVerifyChoose(record.projectId).then((response) => {
                if (response.data.code == 1) {
                    message.success("成功");
                } else {
                    message.error("失败");
                }
            });
            this.fetchData();
        },

        disagree(record) {
            reqeustChangeNoSelect(record.projectId).then((response) => {
                if (response.data.code == 1) {
                    message.success("成功");
                } else {
                    message.error("失败");
                }
            });
            this.fetchData();
        },
        async createSessionClick(item) {
            const result = await createSession({
                toUserId: item.userId,
                toUserName: item.userName,
            });
            const record = result.data.data;
            console.log("temp", record);
            this.$dialog(
                NewMessage,
                // component props
                {
                    record,
                    on: {
                        ok() {
                            console.log("ok 回调");
                        },
                        cancel() {
                            console.log("cancel 回调");
                        },
                        close() {
                            console.log("modal close 回调");
                        },
                    },
                },
                // modal props
                {
                    title: "聊天窗口",
                    width: 650,
                    centered: true,
                    maskClosable: false,
                }
            );
        },
    },
};
</script>

<style scoped>
</style>
