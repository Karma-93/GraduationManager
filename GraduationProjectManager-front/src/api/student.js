import request from "@/utils/request";
const studentApi = {
    GetCurrentStudentData: "/student/getCurrentStudentData",
    GetStudentByUserId: "/student/getStudentByUserId",
    GetStudentListByTeacherId: "/student/getStudentListByTeacherId"

};
export function reqeustStudentListByTeacherId(param) {
    return request({
        url: studentApi.GetStudentListByTeacherId,
        method: "get",
        params: { teacherId: param }
    });
}

export function requestStudentByUserId(param) {
    return request({
        url: studentApi.GetStudentByUserId,
        method: "get",
        params: { userId: param }
    });
}
export function requestCurrentStudentData() {
    return request({
        url: studentApi.GetCurrentStudentData,
        method: "get",
    });
}