<template>
    <a-layout-header :style="{ background: '#fff', padding: 0 }">
        <a-page-header
            style="border: 1px solid rgb(235, 237, 240)"
            title="Title"
            sub-title="This is a subtitle"
            avatar="{}"
        >
            <template slot="extra">

                <a-button key="2">
                    Operation
                </a-button>
                <a-button key="1" title="注销" shape="circle" icon="logout" type="danger" @click="quit">
                </a-button>
            </template>

        </a-page-header>
    </a-layout-header>

</template>

<script>
export default {
    name: "Header",
    data() {
        userData:[]
    },

    created: {
        if() {//判断角色

        }
    },

    methods: {
        quit() {
            localStorage.clear();//清空LocalStorage
            this.$store.commit("delToken");
            this.$router.push("login");
        },
        //如果是学生
        getStudentData() {

        },
        //如果是教师
        getTeacherData() {

        }

    }
}
</script>

<style scoped>

</style>
