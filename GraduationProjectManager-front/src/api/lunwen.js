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

export function requestLunwenById(param) {
    return request({
        url: lunwenApi.GetById,
        method: "get",
        params: { id: param }
    });
}

export function requestLunwenByStudetnId(param) {
    return request({
        url: lunwenApi.GetByStudentId,
        method: "get",
        params: { studentId: param }
    });
}

export function requestLunwenRemove(param) {
    return request({
        url: lunwenApi.Remove,
        method: "get",
        params: { id: param }
    });
}