<template>
  <div id="app">
    <keep-alive :include="[]">
      <router-view></router-view>
    </keep-alive>
  </div>
</template>

<style lang="less">
* {
  padding: 0;
  margin: 0;
}
html {
  width: 100%;
  height: 100%;
  body {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    font-size: 12px;
    color: #2c3e50;
    width: 100%;
    height: 100%;
    #app {
      width: 100%;
      height: 100%;
      background: url("./assets/home_bg.jpg") no-repeat;
    }
  }
}
</style>
