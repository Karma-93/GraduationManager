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
        <div class="logo" :style="{ textAlign: 'center' }" style="width: 300px">
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
            <a-menu-item
                key="sub_home"
                @titleClick="titleClick"
                @click="menuClick('/aindex/')"
            >
                <a-icon type="home" />首页
            </a-menu-item>
            <a-menu-item
                key="sub_usermanager"
                @titleClick="titleClick"
                @click="menuClick('/aindex/ausermanager')"
            >
                <a-icon type="edit" />用户管理
            </a-menu-item>
            <a-menu-item
                key="sub_teachermanager"
                @titleClick="titleClick"
                @click="menuClick('/aindex/ateachermanager')"
            >
                <a-icon type="home" /> 教师管理
            </a-menu-item>
            <a-menu-item
                key="sub_projectmanager"
                @titleClick="titleClick"
                @click="menuClick('/aindex/aprojectmanager')"
            >
                <a-icon type="home" />选题管理
            </a-menu-item>
            <a-menu-item
                key="sub_scoremanager"
                @titleClick="titleClick"
                @click="menuClick('/aindex/ascoremanager')"
            >
                <a-icon type="home" />成绩管理
            </a-menu-item>
        </a-menu>
    </a-layout-sider>
</template>

<script>
export default {
    name: "AdminMenu",
    data() {
        return { 
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
