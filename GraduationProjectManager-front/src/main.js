// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Antd from "ant-design-vue"
import store from "./store/store"
import "ant-design-vue/dist/antd.css"
// import axios from 'axios'
import qs from 'qs'

Vue.prototype.$store=store
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
