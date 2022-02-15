<template>
    <div class="login-container">
        <h2 class="login-title">Vue+AntDesign实现登陆页面</h2>
        <a-form ref="form" :model="form" class="login-form">
            <h2 class="title">用户登录 LOGIN</h2>
            <a-form-item>
                <a-input class="inputBox" v-model="form.username">
                    <img :src="user" slot="prefix" alt="">
                </a-input>
            </a-form-item>
            <a-form-item>
                <a-input-password class="inputBox" v-model="form.password">
                    <img :src="mima" slot="prefix" alt="">
                </a-input-password>
            </a-form-item>

            <a-form-item>
                <a-button class="submit" type="primary" @click="onSubmit">登录</a-button>
            </a-form-item>
        </a-form>
    </div>
</template>

<script>
import user from "../assets/image1.jpg"
import mima from "../assets/image1.jpg"
export default {
    data() {
        return {
            user:user,
            mima:mima,
            form: {
                username: "admin",
                password: "123456"
            }
        }
    },
    methods: {
        onSubmit()  {
            console.log('登陆成功！')
        },
    },
}
</script>
<style>
.login-form {
    width: 565px;
    height: 372px;
    margin: 0 auto;
    background: url("../assets/image1.jpg");
    padding: 40px 110px;
}

/* 背景 */
.login-container {
    position: absolute;
    width: 100%;
    height: 100%;
    background: url("../assets/image1.jpg");
}

/* Log */
.login-title {
    color: #fff;
    text-align: center;
    margin: 150px 0;
    font-size: 48px;
    font-family: Microsoft Yahei;
}
/* 登陆按钮 */
.submit{
    width: 100%;
    height: 45px;
    font-size: 16px;
}
/* 用户登陆标题 */
.title{
    margin-bottom: 50px;
    color: #fff;
    font-weight: 700;
    font-size: 24px;
    font-family: Microsoft Yahei;
}
/* 输入框 */
.inputBox{
    height: 45px;
}
/* 输入框内左边距50px */
.ant-input-affix-wrapper .ant-input:not(:first-child) {
    padding-left: 50px;
}
</style>
