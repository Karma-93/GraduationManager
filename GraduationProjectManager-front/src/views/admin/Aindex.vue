<template>
    <router-view v-if="$route.matched[1]" />
</template>

<script>
export default {
    name: "Aindex"
};
</script>

<style scoped></style>
