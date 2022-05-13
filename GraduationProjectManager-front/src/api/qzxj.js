import request from "@/utils/request";

const qzxjApi = {
    Add: "/qzxj/add",
    GetById: "/qzxj/getbyid",
    GetByStudentId: "/qzxj/getbystudentid",
    Update: "/qzxj/update",
    Remove: "/qzxj/remove"
}

export function reqeustGetQzxjById(param) {
    return ({
        url: qzxjApi.GetById,
        method: "get",
        params: { id: param }
    })
}

export function requestAddQzxj(parameter) {
    return ({
        url: qzxjApi.Add,
        method: "post",
        data: parameter
    });
}
export function requestGetQzxjByStudentId(param) {
    return ({
        url: qzxjApi.GetByStudentId,
        method: "get",
        params: { studentId: param }
    });
}

export function requestUpdateQzxj(parameter) {
    return request({
        url: qzxjApi.Update,
        method: "post",
        data: parameter
    });
}
export function requestRemoveQzxj(param) {
    return request({
        url: qzxjApi.Remove,
        method: "get",
        params: { id: param }
    });
}