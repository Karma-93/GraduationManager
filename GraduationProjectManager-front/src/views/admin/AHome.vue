<template>
    <div>
    <h1>AHOME</h1>

  <a-card style="margin-top: 24px" :bordered="false" title="管理员信息">
      <a-descriptions>
        <a-descriptions-item label="管理员姓名">{{curUserName}}</a-descriptions-item>
        <a-descriptions-item label="联系方式">{{curUserTel}}</a-descriptions-item>
      </a-descriptions>
      
      <a-descriptions title="信息组">
        <a-descriptions-item label="选题个数">725</a-descriptions-item>
        <a-descriptions-item label="可选课题个数">2018-08-08</a-descriptions-item>
        <a-descriptions-item ></a-descriptions-item>
        <a-descriptions-item label="学生个数">725</a-descriptions-item>
        <a-descriptions-item label="未选题学生个数">2018-08-08</a-descriptions-item>
        <a-descriptions-item ></a-descriptions-item>
      </a-descriptions>

    </a-card>


    </div>
</template>

<script>
export default {
    name: "AHome",
    data(){
        return{
            curUserId: "",
            curUserName: "",
            curUserTel: "", 
        }
    },
    created(){
        this.curUserId = this.$store.state.userInfo.userId;
        this.curUserName = this.$store.state.userInfo.userName;
        this.curUserTel = this.$store.state.userInfo.userTel;
    },
    method:{

    }
}
</script>

<style scoped>

</style>
