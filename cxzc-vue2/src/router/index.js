import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import HomePage from '@/components/home/HomePage'
import Home from '@/components/home/Home'
import UserManager from '@/components/sysmanage/UserManager'
import Login from '@/components/Login'
import Error from '@/components/Error'
import addUser from '../components/addUser'

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
      meta: {
        requireAuth: true
      },
      component: HomePage,
      children: [// 开始嵌套路由，这下面的所有路由都是Main路由的子路由
        {
          path: '/', // 嵌套路由里默认是哪个网页
          redirect: '/home'
        },
        {
          path: '/home', // 首页的路由
          name: 'Home',
          component: Home
        },
        {
          path: '/usermanager', // 设置页面的路由
          name: 'UserManager',
          component: UserManager
        }
      ]
    },
    {
      path: '/adduser',
      name: 'addUser',
      component: addUser
    },
    {
      path: '/*', // 注意，这里不是嵌套理由了，这是为了设置404页面，一定要放在最后面，这样当服务器找不到页面的时候就会返回404
      name: 'Error',
      component: Error
    }
  ]
})
