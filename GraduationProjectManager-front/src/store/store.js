//vuex
//vuex是一个状态管理模式，集中式管理所有组件(共享)的状态，
import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);
const state = {userInfo:{},//用户其他属性可在这里初始化
    login:false,//默认用户未登录
    token:"",
}

const mutations = {
    changeUserInfo(state,v){    //v为调用函数传递的参数
        state.userInfo=v;
    },
    setToken(state,value){
        //设置存储token
        state.token=value;
        localStorage.setItem("token",value)
    },
    removeStorage(state,value){
        //删除token
        localStorage.removeItem("token")
    }
}
const getters={     //监听数据变化的
    getStorage(state) {
        //获取本地存储的登录信息
        if (!state.token) {
            state.token=JSON.parse(localStorage.getItem("token"));
        }
        return state.token;
    }
}

const actions = { }

export default new Vuex.Store({
    state,
    mutations,
    actions,
    getters
})
