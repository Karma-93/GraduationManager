<template>
    <a-layout-sider :style="{ overflow: 'auto', height: '100vh', position: 'fixed', left: 0 }" width={300px}>
        <div class="logo" :style="{ textAlign: 'center'}" style="width: 300px">
            <h1 style="color: white;">毕业论文管理系统</h1>
        </div>
        <a-menu
            theme="dark"
            style="width: 300px"
            :default-selected-keys="['1']"
            :open-keys.sync="openKeys"
            mode="inline"
            @click="handleClick"
        >
            <a-menu-item key="sub_home" @titleClick="titleClick" @click="menuClick('/sindex/')" >
                <a-icon type="home" />首页
            </a-menu-item>
            <a-menu-item key="sub_choose" @titleClick="titleClick" @click="menuClick('/sindex/schoose')">
                <a-icon type="edit" />选择课题
            </a-menu-item>
            <a-sub-menu key="sub_process" @titleClick="titleClick">
                <span slot="title"><a-icon type="appstore" /><span>流程管理</span></span>
                <a-menu-item key="sub_ktbg" @click="menuClick('/sindex/sktbg')">
                    开题报告
                </a-menu-item>
                <a-menu-item key="sub_qzxj" @click="menuClick('/sindex/sqzxj')">
                    期中小结
                </a-menu-item>
                <a-menu-item key="sub_paperdemo" @click="menuClick('/sindex/spaperdemo')">
                    论文初稿
                </a-menu-item>
            </a-sub-menu>
            <a-sub-menu key="sub_info" @titleClick="titleClick">
                <span slot="title"><a-icon type="appstore" /><span>查看信息</span></span>
                <a-menu-item key="sub_reply_info" @click="menuClick('/sindex/sreplyinfo')">
                    答辩信息
                </a-menu-item>
                <a-menu-item key="sub_reply_score" @click="menuClick('/sindex/sreplyscore')">
                    查看成绩
                </a-menu-item>
            </a-sub-menu>
            <a-menu-item key="sub_library" @titleClick="titleClick" @click="menuClick('/sindex/slibrary')">
                <a-icon type="home" />历史文库
            </a-menu-item>
            <a-menu-item key="sub_download" @titleClick="titleClick" @click="menuClick('/sindex/sdownload')">
                <a-icon type="home" />资料文件下载
            </a-menu-item>
        </a-menu>
    </a-layout-sider>
</template>

<script>
export default {
    name: "StudentMenu",
    data() {
        return {
            current: ['mail'],
            openKeys: ['sub1'],
        };
    },
    watch: {
        openKeys(val) {
            console.log('openKeys', val);
        },
    },
    methods: {
        handleClick(e) {
            console.log('click', e);
        },
        titleClick(e) {
            console.log('titleClick', e);
        },
        menuClick(route){
            console.log('menuClick',route);
            this.$router.push(route);
        }
    },
}
</script>

<style scoped>

</style>
