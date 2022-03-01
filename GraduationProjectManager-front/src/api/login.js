import request from "@/utils/request";

const userApi = {
  Login: "/user/login",
  Logout: "",
};

export function login(parameter) {
  return request({
    url: userApi.Login,
    method: "post",
    data: parameter,
  });
}

export function logout() {
  return request({
    url: userApi.Logout,
    method: "get",
  });
}
