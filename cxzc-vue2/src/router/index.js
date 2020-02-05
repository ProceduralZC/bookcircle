import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import HomePage from '@/components/home/HomePage'
import Login from '@/components/Login'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    // 下面都是固定的写法
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/index',
      name: 'HomePage',
      component: HomePage,
      meta: {
        requireAuth: true
      }
    }
  ]
})
