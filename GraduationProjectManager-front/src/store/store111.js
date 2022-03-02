//vuex
//vuex是一个状态管理模式，集中式管理所有组件(共享)的状态，
import Vue from "vue";
import Vuex from "vuex";
Vue.use(Vuex);

//state中的数据必须通过mutations修改
const state = {
    userInfo: JSON.parse(localStorage.getItem("userInfo")) || {}, //用户其他属性可在这里初始化
    login: localStorage.getItem("token") || false, //默认用户未登录
    token: localStorage.getItem("token") || ""
};

const mutations = {
    changeUserInfo(state, v) {
        //v为调用函数传递的参数
        state.userInfo = v;
        localStorage.setItem("userInfo", JSON.stringify(v)); //把登录成功后返回的用户信息存入LocalStorage
    },
    setToken(state, value) {
        //设置存储token
        state.token = value;
        localStorage.setItem("token", value);
        state.login = true;
    },
    delToken(state, value) {
        //删除token
        localStorage.removeItem("token");
        state.login = false;
    }
};
const getters = {
    //监听数据变化的
    getStorage(state) {
        //获取本地存储的登录信息
        if (!state.token) {
            state.token = JSON.parse(localStorage.getItem("token"));
            state.login = true;
        }
        return state.token;
    }
};

const actions = {};

export default new Vuex.Store({
    state,
    mutations,
    actions,
    getters
});
