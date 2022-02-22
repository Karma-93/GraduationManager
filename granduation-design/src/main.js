import Vue from "vue";
import App from "@/App.vue";
import 'less'

// 引入初始化样式
// 引入elementUI组件库
// import '@/config/ele.config.js'
import ElementUI from "element-ui";
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

// 路由配置
import router from '@/router'

Vue.config.productionTip = false;


new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");
