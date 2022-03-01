<template>
    <a-layout-header :style="{ background: '#fff' }">
        <!-- <a-page-header
            style="border: 1px solid rgb(235, 237, 240)"
            title="Title"
            sub-title="This is a subtitle"
            avatar="{}"
        >
            <template slot="extra">
                <a-button key="2">
                    Operation
                </a-button>
                <a-button
                    key="1"
                    title="注销"
                    shape="circle"
                    icon="logout"
                    type="danger"
                    @click="quit"
                >
                </a-button>
            </template>
        </a-page-header> -->

        <a-breadcrumb>
            <a-breadcrumb-item>面包屑</a-breadcrumb-item>
            <!-- <a-breadcrumb-item
                ><a href="">Application Center</a></a-breadcrumb-item
            >
            <a-breadcrumb-item
                ><a href="">Application List</a></a-breadcrumb-item
            >
            <a-breadcrumb-item>An Application</a-breadcrumb-item> -->
        </a-breadcrumb>

        <!-- 消息 -->
        <a-popover placement="bottomRight" class="bell">
            <template slot="content">
                <p>Content1</p>
                <p>Content2</p>
            </template>
            <template slot="title">
                <span>消息</span>
            </template>
            <div>
                <a-badge count="5">
                    <a-icon type="bell" style="fontSize: 18px" />
                </a-badge>
            </div>
        </a-popover>

        <!-- 右侧用户 -->
        <a-dropdown placement="bottomCenter">
            <div>
                <a-avatar
                    style="backgroundColor:#87d068;marginRight:10px"
                    icon="user"
                />用户名
            </div>
            <a-menu slot="overlay">
                <a-menu-item> <a-icon type="user" /> 个人中心 </a-menu-item>
                <a-menu-item> <a-icon type="setting" />设置 </a-menu-item>
                <a-menu-item> <a-icon type="logout" />退出登录 </a-menu-item>
            </a-menu>
        </a-dropdown>
    </a-layout-header>
</template>

<script>
export default {
    name: "Header",
    data() {
        return {
            userData: []
        };
    },

    // created: {
    //     if() {
    //         //判断角色
    //     }
    // },

    methods: {
        quit() {
            localStorage.clear(); //清空LocalStorage
            this.$store.commit("delToken");
            this.$router.push("login");
        },
        //如果是学生
        getStudentData() {},
        //如果是教师
        getTeacherData() {}
    }
};
</script>

<style scoped>
.ant-layout-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-left: 30px;
    padding-right: 50px;
}
.bell {
    margin-bottom: -10px;
    margin-left: auto;
    margin-right: 60px;
}
</style>
