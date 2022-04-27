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

    //App组件创建时
    created() {
        console.log("APPstore", this.$store.state);
        // 页面刷新时将vuex里的信息保存到sessionStorage里
        window.addEventListener("beforeunload", () => {
            sessionStorage.setItem("store", JSON.stringify(this.$store.state));
        });
        // 页面刷新后将sessionStorage的数据取出来存入vuex
        window.addEventListener("load", () => {
            this.$store.commit(
                "set_store",
                JSON.parse(sessionStorage.getItem("store"))
            );
            sessionStorage.removeItem("store");
        });
    }

    // created() {
    //     //解决刷新存储store中的名字失效
    //     //如果sessionStorage中存储了store
    //     if (sessionStorage.getItem("store")) {
    //         // replaceState 替换state根状态（参数为 对象）
    //         this.$store.replaceState(
    //             Object.assign(
    //                 {},
    //                 this.$store.state,
    //                 JSON.parse(sessionStorage.getItem("store"))
    //             )
    //         );
    //     }
    //     console.log(this.$store.state);
    //     //在页面刷新时将vuex里的信息保存到sessionStorage里
    //     window.addEventListener("beforeunload", () => {
    //         sessionStorage.setItem("store", JSON.stringify(this.$store.state));
    //     });
    // }
};
</script>

<style scoped>
h1 {
    color: red;
}
</style>
