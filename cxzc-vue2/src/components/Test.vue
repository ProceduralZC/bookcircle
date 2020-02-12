<template>
  <el-container>
    <!--顶部-->
    <el-header style="border-bottom: 1px solid gray;background-color: #ffffff;">
      <el-row style="margin: 15px 15px">
        <el-col :span="1">
          <!--收缩条-->
          <a href="#" @click="changeCollapse" style="font-size: 25px;color:#909399;"><i
            :class="collpaseIcon"></i></a>
        </el-col>
      </el-row>
    </el-header>
    <!--中央区域-->
    <el-main>
      <el-container>
        <!--左侧导航栏-->
        <el-aside :style="{width:collpaseWidth}">
          <!--default-active代表导航栏默认选中哪个index, :collapse决定导航栏是否展开，为boolean类型
          :router决定导航栏是否开启路由模式，即在菜单item上设置路由是否生效，值为boolean类型-->
          <el-menu
            default-active="0"
            class="el-menu-vertical-demo"
            :collapse="isCollapse"
            :router="true"
          >
            <!--index设置当前item的下标，:route则是传一个对象进行，指定路由-->
            <el-menu-item index="0" :route="{name:'Home'}">
              <i class="el-icon-help"></i>
              <span slot="title" style="color: #ffffff;"> 首页</span>
            </el-menu-item>

            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-setting"></i><span style="color: #ffffff;"> 系统管理</span>
              </template>

              <el-menu-item index="/UserManager" :route="{name:'UserManager'}"><i class="el-icon-user"></i> 用户管理
              </el-menu-item>
              <el-menu-item index="1-2"><i class="el-icon-user"></i> 角色管理</el-menu-item>
              <el-menu-item index="1-2"><i class="el-icon-eleme"></i> 菜单管理</el-menu-item>
            </el-submenu>

            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-camera"></i>
                <span style="color: #ffffff;"> 系统监控</span>
              </template>

              <el-menu-item index="2-1" :route="{name:'UserManager'}"><i class="el-icon-s-custom"></i>
                在线用户
              </el-menu-item>
              <el-menu-item index="2-2"><i class="el-icon-s-marketing"></i> 定时任务</el-menu-item>
            </el-submenu>

          </el-menu>

        </el-aside>
        <!--主内容显示区域-->
        <el-main>
          <!--路由渲染-->
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-main>
    <!--底部-->
<!--    <el-footer style="border-top: 1px solid gray"></el-footer>-->
  </el-container>
</template>

<script>
// 这一大段JS就是为了做收缩/展开导航栏而用的！
export default {
  name: 'Main',
  data: function () {
    return {
      isCollapse: false// 决定左侧导航栏是否展开
    }
  },
  computed: {
    collpaseIcon: function () { // 左侧导航栏是否展开状态的图标
      // 如果是展开状态就图标向右，否则图标向左
      return this.isCollapse ? 'el-icon-s-fold' : 'el-icon-s-unfold'
    },
    collpaseWidth: function () { // 左侧导航栏是否展开状态的宽度
      // 如果是展开状态就导航栏宽度为65px，否则200px
      return this.isCollapse ? '65px' : '200px'
    }
  },
  methods: {
    changeCollapse: function () { // 更改左侧导航栏展示状态
      this.isCollapse = !this.isCollapse
    }
  }
}
</script>

<style scoped>
  /*整体显示区域布局样式*/
  .el-container {
    height: 100%;
  }

  .el-header, .el-main {
    padding: 0;
  }

  /*左边导航栏具体样式*/
  .el-menu-vertical-demo.el-menu {
    padding-left: 10px;
    text-align: left;
    height: 100%;
    padding: 0;
    background-color: #144A6A;
    color: #EEEEEE;
  }

  el-container > .el-menu-vertical-demo.el-menu {
    padding: 0;
  }

  .el-submenu .el-menu-item, .el-menu-item {
    min-width: 50px;
    background-color: #0A3148;
    color: #EEEEEE;
  }

  .el-menu-item {
    padding: 0;
  }
</style>
