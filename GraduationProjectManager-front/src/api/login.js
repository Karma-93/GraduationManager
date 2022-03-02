import request from "@/utils/request";

const loginApi = {
    Login: "/user/login",
    Logout: "",
    DownList: "/down/selectAllPage",
    AnnouncementList: "/inform/selectAllPage"
};

export function login(parameter) {
    return request({
        url: loginApi.Login,
        method: "post",
        data: parameter
    });
}

export function logout() {
    return request({
        url: loginApi.Logout,
        method: "get"
    });
}
export function requestDownList(parameter) {
    return request({
        url: loginApi.DownList,
        method: "post",
        data: parameter
    });
}
export function requestAnnouncementList(parameter) {
    return request({
        url: loginApi.AnnouncementList,
        method: "post",
        data: parameter
    });
}
