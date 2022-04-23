import request from "@/utils/request";

const paperlibApi = {
    Add: "/paperlib/insertpaper",
    GetAllPaperlibList: "/paperlib/getallpaperliblist",
    GetPaperlibList: "/paperlib/getpaperliblist" //分页查询
};

export function requestAddPaper(parameter) {
    return request({
        url: paperlibApi.Add,
        method: "post",
        data: parameter
    });
}

export function reqeustGetAllPaperlibList() {
    return request({
        url: paperlibApi.GetAllPaperlibList,
        method: "get",
    });
}