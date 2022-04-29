<template>
    <a-card :title="record.informTitle" :bordered="false" style="width: 550px">
      <p>{{record.informBody}}</p>

      <p>{{record.createDate}}</p>
    </a-card>

</template>
<script>
import { defineComponent } from '@vue/composition-api'

export default{
    
    name:"Inform",
     props: {
        record: {
            type: Object,
            default: null,
        },
    },
    created(){

    },
    data(){
        return{

        }
    },
    methods:{

    }
}
</script>
<style scoped>

</style>
