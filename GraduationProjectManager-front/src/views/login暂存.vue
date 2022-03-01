<template> </template>

<script>
export default {
    handleSubmit(e) {
        e.preventDefault();

        this.form.validateFields((err, values) => {
            if (!err) {
                //当输入值不为空
                console.log("Received values of form: ", values);
                //发起请求
                this.$axios({
                    method: "post",
                    url: "/user/login",
                    data: {
                        account: values["account"],
                        password: values["password"]
                    }
                })
                    .then(response => {
                        console.log("RequestSucces", response.data);
                        if (response.data.code == 1) {
                            const userInfo = response.data.data;
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
                            this.$message.error(
                                "登陆失败:" + response.data.message
                            );
                        }
                    })
                    .catch(error => {
                        console.log("error", error);
                        this.$message.error("请求错误:" + error);
                    });
            }
        });
    },

    getDownList() {
        this.$axios({
            method: "post",
            url: "/down/selectAllPage",
            //qs.stringify() 将json对象转换为get参数方式传递
            //qs.parse() 将get参数转化为json对象
            /*data:this.$qs.stringify({
                    pageNum:0,
                    pageSize:5
                })*/
            data: { pageNum: 0, pageSize: 5 }
        }).then(response => {
            this.downData = response.data.data.data;
            //console.log(this.downData)
        });
    },

    getInformList() {
        this.$axios({
            method: "post",
            url: "/inform/selectAllPage",
            //qs.stringify() 将json对象转换为get参数方式传递
            //qs.parse() 将get参数转化为json对象
            /*data:this.$qs.stringify({
                    pageNum:0,
                    pageSize:5
                })*/
            data: { pageNum: 0, pageSize: 5 }
        }).then(response => {
            this.informData = response.data.data.data;
            //console.log(this.informData)
        });
    },

    //退出接口
    quit() {
        localStorage.clear(); //清空LocalStorage
        this.$store.commit("$_removeStorage");
        this.$router.push({
            name: "/login"
        });
    }
};
</script>

<style></style>
