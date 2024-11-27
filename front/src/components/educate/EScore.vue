<template>
    <el-container class="layout-container-demo" style="height: 500px">
        <el-aside width="200px">
            <el-scrollbar>
                <el-menu :default-openeds="['1', '3']">
                    <el-sub-menu index="1">
                        <template>
                            欢迎来到教务端
                        </template>
                        <el-menu-item-group>
                            <template> 选项</template>
                            <el-menu-item index="1-1" @click="details"> 查看学生信息</el-menu-item>
                            <el-menu-item index="1-2" @click="course">课程所有信息</el-menu-item>
                            <el-menu-item index="1-3" @click="score">查看学生成绩</el-menu-item>
                        </el-menu-item-group>
                    </el-sub-menu>

                </el-menu>
            </el-scrollbar>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <div class="toolbar">
                    <el-dropdown>
                        <el-icon style="margin-right: 8px; margin-top: 1px">
                            <setting/>
                        </el-icon>
                        <template #dropdown>
                            <el-dropdown-menu>
                                <el-dropdown-item>View</el-dropdown-item>
                                <el-dropdown-item>Add</el-dropdown-item>
                                <el-dropdown-item>Delete</el-dropdown-item>
                            </el-dropdown-menu>
                        </template>
                    </el-dropdown>
                    <span>Tom</span>
                </div>
            </el-header>

            <el-main>
                <div>
                    <el-button class="" type="primary" @click="dialogVisible = true">添加成绩</el-button>

                    <el-dialog title="表单弹框" :visible.sync="dialogVisible" width="40%">
                        <el-form ref="form" :model="addScore" label-width="80px">
                            <el-form-item label="学生姓名">
                                <el-input v-model="addScore.studentName"></el-input>
                            </el-form-item>
                            <el-form-item label="学生学号">
                                <el-input v-model="addScore.studentId"></el-input>
                            </el-form-item>
                            <el-form-item label="课程id">
                                <el-input v-model="addScore.courseId"></el-input>
                            </el-form-item>
                            <el-form-item label="课程名称">
                                <el-input v-model="addScore.courseName"></el-input>
                            </el-form-item>
                            <el-form-item label="课程成绩">
                                <el-input v-model="addScore.score"></el-input>
                            </el-form-item>
                        </el-form>
                        <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false;submitForm()">确 定</el-button>
      </span>
                    </el-dialog>
                </div>
                <div>
                    <el-tag>选择查找方式</el-tag>
                    <el-select v-model="fieldName" placeholder="请选择">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                    <el-tag>请输入关键字</el-tag>
                    <el-input v-model="fieldValue" style="width: 200px;" placeholder="请输入关键字"></el-input>
                    <el-button type="primary" @click="getLikeScore">查找</el-button>
                </div>
                <el-scrollbar>
                    <el-table :data="scoreList">
                        <el-table-column prop="studentName" label="学生姓名" width="120"/>
                        <el-table-column prop="studentId" label="学生id" width="120"/>
                        <el-table-column prop="courseId" label="课程id" width="120"/>
                        <el-table-column prop="courseName" label="课程名称" width="120"/>
                        <el-table-column prop="teacherId" label="授课教师id" width="120"/>
                        <el-table-column prop="teacherName" label="授课教师" width="120"/>
                        <el-table-column prop="credit" label="学分" width="120"/>
                        <el-table-column prop="score" label="课程成绩" width="120"/>
                        <el-table-column label="操作" width="120px">
                            <template slot-scope="scope">
                                <el-button type="primary" @click="deleteScore(scope.row.studentId,scope.row.courseId)">删除</el-button>
                            </template>
                        </el-table-column>
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
            options: [{
                value: 'student_id',
                label: '根据学号查询'
            }, {
                value: 'course_id',
                label: '根据课号查询'
            }, {
                value: 'student_name',
                label: '根据学生姓名查询'
            }, {
                value: 'course_name',
                label: '根据课程名称查询'
            }],
            fieldValue: '',
            fieldName: '',
            value: '',
            dialogVisible: false,
            scoreList: [],
            addScore: {
                score: '',
                courseId: '',
                studentId: '',
                studentName: '',
                courseName: ''
            }
        };
    },
    mounted() {
        this.getScoreList();
    },
    methods: {
        submitForm() {
            let form = {
                courseId: this.addScore.courseId,
                score: this.addScore.score,
                studentName: this.addScore.studentName,
                studentId: this.addScore.studentId,
                courseName: this.addScore.courseName
            }
            this.$http.post('/score', form).then(res => {
                if (res.data.code === 200) {
                    this.$message({
                        message: '添加成功',
                        type: 'success'
                    });

                } else {
                    this.$message({
                        message: '添加失败',
                        type: 'error'
                    });
                }
            })
        },
        deleteScore(studentId,courseId) {
            this.$http.delete(`/score?studentId=${studentId}&courseId=${courseId}`).then(res => {
                if (res.data.code === 200) {
                    this.$message({
                        message: '删除成功',
                        type: 'success'
                    });
                } else {
                    this.$message({
                        message: '删除失败',
                        type: 'error'
                    });
                }
            })
        },
        getScoreList() {
            this.$http.get('/score/lists').then(res => {
                if (res.data.code === 200) {
                    this.scoreList = res.data.data;
                } else {
                    this.$message({
                        message: '获取失败',
                        type: 'error'
                    })
                }
            })
        },

        getLikeScore() {
            let LikeBo = {
                fieldName: this.fieldName,
                fieldValue: this.fieldValue
            }
            this.$http.post('/score/likeList', LikeBo).then(res => {
                if (res.data.code === 200) {
                    this.scoreList = res.data.data;
                } else {
                    this.$message({
                        message: '获取失败',
                        type: 'error'
                    })
                }
            })
        },
        score() {

        },
        course() {
            this.$router.push("/educate/course")
        },
        details() {
            this.$router.push("/educate/details")
        }
    },


}
</script>

<style scoped>
.addButton {
    position: relative;
}

</style>
