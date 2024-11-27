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
                    <el-table :data="courseList">
                        <el-table-column prop="courseName" label="课程名称" width="120"/>
                        <el-table-column prop="credit" label="学分" width="120"/>
                        <el-table-column prop="teacherName" label="授课教师" width="120"/>
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
            courseList: []
            // {
            //     id: null,
            //         name: null,
            //     gender: null,
            //     age: null,
            //     phoneNumber: null,
            //     clazz: null,
            //     studyYear: null,
            //     status: null,
            //     majorId: null,
            //     academyId: null,
            //     studentId: null
            // },
        }

    },
    mounted() {
        this.getCourse()
    },
    methods: {
        score() {
            this.$router.push("/student/score")
        },
        course() {
        },
        details() {
            this.$router.push( "/student/details")
        },
        getCourse() {
            this.$http.get("/course/list", {
                params: {
                    studentId: this.$store.state.id
                }
            }).then(res => {
                console.log(typeof res.data)
                this.courseList = res.data.data
            })
        }
    }
}
</script>

<style scoped>

</style>
