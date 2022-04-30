import request from "@/utils/request";
const studentApi = {
    GetCurrentStudentData: "/student/getCurrentStudentData",
    GetStudentByUserId: "/student/getStudentByUserId",
    GetStudentListByTeacherId: "/student/getStudentListByTeacherId",
    GetStudentDataListByTeacherId: "/student/getStudentDataListByTeacherId",
    GetStudentList: "/student/getStudentList",
    GetClassName: "/student/getclassname"
};


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