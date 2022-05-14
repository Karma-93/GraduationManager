<template>
    <!-- 弹窗组件 -->
    <a-modal
        @ok="save"
        @cancel="close"
        :okText="isEdit ? '保存' : '添加'"
        cancelText="取消"
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
                label="用户账号"
                prop="userAccount"
            >
                <!-- 每一项里边的内容，prop绑定的规则名，下见data里的rules对象 -->
                <a-input
                    v-model="form.userAccount"
                    placeholder="请输入用户账号"
                />
            </a-form-model-item>
            <a-form-model-item
                label="用户密码"
                prop="userPassword"
            >
                <a-input
                    v-model="form.userPassword"
                    placeholder="请输入用户密码"
                />
            </a-form-model-item>
            <a-form-model-item
                label="用户名"
                prop="userName"
            >
                <a-input
                    v-model="form.userName"
                    placeholder="请输入用户名"
                />
            </a-form-model-item>
            <a-form-model-item
                label="角色"
                prop="userRoles"
            >
                <a-select
                    v-model="form.userRoles"
                    placeholder="请输入角色"
                >
                    <a-select-option value="1">教师</a-select-option>
                    <a-select-option value="2">学生</a-select-option>
                    <a-select-option value="3">管理员</a-select-option>
                </a-select>
            </a-form-model-item>
            <a-form-model-item
                label="性别"
                prop="userSex"
            >
                <a-select
                    v-model="form.userSex"
                    placeholder="请选择"
                >
                    <a-select-option value="0">未知</a-select-option>
                    <a-select-option value="1">男</a-select-option>
                    <a-select-option value="2">女</a-select-option>
                </a-select>
            </a-form-model-item>
            <a-form-model-item
                label="电话"
                prop="userTel"
            >
                <a-input
                    v-model="form.userTel"
                    placeholder="请输入电话"
                />
            </a-form-model-item>
        </a-form-model>
    </a-modal>
</template>

<script>
import { requestAddUser, requestUpdateUser } from "@/api/user.js";
import { message } from "ant-design-vue";

export default {
    name: "AUserEditDialogg",
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
                userAccount: [
                    // required是否为必填项，非必填时可以不写
                    // message是不满足条件时的提示信息
                    // trigger是触发方式:blur失焦
                    { required: true, message: "请输入账号", trigger: "blur" },
                    { min: 5, message: "长度不少于 6 个字符", trigger: "blur" }
                    //validator自定义校验规则函数，一般提示需要必填就足够用了，不开这个
                    // { validator: this.validatePassword }
                ],
                userPassword: [
                    { required: true, message: "请输入密码", trigger: "blur" }
                ],
                userName: [
                    { required: true, message: "请输入用户名", trigger: "blur" }
                ],
                userRoles: [
                    { required: true, message: "请选择角色", trigger: "blur" }
                ],
                userSex: [
                    // 若性别为非必填项，可以不写，template中的html结构，也可以去掉a-form-item标签中的props属性
                    // { required: true, message: "请选择性别", trigger: "blur" }
                ],
                userTel: [
                    { required: true, message: "请输入手机号", trigger: "blur" }
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
            // record: 该行的数据，如果是编辑按钮(行外添加record为null)，就把行内数据传给表单对象，用来回显
            if (record) {
                this.title = "编辑";
                // 把编辑标识设置为true
                this.isEdit = true;
                // 对record数据进行深拷贝，否则this.form只会拷贝record的地址，修改this.form会影响表格内的源数据
                this.form = JSON.parse(JSON.stringify(record));
                console.log(this.form.userRoles);
                // 这里 +"" 将值从Number转为String，否则select单选框组件不会回显
                this.form.userRoles = this.form.userRoles + "";
                this.form.userSex = this.form.userSex + "";
            } else {
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
            // 调用父组件的查询数据方法
            this.$emit("fetch-data");
            // 关闭弹窗时要清空表单对象，否则会有残留的数据
            this.form = {};
            this.visible = false;
        },

        /**
         * @description 确认事件
         * @author Cui Ruichen
         * @date 2022-04-29
         */
        save() {
            console.log("aaaaaaaaaaa")
            this.$refs.formRef.validate(valid => {
                // 如果所有项都通过了校验
                if (valid) {
                    //console.log("err", err, values);
                    console.log("true");

                    // 如果为编辑
                    if (this.isEdit) {
                        console.log("===调用保存接口===", this.form);
                    }
                    // 如果为添加
                    else {

                        requestAddUser(this.form).then((response) => {
                            if (response.data.code == 1) {
                                message.success("删除成功");
                            } else {
                                message.error("删除失败");
                            }
                        })

                        console.log("===调用添加接口===", this.form);
                    }
                    this.close();
                }
                // 如果校验不通过
                else {
                    console.log("else");
                    return false;
                }
            });
        }
    }
};
</script>

<style></style>
