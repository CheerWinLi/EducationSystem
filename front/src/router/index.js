import Student from '../components/student/Student.vue'
import Login from "../components/Login.vue";
import Course from "@/components/student/Course.vue";
import Score from "@/components/student/Score.vue";
import Details from "@/components/student/Details.vue";
import EducateMain from "@/components/educate/EducateMain.vue";
import EScore from "@/components/educate/EScore.vue";
import EDetails from "@/components/educate/EDetails.vue";
import ECourse from "@/components/educate/ECourse.vue";
import VueRouter from "vue-router";
import Vue from "vue";
import Test from "@/components/Test.vue";

Vue.use(VueRouter)

const router = new VueRouter({
    mode: 'history',
    routes:[
        {
            path: '/',
            redirect: '/login'
        },
        {
            path: '/login',
            component: Login
        },
        {
            path: '/student/score',
            component: Score
        },
        {
            path: '/student',
            component: Student
        },
        {
            path: '/student/course',
            component: Course
        },
        {
            path: '/student/details',
            component: Details
        }, {
            path: '/educate/',
            component: EducateMain
        },
        {
            path: '/educate/score',
            component: EScore
        },
        {
            path: '/educate/course',
            component: ECourse
        },
        {
            path: '/educate/details',
            component: EDetails
        },
        {
            path: '/test',
            component:Test
        }

    ]
})
export default router;
