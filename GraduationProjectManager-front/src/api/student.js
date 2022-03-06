import request from "@/utils/request";
const studentApi = {
    GetStudentByUserId: "/student/getStudentByUserId",
    GetStudentListByTeacherId: "/student/getStudentListByTeacherId"
};

export function getStudentByUserId() {
    return request({
        url: studentApi.GetStudentByUserId,
        method: "get",
    });
}