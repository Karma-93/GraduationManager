<template>
    <div>
        <a-card>
            <a-button type="primary" style="margin:10px 0" @click="clickEdit(null)">添加学生信息</a-button>
            <a-table :data-source="data" :row-key="record => record.userId" :loading="listLoading" :pagination="false">
                <a-table-column key="studentId" title="学生ID" data-index="studentId" align="center"></a-table-column>
                <a-table-column key="studentName" title="姓名" data-index="studentName" align="center" />

                <a-table-column key="classId" title="班级" data-index="classId" align="center">
                    <template slot-scope="text">
                        <span v-if="text == 1">2020级计算机科学技术</span>
                        <span v-if="text == 2">2020级电子信息</span>
                        <span v-if="text == 3">2020级人工智能</span>
                        <span v-if="text == 4">2020级数据分析</span>
                    </template>
                </a-table-column>
                <a-table-column key="studentScore" title="成绩" data-index="sutdentScore" align="center">
                    <template slot-scope="record">
                        <span v-if="record == null">无成绩</span>
                        <span v-else><textarea context="aaa"> </textarea></span>
                    </template>
                </a-table-column>
                <a-table-column key="projectId" title="选题" data-index="projectId" align="center">
                    <template slot-scope="record">
                        <span v-if="record == null">未选题</span>
                        <span v-else>{{ record }}</span>
                    </template>
                </a-table-column>
                <a-table-column key="action" title="操作" align="center">
                    <template slot-scope="text, record">
                        <a-button type="link" @click="clickEdit(record, 'edit')">编辑</a-button>
                        <a-button type="link" @click="clickEdit(record, 'delete')">删除</a-button>
                    </template>
                </a-table-column>
            </a-table>
            <!-- 分页 -->
            <a-pagination style="margin-top:20px" align="center" :current="queryForm.pageNum"
                :pageSize="queryForm.pageSize" show-size-changer :show-total="total => `共 ${total} 条`" :total="total"
                @change="handleCurrentChange" @showSizeChange="onShowSizeChange">
                <template #buildOptionText="props">
                    <span v-if="props.value !== '50'">{{ props.value }}条/页</span>
                    <span v-else>全部</span>
                </template>
            </a-pagination>
        </a-card>

        <!-- 编辑弹框组件 -->
        <edit ref="editRef" @fetch-data="fetchData" />
    </div>
</template>

<script>

// 引入弹框组件
import Edit from "./components/AStudentEditDialog.vue";
import { requestStudentList } from "@/api/student.js"
export default {
    name: "AStudent",
    created() {
        this.fetchData();
    },
    components: { Edit },

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
        }
    },
    methods: {
        async fetchData() {
            this.listLoading = true;
            const result = await requestStudentList(this.queryForm);
            if (result.data.code == 1) {
                this.data = result.data.data.data;
                this.total = result.data.data.total;
            }
            this.listLoading = false;
        },

        /**
         * @description 行内点击按钮编辑事件
         * @author Cui Ruichen
         * @date 2022-04-29
         */
        clickEdit(record, type) {
            // 行外添加
            if (!record) {
                console.log("===调用添加弹窗===");
            }
            // 行内编辑
            else if (type == "edit") {
                console.log("===调用编辑===");
                // 启用子组件弹窗的showEdit事件，使弹窗显示
                this.$refs.editRef.showEdit(record);
            }
            // 行内删除
            else if (type == "delete") {
                Modal.confirm({
                    title: "你确定要删除吗?",
                    onOk() {
                        console.log("===调用删除接口===", record);
                    },
                    class: "test",
                });
            }
        },

        /**
         * @description 分页页码改变回调
         * @author Cui Ruichen
         * @date 2022-04-27
         */
        handleCurrentChange(val) {
            this.queryForm.pageNum = val;
            this.fetchData(this.queryForm);
        },

        /**
         * @description 分页点击事件
         * @author Cui Ruichen
         * @date 2022-04-27
         */
        onShowSizeChange(current, pageSize) {
            this.queryForm.pageSize = pageSize;
            this.fetchData(this.queryForm);
        },
    }
}
</script>

<style scoped>
</style>
