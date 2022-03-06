import request from "@/utils/request";
const teacherApi = {
    GetTeacherById: "/teacher/getTeacherById",
    GetTeacherByUserId: "/teacher/getTeacherByUserId",
    GetTeacherList: "/teacher/getTeacherList"
};

export function getTeacherByUserId() {
    return request({
        url: teacherApi.GetTeacherByUserId,
        method: "get",
    });
}