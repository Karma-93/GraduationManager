<template>
    <div>
        <a-list size="middle">
            <a-list-item :key="index" v-for="(item, index) in projectList">
                <a-list-item-meta :description="item.projectDescribe">
                    <!--<a-avatar slot="avatar" size="large" shape="square" src="https://joeschmoe.io/api/v1/random"/>-->
                    <a slot="title">{{ item.projectName }}</a>
                </a-list-item-meta>
            </a-list-item>
            <div slot="actions">
                <a @click="choose(item)">选择课题</a>
            </div>
        </a-list>
    </div>
</template>

<script>
import pick from 'lodash.pick';
import {requestProejctListByTeacherId} from "@/api/project.js";
import {requestChooseProject} from "../../api/project";

export default {
    name: 'ProjectList',
    props: {
        record: {
            type: Object,
            default: null
        }
    },
    created(){
        this.getProjectList();
    },
    data () {
        return {
            projectList:[],
        }
    },
    mounted () {
    },
    methods: {
        getProjectList(){
            requestProejctListByTeacherId(this.record.teacherId).then((response)=>{
                this.projectList=response.data.data;
                console.log(this.projectList);
            });
        },
        choose(data){
            requestChooseProject(data.projectId);
        },
        onOk () {
            console.log('监听了 modal ok 事件')
            return new Promise(resolve => {
                resolve(true)
            })
        },
        onCancel () {
            console.log('监听了 modal cancel 事件')
            return new Promise(resolve => {
                resolve(true)
            })
        },
        handleSubmit () {
            const { form: { validateFields } } = this
            this.visible = true
            validateFields((errors, values) => {
                if (!errors) {
                    console.log('values', values)
                }
            })
        }
    }
}
</script>
