import request from "@/utils/request";
const studentApi = {
    GetCurrentStudentData: "/student/getCurrentStudentData",
    GetStudentByUserId: "/student/getStudentByUserId",
    GetStudentListByTeacherId: "/student/getStudentListByTeacherId",
    GetProjectList: "/project/getAll",
    GetCountProject: "/project/getcountproject",
    ChooseProject: "/project/updatestudentidbyproject",
    GetProjectByStudentId: "/project/getprojectbystudentid",

};

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