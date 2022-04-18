import request from "@/utils/request";
const teacherApi = {
    GetTeacherById: "/teacher/getTeacherById",
    GetTeacherByUserId: "/teacher/getTeacherByUserId",
    GetTeacherList: "/teacher/getTeacherList",
    GetAllTeacherList:"/teacher/getAllTeacherList"
};

export function requestTeacherByUserId() {
    return request({
        url: teacherApi.GetTeacherByUserId,
        method: "get",
    });
}
export function requestAllTeacherList(){
    return request({
        url:teacherApi.GetAllTeacherList,
        method:"get",
    });
}
