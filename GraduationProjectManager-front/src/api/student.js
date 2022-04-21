import request from "@/utils/request";
const studentApi = {
    getCurrentStudentData: "/student/getCurrentStudentData",
    GetStudentByUserId: "/student/getStudentByUserId",
    GetStudentListByTeacherId: "/student/getStudentListByTeacherId",
    GetProjectList: "/project/getAll",
    GetCountProject: "/project/getcountproject",
    ChooseProject: "/project/updatestudentidbyproject",
    GetProjectByStudentId: "/project/getprojectbystudentid",

};

export function requestStudentByUserId(params) {
    return request({
        url: studentApi.GetStudentByUserId,
        method: "get",
        params
    });
}
export function requestCurrentStudentData() {
    return request({
        url: studentApi.getCurrentStudentData,
        method: "get",
    });
}