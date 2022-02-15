<template>
    <header class="app-header">
        <h1>{{title}}</h1>
    </header>
</template>

<script>
export default {
    name: "app-header",
    data(){
        return{
            title:"Vue Demo"
        }
    }
}
</script>

<style scoped>
    header{
        background-color: lightcoral;
        padding: 10px;
    }
    h1{
        color: #222222;
        text-align: center;
    }
</style>
