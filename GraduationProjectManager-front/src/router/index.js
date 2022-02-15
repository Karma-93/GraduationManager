import Vue from 'vue'
import Router from 'vue-router'
import App from "@/App"
import HomeTest from "@/views/HomeTest"
import Sindex from "../views/student/Sindex";
import LayoutTest from "../views/LayoutTest";
import SHome from "../views/student/SHome";
import SChoose from "../views/student/SChoose";
import SDownload from "../views/student/SDownload";
import SKtbg from "../views/student/SKtbg";
import SLibrary from "../views/student/SLibrary";
import SPaperdemo from "../views/student/SPaperdemo";
import SQzxj from "../views/student/SQzxj";
import SReplyInfo from "../views/student/SReplyInfo";
import SReplyScore from "../views/student/SReplyScore";
import Login from "../views/Login";
import Tindex from "../views/teacher/Tindex";
import Aindex from "../views/admin/Aindex";
import THome from "../views/teacher/THome";
import AHome from "../views/admin/AHome";
import store from "../store/store"

Vue.use(Router)



const router= new Router({
    routes: [
        {
            path: '/',
            redirect: "/hometest"
        },
        {
            path: '/hometest',
            name: 'HomeTest',
            component: HomeTest
        },
        {
            path: '/login',
            name: "Login",
            component: Login
        },
        {
            path: '/sindex',
            name: 'Sindex',
            component: Sindex,
            meta:{
                requireAuth:true    //true为这个页面需要登录
            },
            children: [
                {
                    path: '/',
                    name: 'SHome',
                    component: SHome
                }, {
                    path: 'schoose',
                    name: 'SChoose',
                    component: SChoose
                }, {
                    path: 'sdownlaod',
                    name: 'SDownload',
                    component: SDownload
                }, {
                    path: 'sktbg',
                    name: 'SKtbg',
                    component: SKtbg
                }, {
                    path: 'slibrary',
                    name: 'SLibrary',
                    component: SLibrary
                }, {
                    path: 'spaperdemo',
                    name: 'SPaperdemo',
                    component: SPaperdemo
                }, {
                    path: 'sqzxj',
                    name: "SQzxj",
                    component: SQzxj
                }, {
                    path: 'sreplyinfo',
                    name: 'SReplyInfo',
                    component: SReplyInfo
                }, {
                    path: 'sreplyscore',
                    name: 'SReplyScore',
                    component: SReplyScore
                }
            ]
        },
        {
            path: '/tindex',
            name: 'Tindex',
            component: Tindex,
            children: [
                {
                    path: '/',
                    name: 'THome',
                    component: THome
                },
            ]
        },

        {
            path: '/aindex',
            name: 'Aindex',
            component: Aindex,
            children: [
                {
                    path: '/',
                    name: 'AHome',
                    component: AHome
                },
            ]
        },
        {
            path: '/layouttest',
            name: "LayoutTest",
            component: LayoutTest
        }
    ]
})



//设置全局前置守卫路由，并判断是否取出token    即路由拦截，
//to即将进入的目标路由对象，form正要离开的路由，进行管道中的下一个钩子，要确保调用next方法
router.beforeEach((to, from, next) => {
    console.log("beforeEach")
    const nextRouter=['Login'];  //不需要登录即可访问的页面

    if (nextRouter.indexOf(to.name)<0){ //当需要登录才能访问
        if(!store.state.login){//当没有登录
            console.log("未登录");
            next("Login");
        }
    }
    //已经登录状态
    if (to.name === 'Login') {
        if (store.state.login) {
            const userRoles=store.state.userInfo.userRoles;
            if (userRoles==1){
                this.$router.push("/tindex")
            }else if(userRoles==2){
                this.$router.push("/sindex")
            }else if(userRoles==3){
                this.$router.push("/aindex")
            }
        }
    }


    if (to.matched.some(res => res.meta.requireAuth)) {
        console.log("requireAuth"+res.meta.requireAuth)
        //验证是否需要登录
        if (localStorage.getItem("userInfo")) {     //查询本地信息是否已经登录
            next();
        } else {
            next({
                path:"/login"   //为登录则跳转至登录页面
            })
        }
    }
})




export default router
