<template>
    <div>
        <a-card>
            <a-button type="primary" style="margin:10px 0" @click="clickEdit(null)">添加教师信息</a-button>
            <a-table :data-source="data" :row-key="record => record.userId" :loading="listLoading" :pagination="false">
                <a-table-column key="teacherId" title="教师ID" data-index="teacherId" align="center">

                </a-table-column>
                <a-table-column key="teacherName" title="姓名" data-index="teacherName" align="center" />

                <a-table-column key="deptId" title="所属部门" data-index="deptId" align="center">
                    <template slot-scope="text">
                        <span v-if="text == 1">计算机科学教研室</span>
                        <span v-if="text == 2">大数据教研室</span>
                        <span v-if="text == 3">数字媒体技术教研室</span>
                        <span v-if="text == 4">广播电视工程教研室</span>
                    </template>
                </a-table-column>
                <a-table-column key="zhicheng" title="职称" data-index="zhicheng" align="center" />
                <a-table-column key="teacherDescribe" title="研究方向" data-index="teacherDescribe" align="center" />
                <a-table-column key="teacherProjectNum" title="研究课题数" data-index="teacherProjectNum" align="center" />
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
import Edit from "./components/ATeacherEditDialog.vue";
// 引入删除弹窗组件
import {message, Modal} from "ant-design-vue";
import {
    requestAllTeacherList,
    requestNameByTeacherId,
    requestRemoveTeacher,
} from "@/api/teacher.js";

export default {
    name: "ATeacher",
    components: { Edit },
    data() {
        return {
            // 编辑弹窗对象
            editRef: null,
            // 表格数据
            data: [],
            // 表格lading
            listLoading: false,
            // 查询列表数据条件
            queryForm: {
                pageNum: 0,
                pageSize: 10,
            },
            total: 0,
        };
    },
    methods: {
        /**
         * @description 查询列表
         * @author Cui Ruichen
         * @date 2022-04-29
         */
        async fetchData() {
            this.listLoading = true;
            const res = await requestAllTeacherList(this.queryForm);
            this.data = res.data.data;
            this.total = res.data.total;
            await this.getTeacherName();
            console.log("data",this.data);
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
                this.$refs.editRef.showEdit(record);
            }
            // 行内编辑
            else if (type == "edit") {
                this.$refs.editRef.showEdit(record, type);
            }
            // 行内删除
            else if (type == "delete") {
                Modal.confirm({
                    title: "你确定要删除吗?",
                    onOk() {
                        requestRemoveTeacher(record.teacherId).then((response)=>{
                            if (response.data.code==1){
                                message.success("删除成功");
                            }else{
                                message.error("删除失败");
                            }
                        });
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


        async getTeacherName() {
            var index;
            for (index in this.data) {
                const temp = this.data[index]
                const res = await requestNameByTeacherId(temp.teacherId);
                temp.teacherName = res.data.data;
                //temp["teacherName"]=res.data.data;
            }
        },
    },
    created() {
        this.fetchData();
    },
};
</script>

<style scoped>
</style>
