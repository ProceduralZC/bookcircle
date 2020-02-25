<template>
  <body id="poster">
  <el-form class="login-container" label-position="left"
           label-width="0px" ref="loginForm" :model="loginForm" :rules="loginRules">
    <h3 class="login_title">书圈后台管理系统</h3>
    <el-form-item>
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="账号">
      </el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码">
      </el-input>
    </el-form-item>
    <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 25px 0px;right: 130px">记住密码</el-checkbox>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #707070;border: none" v-on:click="login">登录</el-button>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-text type="primary" v-on:click="addUser">用户添加</el-text>
    </el-form-item>
  </el-form>
  </body>
</template>
<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: 'admin',
        password: 'admin',
        rememberMe: false
      },
      loading: false,
      responseResult: []
    }
  },
  created () {
    this.getCookie()
  },
  methods: {
    getCookie () {
      const username = this.$cookies.get('username')
      const password = this.$cookies.get('password')
      const rememberMe = this.$cookies.get('rememberMe')
      this.loginForm = {
        username: username === undefined ? this.loginForm.username : username,
        password: password === undefined ? this.loginForm.password : password,
        rememberMe: rememberMe === undefined ? false : Boolean(rememberMe)
      }
    },
    login () {
      var _this = this
      if (this.loginForm.username == null) {
        this.$message.warning('登录信息不能为空')
        return
      }
      this.$axios
        .post('/login', {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            if (_this.loginForm.rememberMe) {
              // this.$cookies.set(keyName, time)
              _this.$cookies.set('username', this.loginForm.username, { expires: 30 })
              _this.$cookies.set('password', this.loginForm.password, { expires: 30 })
              _this.$cookies.set('rememberMe', this.loginForm.rememberMe, { expires: 30 })
            } else {
              _this.$cookies.remove('username')
              _this.$cookies.remove('password')
              _this.$cookies.remove('rememberMe')
            }

            // var data = this.loginForm
            _this.$store.commit('login', _this.loginForm)
            var path = this.$route.query.redirect
            this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
          } else {
            // this.$message.warning('登录失败！')
            this.$alert('登录失败', '提示', {
              confirmButtonText: '确定'
            })
          }
        })
        .catch(failResponse => {
        })
    },
    addUser () {
      this.$router.replace('/adduser')
    }
  }
}
</script>
<style>
  #poster {
    background:url("../assets/image/login-background.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
  }
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 35px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

</style>
