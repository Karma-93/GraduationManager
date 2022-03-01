<template>
    <a-layout>
        <a-layout-header style="padding: 0 80px"
            ><h2 style="color: white">
                毕业论文(设计)管理系统
            </h2></a-layout-header
        >
        <a-layout-content style="padding: 0 80px">
            <div :style="{ padding: '32px 0px', minHeight: '280px' }">
                <div
                    class="login-div"
                    v-bind:style="{ backgroundImage: 'url(' + bg + ')' }"
                >
                    <a-form
                        class="login-form"
                        id="components-form-demo-normal-login"
                        :form="form"
                        @submit="handleSubmit"
                    >
                        <a-form-item>
                            <a-input
                                v-decorator="[
                                    'account',
                                    {
                                        rules: [
                                            {
                                                required: true,
                                                message: '请输入你的账户!'
                                            }
                                        ]
                                    }
                                ]"
                                placeholder="输入账号"
                            >
                                <a-icon
                                    slot="prefix"
                                    type="user"
                                    style="color: rgba(0,0,0,.25)"
                                />
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input
                                v-decorator="[
                                    'password',
                                    {
                                        rules: [
                                            {
                                                required: true,
                                                message: '请输入你的密码!'
                                            }
                                        ]
                                    }
                                ]"
                                type="password"
                                placeholder="输入密码"
                            >
                                <a-icon
                                    slot="prefix"
                                    type="lock"
                                    style="color: rgba(0,0,0,.25)"
                                />
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-checkbox
                                v-decorator="[
                                    'remember',
                                    {
                                        valuePropName: 'checked',
                                        initialValue: true
                                    }
                                ]"
                            >
                                记住我
                            </a-checkbox>
                            <a class="login-form-forgot" href="">
                                忘记密码
                            </a>
                            <a-button
                                type="primary"
                                html-type="submit"
                                class="login-form-button"
                            >
                                登录
                            </a-button>
                        </a-form-item>
                    </a-form>
                </div>
                <div style="margin-top:32px">
                    <a-row type="flex">
                        <a-col
                            :flex="3"
                            :style="{
                                marginRight: '32px',
                                borderRadius: '5px'
                            }"
                        >
                            <a-list
                                bordered
                                :data-source="informData"
                                class="a-list"
                            >
                                <a-list-item
                                    slot="renderItem"
                                    slot-scope="item, index"
                                >
                                    {{ item.informTitle }}
                                </a-list-item>
                                <div slot="header">
                                    <h3>通知公告</h3>
                                </div>
                                <div slot="footer">
                                    加载更多
                                </div>
                            </a-list>
                        </a-col>
                        <a-col :flex="2" :style="{ borderRadius: '5px' }"
                            ><!--横向比例布局-->
                            <a-list
                                bordered
                                :data-source="downData"
                                class="a-list"
                            >
                                <a-list-item
                                    slot="renderItem"
                                    slot-scope="item, index"
                                >
                                    {{ item.downTitle }}
                                </a-list-item>
                                <div slot="header">
                                    <h3>文件下载</h3>
                                </div>
                                <div slot="footer">
                                    加载更多
                                </div>
                            </a-list>
                        </a-col>
                    </a-row>
                </div>
            </div>
        </a-layout-content>
        <a-layout-footer :style="{ textAlign: 'center' }">
            <p>
                由
                <a href="https://github.com/Alone-93" title="CX" target="_blank"
                    >CX</a
                >提供技术支持
            </p>
            <p>copyright &copy; 2018-2028, All Rights Reserved.</p>
        </a-layout-footer>
    </a-layout>
</template>

<script>
import { login } from "@/api/login.js";
export default {
    name: "Login",
    data() {
        return {
            bg: require("@/assets/image1.jpg"),
            downData: [],
            informData: []
        };
    },

    beforeCreate() {
        this.form = this.$form.createForm(this, { name: "login" });
    },
    created() {
        this.getDownList();
        this.getInformList();
    },
    methods: {
        /**
         * @description 处理登陆函数
         * @author cuiruichen
         * @date DATE_TIME
         * @export
         * @param
         * @returns
         */
        handleSubmit(e) {
            e.preventDefault();
            this.form.validateFields((err, values) => {
                if (!err) {
                    //当输入值不为空
                    console.log("Received values of form: ", values);
                    //发起请求
                    login({
                        account: values["account"],
                        password: values["password"]
                    }).then(res => {
                        // 请求成功
                        console.log(res);
                        if (res.data.code == 1) {
                            const userInfo = res.data.data;
                            console.log("userInfo", userInfo.satoken);
                            this.$store.commit("setToken", userInfo.satoken);
                            this.$store.commit(
                                "changeUserInfo",
                                JSON.stringify(userInfo)
                            ); //通过commit调用mutaions中的方法 传递值
                            this.$message.success("登录成功");
                            if (userInfo.userRoles == 1) {
                                //判断用户角色来跳转不同的主页
                                this.$router.push("/tindex");
                            } else if (userInfo.userRoles == 2) {
                                this.$router.push("/sindex");
                            } else if (userInfo.userRoles == 3) {
                                this.$router.push("/aindex");
                            }
                        } else {
                            this.$message.error("登陆失败:" + res.data.message);
                        }
                    });
                }
            });
        },

        /**
         * @description
         * @author cuiruichen
         * @date DATE_TIME
         * @export
         * @param
         * @returns
         */
        getDownList() {},
        getInformList() {},
        quit() {}
    }
};
</script>

<style scoped>
.login-div {
    width: 100%;
    display: flex;
    justify-content: flex-end;
    padding: 30px;
    border-radius: 5px;
}

.login-form {
    width: 320px;
    border-radius: 5px;
    padding: 30px 8px 8px 8px;
    background: hsla(0, 0%, 100%, 0.6);
}

#components-form-demo-normal-login .login-form-forgot {
    float: right;
}

#components-form-demo-normal-login .login-form-button {
    width: 100%;
}

.a-list {
    background-color: white;
    border-style: none;
    border-radius: 5px;
}
</style>
