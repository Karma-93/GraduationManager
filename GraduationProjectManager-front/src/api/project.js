import request from "@/utils/request";

const projectApi = {
    GetAll: "/project/getAll", //分页查询所有选题
    GetCountProject: "/user/getcountproject", //查询所有可以选择的课题数量
    GetProjectListByTeacherId: "/project/getprojectlistbyteacherid",
    GetProjectById: "/project/getprojectbyid", //通过projectId获取project
    Insert: "/project/insert",
    ChooseProject: "/project/updatestudentidbyproject", //学生用户选择选题，
    ChangeNoSelect: "/project/updatenostudent", //更改选题为未被选择，
    UpdateProject: "/project/updatebyprimarykey" //更新选题信息

};


export function requestProjectById(param) {
    return request({
        url: projectApi.GetProjectById,
        method: "get",
        params: { projectId: param }
    });
}
export function requestProejctListByTeacherId(param) {
    return request({
        url: projectApi.GetProjectListByTeacherId,
        method: "get",
        params: { teacherId: param }
    });
}

export function requestCountProject() {
    return request({
        url: projectApi.GetCountProject,
        method: "get",
    });
}
export function requestInsert(parameter) {
    return request({
        url: projectApi.Insert,
        method: "post",
        data: parameter
    });
}

export function requestUpdateProject(parameter) {
    return request({
        url: projectApi.UpdateProject,
        method: "post",
        data: parameter
    });
}

export function reqeustChangeNoSelect() {
    return request({

    });
}
export function requestChooseProject() {
    return request({

    });
}