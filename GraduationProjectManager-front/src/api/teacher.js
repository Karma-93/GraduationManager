import request from "@/utils/request";
const teacherApi = {
    GetTeacherByTeacherId: "/teacher/getTeacherByTeacherId",
    GetTeacherByUserId: "/teacher/getTeacherByUserId",
    GetTeacherList: "/teacher/getTeacherList",
    GetAllTeacherList: "/teacher/getAllTeacherList",
    GetAllTeacherData: "/teacher/getAllTeacherData"
};

export function requestTeacherByTeacherId(params) {

    return request({
        url: teacherApi.GetTeacherByTeacherId,
        method: "get",
        params
    });
}
export function requestTeacherByUserId(params) {
    return request({
        url: teacherApi.GetTeacherByUserId,
        method: "get",
        params
    });
}
export function requestAllTeacherList() {
    return request({
        url: teacherApi.GetAllTeacherList,
        method: "get",
    });
}
export function requestAllTeacherData() {
    return request({
        url: teacherApi.GetAllTeacherData,
        method: "get",
    });
}