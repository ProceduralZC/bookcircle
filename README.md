# bookcircle
扫码加微信（微信ID：mmlz6879），备注书圈，进群讨论。

![个人微信](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/6941970c818d4d4a9737a36bca26a9e8~tplv-k3u1fbpfcp-zoom-1.image)

## 项目介绍

书圈是一个前后端分离的书籍分享管理系统，项目采用 SpringBoot+Vue 开发，项目计划加入常见的企业级应用所涉及到的技术点，例如 Redis、RabbitMQ 等。


- 项目地址：暂无
- [项目部署视频教程]()

### 项目技术栈

#### 后端技术栈

1. Spring Boot
2. Spring Shiro
3. MyBatis
4. MySQL
5. Redis
6. RabbitMQ
7. Spring Cache
8. WebSocket
9. ...

#### 前端技术栈

1. Vue
2. ElementUI
3. axios
4. vue-router
5. Vuex
6. WebSocket
7. vue-cli4
8. ...

### 项目效果图

下载代码后本地启动

## 快速部署

1. clone 项目到本地 `https://github.com/ProceduralZC/bookcircle.git`
2. 数据库脚本使用 Flyway 管理，**不需要手动导入数据库脚本**，只需要提前在本地 MySQL 中创建一个空的数据库 ，并修改项目中关于数据的配置（resources 目录下的 application.properties 文件中）即可
3. 在 IntelliJ IDEA 中打开 项目


**OK，至此，服务端就启动成功了，此时我们直接在地址栏输入 `http://localhost:8081/index.html` 即可访问我们的项目，如果要做二次开发，请继续看第4步。**

4. 进入到vuehr目录中，在命令行依次输入如下命令：

```
# 安装依赖
npm install

# 在 localhost:8080 启动项目
npm run serve
```

由于我在 项目中已经配置了端口转发，将数据转发到 Spring Boot 上，因此项目启动之后，在浏览器中输入 `http://localhost:8080` 就可以访问我们的前端项目了，所有的请求通过端口转发将数据传到 Spring Boot 中（注意此时不要关闭 Sprin gBoot 项目）。


## 文档
**Spring Boot + Vue 前后端分离**

* [Spring Boot + Vue前后端分离（一）前端Vue环境搭建](https://mp.weixin.qq.com/s/xgYwKS_ASDZpnr7LOeOyIQ)

* [Spring Boot + Vue前后端分离（二）前端Vue启动流程](https://mp.weixin.qq.com/s/cK-vsutSJ_hE2dRe7qdSwA)

* [Spring Boot + Vue前后端分离（三）实现登录功能](https://mp.weixin.qq.com/s/gy6mxTgySb-G4H6cMlrIgQ)

* [Spring Boot + Vue前后端分离（四）前端路由](https://mp.weixin.qq.com/s/vRpMabEM1axqB_CpEYvd5w)

* [Spring Boot + Vue前后端分离（五）登录拦截器](https://mp.weixin.qq.com/s/rysn5d8g7d-alDgTMG3i6g)

* [Spring Boot + Vue前后端分离（六）使用Element渲染登录界面](https://mp.weixin.qq.com/s/QTY4dGm3dZINSzgLXdbElQ)

* [Spring Boot + Vue前后端分离（七）后端系统，功能导航页](https://mp.weixin.qq.com/s/xb3wKPEtQSOOsMU5Fo_u6w)

* [Spring Boot + Vue前后端分离（八）权限数据库设计](https://mp.weixin.qq.com/s/anyTXnMp-9PswnIkZ9XNpQ)

* [Spring Boot + Vue前后端分离（九）使用Shiro实现用户信息加密](https://mp.weixin.qq.com/s/HrUn5TUy25-_tYIk6ytLkQ)

* [Spring Boot+ Vue前后端分离（十）使用Shiro实现登录认证](https://mp.weixin.qq.com/s/8PDhivGubGMMcex8KF22Lg)


### 更新记录

### 2020.8.23 更新
更新项目描述说明，启动等

#### 相关文档：
查看各个步骤文章

### 公众号

如果大家想要实时关注我更新的文章以及分享的干货的话，可以关注我的公众号。

**有关学习视频和面试资料，[公众号](#公众号：程序员漫画编程)后台回复 **"学习资料"** 即可免费领取！公众号[ 程序员漫画编程 ]

![我的公众号](https://img-blog.csdnimg.cn/20201009212156961.jpeg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2ppYW5wZW5neHVleGlrYWlmYQ==,size_16,color_FFFFFF,t_70)
