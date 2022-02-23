import NotFind from "@/views/404";
import Login from "@/views/Login";

const routes = [
  {
    path: "*",
    name: "NotFind",
    component: NotFind,
  },
  {
    path: "/",
    redirect: "/login",
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  //异步路由
  {
    path: "/student",
    name: "Student",
    component: () => import(/* webpackChunkName: "student" */ "@/views/Student")
  },
  {
    path: "/teacher",
    name: "Teacher",
    component: () => import(/* webpackChunkName: "teacher" */ "@/views/Teacher")
  },
];

export default routes;
