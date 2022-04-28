<template>
    <div>
        <!--<a-button @click="log()">日志</a-button>-->
        <h1>{{this.sessionListName}}</h1>

        <div class="up" ref="element" id="msg_end">
            <div
                v-for="(item,i) in list"
                :key="i"
                :class="item.userId===curUserId ? 'msg_right':'msg_lefg'"
            >
                <div
                    class="msg_right_up"
                >
                {{item.userId===curUserId ? curUserName:sessionListName}}</div>
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
</template>

<script>
import { messageList, newWebSocket } from "@/api/message.js";

export default {
    name: "NewMessage",
    props: {
        record: {
            type: Object,
            default: null,
        },
    },
    created() {
        this.curUserId = this.$store.state.userInfo.userId;
        this.curUserName = this.$store.state.userInfo.userName;
        this.curSessionId = this.record.id;
        this.sessionListName = this.record.listName;
        //this.getSessionListAlready();
        //this.getSessionListNot();
        this.startSession(this.record.id);
    },
    data() {
        return {
            curUserId: "",
            curUserName: "",
            curSessionId: "",
            sessionListName: "",

            sessionList_already: [], //已经发起过会话的列表?
            sessionList_not: [],
            list: [], //存放消息数据
            textarea: "",
        };
    },
    methods: {
        log() {
            console.log("curUserId", this.curUserId);
            console.log("curSessionId", this.curSessionId);
            console.log("list", this.list);
            console.log("record", this.record);
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
        // 获取消息数据
        msgList(sessionId) {
            messageList(sessionId)
                .then((res) => {
                    if (res.data.code == 1) {
                        this.list = res.data.data;
                        //从新获取列表
                        //this.getSessionListAlready();
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

        //开始会话
        startSession(sessionId) {
            if (this.websock != undefined) {
                this.websock.close();
            }
            this.curSessionId = sessionId;
            this.initWebSocket(this.curUserId, sessionId);
            this.msgList(sessionId);
        },
    },
    destroyed: function () {
        this.websocketclose();
    },
};
</script>

<style scoped>
.up {
    width: 600px;
    height: 550px;
    overflow-y: scroll;
    overflow-x: hidden;
    /* padding-bottom: 40px; */
    border-bottom: 1px #1890ff solid;
}

.down {
    width: 600px;
    height: 200px;
    /* border: 1px red solid; */
}


.msg_left {
    width: 530px;
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
    width: 550px;
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
</style>
