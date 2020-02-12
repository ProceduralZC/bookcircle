<template>
  <div id="app">
    <!--<img src="./assets/ewm.png">-->
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  html, body, #app {
  text-align: center;
  color: #2c3e50;
  height: 100%;
  width: 100%;
  margin: 0;
  padding: 0;
  /*margin-top: 60px;*/
}
</style>
