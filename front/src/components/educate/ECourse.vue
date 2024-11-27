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
                    <el-button class="" type="primary" @click="dialogVisible = true">添加课程</el-button>

                    <el-dialog title="表单弹框" :visible.sync="dialogVisible" width="40%">
                        <el-form ref="form" :model="addCourse" label-width="100px">
                            <el-form-item label="上课学生id">
                                <el-input v-model="addCourse.studentId"></el-input>
                            </el-form-item>
                            <el-form-item label="课程名称">
                                <el-input v-model="addCourse.name"></el-input>
                            </el-form-item>
                            <el-form-item label="课程学分">
                                <el-input v-model="addCourse.credit"></el-input>
                            </el-form-item>
                            <el-form-item label="授课教师姓名">
                                <el-input v-model="addCourse.teacherName"></el-input>
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
                    <el-button type="primary" @click="getLikeCourses">查找</el-button>
                </div>
                <el-scrollbar>
                    <el-table :data="scoreList">
                        <el-table-column prop="studentName" label="学生姓名" width="120"/>
                        <el-table-column prop="studentId" label="学号" width="120"/>
                        <el-table-column prop="courseId" label="课程id" width="120"/>
                        <el-table-column prop="courseName" label="课程名称" width="120"/>
                        <el-table-column prop="teacherId" label="授课教师id" width="120"/>
                        <el-table-column prop="teacherName" label="授课教师" width="120"/>
                        <el-table-column prop="credit" label="学分" width="120"/>
                        <el-table-column label="操作" width="120px">
                            <template slot-scope="scope">
                                <el-button type="primary" @click="deleteCourse(scope.row.courseId,scope.row.studentId)">删除</el-button>
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
                value: 'course_id',
                label: '根据课程编号选择'
            }, {
                value: 'course_name',
                label: '根据课程名称选择'
            }, {
                value: 'teacher_name',
                label: '授课教师'
            }],
            value: '',
            dialogVisible: false,
            addCourse: {
                name: '',
                credit: '',
                teacherName: '',
                studentId: ''
            },
            scoreList: [],
            searchCourse: {
                courseId: "",
                courseName: "",
                studentId: "",
                teacherId: "",
                teacherName: ""
            },
            fieldName: '',
            fieldValue: ''
        };
    },

    mounted() {
        this.getCourses();
    },
    methods: {
        submitForm() {
            let form = {
                courseName: this.addCourse.name,
                credit: this.addCourse.credit,
                teacherName: this.addCourse.teacherName,
                studentId: this.addCourse.studentId
            }
            this.$http.post('/course', form).then(res => {
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

        getCourses() {
            this.$http.get('/course/list').then(res => {
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
        deleteCourse(courseId,studentId) {
            this.$http.delete(`/course?courseId=${courseId}&studentId=${studentId}`).then(res => {
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
        getLikeCourses() {
            let LikeBo = {
                fieldName: this.fieldName,
                fieldValue: this.fieldValue
            };
            this.$http.post('/course/likeList', LikeBo).then(res => {
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
            this.$router.push("/educate/score")
        },
        course() {

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
