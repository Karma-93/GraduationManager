<template>
    <div>
        <a-card>
            <a-button
                type="primary"
                style="margin:10px 0"
                @click="clickEdit(null)"
                >添加新用户</a-button
            >
            <a-table
                :data-source="data"
                :row-key="record => record.userId"
                :loading="listLoading"
                :pagination="false"
            >
                <a-table-column
                    key="userId"
                    title="用户ID"
                    data-index="userId"
                    align="center"
                />
                <a-table-column
                    key="userAccount"
                    title="用户账号"
                    data-index="userAccount"
                    align="center"
                />
                <a-table-column
                    key="userName"
                    title="用户名"
                    data-index="userName"
                    align="center"
                />
                <a-table-column
                    key="userPassword"
                    title="用户密码"
                    data-index="userPassword"
                    align="center"
                />
                <a-table-column
                    key="userRoles"
                    title="角色"
                    data-index="userRoles"
                    align="center"
                >
                    <template slot-scope="text">
                        {{ text == 1 ? "教师" : "学生" }}
                    </template>
                </a-table-column>
                <a-table-column
                    key="userSex"
                    title="性别"
                    data-index="userSex"
                    align="center"
                >
                    <template slot-scope="text">
                        {{ text == 0 ? "男" : text == 1 ? "女" : "未知" }}
                    </template>
                </a-table-column>
                <a-table-column
                    key="userTel"
                    title="电话"
                    data-index="userTel"
                    align="center"
                />
                <a-table-column key="action" title="操作" align="center">
                    <template slot-scope="text, record">
                        <a-button type="link" @click="clickEdit(record, 'edit')"
                            >编辑</a-button
                        >
                        <a-button
                            type="link"
                            @click="clickEdit(record, 'delete')"
                            >删除</a-button
                        >
                    </template>
                </a-table-column>
            </a-table>

            <!-- 分页 -->
            <a-pagination
                style="margin-top:20px"
                align="center"
                :current="queryForm.pageNum"
                :pageSize="queryForm.pageSize"
                show-size-changer
                :show-total="total => `共 ${total} 条`"
                :total="total"
                @change="handleCurrentChange"
                @showSizeChange="onShowSizeChange"
            >
                <template #buildOptionText="props">
                    <span v-if="props.value !== '50'"
                        >{{ props.value }}条/页</span
                    >
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
import Edit from "./components/AUserEditDialog.vue";
// 引入删除弹窗组件
import { Modal } from "ant-design-vue";
import { requestGetUserList, requestRemoveUser } from "@/api/user.js";
import { message } from "ant-design-vue";

export default {
    name: "AUser",
    components: { Edit },
    data() {
        return {
            editRef: null,
            // 表格数据
            data: [],
            // 表格lading
            listLoading: false,
            // 查询列表数据条件
            queryForm: {
                pageNum: 1,
                pageSize: 10
            },
            total: 0
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
            const res = await requestGetUserList(this.queryForm);
            this.data = res.data.data.data;
            this.total = res.data.data.total;
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
                // 调用弹窗，行外添加无数据传输
                this.$refs.editRef.showEdit();
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
                        requestRemoveUser(record.userId).then(response => {
                            if (response.data.code == 1) {
                                message.success("删除成功");
                            } else {
                                message.error("删除失败");
                            }
                        });
                        console.log("===调用删除接口===", record);
                    },
                    class: "test"
                });
                this.fetchData();
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
        }
    },
    created() {
        this.fetchData();
    }
};
</script>

<style scoped></style>
