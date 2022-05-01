<template>
    <a-card>
        <a-list bordered :data-source="downData" class="a-list">
            <a-list-item slot="renderItem" slot-scope="item, index">{{ item.downTitle }}</a-list-item>
            <div slot="header">
                <h3>文件下载</h3>
            </div>
        </a-list>
    </a-card>
</template>

<script>

import {
    requestDownList,
} from "@/api/login.js";

export default {
    name: "TDownloadload",
    data(){
        return{
            downData:[],
        }
    },
    created(){
        this.getDownList();
    },
    methods:{
        // 获取文件下载列表
        getDownList() {
            requestDownList({ pageNum: 0, pageSize: 5 }).then(response => {
                this.downData = response.data.data.data;
            });
        },

    }
};
</script>

<style scoped>
</style>
