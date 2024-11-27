<template>
    <el-container class="layout-container-demo" style="height: 500px">
        <el-aside width="200px">
            <el-scrollbar>
                <el-menu :default-openeds="['1', '3']">
                    <el-sub-menu index="1">
                        <template title style="font-size: 16px">
                            欢迎来到学生端
                        </template>
                        <el-menu-item-group>
                            <template title> 选项</template>
                            <el-menu-item index="1-1" @click="details"> 查看个人信息</el-menu-item>
                            <el-menu-item index="1-2" @click="course">查看课程信息</el-menu-item>
                            <el-menu-item index="1-3" @click="score">查看成绩</el-menu-item>
                        </el-menu-item-group>
                    </el-sub-menu>

                </el-menu>
            </el-scrollbar>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <div class="toolbar">
                    <span>学生端</span>
                </div>
            </el-header>
        </el-container>
    </el-container>
</template>


<script>

export default {
    data() {
        return {
            tableData: []
        }
    },
    methods: {
        score() {
            this.$router.push("/student/score")
        },
        course() {
            this.$router.push("/student/course")
        },
        details() {
            this.$router.push("/student/details")
        }
    }
}
</script>

<style scoped>

</style>
