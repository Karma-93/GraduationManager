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
    }
    // App组件创建时
    // created() {
    //     // 页面刷新时将vuex里的信息保存到localStorage里
    //     window.addEventListener("beforeunload", () => {
    //         localStorage.setItem("store", JSON.stringify(this.$store.state));
    //     });
    //     // 页面刷新后将localStorage的数据取出来存入vuex
    //     window.addEventListener("load", () => {
    //         this.$store.commit("set_state", localStorage.getItem("store"));
    //         localStorage.removeItem("store");
    //     });
    // }
};
</script>

<style scoped>
h1 {
    color: red;
}
</style>
