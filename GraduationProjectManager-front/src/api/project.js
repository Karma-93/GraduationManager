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
        url: messageApi.MessageList,
        method: "get",
        params: { projectId: param }
    });
}
export function requestProejctListByTeacherId() {
    return request({

    });
}