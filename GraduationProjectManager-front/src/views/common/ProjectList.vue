<template>
    <div>
        <a-card style="margin-top: 24px" :bordered="false">
            <a-list size="small">
                <a-list-item :key="index" v-for="(item, index) in projectList">
                    <a-list-item-meta :description="item.projectDescribe">
                        <!--<a-avatar slot="avatar" size="large" shape="square" src="https://joeschmoe.io/api/v1/random"/>-->
                        <a slot="title">{{ item.projectName }}</a>
                    </a-list-item-meta>
                    <div slot="actions">
                        <a-popconfirm
                            :disabled="item.projectState==0?false:true"
                            title="确认选择该选题?"
                            ok-text="Yes"
                            cancel-text="No"
                            @confirm="choose(item)"
                        >
                            <a-button :disabled="item.projectState==0?false:true">选择该选题</a-button>
                        </a-popconfirm>
                    </div>

                    <div class="list-content">
                        <div class="list-content-item">
                            <a-badge :status="item.projectState==0?'success':'error'" :text="item.projectState==0?'可选':'已被选择'" />
                        </div>

                    </div>
                </a-list-item>
            </a-list>
        </a-card>
    </div>
</template>

<script>
import pick from "lodash.pick";
import { requestProejctListByTeacherId } from "@/api/project.js";
import { requestChooseProject } from "../../api/project";

export default {
    name: "ProjectList",
    props: {
        record: {
            type: Object,
            default: null,
        },
    },
    created() {
        this.getProjectList();
    },
    data() {
        return {
            projectList: [],
        };
    },
    mounted() {},

    methods: {
        getProjectList() {
            requestProejctListByTeacherId(this.record.teacherId).then(
                (response) => {
                    this.projectList = response.data.data;
                }
            );
        },
        choose(data) {
            console.log("choose");
            requestChooseProject(data.projectId);
            this.getProjectList();
        },
        onOk() {
            console.log("监听了 modal ok 事件");
            return new Promise((resolve) => {
                resolve(true);
            });
        },
        onCancel() {
            console.log("监听了 modal cancel 事件");
            return new Promise((resolve) => {
                resolve(true);
            });
        },
        handleSubmit() {
            const {
                form: { validateFields },
            } = this;
            this.visible = true;
            validateFields((errors, values) => {
                if (!errors) {
                    console.log("values", values);
                }
            });
        },
    },
};
</script>
