import request from "@/utils/request";

const projectApi = {
    GetAll: "/project/getAll", //分页查询所有选题
    GetCountNoChooseProject: "/project/getcountnochooseproject", //查询所有可以选择的课题数量
    GetCountProject: "/project/getcountproject",
    GetProjectListByTeacherId: "/project/getprojectlistbyteacherid",
    GetProjectById: "/project/getprojectbyid", //通过projectId获取project
    Insert: "/project/insert",
    ChooseProject: "/project/updatestudentidbyproject", //学生用户选择选题，
    ChangeNoSelect: "/project/updatenostudent", //更改选题为未被选择，
    UpdateProject: "/project/updatebyprimarykey", //更新选题信息
    GetVerifyChoose: "/project/verifychoose",
    GetVerifyProjectList: "/project/getverifyprojectlist",
    Delete: "/project/delete",
    GetProjectList: "/project/getprojectlist"
};


export function requestProjectList(patameter) {
    console.log("aaaaaaa", patameter);
    return request({
        url: projectApi.GetProjectList,
        method: "psot",
        data: patameter
    });
}

export function requestDelete(param) {
    return request({
        url: projectApi.Delete,
        method: "get",
        params: { projectId: param }
    });
}
export function requestVerifyPorjectList(param) {
    return request({
        url: projectApi.GetVerifyProjectList,
        method: "get",
        params: { teacherId: param }
    });
}



export function requestVerifyChoose(param) {
    return request({
        url: projectApi.GetVerifyChoose,
        method: "get",
        params: { projectId: param }
    });
}

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
export function requestCountNoChooseProject() {
    return request({
        url: projectApi.GetCountNoChooseProject,
        method: "get",
    })
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

export function reqeustChangeNoSelect(projectId) {
    return request({
        url: projectApi.ChangeNoSelect,
        mothod: "get",
        data: { projectId: projectId }
    });
}
export function requestChooseProject(projectId) {
    return request({
        url: projectApi.ChooseProject,
        mothod: "get",
        params: { projectId: projectId }
    });
}