<template>
    <div>
        <a-card>
            <!-- <a-row>
            <a-space>
                <a-radio-group v-model="status">
                    <a-radio-button value="all">全部</a-radio-button>
                    <a-radio-button value="processing">进行中</a-radio-button>
                    <a-radio-button value="waiting">等待中</a-radio-button>
                </a-radio-group>
                <a-input v-model:value="value" placeholder="请输入" />
                <a-button
                    type="primary"
                    :loading="iconLoading"
                    @click="enterIconLoading"
                >
                    <template #icon><search-outlined /></template>
                    查询
                </a-button>
            </a-space>
        </a-row> -->
            <a-button
                type="primary"
                style="margin:10px 0"
                @click="clickEdit(null)"
                >添加</a-button
            >
            <a-table :data-source="data">
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
                />
                <a-table-column
                    key="projectName"
                    title="课题名"
                    data-index="projectName"
                    align="center"
                />

                <!-- 每一列的显示控制 -->
                <a-table-column
                    key="projectStatus"
                    title="选题状态"
                    data-index="projectStatus"
                    align="center"
                >
                    <!-- 列里边的模板，text代表该行的列数据,record代表该行整体对象数据，这里record.projectStatus就等于text -->
                    <template slot-scope="text">
                        <a-tag v-if="text == 0" color="blue">
                            未选择
                        </a-tag>
                        <a-tag v-if="text == 1" color="red">已被选</a-tag>
                    </template>
                </a-table-column>
                <a-table-column
                    key="studentId"
                    title="选题学生"
                    data-index="studentId"
                    align="center"
                />
                <!-- 不写template模板的话，直接显示该行数据对应的key配对的值 -->
                <a-table-column
                    key="teacherId"
                    title="指导老师"
                    data-index="teacherId"
                    align="center"
                />
                <a-table-column key="action" title="操作" align="center">
                    <template slot-scope="text, record">
                        <a-button type="link" @click="clickEdit(record)"
                            >编辑</a-button
                        >
                    </template>
                </a-table-column>
            </a-table>
        </a-card>
    </div>
</template>

<script>
export default {
    name: "AProject",
    data() {
        return {
            // 表格数据
            data: [
                {
                    projectDescribe: "课题描述111",
                    projectFromId: "课题来源课题来源",
                    projectName: "基于单片机的宿舍智能防火防盗系统",
                    projectStatus: 0,
                    studentId: "小明",
                    teacherId: "张三"
                },
                {
                    projectDescribe: "课题描述222",
                    projectFromId: "课题来源课题来源",
                    projectName: "基于单片机的智能热水器系统",
                    projectStatus: 1,
                    studentId: "小红",
                    teacherId: "李四"
                }
            ]
        };
    },
    methods: {
        /**
         * @description 行内点击按钮编辑事件
         * @author Cui Ruichen
         * @date 2022-04-29
         */
        clickEdit(record) {
            if (record) {
                // 如果record存在，则为行内操作点击事件
                console.log("===行内点击===", record);
            } else {
                console.log("===行外点击===");
                // 否则为表格外添加按钮点击事件
            }
        }
    }
};
</script>

<style scoped></style>
