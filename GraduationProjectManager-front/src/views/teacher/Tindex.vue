<template>
    <a-layout>
        <TMenu/>
        <a-layout :style="{marginLeft:'300px'}">
            <a-layout-header :style="{ background: '#fff', padding: 0 }">用户</a-layout-header>
            <a-layout-content :style="{ margin: '24px 20px 0', overflow: 'initial' }">
                <router-view/>
            </a-layout-content>
            <a-layout-footer :style="{ textAlign: 'center' }">
                <p>由 <a href="https://github.com/Alone-93" title="CX" target="_blank">CX</a>
                    提供技术支持</p>
                <p>copyright &copy; 2018-2028, All Rights Reserved.</p>
            </a-layout-footer>
        </a-layout>
    </a-layout>
</template>

<script>
import TMenu from "./TMenu"
export default {
    name: "Tindex",
    components:{TMenu}
}
</script>

<style scoped>

</style>
