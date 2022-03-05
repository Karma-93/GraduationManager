<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>
export default {
    name: "App",
    data() {
        return {};
    },

    /** 
    //App组件创建时
    created() {
        // 页面刷新时将vuex里的信息保存到localStorage里
        window.addEventListener("beforeunload", () => {
            localStorage.setItem("store", JSON.stringify(this.$store.state));
            console.log("beforeunload"+this.$store.state);
        });
        // 页面刷新后将localStorage的数据取出来存入vuex
        window.addEventListener("load", () => {
            this.$store.commit("set_store", JSON.parse(localStorage.getItem("store")));
            console.log("load"+this.$store.state.userInfo);
            localStorage.removeItem("store");
        });
    },
    */

    created() {
        //解决刷新存储store中的名字失效
        //如果sessionStorage中存储了store
        if (sessionStorage.getItem("store")) {
            // replaceState 替换state根状态（参数为 对象）
            this.$store.replaceState(
                Object.assign(
                    {},
                    this.$store.state,
                    JSON.parse(sessionStorage.getItem("store"))
                )
            );
        }
        console.log(this.$store.state);
        //在页面刷新时将vuex里的信息保存到sessionStorage里
        window.addEventListener("beforeunload", () => {
            sessionStorage.setItem("store", JSON.stringify(this.$store.state));
        });
    },
    beforeRouteLeave(to, from, next) {
        const nextRouter = ["Login"]; //不需要登录即可访问的页面
        if (nextRouter.indexOf(to.name) < 0) {
            //当需要登录才能访问
            if (!store.state.login) {
                //当没有登录
                console.log("未登录");
                next("login");
            }
        }
        next();
    }
};
</script>

<style scoped>
h1 {
    color: red;
}
</style>
