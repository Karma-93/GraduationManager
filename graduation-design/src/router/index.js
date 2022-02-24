import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

// 引入路由配置
import routes from '@/config/router.config.js'

const router = new VueRouter({
  mode: "history",
  routes
})

// 防止路由栈溢出
// hack router push callback
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location, onResolve, onReject) {
  if (onResolve || onReject) return originalPush.call(this, location, onResolve, onReject)
  return originalPush.call(this, location).catch(err => err)
}

export default router

