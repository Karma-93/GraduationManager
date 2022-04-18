import request from "@/utils/request";
const studentApi = {
    GetStudentByUserId: "/student/getStudentByUserId",
    GetStudentListByTeacherId: "/student/getStudentListByTeacherId",
    GetProjectList:"/project/getAll",
    GetCountProject:"/project/getcountproject",
    ChooseProject:"/project/updatestudentidbyproject",
    GetProjectByStudentId:"/project/getprojectbystudentid",
};

export function getStudentByUserId() {
    return request({
        url: studentApi.GetStudentByUserId,
        method: "get",
    });
}

export function getTeacherList(){

}
