import request from "@/utils/request";
const messageApi = {
    MessageList: "/message/messageList",
    CreateSessionList: "/session/createSessionList",
    DelSessionList: "/session/delSessionList",
    SessionListsAlready: "/session/sessionListsAlready",
    SessionListsNot: "/session/sessionListsNot"
};

export function newWebSocket(userId, sessionId) {
    return new WebSocket(
        "ws://localhost:8082/websocket/" + userId + "/" + sessionId
        //"ws://124.223.184.251:8082/websocket/" + userId + "/" + sessionId
    );
}

export function messageList(param) {
    return request({
        url: messageApi.MessageList,
        method: "get",
        params: { sessionListId: param }
    });
}

export function createSession(parameter) {
    return request({
        url: messageApi.CreateSessionList,
        method: "get",
        params: parameter
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