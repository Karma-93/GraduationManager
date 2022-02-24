import axios from "axios";
import qs from 'qs'

const request = axios.create({
  baseURL:'http://60.205.187.211:8082',
  headers:{ "Content-Type":"application/json"},
  timeout: 6000,
});
// 异常拦截处理器
const errorHandler = (error) => {
  console.log("#############", error);
  if (error.response) {
    // const data = error.response.data;
    // 从 localstorage 获取 token
    // const token = storage.get(ACCESS_TOKEN);
  }
  return Promise.reject(error);
};

// request interceptor
request.interceptors.request.use((config) => {
  if (!config.headers["Content-Type"]) {
    config.headers["Content-Type"] = "application/x-www-form-urlencoded";
    config.data = qs.stringify(config.data);
  }
  // const token = storage.get(ACCESS_TOKEN);
  // // 如果 token 存在
  // // 让每个请求携带自定义 token 请根据实际情况自行修改
  // if (token) {
  //   config.headers["token"] = token;
  // }
  return config;
}, errorHandler);

// // response interceptor
// request.interceptors.response.use((response) => {
//   return new Promise((resolve, reject) => {
//     const data = response.data;
//     if (data.status === "1") {
//       return resolve(data.data);
//     } else {
//       switch (data.status) {
//         case "xxxx": // 自定义code
//           // eslint-disable-next-line prefer-promise-reject-errors
//           reject({
//             response: {
//               status: "xxxx",
//               msg: data.detail,
//             },
//           });
//           break;
//         default: {
//           notification.error({
//             message: "错误",
//             description: data.detail,
//           });
//           reject(data);
//         }
//       }
//     }
//   });
// }, errorHandler);

export default request;
