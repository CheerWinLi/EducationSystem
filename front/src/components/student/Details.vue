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
                <!-- 上传图片按钮 -->
                <el-upload
                    class="upload-demo"
                    :before-upload="uploadImage"
                    show-file-list="false"
                    style="margin-right: 20px"
                >
                    <el-button type="primary">上传头像</el-button>
                </el-upload>
                <img :src="avatarUrl" alt="头像" style="width: 40px; height: 40px; border-radius: 50%; margin-left: 10px;"/>
            </el-header>
            <el-main>
                <el-scrollbar>
                    <el-table :data="detailList">
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
            detailList: [],
            uploadedImageUrl: '',
            avatarUrl: '/image/'+this.$store.state.studentId+'.png'
        }

    },
    mounted() {
        this.getDetails()
    },
    methods: {
        score() {
            this.$router.push("/student/score")
        },
        course() {
            this.$router.push("/student/course")
        },
        details() {
        },
        getDetails() {
            this.$http.get("/student", {
                params: {
                    studentId: this.$store.state.studentId
                }
            }).then(res => {
                console.log(typeof res.data)
                this.detailList = [res.data.data]
            })
        },
        uploadImage(file) {
            const formData = new FormData();
            formData.append('file', file);
            formData.append('studentId', this.$store.state.studentId);
            this.$http.post('/student/image', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            }).then(response => {
                // 处理上传成功后的响应，这里假设后端返回的数据包含图片链接
                this.uploadedImageUrl = response.data.data;
                this.$message.success('图片上传成功！');
            }).catch(error => {
                // 处理上传失败的情况
                console.error('图片上传失败：', error);
                this.$message.error('图片上传失败，请重试！');
            });
        },
    }
}
</script>

<style scoped>
</style>
