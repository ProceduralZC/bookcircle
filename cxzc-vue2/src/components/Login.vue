<template>
  <div>
    账号: <input type="text" v-model="loginForm.username" placeholder="请输入账号"/>
    <br><br>
    密码: <input type="password" v-model="loginForm.password" placeholder="请输入密码"/>
    <br><br>
    <button v-on:click="login">登录账号</button>
  </div>
</template>

<script>

export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      responseResult: []
    }
  },
  methods: {
    login () {
      this.$axios
        .post('/login', {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/index'})
          } else {
            alert('登录失败！')
          }
        })
        .catch(failResponse => {
        })
    }
  }
}
</script>
