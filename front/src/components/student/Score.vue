<template>
    <el-container class="layout-container-demo" style="height: 500px">
        <el-aside width="200px">
            <el-scrollbar>
                <el-menu :default-openeds="['1', '3']">
                    <el-sub-menu index="1">
                        <el-menu-item-group>
                            <template #title> 学生模块</template>
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
                    <span>Tom</span>
                </div>
            </el-header>

            <el-main>
                <el-scrollbar>
                    <el-table :data="scoreList">
                        <el-table-column prop="courseId" label="课程编号" width="120"/>
                        <el-table-column prop="courseName" label="课程名称" width="120"/>
                        <el-table-column prop="teacherName" label="授课教师" width="120"/>
                        <el-table-column prop="credit" label="学分" width="120"/>
                        <el-table-column prop="score" label="课程成绩" width="120"/>
                    </el-table>
                </el-scrollbar>
            </el-main>
        </el-container>
    </el-container>
</template>


<script>

export default {
    data() {
        return {
            scoreList: []

        }

    },
    mounted() {
        this.getScores()
    },
    methods: {
        score() {
        },
        course() {
            this.$router.push("/student/course")
        },
        details() {
            this.$router.push("/student/details")
        },
        getScores() {
            this.$http.get("/score/list", {
                params: {
                    studentId: this.$store.state.studentId
                }
            }).then(res => {
                console.log(typeof res.data)
                this.scoreList = res.data.data
            })
        }
    }
}
</script>

<style scoped>
</style>
