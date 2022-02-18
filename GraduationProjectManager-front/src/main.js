// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Antd from "ant-design-vue"
import store from "./store/store"
import "ant-design-vue/dist/antd.css"
import axios from 'axios'
import qs from 'qs'

axios.defaults.baseURL = "http://60.205.187.211:8082/"
axios.defaults.headers['Content-Type'] = "application/json"
axios.defaults.headers.common["token"] = store.state.token;  //在header中添加token
//添加请求拦截器
axios.interceptors.request.use(
    function (config) {
        //在请求之前做些什么
        //判断是否存在token,如果存在则将每个页面的header中添加token,
        if (store.state.token) {
            config.headers.common["satoken"] = store.state.token
        }
        return config;
    },
    function (error) {
        console.log("interceptorsError",error)
        router.push("/login");
        return Promise.reject(error);
    }
);
//添加响应拦截器
axios.interceptors.response.use(
    function (response) {
        //对响应数据做点什么
        if (response.data.code == 2001) {//为登录状态码
            store.commit("del_token");
            router.push("/login");
        }

        //如果用户角色权限错误
        if (response.data.code ==4001) {
            this.$message.error("用户无权限");
        }
        //如果token过期失效。。。。。。。

        return response;
    },
    function (error) {
        //对响应错误做点什么
        if (error.response) {
            switch (error.response.status) {
                case 401:
                    store.commit("delToken");
                    router.push("/login");
            }
        }
        return Promise.reject(error);
    }
);

Vue.prototype.$store=store
Vue.prototype.$axios = axios      //全局注册，使用方法为  this.$axios
Vue.prototype.$qs = qs     //同全局注册,qs为一个url参数转化的js库
Vue.config.productionTip = false
Vue.use(Antd)


//全局注册组件
//Vue.component('users',Users);
/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    store,
    components: {App},
    template: '<App/>'
})
