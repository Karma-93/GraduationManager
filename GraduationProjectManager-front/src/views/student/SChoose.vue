<template>
    <div>
        <a-card style="margin-top: 24px" :bordered="false" title="教师列表">
            <div slot="extra">
                <a-radio-group v-model="status">
                    <a-radio-button value="all">全部</a-radio-button>
                    <a-radio-button value="processing">进行中</a-radio-button>
                    <a-radio-button value="waiting">等待中</a-radio-button>
                </a-radio-group>
                <a-input-search style="margin-left: 16px; width: 272px;" />
            </div>
            <!--
            <div class="operate">
                <a-button type="dashed" style="width: 100%" icon="plus" @click="add">添加</a-button>
            </div>
            -->
            <a-table
                :loading="listLoading"
                :columns="columns"
                :data-source="list"
                :row-key="record => record.teacherId"
                :pagination="false"
                bordered
            >
                <!-- 可选题数 -->
                <div class="project_num" slot="project_num" slot-scope="record">
                    <a-progress :steps="10" :percent="record" type="line" />
                </div>
                <!-- 操作 -->
                <div class="action" slot="action" slot-scope="record">
                    <a-button type="primary" @click="clickEdit(record)"
                        >选择</a-button
                    >
                </div>
            </a-table>

            <!-- 分页 -->
            <a-pagination
                style="margin-top:20px"
                align="center"
                :current="queryForm.pageNum"
                :pageSize="queryForm.pageSize"
                show-size-changer
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
    </div>
</template>

<script>
import ProjectList from "@/views/common/ProjectList";
import { requestAllTeacherData,requestTeacherData } from "@/api/teacher.js";


export default {
    components: { ProjectList },
    data() {
        return {
            total:0,
            projectRef: null, //弹窗对象
            listLoading: true, //列表loading开关
            list: [], //表格列表渲染数据
            // 查询表单
            queryForm: {
                pageNum: 1, //当前页数
                pageSize: 5 //每页显示数据量
            },
            // 表格列配置项
            columns: [
                {
                    title: "姓名",
                    dataIndex: "userName",
                    key: "name",
                    align: "center"
                },
                {
                    title: "职称",
                    dataIndex: "zhicheng",
                    key: "zhicheng",
                    align: "center"
                },
                {
                    title: "部门",
                    dataIndex: "userName",
                    key: "userName",
                    align: "center"
                },
                {
                    title: "剩余可选题数",
                    dataIndex: "project_num",
                    key: "project_num",
                    scopedSlots: { customRender: "project_num" },
                    align: "center",
                    width: "300px"
                },
                {
                    title: "操作",
                    key: "action",
                    scopedSlots: { customRender: "action" },
                    align: "center"
                }
            ],
            status: "all" //状态,
        };
    },
    methods: {
        /**
         * @description 查询列表数据
         * @author Cui Ruichen
         * @date 2022-04-27
         */
        async fetchData() {
            this.listLoading = true;
            const result = await requestTeacherData(this.queryForm);
            this.list = result.data.data.data;
            this.total = result.data.data.total;
            this.listLoading = false;
        },

        /**
         * @description 分页页码改变回调
         * @author Cui Ruichen
         * @date 2022-04-27
         */
        handleCurrentChange(val) {
            this.queryForm.pageNum = val;
            this.fetchData();
        },

        /**
         * @description 分页点击事件
         * @author Cui Ruichen
         * @date 2022-04-27
         */
        onShowSizeChange(current, pageSize) {
            console.log(current, pageSize);
        },

        /**
         * @description 行内点击事件
         * @author Cui Ruichen
         * @date 2022-04-27
         */
        clickEdit(record) {
            console.log(record);
            console.log(this.$refs.projectRef);
            this.$dialog(
                ProjectList,
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
                        }
                    }
                },
                // modal props
                {
                    title: "选题列表",
                    width: 1000,
                    centered: true,
                    maskClosable: false
                }
            );
        }
    },
    created() {
        this.fetchData();
    }
};
</script>

<style></style>
