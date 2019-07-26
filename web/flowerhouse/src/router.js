import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home'
import UserLogin from './views/UserLogin'
import AdminLogin from './views/AdminLogin'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/login',
      name: 'home',
      component: Home
    },
    {
      path: '/usPage',
      name: 'userLogin',
      component: UserLogin
    },
    {
      path: '/adPage',
      name: 'adminLogin',
      component: AdminLogin
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () = > import(/* webpackChunkName: "about" */ './views/About.vue')
}
]
})
