<template>
    <div>
        <a-card>
            <a-button
                type="primary"
                style="margin:10px 0"
                @click="clickEdit(null)"
            >添加</a-button>
            <a-table :data-source="data">
                <a-table-column
                    key="projectName"
                    title="课题名"
                    data-index="projectName"
                    align="center"
                />
                <a-table-column
                    key="projectDescribe"
                    title="课题表述"
                    data-index="projectDescribe"
                    align="center"
                />
                <a-table-column
                    key="projectFromId"
                    title="课题来源"
                    data-index="projectFromId"
                    align="center"
                >
                    <template slot-scope="text">
                        <span v-if="text == 1">自定选题</span>
                        <span v-if="text == 2">社会实践</span>

                    </template>
                </a-table-column>
                <!-- 每一列的显示控制 -->
                <a-table-column
                    key="projectState"
                    title="选题状态"
                    data-index="projectState"
                    align="center"
                >
                    <!-- 列里边的模板，text代表该行的列数据,record代表该行整体对象数据，这里record.projectStatus就等于text -->
                    <template slot-scope="text">
                        <a-tag
                            v-if="text == 0"
                            color="blue"
                        >
                            未选择
                        </a-tag>
                        <a-tag
                            v-if="text == 1"
                            color="orange"
                        >已被选择，待审核</a-tag>
                        <a-tag
                            v-if="text == 2"
                            color="red"
                        >已完成选择</a-tag>
                    </template>
                </a-table-column>
                <a-table-column
                    key="studentName"
                    title="选题学生"
                    data-index="studentName"
                    align="center"
                />
                <!-- 不写template模板的话，直接显示该行数据对应的key配对的值 -->
                <a-table-column
                    key="teacherName"
                    title="指导老师"
                    data-index="teacherName"
                    align="center"
                />
                <a-table-column
                    key="action"
                    title="操作"
                    align="center"
                >
                    <template slot-scope="text, record">
                        <a-button
                            type="link"
                            @click="clickEdit(record, 'edit')"
                        >编辑</a-button>
                        <a-button
                            type="link"
                            @click="clickEdit(record, 'delete')"
                        >删除</a-button>
                    </template>
                </a-table-column>
            </a-table>
        </a-card>

        <!-- 编辑弹框组件 -->
        <edit
            ref="editRef"
            @fetch-data="fetchData()"
        />
    </div>
</template>

<script>
import Edit from "./components/AProjectEditDialog.vue";
import { requestProjectList, requestDelete } from "@/api/project.js"
import { requestNameByStudentId } from "@/api/student.js"
import { requestNameByTeacherId } from "@/api/teacher.js";
import { message } from "ant-design-vue";
export default {
    name: "AProject",
    components: { Edit },
    data() {
        return {
            queryForm: {
                pageNum: 1,
                pageSize: 10
            },
            total: 0,
            // 表格数据
            data: [],
            editRef: null,

        };
    },
    created() {
        this.fetchData();
    },
    methods: {
        /**
         * @description 行内点击按钮编辑事件
         * @author Cui Ruichen
         * @date 2022-04-29
         */
        clickEdit(record) {
            // 行外添加
            if (!record) {
                this.$refs.editRef.showEdit();
            }
            // 行内编辑
            else if (type == "edit") {
                // 启用子组件弹窗的showEdit事件，使弹窗显示
                this.$refs.editRef.showEdit(record, type);
            }
            // 行内删除
            else if (type == "delete") {
                Modal.confirm({
                    title: "你确定要删除吗?",
                    onOk() {
                        requestDelete(record.projectId).then((response) => {
                            if (response.data.code == 1) {
                                message.success("删除成功");
                            } else {
                                message.error("删除失败");
                            }
                        });
                        console.log("===调用删除接口===", record);
                    },
                    class: "test",
                });
            }
        },

        async fetchData() {
            this.listLoading = true;
            const res = await requestProjectList(this.queryForm.pageSize, this.queryForm.pageNum);
            if (res.data.code == 1) {
                this.data = res.data.data.data;
                this.total = res.data.data.total;
            }
            this.getStudentName();
            this.getTeacherName();
            this.listLoading = false;
        },
        async getStudentName() {
            var index;
            for (index in this.data) {
                const temp = this.data[index]
                if (temp.studentId != null) {
                    const res = await requestNameByStudentId(temp.studentId);
                    if (res.data.code == 1) {
                        temp.studentName = res.data.data;
                    }
                }
            }
        },
        async getTeacherName() {
            var index;
            for (index in this.data) {
                const temp = this.data[index]
                if (temp.teacherId != null) {
                    const res = await requestNameByTeacherId(temp.teacherId);
                    if (res.data.code == 1) {
                        temp.teacherName = res.data.data;
                    }
                }
            }
        },
    }
};
</script>

<style scoped>
</style>
