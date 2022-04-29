import Vue from "vue";
import Router from "vue-router";
import App from "@/App";
import HomeTest from "@/views/HomeTest";
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
import THome from "../views/teacher/THome";
import Aindex from "../views/admin/Aindex";
import AHome from "../views/admin/AHome";
import AUser from "../views/admin/AUser/index.vue";
import ATeacher from "../views/admin/ATeacher/index.vue";
import AStudent from "../views/admin/AStudent";
import AScore from "../views/admin/AScore";
import AProject from "../views/admin/AProject";
import store from "../store/store";
import TProject from "../views/teacher/TProject";
import TScore from "../views/teacher/TScore";
import TShowStudentList from "../views/teacher/TShowStudentList";
import TVerifyProject from "../views/teacher/TVerifyProject";
import TProcessManager from "../views/teacher/TProcessManager";
import TDownload from "../views/teacher/TDownload";
import TLibrary from "../views/teacher/TLibrary";

Vue.use(Router);
// 获取原型对象上的push函数
const originalPush = Router.prototype.push;
// 修改原型对象中的push方法
Router.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err);
};
const router = new Router({
    routes: [
        {
            path: "/",
            redirect: "/login"
        },
        {
            path: "/hometest",
            name: "HomeTest",
            component: HomeTest
        },
        {
            path: "/login",
            name: "Login",
            component: Login
        },
        {
            path: "/message",
            name: "message",
            component: () => import("@/views/message/Message")
        },
        {
            path: "/sindex",
            name: "Sindex",
            component: Sindex,
            meta: {
                requireAuth: true //true为这个页面需要登录
            },

            children: [
                {
                    path: "",
                    name: "SHome",
                    component: SHome
                },
                {
                    path: "schoose",
                    name: "SChoose",
                    component: SChoose
                },
                {
                    path: "sdownload",
                    name: "SDownload",
                    component: SDownload
                },
                {
                    path: "sktbg",
                    name: "SKtbg",
                    component: SKtbg
                },
                {
                    path: "slibrary",
                    name: "SLibrary",
                    component: SLibrary
                },
                {
                    path: "spaperdemo",
                    name: "SPaperdemo",
                    component: SPaperdemo
                },
                {
                    path: "sqzxj",
                    name: "SQzxj",
                    component: SQzxj
                },
                {
                    path: "sreplyinfo",
                    name: "SReplyInfo",
                    component: SReplyInfo
                },
                {
                    path: "sreplyscore",
                    name: "SReplyScore",
                    component: SReplyScore
                }
            ]
        },
        {
            path: "/tindex",
            name: "Tindex",
            component: Tindex,
            children: [
                {
                    path: "",
                    name: "THome",
                    component: THome
                },
                {
                    path: "tlibrary",
                    name: "TLibrary",
                    component: TLibrary
                },
                {
                    path: "tproject",
                    name: "TProject",
                    component: TProject
                },
                {
                    path: "tscore",
                    name: "TScore",
                    component: TScore
                },
                {
                    path: "tshowstudentlist",
                    name: "TShowStudentList",
                    component: TShowStudentList
                },
                {
                    path: "tverifyproject",
                    name: "TVerifyProject",
                    component: TVerifyProject
                },
                {
                    path: "tprocessmanager",
                    name: "TProcessManager",
                    component: TProcessManager
                },
                {
                    path: "tdownload",
                    name: "TDownload",
                    component: TDownload
                }
            ]
        },

        {
            path: "/aindex",
            name: "Aindex",
            component: Aindex,
            children: [
                {
                    path: "",
                    name: "AHome",
                    component: AHome
                },
                {
                    path: "ausermanager",
                    name: "AUser",
                    component: AUser
                },
                {
                    path: "ateachermanager",
                    name: "ATeacher",
                    component: ATeacher
                },
                {
                    path: "astudentmanager",
                    name: "AStudent",
                    component: AStudent
                },
                {
                    path: "ascoremanager",
                    name: "AScore",
                    component: AScore
                },
                {
                    path: "aprojectmanager",
                    name: "AProject",
                    component: AProject
                }
            ]
        },
        {
            path: "/layouttest",
            name: "LayoutTest",
            component: LayoutTest
        }
    ],
    mode: "history"
});

//设置全局前置守卫路由，并判断是否取出token    即路由拦截，
//to即将进入的目标路由对象，form正要离开的路由，进行管道中的下一个钩子，要确保调用next方法
router.beforeEach((to, from, next) => {
    const nextRouter = ["Login"]; //不需要登录即可访问的页面
    if (nextRouter.indexOf(to.name) < 0) {
        //当需要登录才能访问
        if (store.state.login != true) {
            let loginStatus = JSON.parse(sessionStorage.getItem("store"));
            if (loginStatus.login != true) {
                next("login");
                //当没有登录
                console.log("未登录");
            }
        }
    }
    //已经登录状态
    // if (to.name === "Login") {
    //     if (store.state.login) {
    //         const userRoles = store.state.userInfo.userRoles;
    //         if (userRoles == 1) {
    //             next("Tindex");
    //         } else if (userRoles == 2) {
    //             next("Sindex");
    //         } else if (userRoles == 3) {
    //             next("Aindex");
    //         }
    //     }
    // }
    next();

    /*

    if (to.matched.some(res => res.meta.requireAuth)) {
        console.log("requireAuth"+res.meta.requireAuth)
        //验证是否需要登录
        if (sessionStorage.getItem("userInfo")) {     //查询本地信息是否已经登录
            next();
        } else {
            next({
                path:"/login"   //为登录则跳转至登录页面
            })
        }
    }

     */
});

export default router;
