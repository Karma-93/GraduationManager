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
        </a-page-header>-->

        <!-- 面包屑 -->
        <a-breadcrumb>
            <a-breadcrumb-item>a</a-breadcrumb-item>
            <a-breadcrumb-item>b</a-breadcrumb-item>
            <a-breadcrumb-item>c</a-breadcrumb-item>
        </a-breadcrumb>

        <!-- 消息 -->
        <a-popover placement="bottomRight" class="bell" @click="test1">
            <template slot="content">
                <a-list size="small">
                    <a-list-item
                        :key="index"
                        v-for="(item, index) in sessionList_already"
                        @click="messageInfo(item)"
                    >
                        <a-list-item-meta>
                            <!-- :description="item.listName"-->
                            <a-avatar
                                slot="avatar"
                                size="large"
                                shape="square"
                                src="https://joeschmoe.io/api/v1/random"
                            />
                            <a slot="title">{{ item.listName }}</a>
                        </a-list-item-meta>
                        <div class="list-content">
                            <a-badge :count="item.unReadCount" />
                        </div>
                    </a-list-item>
                </a-list>
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
                <a-avatar style="backgroundColor:#87d068;marginRight:10px" icon="user" />用户名
            </div>
            <a-menu slot="overlay">
                <a-menu-item>
                    <a-icon type="user" />个人中心
                </a-menu-item>
                <a-menu-item>
                    <a-icon type="setting" />设置
                </a-menu-item>
                <a-menu-item @click="quit()">
                    <a-icon type="logout" />退出登录
                </a-menu-item>
            </a-menu>
        </a-dropdown>
    </a-layout-header>
</template>

<script>
import { logout } from "@/api/login.js";
import { getStudentByUserId } from "@/api/student.js";
import { getTeacherByUserId } from "@/api/teacher.js";
import { sessionListsAlready } from "@/api/message.js";
import NewMessage from "@/views/message/NewMessage";
export default {
    name: "Header",
    data() {
        return {
            userName: "",
            userData: [],
            sessionList_already: [],
        };
    },
    created() {
        this.userName = this.$store.state.userInfo.userName;
        //初始化用户信息s
        if (this.$store.state.userInfo.userRoles == 1) {
            this.getTeacherData();
        } else if (this.$store.state.userInfo.userRoles == 2) {
            this.getStudentData();
        }
        this.getSessionListAlready();
    },
    methods: {
        test1() {
            this.$router.push({ path: "/message" });
        },
        ccc() {
            console.log(this);
        },
        // 退出登陆
        quit() {
            logout();
            this.$store.commit("remove_user_info");
            this.$router.replace({ path: "/login" });
            this.$message.success("注销成功！");
        },
        //如果是学生
        getStudentData() {},
        //如果是教师
        getTeacherData() {},
        //获取已经存在的会话列表
        getSessionListAlready() {
            sessionListsAlready(this.curUserId)
                .then((res) => {
                    if (res.data.code == 1) {
                        this.sessionList_already = res.data.data;
                        console.log("sessionlist", this.sessionList_already);
                    } else {
                        return this.$message.error(
                            "message Error" + res.data.message
                        );
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        },

        messageInfo(record) {
            this.$dialog(
                NewMessage,
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
                        },
                    },
                },
                // modal props
                {
                    title: "聊天窗口",
                    width: 650,
                    centered: true,
                    maskClosable: false,
                }
            );
        },
    },
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
