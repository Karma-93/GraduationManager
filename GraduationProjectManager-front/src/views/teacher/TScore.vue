<template>
    <div>
        <a-card>
            <a-table
                :data-source="data"
                :row-key="record => record.userId"
                :loading="listLoading"
                :pagination="false"
            >
                <a-table-column
                    key="studentId"
                    title="学生ID"
                    data-index="studentId"
                    align="center"
                ></a-table-column>
                <a-table-column
                    key="studentName"
                    title="姓名"
                    data-index="studentName"
                    align="center"
                />

                <a-table-column
                    key="classId"
                    title="班级"
                    data-index="classId"
                    align="center"
                >
                    <template slot-scope="text">
                        <span v-if="text == 1">2020级计算机科学技术</span>
                        <span v-if="text == 2">2020级电子信息</span>
                        <span v-if="text == 3">2020级人工智能</span>
                        <span v-if="text == 4">2020级数据分析</span>
                    </template>
                </a-table-column>
                <a-table-column
                    key="studentScore"
                    title="成绩"
                    data-index="sutdentScore"
                    align="center"
                >
                    <template slot-scope="record">
                        <span v-if="record == null">
                            <a-input-search
                                v-model:value="scort"
                                placeholder="请输入成绩"
                                enter-button="保存"
                                size="smile"
                                @search="saveScort"
                            />
                        </span>
                        <span v-else>
                            {{record}}
                        </span>
                        <!--
                        <span v-if="record == null">无成绩</span>
                        <span v-else><textarea context="aaa"> </textarea></span>
                        -->
                    </template>
                </a-table-column>
                <!--
                <a-table-column
                    key="projectId"
                    title="选题"
                    data-index="projectId"
                    align="center"
                >
                    <template slot-scope="record">
                        <span v-if="record == null">未选题</span>
                        <span v-else>{{ record }}</span>
                    </template>
                </a-table-column>
               -->
            </a-table>

        </a-card>

        <!-- 编辑弹框组件 -->
        <!--<edit ref="editRef" @fetch-data="fetchData" />-->
    </div>
</template>

<script>
import { requestTeacherByUserId } from "@/api/teacher.js"
import { requestStudentList, reqeustStudentListByTeacherId, requestNameByStudentId, requestRemoveStudent } from "@/api/student.js"
import { message, Modal } from "ant-design-vue";

export default {
    name: "TScore",

    created() {
        this.fetchData();
    },

    data() {
        return {
            data: [],
            total: 0,
            // 查询列表数据条件
            queryForm: {
                pageNum: 1,
                pageSize: 5,
            },

            // 编辑弹窗对象
            editRef: null,
            // 表格lading
            listLoading: false,

            teacherData: [],
            curUserId: "",
            scort: 0,
        }
    },
    methods: {
        async fetchData() {
            this.listLoading = true;
            this.curUserId = this.$store.state.userInfo.userId;
            const teacherres = await requestTeacherByUserId(this.curUserId)
            this.teacherData = teacherres.data.data;
            //const result = await requestStudentList(this.queryForm);
            const result = await reqeustStudentListByTeacherId(this.teacherData.teacherId);
            if (result.data.code == 1) {
                this.data = result.data.data;
            }
            await this.getStudentName();
            this.listLoading = false;
        },

        async getStudentName() {
            var index;
            for (index in this.data) {
                const temp = this.data[index]
                const res = await requestNameByStudentId(temp.studentId);
                temp.studentName = res.data.data;
                //temp["teacherName"]=res.data.data;
            }
        },
        saveScort() {

        }



    }
}
</script>

<style scoped>
</style>
