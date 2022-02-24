import request from '../utils/request.js';

const userApi = {
  Login: '/user/login',
  Logout: '/boss/passport/logout',
};

export function login(parameter) {
  return request({
    url: userApi.Login,
    method:'post',
    data:parameter
  })
}