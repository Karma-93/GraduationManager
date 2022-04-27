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

            <a-list
                size="large"
                :pagination="{
                    showSizeChanger: true,
                    showQuickJumper: true,
                    pageSize: 5,
                    total: 50
                }"
            >
                <a-list-item
                    :key="index"
                    v-for="(item, index) in allTeacherData"
                >
                    <a-list-item-meta :description="item.describe">
                        <a-avatar
                            slot="avatar"
                            size="large"
                            shape="square"
                            src="https://joeschmoe.io/api/v1/random"
                        />

                        <a slot="title">{{ item.userName }}</a>
                    </a-list-item-meta>
                    <div slot="actions">
                        <a @click="choose(item)">选择该教师的课题</a>
                    </div>
                    <!--
                    <div slot="actions">
                        <a-dropdown>
                            <a-menu slot="overlay">
                                <a-menu-item><a>编辑</a></a-menu-item>
                                <a-menu-item><a>删除</a></a-menu-item>
                            </a-menu>
                            <a>更多<a-icon type="down"/></a>
                        </a-dropdown>
                    </div>
                    -->
                    <div class="list-content">
                        <div class="list-content-item">
                            <span>职称</span>
                            <p>{{ item.zhicheng }}</p>
                        </div>

                        <div class="list-content-item">
                            <span>部门</span>
                            <p>{{ item.dept }}</p>
                        </div>
                        <div class="list-content-item">
                            <span>可选课题数</span>
                            <a-progress
                                :steps="10"
                                :percent="item.project_num"
                                style="width: 180px"
                            />
                        </div>
                    </div>
                </a-list-item>
            </a-list>
        </a-card>
    </div>
</template>

<script>
import { requestAllTeacherData } from "@/api/teacher.js";
import { requestUserById } from "@/api/user.js";
import ProjectList from "@/views/common/ProjectList";

export default {
    name: "SChoose",
    data() {
        return {
            allTeacherData: [],
            status: "all"
        };
    },
    created() {
        this.getAllTeacherData();
    },
    methods: {
        getAllTeacherData() {
            requestAllTeacherData().then(response => {
                this.allTeacherData = response.data.data;
            });
        },
        choose(record) {
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
    }
};
</script>

<style scoped></style>
