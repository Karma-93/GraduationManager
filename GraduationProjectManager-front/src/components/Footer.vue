<template>
    <footer class="app-footer">
    <p>{{copyright}}</p>
    </footer>
</template>

<script>
export default {
    name: "app-footer",
    data(){
        return{
            copyright:"vue demo"
        }
    }
}
</script>

<style scoped>
footer{
    background: lightblue;
    padding: 10px;
}
p{
    color: grey;
    text-align: center;
}
</style>

