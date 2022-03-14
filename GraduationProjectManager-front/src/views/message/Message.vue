<template>
    <div class="main">
        <div class="main-up">{{ this.curUserName }}</div>
        <a-button @click="log()">log</a-button>
        <div class="main-down">
            <a-row type="flex">
                <a-col :flex="2">
            <div class="left">
                <div class="left_up">
                    <div class="label_title">已建立会话</div>
                    <!--遍历已经发起过会话的列表-->
                    <div
                        v-for="item in sessionList_already"
                        :class="curSessionId == item.id ? 'box_select' : 'box'"
                        :key="item.id"
                    >
                        <!--显示接受者的用户名-->
                        <div class="box_left" @click="startSession(item.id)">{{ item.listName }}</div>
                        <!--显示未读消息数量和删除聊天记录按钮-->
                        <div class="right_left">
                            <div class="right_left_count">{{ item.unReadCount }}</div>
                            <div class="right_left_del">
                                <i class="el-icon-close" @click="delSession(item.id)"></i>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="left_down">
                    <div class="label_title">可建立会话</div>
                    <div
                        v-for="item in sessionList_not"
                        :key="item.userId"
                        class="box"
                        @click="createSession(item.userId, item.userName)"
                    >
                        <div class="box_left">{{item.userName}}</div>
                    </div>
                </div>
            </div>
                </a-col>
                <a-col :flex="3">
            <div class="right">
                <div class="up" ref="element" id="msg_end">
                    <div
                        v-for="(item,i) in list"
                        :key="i"
                        :class="item.userId===curUserId ? 'msg_right':'msg_lefg'"
                    >
                        <div
                            class="msg_right_up"
                        >{{item.userId===curUserId ? curUserName:sessionList_already.find(element => element.id==curSessionId).listName}}</div>
                        <div
                            :class="item.userId === curUserId ? 'msg_right_down' : 'msg_left_down'"
                        >{{item.messageBody}}</div>
                    </div>
                </div>
                <div class="down">
                    <a-textarea
                        v-model="textarea"
                        placeholder="请输入内容，回车发送"
                        @pressEnter="sendMsg"
                        :auto-size="{ minRows: 3, maxRows: 5 }"
                    />
                    <!--
                    <el-input
                        type="textarea"
                        :rows="9"
                        placeholder="请输入内容，回车发送！"
                        @keyup.enter.native="sendMsg"
                        v-model="textarea"
                    ></el-input>
                    -->
                </div>
            </div>
                </a-col>
            </a-row>
        </div>
    </div>
</template>

<script>
import {
    messageList,
    sessionListsAlready,
    sessionListsNot,
    createSession,
    delSession,
    newWebSocket,
} from "@/api/message.js";

export default {
    name: "Message",
    data() {
        return {
            curUserId: "",
            curUserName: "",
            curSessionId: "",
            sessionList_already: [], //已经发起过会话的列表?
            sessionList_not: [],
            list: [], //存放消息数据
            textarea: "",
        };
    },
    created() {
        this.curUserId = this.$store.state.userInfo.userId;
        this.curUserName = this.$store.state.userInfo.userName;
        this.getSessionListAlready();
        this.getSessionListNot();
        this.startSession(99999999);
    },
    updated() {},
    destroyed: function () {
        this.websocketclose();
    },

    components: {},

    methods: {
        log() {
            console.log("sessionListAlready", this.sessionList_already);
            console.log("sessionListNot", this.sessionList_not);
            console.log("list", this.list);
        },
        //和后端建立链接，
        initWebSocket: function (userId, sessionId) {
            // WebSocket与普通的请求所用协议有所不同，ws等同于http，wss等同于https
            this.websock = newWebSocket(userId, sessionId);
            this.websock.onopen = this.websocketonopen;
            this.websock.onerror = this.websocketonerror;
            this.websock.onmessage = this.websocketonmessage;
            this.websock.onclose = this.websocketclose;
        },
        //链接成功后会调用此方法
        websocketonopen: function () {
            console.log("WebSocket连接成功");
        },
        //链接错误的回调方法
        websocketonerror: function (e) {
            console.log("WebSocket连接发生错误", e);
        },
        //当接收到后端发送的消息时的方法，e为传递的内容
        websocketonmessage: function (e) {
            let data = JSON.parse(e.data);
            if (data instanceof Array) {
                //如果是列表数据
                this.sessionList_already = data;
            } else {
                //消息数据，单条
                this.list.push(data);
            }
        },
        //当链接关闭时的方法
        websocketclose: function (e) {
            if (this.curUserId != null) {
                //当已登录
                //????????????????????
                if (this.curSessionId != null) {
                    this.initWebSocket(this.curUserId, this.curSessionId);
                } else {
                    this.initWebSocket(this.curUserId, 99999999);
                }
                console.log("connection closed", e);
                console.log(e);
            }
        },
        //消息发送
        sendMsg() {
            if (this.curSessionId == "") {
                return this.$message.error("请选择左边的对话框开始聊天!");
            }
            let data = {
                userId: this.curUserId,
                userName: this.curUserName,
                messageBody: this.textarea, //content
            };
            this.list.push(data);
            //主动发送消息
            this.websock.send(this.textarea);
            this.textarea = "";
        },

        //获取可以建立会话的列表,即还没有发起过聊天的用户
        getSessionListNot() {
            sessionListsNot(this.curUserId)
                .then((res) => {
                    //当请求成功
                    if (res.data.code == 1) {
                        this.sessionList_not = res.data.data;
                    } else {
                        //如果请求失败
                        return this.$message.error(
                            "message Error" + res.data.message
                        );
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        //获取已经存在的会话列表
        getSessionListAlready() {
            sessionListsAlready(this.curUserId)
                .then((res) => {
                    if (res.data.code == 1) {
                        this.sessionList_already = res.data.data;
                    } else {
                        return this.$message.error(
                            "message Error" + res.data.message
                        );
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        createSession(toUserId, toUserName) {
            createSession({
                toUserId,
                toUserName,
            })
                .then((res) => {
                    //请求错误
                    if (res.data.code != 1) {
                        return this.$message.error("错误" + res.data.message);
                    }
                    this.getSessionListNot();
                    this.getSessionListAlready();
                })
                .catch(function (error) {
                    console.log(error);
                });
        },

        //开始会话
        startSession(sessionId) {
            if (this.websock != undefined) {
                this.websock.close();
            }
            this.curSessionId = sessionId;
            this.initWebSocket(this.curUserId, sessionId);
            this.msgList(sessionId);
        },
        //删除会话
        delSession(sessionId) {
            delSession(sessionId)
                .then((res) => {
                    if (res.data.code != 1) {
                        return this.$message.error("错误:" + res.data.message);
                    }
                    this.getSessionListNot();
                    this.sessionListAlready();
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        // 获取消息数据
        msgList(sessionId) {
            messageList(sessionId)
                .then((res) => {
                    if (res.data.code == 1) {
                        this.list = res.data.data;
                        //从新获取列表
                        this.getSessionListAlready();
                    } else {
                        return this.$message.error(
                            "获取消息列表失败",
                            res.data.errDesc
                        );
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
    },
};
</script>

<style scoped>
.main {
    width: 980px;
    /* border: 1px #1890ff solid; */
    margin-top: 50px;
    height: 790px;
}
.main_up {
    width: 980px;
    height: 40px;
    /* border:1px red solid; */
}
.main_down {
    width: 981px;
    height: 750px;
    border: 1px #1890ff solid;
    display: flex;
    justify-self: space-between;
}
.left {
    width: 300px;
    height: 750px;
    border-right: 1px #1890ff solid;
}
.left_up {
    width: 300px;
    height: 450px;
    overflow-y: auto;
    /* border: 1px red solid; */
}
.label_title {
    width: 282px;
    height: 25px;
    background-color: #f8f8f8;
    font-weight: 600;
    padding: 8px;
}
.left_down {
    width: 300px;
    height: 300px;
    overflow-y: auto;
    /* border: 1px green solid; */
}
.right {
    width: 600px;
    height: 750px;
    /* border-right: 1px #1890ff solid; */
}
.box {
    width: 250px;
    height: 22px;
    padding: 10px 25px 10px 25px;
    display: flex;
    justify-self: flex-end;
    /* border: 1px red solid; */
}
.box:hover {
    background-color: gainsboro;
    cursor: pointer;
}
.box_select {
    width: 250px;
    height: 22px;
    padding: 10px 25px 10px 25px;
    display: flex;
    justify-self: flex-end;
    background-color: gainsboro;
}
.box_left {
    width: 230px;
    height: 22px;
}
.right_left {
    width: 50px;
    height: 22px;
    display: flex;
    justify-content: space-between;
    /* border: 1px red solid; */
}
.right_left_count {
    /* border: 1px blue solid; */
    padding-left: 10px;
    width: 20px;
}
.right_left_del {
    width: 20px;
    padding-left: 10px;
}
.up {
    width: 680px;
    height: 550px;
    overflow-y: scroll;
    overflow-x: hidden;
    /* padding-bottom: 40px; */
    border-bottom: 1px #1890ff solid;
}
.msg_left {
    width: 675px;
    /* padding-left: 5px; */
    margin-top: 5px;
    /* border: 1px #1890ff solid; */
}
.msg_left_up {
    height: 25px;
    margin-top: 5px;
}
.msg_left_down {
    height: 25px;
    /* border: 1px #1890ff solid; */
    padding-left: 10px;
}
.msg_right {
    width: 660px;
    /* padding-right: 20px; */
    margin-top: 5px;
    /* border: 1px #1890ff solid; */
    text-align: right;
}
.msg_right_up {
    height: 25px;
}
.msg_right_down {
    height: 25px;
    /* border: 1px #1890ff solid; */
    padding-right: 10px;
}
.down {
    width: 680px;
    height: 200px;
    /* border: 1px red solid; */
}
</style>
