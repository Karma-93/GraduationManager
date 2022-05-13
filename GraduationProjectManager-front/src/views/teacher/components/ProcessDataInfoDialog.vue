<template>
  <div>
    <a-modal @ok="save" @cancel="close" v-model:visible="visible" title="Basic Modal">
      <p>Some contents...</p>
      <p>Some contents...</p>
      <p>Some contents...</p>
    </a-modal>
  </div>
</template>

<script>
export default {
  name: "ProcessDataInfoDialog",
  emit: ["fetch-data"],
  data() {
    return {
      // 弹窗显示开关
      visible: false
    };
  },
  methods: {
    /**
     * @description 弹窗展示
     * @author Cui Ruichen
     * @date 2022-04-29
     */
    showEdit(record) {
      // record: 该行的数据
      console.log("弹窗展示", record);
      this.visible = true;
    },

    /**
     * @description 取消事件
     * @author Cui Ruichen
     * @date 2022-04-29
     */
    close() {
      // 调用父组件的查询数据方法
      this.$emit("fetch-data");
      this.visible = false;
    },

    /**
     * @description 确认事件
     * @author Cui Ruichen
     * @date 2022-04-29
     */
    save() {
      console.log("===按下确认===");
      this.close();
    }
  }
};
</script>

<style>
</style>
