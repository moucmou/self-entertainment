<template>
  <div class="flower">
    <div class="logo">
      <span class="logo-img"></span><span class="logo-title">创意花坊</span>
    </div>
    <div class="contain">
      <div class="tab-class">
        <ul class="left">
          <li :class="{active: tabPage === 'home'}" @click="tabChange('home')">主页</li>
          <li :class="{active: tabPage === 'car'}" @click="tabChange('car')">购物车</li>
          <li :class="{active: tabPage === 'order'}" @click="tabChange('order')">订单</li>
          <li :class="{active: tabPage === 'info'}" @click="tabChange('info')">个人信息</li>
        </ul>
        <Input search placeholder="Enter something..."/>
      </div>
      <div class="left">
        <div v-if="tabPage === 'home'" class="home-page">home</div>
        <div v-else-if="tabPage === 'car'" class="car-page">car</div>
        <div v-else-if="tabPage === 'order'" class="order-page">order</div>
        <div v-else-if="tabPage === 'info'" class="info">info</div>
      </div>
      <div class="right"></div>
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
      tabPage: 'home',
      userInfo: {}
    }
  },
  watch: {
  },
  methods: {
    tabChange (val) {
      if (val === this.tabPage) return
      this.tabPage = val
      switch (val) {
        case 'home': {
          break
        }
        case 'car': {
          break
        }
        case 'order': {
          break
        }
        case 'info': {
          break
        }
        default:
      }
    }
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
      padding-right: 64px;
      height: 48px;
      border: 1px solid #fff;
      ul.left {
        margin-top: 8px;
        list-style: none;
        height: 32px;
        line-height: 32px;
        >li {
          float: left;
          cursor: pointer;
          padding-left: 16px;
          &.active, &:hover {
            color: #fdfcf0;
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
        margin-top: 8px;
        width: 240px;
        float: right;
      }
    }
    .left {
      float: left;
      width: calc(~'100% - 272px');
      height: calc(~'100% - 48px');
      background-color: rgba(255, 255, 255, 0.2);
    }
    .right {
      float: right;
      width: 256px;
      height: calc(~'100% - 48px');
      background-color: rgba(255, 255, 255, 0.3);
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
