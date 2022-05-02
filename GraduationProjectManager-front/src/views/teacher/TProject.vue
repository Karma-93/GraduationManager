<template>
    <a-card title="选题列表">
        <a-list
            rowKey="id"
            :grid="{gutter: 24, lg: 3, md: 2, sm: 1, xs: 1}"
            :dataSource="projectList"
            class="card-list"
        >
            <a-list-item slot="renderItem" slot-scope="item">
                <template v-if="!item || item.projectId === undefined">
                    <a-button class="new-btn" type="dashed">
                        <a-icon type="plus" />新增选题
                    </a-button>
                </template>
                <template v-else>
                    <a-card :hoverable="true">
                        <a-card-meta>
                            <a slot="title">{{ item.projectName }}</a>
                            <!--<a-avatar
                                class="card-avatar"
                                slot="avatar"
                                :src="item.avatar"
                                size="large"
                            />-->
                            <div class="meta-content" slot="description">
                                <p>
                                <a-tag v-if="item.projectState == 0" color="blue">未选择</a-tag>
                                <a-tag v-if="item.projectState == 1" color="red">已被选待审核</a-tag>
                                <a-tag v-if="item.projectState == 2" color="red">已被选</a-tag>
                                </p>
                                <p>{{ item.projectDescribe }}</p>

                            </div>
                        </a-card-meta>
                        <template class="ant-card-actions" slot="actions">
                            <a>编辑</a>
                            <a @click="deleteProject(item.projectId)">删除</a>
                        </template>
                    </a-card>
                </template>
            </a-list-item>
        </a-list>
    </a-card>
</template>

<script>
import {
    requestProejctListByTeacherId,
    requestUpdateProject,
    requestDelete,
} from "@/api/project.js";
import { requestTeacherByUserId } from "@/api/teacher.js";

export default {
    name: "TProject",
    data() {
        return {
            teacherData: [],
            projectList: [],
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
            const projectresult = await requestProejctListByTeacherId(
                this.teacherData.teacherId
            );
            this.projectList = projectresult.data.data;
            this.projectList.push({});
            console.log(this.projectList);
            console.log(this.teacherData);
        },
        deleteProject(projectId) {
            requestDelete(projectId);
        },
    },
};
</script>

<style lang="less" scoped>
.card-list {
    /deep/ .ant-card-body:hover {
        .ant-card-meta-title > a {
        }
    }

    /deep/ .ant-card-meta-title {
        margin-bottom: 12px;

        & > a {
            display: inline-block;
            max-width: 100%;
            color: rgba(0, 0, 0, 0.85);
        }
    }

    /deep/ .meta-content {
        position: relative;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        height: 64px;
        -webkit-line-clamp: 3;
        -webkit-box-orient: vertical;

        margin-bottom: 1em;
    }
}

.card-avatar {
    width: 48px;
    height: 48px;
    border-radius: 48px;
}

.ant-card-actions {
    background: #f7f9fa;

    li {
        float: left;
        text-align: center;
        margin: 12px 0;
        color: rgba(0, 0, 0, 0.45);
        width: 50%;

        &:not(:last-child) {
            border-right: 1px solid #e8e8e8;
        }

        a {
            color: rgba(0, 0, 0, 0.45);
            line-height: 22px;
            display: inline-block;
            width: 100%;
            &:hover {
            }
        }
    }
}

.new-btn {
    background-color: #fff;
    border-radius: 2px;
    width: 100%;
    height: 188px;
}
</style>
