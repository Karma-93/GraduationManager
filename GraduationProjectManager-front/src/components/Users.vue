<template>
    <div class="users">
        <h1>USERS</h1>
        <ul>
            <li v-for="(user,index) in users" @click="user.show=!user.show">
                <h2>{{ user.name }}</h2>
                <h3 v-show="user.show">{{ user.position }}</h3>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    name: "Users",
    data() {
        return {
            title: "",
            users: [
                {name: "Henry", position: "web开发", show: false},
                {name: "Henry", position: "web开发", show: false},
                {name: "Henry", position: "web开发", show: false},
                {name: "Henry", position: "web开发", show: false},
                {name: "Henry", position: "web开发", show: false},
                {name: "Henry", position: "web开发", show: false},
                {name: "Henry", position: "web开发", show: false},
                {name: "Henry", position: "web开发", show: false},
                {name: "Henry", position: "web开发", show: false},
                {name: "Henry", position: "web开发", show: false}
            ]
        }
    }
}
</script>

<style scoped>
h1 {
    color: orange;
}

.users {
    width: 100%;
    max-width: 1200px;
    margin: 20px auto;
    padding: 0 20px;
    box-sizing: border-box;
}

.users ul {
    display: flex;
    max-width: 1200 px;
    flex-wrap: wrap;
    list-style-type: none;
    padding: 0px;
}

.users ul li {
    list-style-type: none;
    flex-grow: 1;
    flex-basis: 200 px;
    text-align: center;
    padding: 30px;
    border: 1px solid grey;
    margin: 10px;
}
</style>
