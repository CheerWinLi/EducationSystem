import Vuex from "vuex";
import Vue from "vue";
Vue.use(Vuex)
const store = new Vuex.Store({
    state: {
        studentId: null,
    },
    mutations: {
        setId(state,studentId) {
            state.studentId = studentId;
        },
    }
})

export default store;
