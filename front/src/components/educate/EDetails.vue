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
                    <el-button class="" type="text" @click="dialogVisible = true">添加学生</el-button>

                    <el-dialog title="表单弹框" :visible.sync="dialogVisible" width="30%">
                        <el-form ref="form" :model="student" label-width="80px">
                            <el-form-item label="姓名">
                                <el-input v-model="student.name"></el-input>
                            </el-form-item>
                            <el-form-item label="学号">
                                <el-input v-model="student.studentId"></el-input>
                            </el-form-item>
                            <el-form-item label="电话号码">
                                <el-input v-model="student.phoneNumber"></el-input>
                            </el-form-item>
                            <el-form-item label="班级">
                                <el-input v-model="student.clazz"></el-input>
                            </el-form-item>
                            <el-form-item label="年龄">
                                <el-input v-model="student.age"></el-input>
                            </el-form-item>
                            <el-form-item label="年级">
                                <el-input v-model="student.grade"></el-input>
                            </el-form-item>
                            <el-form-item label="性别">
                                <el-input v-model="student.gender"></el-input>
                            </el-form-item>
                            <el-form-item label="入学年份">
                                <el-input v-model="student.studyYear"></el-input>
                            </el-form-item>
                            <el-form-item label="专业名">
                                <el-input v-model="student.majorName"></el-input>
                            </el-form-item>
                            <el-form-item label="学院名">
                                <el-input v-model="student.academyName"></el-input>
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
                    <el-button type="primary" @click="getLikeStudents">查找</el-button>
                </div>

                <el-scrollbar>
                    <el-table :data="detailsList">
                        <el-table-column prop="studentId" label="学号" width="120"/>
                        <el-table-column prop="studentName" label="姓名" width="120"/>
                        <el-table-column prop="gender" label="性别" width="120"/>
                        <el-table-column prop="age" label="年龄" width="120"/>
                        <el-table-column prop="phoneNumber" label="电话" width="120"/>
                        <el-table-column prop="grade" label="年级" width="120"/>
                        <el-table-column prop="clazz" label="班级" width="120"/>
                        <el-table-column prop="status" label="学籍状态" width="120"/>
                        <el-table-column prop="majorName" label="专业" width="120"/>
                        <el-table-column prop="academyName" label="学院" width="120"/>
                        <el-table-column label="操作" width="120px">
                            <template slot-scope="scope">
                                <el-button type="primary" @click="downloadFile(scope.row.studentId)">下载</el-button>
                                <el-button type="primary" @click="deleteStudent(scope.row.studentId)">删除</el-button>
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
                label: '根据学生学号查询'
            }, {
                value: 'student_name',
                label: '根据学生姓名查询'
            }, {
                value: 'major_name',
                label: '根据专业名称查询'
            }, {
                value: 'academy_name',
                label: '根据学院名称查询'
            }],
            dialogVisible: false,
            student: {
                gender: '',
                name: '',
                studentId: '',
                academyId: '',
                majorId: '',
                phoneNumber: '',
                clazz: '',
                studyYear: '',
                age: '',
                grade: '',
                majorName: '',
                academyName: '',
            },
            detailsList: [],
            fieldValue: '',
            fieldName: '',
            searchStudent: {
                fieldName: "",
                fieldValue: ""
            }
        };
    },

    mounted() {
        this.getStudents();
    },
    methods: {
        downloadFile(studentId) {
            this.$http.get(`/student/image?studentId=${studentId}`, {responseType: 'blob'})
                .then(response => {
                    const url = window.URL.createObjectURL(response.data);
                    const link = document.createElement('a');
                    link.href = url;
                    link.setAttribute('download', `student_${studentId}.png`); // or the desired file extension
                    document.body.appendChild(link);
                    link.click();
                })
                // eslint-disable-next-line no-unused-vars
                .catch(error => {
                    this.$message({
                        message: '下载失败',
                        type: 'error'
                    });
                });
        },
        deleteStudent(studentId) {
            this.$http.delete(`/student?studentId=${studentId}`).then(res => {
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
        submitForm() {
            let form = {
                gender: this.student.gender,
                studentName: this.student.name,
                studentId: this.student.studentId,
                academyId: this.student.academyId,
                majorId: this.student.majorId,
                phoneNumber: this.student.phoneNumber,
                clazz: this.student.clazz,
                studyYear: this.student.studyYear,
                age: this.student.age,
                grade: this.student.grade,
                majorName: this.student.majorName,
                academyName: this.student.academyName,
            }
            this.$http.post(
                '/student', form).then(res => {
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

        getStudents() {
            this.$http.get('/student/list').then(res => {
                if (res.data.code === 200) {
                    this.searchStudent.fieldName =
                        this.detailsList = res.data.data;
                } else {
                    this.$message({
                        message: '获取失败',
                        type: 'error'
                    })
                }
            })
        },

        getLikeStudents() {
            let LikeBo = {
                fieldName: this.fieldName,
                fieldValue: this.fieldValue
            };
            this.$http.post('/student/likeList', LikeBo).then(res => {
                if (res.data.code === 200) {
                    this.detailsList = res.data.data;
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
            this.$router.push("/educate/course")

        },
        details() {
        }
    },


}
</script>

<style scoped>
</style>
