<template>
    <div>
        <a-card :bordered="false" title="流程进度">
            <a-steps :direction="isMobile && 'vertical' || 'horizontal'" :current="0" progressDot>
                <a-step>
                    <template v-slot:title>
                        <span>选择选题</span>
                    </template>
                    <template v-slot:description>
                        <div class="antd-pro-pages-profile-advanced-style-stepDescription">
                            <!--<div>2016-12-12 12:32</div><-->
                        </div>
                    </template>
                </a-step>
                <a-step>
                    <template v-slot:title>
                        <span>选题审核</span>
                    </template>
                    <template v-slot:description>
                        <div class="antd-pro-pages-profile-advanced-style-stepDescription">教师审核选题</div>
                    </template>
                </a-step>
                <a-step title="提交过程资料" />
                <a-step title="完成" />
            </a-steps>
        </a-card>

        <br/>
        <a-card style="margin-top: 24px" :bordered="false" title="用户信息">
            <a-descriptions>
                <a-descriptions-item label="用户姓名">{{curUserName}}</a-descriptions-item>
                <a-descriptions-item label="用户Id">{{curUserId}}</a-descriptions-item>
                <a-descriptions-item label="学号">{{studentData.studentId}}</a-descriptions-item>
                <a-descriptions-item label="联系方式">{{curUserTel}}</a-descriptions-item>
            </a-descriptions>
            <a-descriptions title="选题信息">
                <a-descriptions-item
                    label="状态"
                >{{studentData.projectId==null?"未选择选题":projectData.state==1?"待审核":"已完成选择 "}}</a-descriptions-item>
                <a-descriptions-item></a-descriptions-item>
                <a-descriptions-item></a-descriptions-item>
                <a-descriptions-item label="选题名称">{{projectData.projectName}}</a-descriptions-item>
                <a-descriptions-item label="选题详情">{{projectData.projectDescribe}}</a-descriptions-item>
                <a-descriptions-item></a-descriptions-item>
                <a-descriptions-item label="指导教师">{{projectData.teacherId}}</a-descriptions-item>
                <!--<a-descriptions-item label="选题来源">2018-08-08</a-descriptions-item>-->
                <a-descriptions-item></a-descriptions-item>
            </a-descriptions>
            <!--
      <a-card type="inner" title="多层信息组">
        <a-descriptions title="组名称" size="small">
          <a-descriptions-item label="负责人">林东东</a-descriptions-item>
          <a-descriptions-item label="角色码">1234567</a-descriptions-item>
          <a-descriptions-item label="所属部门">XX公司-YY部</a-descriptions-item>
          <a-descriptions-item label="过期时间">2018-08-08</a-descriptions-item>
          <a-descriptions-item label="描述">这段描述很长很长很长很长很长很长很长很长很长很长很长很长很长很长...</a-descriptions-item>
        </a-descriptions>
        <a-divider style="margin: 16px 0" />
        <a-descriptions title="组名称" size="small" :col="1">
          <a-descriptions-item label="学名">	Citrullus lanatus (Thunb.) Matsum. et Nakai一年生蔓生藤本；茎、枝粗壮，具明显的棱。卷须较粗..</a-descriptions-item>
        </a-descriptions>
        <a-divider style="margin: 16px 0" />
        <a-descriptions title="组名称" size="small" :col="2">
          <a-descriptions-item label="负责人">付小小</a-descriptions-item>
          <a-descriptions-item label="角色码">1234567</a-descriptions-item>
        </a-descriptions>
      </a-card>
            -->
        </a-card>
    </div>
</template>

<script>
import {
    requestCurrentStudentData,
    requestStudentByUserId,
} from "@/api/student.js";
import { requestProjectById } from "@/api/project.js";

export default {
    name: "SHome",
    data() {
        return {
            curUserId: "",
            curUserName: "",
            curUserTel: "",
            currentStep: 0,
            studentData: [],
            projectData: [],
        };
    },
    created() {
        this.curUserId = this.$store.state.userInfo.userId;
        this.curUserName = this.$store.state.userInfo.userName;
        this.curUserTel = this.$store.state.userInfo.userTel;
        this.initData();
    },
    methods: {
        initData() {
            requestCurrentStudentData
                .then((result) => {
                    this.studentData = result.data.data;
                    if (result.projectId == null) {
                        this.step = 0;
                        this.projectData = null;
                    } else {
                        this.getProjectData();
                    }
                })
                .catch((err) => {});
        },
        getProjectData() {
            requestProjectById(this.studentData.projectId)
                .then((result) => {
                    this.projectData = result.data.data;
                    if (this.projectData.state == 1) {
                        this.step = 1;
                    } else if (this.projectData.state == 2) {
                        this.step = 2;
                    }
                })
                .catch((err) => {});
        },
    },
};
</script>

<style scoped></style>
