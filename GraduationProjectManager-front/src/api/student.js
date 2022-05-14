import request from "@/utils/request";
const studentApi = {
    AddStudent:"/student/addstudent",
    UpdateStudent:"/student/update",
    RemoveStudent:"/student/delete",
    GetCurrentStudentData: "/student/getCurrentStudentData",
    GetStudentByUserId: "/student/getStudentByUserId",
    GetStudentListByTeacherId: "/student/getStudentListByTeacherId",
    GetStudentDataListByTeacherId: "/student/getStudentDataListByTeacherId",
    GetStudentList: "/student/getStudentList",
    GetClassName: "/student/getclassname",
    GetStudentNum: "/student/getstudentnum",
    GetNoProjectStudentNum: "/student/getnoprojectstudentnum",
    GetStudentPorcessList: "/student/getstudentprocesslist",
    GetNameByStudentId: "/student/getNamebystudentid"
};

export function requestAddStudent(param){
    return request({
        url:studentApi.AddStudent,
        method:"post",
        data:param
    })
}

export function requestUpdateStudent(param){
    return request({
        url:studentApi.UpdateStudent,
        method:"post",
        data:param
    })
}
export  function requestRemoveStudent(param){
    return request({
        url:studentApi.RemoveStudent,
        method:"get",
        params:{studentId:param}
    });
}

export function requestNameByStudentId(parameter) {
    return request({
        url: studentApi.GetNameByStudentId,
        method: "get",
        params: { studentId: parameter }
    });

}

export function requestStudentProcessList(param) {
    return request({
        url: studentApi.GetStudentPorcessList,
        method: "get",
        params: { teacherId: param }
    });
}

export function getStudentNum() {
    return request({
        url: studentApi.GetStudentNum,
        method: "get",
    });
}
export function getNoProjectStudentNum() {
    return request({
        url: studentApi.GetNoProjectStudentNum,
        method: "get",
    });
}

export function requestClassName(param) {
    return request({
        url: studentApi.GetClassName,
        method: "get",
        params: { userId: param }
    });
}

// 根据teacherId查询student Data
export function reqeustStudentDataListByTeacherId(param) {
    return request({
        url: studentApi.GetStudentDataListByTeacherId,
        method: "get",
        params: { teacherId: param }
    });
}

//分页查询所有学生数据
export function requestStudentList(parameter) {
    parameter.pageNum = parameter.pageNum - 1;
    return request({
        url: studentApi.GetStudentList,
        method: "post",
        data: parameter
    });
}

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
