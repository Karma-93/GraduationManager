import request from "@/utils/request";

const userApi = {

    GetUserById: "/user/getUserById",
};
export function requestUserById(params) {
    return request({
        url: this.GetUserById,
        method: "get",
        params
    });
}