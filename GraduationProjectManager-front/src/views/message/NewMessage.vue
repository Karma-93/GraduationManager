<template>
    <div>
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
</template>

<script>
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
        this.curSessionId=this.record.sessionId;
        //this.getSessionListAlready();
        //this.getSessionListNot();
        this.startSession(99999999);
    },
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
    methods: {
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
        initWebSocket: function (userId, sessionId) {
            // WebSocket与普通的请求所用协议有所不同，ws等同于http，wss等同于https
            this.websock = newWebSocket(userId, sessionId);
            this.websock.onopen = this.websocketonopen;
            this.websock.onerror = this.websocketonerror;
            this.websock.onmessage = this.websocketonmessage;
            this.websock.onclose = this.websocketclose;
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
    destroyed: function () {
        this.websocketclose();
    },

};
</script>

<style scoped>
.up {
    width: 680px;
    height: 550px;
    overflow-y: scroll;
    overflow-x: hidden;
    /* padding-bottom: 40px; */
    border-bottom: 1px #1890ff solid;
}

.down {
    width: 680px;
    height: 200px;
    /* border: 1px red solid; */
}
</style>
