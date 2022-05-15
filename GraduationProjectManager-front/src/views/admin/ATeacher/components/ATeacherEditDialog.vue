<template>
    <div>
        <a-modal
            @ok="save"
            @cancel="close"
            v-model:visible="visible"
            :title="title"
        >
            <!-- 表单组件，表单内容都需要a-form包裹起来 -->
            <!-- model属性是双向绑定的表单对象，label-col属性是每个a-form-model-item内label的横向长度，wrapper-col是每个a-form-model-item的横向长度 -->
            <a-form-model
                :model="form"
                :label-col="{ span: 5 }"
                :wrapper-col="{ span: 12 }"
                ref="formRef"
                :rules="rules"
            >
                <!-- a-form-model-item是表单里每一个表单项，如用户账号，用户名等 -->
                <a-form-model-item
                    label="研究方向"
                    prop="teacherDescribe"
                >
                    <!-- 每一项里边的内容，prop绑定的规则名，下见data里的rules对象 -->
                    <a-input
                        v-model="form.teacherDescribe"
                        placeholder="请输入教师研究方向"
                    />
                </a-form-model-item>
                <a-form-model-item
                    label="职称"
                    prop="zhicheng"
                >
                    <a-input
                        v-model="form.zhicheng"
                        placeholder="请输入用户密码"
                    />
                </a-form-model-item>

                <a-form-model-item
                    label="部门"
                    prop="deptId"
                >
                    <a-select
                        v-model="form.deptId"
                        placeholder="请选择部门"
                    >
                        <a-select-option value="1">计算机科学教研室</a-select-option>
                        <a-select-option value="2">大数据教研室</a-select-option>
                        <a-select-option value="3">数字媒体技术教研室</a-select-option>
                        <a-select-option value="4">广播电视工程教研室</a-select-option>
                    </a-select>
                </a-form-model-item>
            </a-form-model>
        </a-modal>
    </div>
</template>

<script>
import {message} from "ant-design-vue";
import {requestUpdateTeacher,requestAddTeacher} from "@/api/teacher";

export default {
    name: "ATeacherEditDialog",
    emit: ["fetch-data"],
    data() {
        return {
            // 弹窗显示开关
            visible: false,
            // 弹窗左上角的标题
            title: "",
            // 是否为编辑按钮
            isEdit: false,
            // 表单对象,用来获取整个表单组件
            formRef: null,
            // 表单内的值所绑定的对象，数据都在这里边
            form: {},
            // 表单校验规则
            rules: {
                // userAccount规则名，数组里的每个对象是有几条校验规则，每个都回跑一遍，
                zhicheng: [
                    // required是否为必填项，非必填时可以不写
                    // message是不满足条件时的提示信息
                    // trigger是触发方式:blur失焦
                    {required: true, message: "请输入职称", trigger: "blur"},
                    //validator自定义校验规则函数，一般提示需要必填就足够用了，不开这个
                    // { validator: this.validatePassword }
                ],
                teacherDescribe:[
                    {required:true,message:"请输入研究方向",trigger:"blur"}
                ],
                deptId:[
                    {required:true,message:"请选择部门",trigger:"blur"}
                ]
            }
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
            if (record){
                this.title = "编辑";
                // 把编辑标识设置为true
                this.isEdit = true;
                // 对record数据进行深拷贝，否则this.form只会拷贝record的地址，修改this.form会影响表格内的源数据
                this.form = JSON.parse(JSON.stringify(record));
                // 这里 +"" 将值从Number转为String，否则select单选框组件不会回显
                this.form.deptId = this.form.deptId + "";
            }else{
                    this.title = "添加";
            }
            this.visible = true;
        },

        /**
         * @description 取消事件
         * @author Cui Ruichen
         * @date 2022-04-29
         */
        close() {
            // 清空规则校验
            this.$refs.formRef.resetFields();
            // 关闭弹窗时要清空表单对象，否则会有残留的数据
            this.form = {};
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
            this.$refs.formRef.validate(valid => {
                // 如果所有项都通过了校验
                if (valid) {
                    //console.log("err", err, values);
                    // 如果为编辑

                    if (this.isEdit) {
                        requestUpdateTeacher(this.form).then((response) => {
                            if (response.data.code == 1) {
                                message.success("编辑成功");
                            } else {
                                message.error("编辑失败");
                            }
                        })
                    }
                    // 如果为添加
                    else {
                        requestAddTeacher(this.form).then((response) => {
                            if (response.data.code == 1) {
                                message.success("添加成功");
                            } else {
                                message.error("添加失败");
                            }
                        })
                    }
                    this.close();
                }
                // 如果校验不通过
                else {
                    return false;
                }
            });
        }
    }
};
</script>

<style></style>
