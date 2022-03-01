<template>
    <a-layout>
        <SMenu />
        <a-layout :style="{ marginLeft: '300px' }">
            <Header />
            <a-layout-content
                :style="{ margin: '24px 20px 0', overflow: 'initial' }"
            >
                <router-view />
            </a-layout-content>
            <a-layout-footer :style="{ textAlign: 'center' }">
                <p>
                    由
                    <a
                        href="https://github.com/Alone-93"
                        title="CX"
                        target="_blank"
                        >CX</a
                    >
                    提供技术支持
                </p>
                <p>copyright &copy; 2018-2028, All Rights Reserved.</p>
            </a-layout-footer>
        </a-layout>
    </a-layout>
</template>

<script>
import SMenu from "./SMenu";
import Header from "../common/Header";
export default {
    name: "Sindex",
    components: { SMenu, Header }
};
</script>

<style scoped>
main {
    height: calc(100vh - 206px);
    background-color: #fff;
}
</style>
