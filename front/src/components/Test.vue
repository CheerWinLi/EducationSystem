<template>
    <div>
        <el-select v-model="value1" multiple placeholder="请选择">
            <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
            </el-option>
        </el-select>

        <el-input v-model="condition" style="width: 200px;" placeholder="请输入关键字"></el-input>
    </div>

</template>

<script>
export default {
    data() {
        return {
            options: [{
                value: 'studentId',
                label: '根据学号选择'
            }, {
                value: 'clazz',
                label: '根据班级选择'
            }, {
                value: '选项3',
                label: '根据专业id'
            }, {
                value: '选项4',
                label: '根据学院id'
            }],
            value1: [],
            value2: [],
            condition: "",
        }
    }
}
</script>
