<template>
  <div class="login">
    <el-form>
      <h1>欢迎使用</h1>
      <el-form-item label="账号">
        <el-input v-model="account" placeholder="请输入账号"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input placeholder="请输入密码" v-model="password" show-password></el-input>
      </el-form-item>
      <el-form-item>
        <el-button style="width: 100%" type="primary" @click="handleLogin"
          >登陆</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { login } from "@/api/login"
export default {
  data() {
    return {
      account: "学生1",
      password: "123456",
    };
  },
  methods: {
    // 处理登陆
    handleLogin() {
      login({
        account: this.account,
        password: this.password
      }).then(res => {
        if(res.status == 200 && res.data.code == 1){
          this.$message.success("登陆成功！");
          if(res.data.data.userRoles == 1){
            this.$router.push({path: "/teacher"})
          }else if(res.data.data.userRoles == 2){
            this.$router.push({path: "/student"})
          }
        }else{
          this.$message.error(res.data.message);
        }
      })
    },
  },
};
</script>

<style lang="less">
.login {
  position: relative;
  height: 100vh;
  background-color: #ffffff;
  .el-form {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -70%);
    width: 450px;
    padding: 20px 50px;
    border: 1px solid #409eff;
    border-radius: 5px;
    h1 {
      margin-bottom: 10px;
      text-align: center;
      font-size: 35px;
      color: #409eff;
    }
    button {
      margin-top: 20px;
    }
  }
}
</style>
