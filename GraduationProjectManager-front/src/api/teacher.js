import request from "@/utils/request";
const teacherApi = {
    GetTeacherByTeacherId: "/teacher/getTeacherByTeacherId",
    GetTeacherByUserId: "/teacher/getTeacherByUserId",
    GetTeacherList: "/teacher/getTeacherList",
    GetAllTeacherList: "/teacher/getAllTeacherList",
    GetAllTeacherData: "/teacher/getAllTeacherData"
};

export function requestTeacherByTeacherId(param) {

    return request({
        url: teacherApi.GetTeacherByTeacherId,
        method: "get",
        params: { teacherId: param }
    });
}
export function requestTeacherByUserId(param) {
    return request({
        url: teacherApi.GetTeacherByUserId,
        method: "get",
        params: { userId: param }
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