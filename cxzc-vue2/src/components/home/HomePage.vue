<template>
  <el-container>
    <div class="controlPanel-sidebar" width="220px">
      <el-menu class="el-menu-vertical-demo"
               @open="handleOpen"
               @close="handleClose"
               :collapse="isCollapse"
               background-color="rgb(32,34,42)"
               text-color="rgba(255, 255, 255, 0.8)"
               active-text-color="#fff"
               :router="true">
        <div class="Title1" v-if="!isCollapse"><span>书圈后台管理</span></div>
        <div class="Title2" v-if="isCollapse" style="width:60px;">书圈</div>

        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-data-board"></i>
            <span slot="title">工作台</span>
          </template>
          <el-menu-item index="1-1" :route="{name:'Home'}"><div class="barstyle"></div>通知公告</el-menu-item>
        </el-submenu>

        <el-submenu index="6">
          <template slot="title">
            <i class="el-icon-setting"></i>
            <span slot="title">系统管理</span>
          </template>
          <el-menu-item index="6-1" :route="{name:'UserManager'}"><div class="barstyle"></div>用户管理</el-menu-item>
          <el-menu-item index="6-2"><div class="barstyle"></div>角色管理</el-menu-item>
          <el-menu-item index="6-3"><div class="barstyle"></div>菜单管理</el-menu-item>
          <el-menu-item index="6-4"><div class="barstyle"></div>字典管理</el-menu-item>
        </el-submenu>

        <el-submenu index="5">
          <template slot="title">
            <i class="el-icon-data-analysis"></i>
            <span slot="title">平台管理</span>
          </template>
          <el-menu-item index="5-1" :route="{name:'Home'}"><div class="barstyle"></div>书单管理</el-menu-item>
          <el-menu-item index="5-2"><div class="barstyle"></div>书圈管理</el-menu-item>
        </el-submenu>

        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">事务管理</span>
          </template>
          <el-menu-item index="2-1" :route="{name:'UserManager'}"><div class="barstyle"></div>审核书单</el-menu-item>
          <el-menu-item index="2-2"><div class="barstyle"></div>审核书圈</el-menu-item>
        </el-submenu>

        <el-submenu index="3">
          <template slot="title">
            <i class="el-icon-view"></i>
            <span slot="title">系统监控</span>
          </template>
          <el-menu-item index="3-1" :route="{name:'Home'}"><div class="barstyle"></div>接口文档</el-menu-item>
          <el-submenu index="3-2">
            <span slot="title">日志管理</span>
            <el-menu-item index="3-2-1" :route="{name:'UserManager'}"><div class="barstyle" style="margin-left:-60px"></div>通用日志</el-menu-item>
            <el-menu-item index="3-2-2"><div class="barstyle" style="margin-left:-60px"></div>接口日志</el-menu-item>
            <el-menu-item index="3-2-3"><div class="barstyle" style="margin-left:-60px"></div>错误日志</el-menu-item>
          </el-submenu>
        </el-submenu>

        <el-submenu index="4">
          <template slot="title">
            <i class="el-icon-connection"></i>
            <span slot="title">资源管理</span>
          </template>
          <el-menu-item index="4-1" :route="{name:'Home'}"><div class="barstyle"></div>视频课程</el-menu-item>
          <el-menu-item index="4-2"><div class="barstyle"></div>文章资料</el-menu-item>
        </el-submenu>

      </el-menu>
    </div>
    <el-container class="controlPanel-mainbar" >
      <el-header height="55px">
        <i class="el-icon-s-fold" @click="CollapseTrue()" id="CollapseTrueIcon"></i>
        <i class="el-icon-s-unfold" @click="CollapseFalse()" id="CollapseFalseIcon"></i>
        <el-input
          placeholder="请输入搜索内容"
          v-model="input"
          size="small">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
        <div class="userinfo">

          <el-dropdown :hide-on-click="false">
            <div class="el-dropdown-link">
              圈主<i class="el-icon-arrow-down el-icon--right"></i>
            </div>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>首页</el-dropdown-item>
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>公众号</el-dropdown-item>
              <el-dropdown-item divided>退出系统</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <div class="avater"></div>
        </div>
      </el-header>
      <el-main>
        <el-scrollbar style="height:100%">
          <keep-alive>
            <router-view></router-view>
          </keep-alive>
        </el-scrollbar>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'topbar',
  data () {
    return {
      isCollapse: false,
      input: ''
    }
  },
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    },
    // 收起
    CollapseTrue () {
      this.isCollapse = true
      var show1 = document.getElementById('CollapseTrueIcon')
      var show2 = document.getElementById('CollapseFalseIcon')
      show2.style.display = 'block'
      show1.style.display = 'none'
    },
    // 展开
    CollapseFalse () {
      this.isCollapse = false
      var show1 = document.getElementById('CollapseTrueIcon')
      var show2 = document.getElementById('CollapseFalseIcon')
      show1.style.display = 'block'
      show2.style.display = 'none'
    }
  }
}
</script>

<style lang="scss" scoped>
  .controlPanel-sidebar {
    height: 100vh;
    .Title1 {
      background:rgb(32,34,42);
      width:219px;
      height:55px;
      border-bottom: 2px rgb(6,7,8) solid;
      span {
        display: block;
        text-align: center;
        font-weight: 300;
        font-size: 18px;
        color: white;
        font-family: 'YouYuan';
        padding-top: 15px;
      }
    }
    .Title2 {
      background:rgb(32,34,42);
      width:219px;
      height:55px;
      border-bottom: 2px rgb(6,7,8) solid;
      display: block;
      text-align: center;
      font-size: 18px;
      font-weight: bold;
      color: #fff;
      padding-top:15px;
    }
    .el-menu-vertical-demo {
      // width: 220px;
      min-height: 100%;
      height: 100%;
      .barstyle {
        width: 4px;
        background: #409EFF;
        height: 50px;
        float: left;
        margin-left: -40px;
        display: none;
      }

      /*左边导航栏具体样式*/
      .el-menu-vertical-demo.el-menu {
        background-color: #144A6A;
        color: #EEEEEE;
      }

      .el-submenu .el-menu-item, .el-menu-item {
        background-color: #0A3148;
        color: #EEEEEE;
      }
      .el-menu-item:hover {
        background: rgb(6,7,8) !important;
        color: #fff !important;
        i {
          color: #fff !important;
        }
        .barstyle {
          display: block;
        }
      }
      .el-menu-item.is-active {
        background: rgb(6,7,8) !important;
        .barstyle {
          display: block;
        }
      }
    }
    .el-menu-vertical-demo:not(.el-menu--collapse) {
      width: 220px;
    }
  }
  .controlPanel-mainbar {
    padding: 0px;
    height: 100vh;
    background: rgb(242,242,242);
    .el-header {
      background: white !important;
      .el-icon-s-fold {
        font-size: 28px;
        color: rgb(144,147,153);
        padding-top: 13px;
        display: block;
        width: 20px;
        float: left;
      }
      .el-icon-s-unfold {
        font-size: 28px;
        color: rgb(144,147,153);
        padding-top: 13px;
        display: none;
        width: 20px;
        float: left;
      }
      .el-input {
        width:250px;
        padding-left: 30px;
        padding-top: 12px;
        .el-button {
          padding-left: 13px;
          padding-right: 6px;
        }
      }
      .userinfo {
        float: right;
        .avater {
          width: 35px;
          height: 35px;
          background: rgb(56,161,242);
          -moz-border-radius: 50px;
          -webkit-border-radius: 50px;
          border-radius: 50px;
          margin-top: 10px;
          float: right;
          margin-right: 15px;
        }
        .el-dropdown {
          float: right;
          .el-dropdown-link {
            color: black !important;
            // float: right;
            margin-right: 5px;
            margin-top: 18px;
          }

        }
      }
    }
  }
</style>
<style>
  .controlPanel-sidebar .el-submenu i,span{
    color: rgba(255, 255, 255, 0.8) !important;
  }
  .controlPanel-sidebar .el-submenu i:hover,span:hover{
    color: #fff !important;
    background: rgb(6,7,8) !important;
  }
  .controlPanel-sidebar .el-submenu .el-submenu__title:hover{
    color: #fff !important;
    background: rgb(6,7,8) !important;

  }
  .controlPanel-sidebar .el-submenu .el-submenu__title.is-active {
    background: rgb(6,7,8) !important;
  }
</style>
