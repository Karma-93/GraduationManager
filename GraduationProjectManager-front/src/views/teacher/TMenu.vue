<template>
    <a-layout-sider
        :style="{
            overflow: 'auto',
            height: '100vh',
            position: 'fixed',
            left: 0
        }"
        width="{300px}"
    >
        <div
            class="logo"
            :style="{ textAlign: 'center' }"
            style="width: 300px"
        >
            <h1 style="color: white;">毕业设计管理系统</h1>
        </div>
        <a-menu
            theme="dark"
            style="width: 300px"
            :default-selected-keys="['1']"
            :open-keys.sync="openKeys"
            mode="inline"
            @click="handleClick"
        >
            <a-menu-item
                key="sub_home"
                @titleClick="titleClick"
                @click="menuClick('/tindex/')"
            >
                <a-icon type="home" />
                首页
            </a-menu-item>
            <a-menu-item
                key="sub_project"
                @titleClick="titleClick"
                @click="menuClick('/tindex/tproject')"
            >
                <a-icon type="edit" />
                课题申报
            </a-menu-item>
            <a-sub-menu
                key="sub_process"
                @titleClick="titleClick"
            >
                <span slot="title">
                    <a-icon type="appstore" /><span>流程管理</span>
                </span>
                <a-menu-item
                    key="sub_verifyproject"
                    @click="menuClick('/tindex/tverifyproject')"
                >
                    确认选题
                </a-menu-item>
                <a-menu-item
                    key="sub_processmanager"
                    @click="menuClick('/tindex/tprocessmanager')"
                >
                    流程管理
                </a-menu-item>
                <a-menu-item
                    key="sub_score"
                    @click="menuClick('/tindex/tscore')"
                >
                    成绩评定
                </a-menu-item>
            </a-sub-menu>
            <a-sub-menu
                key="sub_info"
                @titleClick="titleClick"
            >
                <span slot="title">
                    <a-icon type="appstore" /><span>查看信息</span>
                </span>
                <a-menu-item
                    key="sub_studentlist"
                    @click="menuClick('/tindex/tshowstudentlist')"
                >
                    查看学生信息
                </a-menu-item>

            </a-sub-menu>
            <a-menu-item
                key="sub_library"
                @titleClick="titleClick"
                @click="menuClick('/tindex/tlibrary')"
            >
                <a-icon type="home" />
                历史文库
            </a-menu-item>
            <a-menu-item
                key="sub_download"
                @titleClick="titleClick"
                @click="menuClick('/tindex/tdownload')"
            >
                <a-icon type="home" />
                资料文件下载
            </a-menu-item>
        </a-menu>
    </a-layout-sider>
</template>

<script>
export default {
    name: "TMenu",
    data() {
        return {
            current: ["mail"],
            openKeys: ["sub1"]
        };
    },
    watch: {
        openKeys(val) {
            // console.log("openKeys", val);
        }
    },
    methods: {
        handleClick(e) {
            // console.log("click", e);
        },
        titleClick(e) {
            // console.log("titleClick", e);
        },
        menuClick(route) {
            this.$router.push({ path: route });
        }
    }
};
</script>

<style scoped></style>
