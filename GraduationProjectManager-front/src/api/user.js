import request from "@/utils/request";

const userApi = {
    AddUser: "/user/add",
    GetUserById: "/user/getUserById",
    GetUserList: "/user/getUserList",
    UpdateUser: "/user/update",
    RemoveUser:"/user/remove"
};
export  function requestRemoveUser(param){
    return request({
        url:userApi.RemoveUser,
        method:"get",
        params:{userId:param}
    })
}
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

export function requestGetUserList(data) {
    data.pageNum = data.pageNum - 1;
    console.log("page", data);
    return request({
        url: userApi.GetUserList,
        method: "post",
        data
    });
}
export function requestUpdateUser(parameter) {
    return request({
        url: userApi.UpdateUser,
        method: "post",
        data: parameter
    });
}
