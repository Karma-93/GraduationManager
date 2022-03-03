<template>
    <div class="main">
        <div class="main-up">
            {{this.UserName}}
        </div>
        <div class="main-down">
            <div class="left">
                <div class="left_up">
                    <div class="label_title">
                        已建立会话
                    </div>
                    <!--遍历已经发起过会话的列表-->
                    <div :class="curSessionId==item.id?'box_select':'box'" v-for="item in sessionList_already" :key="item.id">
                        <!--显示接受者的用户名-->
                        <div class="box_left"  @click="startSession(item.id)">
                            {{item.listName}}
                        </div>
                        <!--显示未读消息数量和删除聊天记录按钮-->
                        <div class="right_left">
                            <div class="right_left_count">
                                {{item.unReadCount}}
                            </div>
                            <div class="right_left_del">
                                <i class="el-icon-close" @click="delSession(item.id)"></i>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="left_down"></div>
            </div>
            <div class="right">

            </div>
        </div>
    </div>
</template>

<script>
import store from "@/store/store.js"

    export default {
        name:"Message",
        data(){
            return{
                curUserId:"",
                curUserName:"",
                curSessionId:"",
                sessionList_already:[],    //已经发起过会话的列表?
                sessionList_not:[],
                list:[] ,  //存放消息数据
            }
        },
        created(){
            this.curUserId=store.state.userInfo.userId;
            this.curUserName=store.state.userInfo.userName;
            this.getSessionListAlready();
            this.startSession(99999999);
        },
        updated() {

        },
        destroyed:function (){
            this.websocketclose();
        },

        components:{},

        methods:{

            initWebSocket: function (userId,sessionId){
                // WebSocket与普通的请求所用协议有所不同，ws等同于http，wss等同于https
                this.websock = new WebSocket("ws://127.0.0.1:1997/websocket/"+userId+"/"+sessionId);
                this.websock.onopen = this.websocketonopen;
                this.websock.onerror = this.websocketonerror;
                this.websock.onmessage = this.websocketonmessage;
                this.websock.onclose = this.websocketclose;
            },
            websocketonopen: function () {
                console.log("WebSocket连接成功");
            },
            websocketonerror: function (e) {
                console.log("WebSocket连接发生错误",e);
            },
            websocketonmessage:function (e){
                let data=JSON.parse(e.data);
                if (data instanceof Array){//如果是列表数据
                    this.sessionList_already=data;
                }else{
                    //消息数据，单条
                    this.list.push(data);
                }
            },
            websocketclose:function (e){
                if (this.curUserId!=null){//当已登录
                    //????????????????????
                    if(this.curSessionId != null){
                        this.initWebSocket(this.curUserId, this.curSessionId)
                    }else{
                        this.initWebSocket(this.curUserId, 99999999)
                    }
                    console.log("connection closed",e);
                    console.log(e);
                }
            },
            //消息发送
            sendMsg(){
                if(this.curSessionId == ''){
                    return this.$message.error("请选择左边的对话框开始聊天!")
                }
                let data = {
                    "UserId": this.curUserId,
                    "UserName": this.curUserName,
                    "content": this.textarea
                }
                this.list.push(data)
                this.websock.send(this.textarea)
                this.textarea = ''
            },

            //获取可以建立会话的列表,即还没有发起过聊天的用户
            getSessionListNot(){
                axios.get('http://127.0.0.1:1997/sessionList/not?id=' + this.curUserId)
                    .then(function (response) {
                        if(response.data.code == -1){
                            return this.$message.error(response.data.errDesc);
                        }
                        this.sessionList_not = response.data.data
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            //开始会话
            startSession(sessionId){
                if (this.websock!=undefined){
                    this.websock.close()
                }
                this.curSessionId = sessionId
                this.initWebSocket(this.curUserId, sessionId)
                this.msgList(sessionId)
            },

        }

    }

</script>

<style scoped>

</style>
