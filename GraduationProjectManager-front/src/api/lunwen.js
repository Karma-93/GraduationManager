import request from "@/utils/request";

const lunwenApi = {
    Add: "/lunwen/add",
    GetById: "/lunwen/getById",
    GetByStudentId: "/lunwen/getByStudentId",
    Remove: "/lunwen/remove",
    Update: "/lunwen/update"
};

export function requestAddLunwen(parameter) {
    return request({
        url: lunwenApi.Add,
        method: "post",
        data: parameter
    });
}

export function reqeustUpdateLunwen(parameter) {
    return request({
        url: lunwenApi.Update,
        method: "post",
        data: parameter
    });
}