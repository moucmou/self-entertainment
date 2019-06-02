<template>
  <div class="flower">
    <div class="logo">
      <span class="logo-img"></span><span class="logo-title">创意花坊</span>
    </div>
    <div class="contain">
      <div class="tab-class">
        <slot name="tabClass"></slot>
      </div>
      <div class="left">
        <slot name="leftContain"></slot>
      </div>
      <div class="right">
        <span class="title">周介绍</span>
        <div class="flower-page"></div>
        <span class="flower-name">玫瑰</span>
        <p class="flower-babel">玫瑰代表爱情，不同颜色、朵数的玫瑰还另有吉意。</p>
      </div>
    </div>
    <div class="foot">© 2019 Flower Cap</div>
  </div>
</template>

<script>
export default {
  name: 'Flower',
  components: {},
  data () {
    return {
    }
  },
  watch: {
  },
  methods: {
  },
  created () {
  },
  mounted () {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="less">
.flower {
  position: relative;
  top: 0;
  left: 0;
  margin: 0 auto;
  width: 1376px;
  height: 100%;
  color: #fff;
  background-color: rgba(255, 255, 255, 0.2);
  .logo {
    height: 64px;
    background-color: #555;
    padding-left: 16px;
    >span {
      float: left;
      margin-left: 16px;
      height: 64px;
      line-height: 64px;
      font-size: 20px;
      font-weight: bold;
      &:first-child {
        width: 135px;
        border: 1px solid transparent;
        border-radius: 80px;
        background-size: 50%, 50%;
        background-image: url('../assets/logo.jpg');
      }
    }
  }
  .contain {
    margin-top: 16px;
    height: calc(~'100% - 112px');
    background-color: rgba(255, 255, 255, 0.3);
    .tab-class {
      padding-left: 8px;
      padding-right: 8px;
      height: 48px;
      border: 1px solid #fff;
      ul.left {
        float: left;
        margin-top: 8px;
        list-style: none;
        width: calc(~'100% - 328px');
        height: 32px;
        line-height: 32px;
        background-color: rgba(255, 255, 255, 0.2);
        >li {
          float: left;
          cursor: pointer;
          padding-left: 16px;
          &.active, &:hover {
            color: #fdfcf0;
            font-size: 18px;
            font-weight: bold;
          }
          &:before {
            content: '';
            padding-right: 16px;
            border-left: 1px solid #fff;
          }
        }
        >li:first-child:before{
          content: '';
          padding-right: 0;
          border: none;
        }
      }
      .ivu-input-type {
        margin-right: 56px;
        float: right;
        margin-top: 8px;
        width: 240px;
      }
    }
    >.left {
      float: left;
      width: calc(~'100% - 272px');
      height: calc(~'100% - 48px');
      background-color: rgba(255, 255, 255, 0.2);
      >div {
        padding: 16px;
        height: 100%;
      }
    }
    >.right {
      float: right;
      width: 256px;
      height: calc(~'100% - 48px');
      background-color: rgba(255, 255, 255, 0.3);
      .title {
        padding-left: 16px;
        height: 48px;
        line-height: 48px;
        font-size: 18px;
        font-weight: bold;
      }
      .flower-page {
        height: 350px;
        background: url('../assets/rose.png') center center no-repeat;
      }
      .flower-name {
        display: block;
        font-size: 16px;
        font-weight: bold;
        line-height: 32px;
        text-align: center;
      }
      .flower-babel {
        padding: 0 16px;
        font-size: 14px;
        text-align: center;
      }
    }
  }
  .foot {
    position: absolute;
    bottom: 0;
    width: 100%;
    height: 32px;
    padding-right: 16px;
    line-height: 32px;
    font-size: 14px;
    text-align: right;
    background-color: rgba(255, 255, 255, 0.5);
  }
}
</style>
