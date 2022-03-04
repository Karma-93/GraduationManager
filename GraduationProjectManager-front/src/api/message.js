import request from "@/utils/request";
const messageApi = {
    MessageList: "/message/messageList",
    CreateSessionList: "/session/createSessionList",
    DelSessionList: "/session/delSessionList",
    SessionListsAlready: "/sessionListsAlready",
    SessionListsNot: "/session/sessionListsNot"
};

export function newWebSocket() {
    return new WebSocket(
        "ws://localhost:8082/websocket/" + userId + "/" + sessionId
    );
}

export function messageList(params) {
    return request({
        url: messageApi.MessageList,
        method: "get",
        params
    });
}

export function createSession(data) {
    return request({
        url: messageApi.CreateSessionList,
        method: "post",
        data
    });
}
export function delSession(params) {
    return request({
        url: messageApi.DelSessionList,
        method: "get",
        params
    });
}
export function sessionListsAlready() {
    return request({
        url: messageApi.SessionListsAlready,
        method: "get"
    });
}
export function sessionListsNot() {
    return request({
        url: messageApi.SessionListsNot,
        method: "get"
    });
}
