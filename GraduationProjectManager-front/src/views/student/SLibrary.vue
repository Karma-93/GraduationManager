<template>
    <a-card title="参考文库">
        
        <a-list
            rowKey="id"
            :grid="{gutter: 24, lg: 3, md: 2, sm: 1, xs: 1}"
            :dataSource="paperlib"
            class="card-list"
        >
            <a-list-item slot="renderItem" slot-scope="item">
                <template>
                    <a-card :hoverable="true">
                        <a-card-meta>
                            <a slot="title">{{ item.name }}</a>
                            <!--<a-avatar
                                class="card-avatar"
                                slot="avatar"
                                :src="item.avatar"
                                size="large"
                            />-->
                            <div class="meta-content" slot="description">{{ item.info }}</div>
                        </a-card-meta>
                        <!--
                        <template class="ant-card-actions" slot="actions">
                            <a>编辑</a>
                            <a @click>删除</a>
                        </template>
                        -->
                    </a-card>
                </template>
            </a-list-item>
        </a-list>
    </a-card>
</template>

<script>
import {reqeustGetAllPaperlibList} from "@/api/paperlib.js"

export default {
    name: "SLibrary",
    data() {
        return {
        paperlib: [],
        }
    },
    created() {
        this.fetchData();
    },
    methods: {
        async fetchData() {
            const result=await reqeustGetAllPaperlibList();
            this.paperlib=result.data.data;
            console.log(this.paperlib);
        },
    },
};
</script>

<style lang="less" scoped>
.card-list {
    /deep/ .ant-card-body:hover {
        .ant-card-meta-title > a {
        }
    }

    /deep/ .ant-card-meta-title {
        margin-bottom: 12px;

        & > a {
            display: inline-block;
            max-width: 100%;
            color: rgba(0, 0, 0, 0.85);
        }
    }

    /deep/ .meta-content {
        position: relative;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        height: 64px;
        -webkit-line-clamp: 3;
        -webkit-box-orient: vertical;

        margin-bottom: 1em;
    }
}

.card-avatar {
    width: 48px;
    height: 48px;
    border-radius: 48px;
}

.ant-card-actions {
    background: #f7f9fa;

    li {
        float: left;
        text-align: center;
        margin: 12px 0;
        color: rgba(0, 0, 0, 0.45);
        width: 50%;

        &:not(:last-child) {
            border-right: 1px solid #e8e8e8;
        }

        a {
            color: rgba(0, 0, 0, 0.45);
            line-height: 22px;
            display: inline-block;
            width: 100%;
            &:hover {
            }
        }
    }
}

.new-btn {
    background-color: #fff;
    border-radius: 2px;
    width: 100%;
    height: 188px;
}
</style>
