<template>
    <el-container class="layout-container-demo" style="height: 500px">
        <el-aside width="200px">
            <el-scrollbar>
                <el-menu :default-openeds="['1', '3']">
                    <el-sub-menu index="1">
                        <template  >
                            欢迎来到教务端
                        </template>
                        <el-menu-item-group>
                            <template > 选项</template>
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
                <el-scrollbar>
                    <el-table :data="tableData">
                        <el-table-column prop="date" label="Date" width="140"/>
                        <el-table-column prop="name" label="Name" width="120"/>
                        <el-table-column prop="address" label="Address"/>
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
            tableData: []
        }
    },
    methods: {
        score() {
            this.$router.push("/educate/score")
        },
        course() {
            this.$router.push("/educate/course")

            },
        details() {
            this.$router.push("/educate/details")
        }
    }
}
</script>

<style scoped>

</style>
