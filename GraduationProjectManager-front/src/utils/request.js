import axios from "axios";
import store from "@/store/store";
const request = axios.create({
    // baseURL: "http://localhost:8082/",
    baseURL: "http://124.223.184.251:8082/",
    headers: { "Content-Type": "application/json" },
    timeout: 6000
    // headers.common["token"] = store.state.token;
});

//添加请求拦截器s
request.interceptors.request.use(
    function(config) {
        //在请求之前做些什么
        //判断是否存在token,如果存在则将每个页面的header中添加token,
        if (store.state.token) {
            config.headers.common["satoken"] = store.state.token;
        } else {
            console.log("request.js-拦截器:toekn不存在");
            console.log(store.state.token);
        }
        return config;
    },
    function(error) {
        console.log("interceptorsError", error);
        //router.push("/login");
        return Promise.reject(error);
    }
);
//添加响应拦截器
request.interceptors.response.use(
    function(response) {
        //对响应数据做点什么
        if (response.data.code == 2001) {
            //为登录状态码
            store.commit("remove_user_info");
            //router.push("/login");
        }
        //如果用户角色权限错误
        if (response.data.code == 4001) {
            this.$message.error("用户无权限");
        }
        //如果token过期失效。。。。。。。
        return response;
    },
    function(error) {
        //对响应错误做点什么
        if (error.response) {
            switch (error.response.status) {
                case 401:
                    store.commit("remove_user_info");
                //router.push("/login");
            }
        }
        return Promise.reject(error);
    }
);

export default request;
