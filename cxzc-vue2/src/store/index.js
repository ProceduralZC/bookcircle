import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {
      username: window.localStorage.getItem('userinfo' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('userinfo' || '[]')).username
    }
  },
  mutations: {
    login (state, user) {
      state.user = user
      window.localStorage.setItem('userinfo', JSON.stringify(user))
    }
  }
})
