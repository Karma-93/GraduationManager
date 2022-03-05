//vuex
//vuex是一个状态管理模式，集中式管理所有组件(共享)的状态，
import Vue from "vue";
import Vuex from "vuex";
Vue.use(Vuex);

//state中的数据必须通过mutations修改
Vue.use(Vuex);

const SET_STORE = "set_store";
const SET_TOKEN = "set_token";
const CHANGE_USER_INFO = "change_user_info";
const REMOVE_USER_INFO = "remove_user_info";

export default new Vuex.Store({
    state: {},
    mutations: {
        [SET_STORE](state, payload) {
            state = payload;
        },


        [SET_TOKEN](state, payload) {
            state.token = payload;
        },
        [CHANGE_USER_INFO](state, payload) {
            state.userInfo = payload;
            state.login = true;
        },
        [REMOVE_USER_INFO](state) {
            state.userInfo = {};
            state.login = false;
        }
    },
    actions: {
        set_store(context) {
            context.commit(SET_STORE);
        }
    }
});