import request from "@/utils/request";

const userApi = {
    AddUser: "/user/add",
    GetUserById: "/user/getUserById",
    GetUserList: "/user/getUserList",
    UpdateUser: "/user/update"
};
export function requestUserById(param) {
    return request({
        url: userApi.GetUserById,
        method: "get",
        params: { userId: param }
    });
}
export function requestAddUser(parameter) {
    return request({
        url: userApi.AddUser,
        method: "post",
        data: parameter
    });
}

export function requestGetUserList(parameter) {
    return request({
        url: userApi.GetUserList,
        method: "post",
        data: parameter
    });
}
export function requestUpdateUser(parameter) {
    return request({
        url: userApi.UpdateUser,
        method: "post",
        data: parameter
    });
}