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
        <div v-if="tabPage === 'home'" class="home-page">
          <div class="notice">{{notice}}</div>
          <div class="flower-book">
            <div
              :key="index"
              class="flower-item"
              v-for="item, index in flowerList">
              <img src="" alt="">
              <div class="flower-info">
                <span>单价：{{item.price}}</span>
                <span>剩余量：{{item.total}}</span>
                <span class="add-btn" @click="addOrder(item)">加入购物车</span>
              </div>
            </div>
          </div>
          <div class="pagination-bar">
            <Page :total="100" show-elevator show-total/>
          </div>
        </div>
        <div v-else-if="tabPage === 'car'" class="car-page">
          <div id="car-table" class="car-table">
            <Table :height="tableHeight" ref="selection" :columns="columns" :data="carFlowerList">
              <template slot-scope="{ row }" slot="img">
                <img class="flower-pic" :src="row.img" alt="">
              </template>
              <template slot-scope="{ row, index }" slot="num">
                <Button size="small" icon="ios-remove" shape="circle"></Button>
                {{row.num}}
                <Button size="small" icon="ios-add" shape="circle"></Button>
              </template>
              <template slot-scope="{ row, index }" slot="action">
                <Button type="error" size="small" icon="ios-trash" shape="circle"></Button>
              </template>
            </Table>
          </div>
          <div class="car-result">
            <span>合计: </span>
            <Button >结算</Button>
          </div>
        </div>
        <div v-else-if="tabPage === 'order'" class="order-page">
          <div class="order-table">
            <div
              class="order-item"
              :key="index"
              v-for="item, index in orderFlowerList">
              <div class="left-table">
                <Table :columns="orderColumns" :data="item.carFlowerList">
                  <template slot-scope="{ row }" slot="img">
                    <img class="flower-pic" :src="row.img" alt="">
                  </template>
                </Table>
              </div>
              <div class="right-info">
              </div>
            </div>
          </div>
        </div>
        <div v-else-if="tabPage === 'info'" class="info-page">
          <Form :model="infoForm" :label-width="120" label-position="right">
            <FormItem label="用户名">
              <Input v-model="infoForm.userName" type="text"/>
            </FormItem>
            <FormItem label="密码">
              <Input v-model="infoForm.password" type="password"/>
            </FormItem>
            <FormItem label="确认密码">
              <Input v-model="infoForm.rePassword" type="password"/>
            </FormItem>
            <FormItem label="真实姓名">
              <Input v-model="infoForm.realName" type="text"/>
            </FormItem>
            <FormItem label="电话">
              <Input v-model="infoForm.phone" type="text"/>
            </FormItem>
            <FormItem label="地址">
              <Input v-model="infoForm.address" type="text"/>
            </FormItem>
            <FormItem>
              <Button class="one-btn" type="primary">保存</Button>
            </FormItem>
          </Form>
        </div>
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
      tabPage: 'home',
      tableHeight: 600,
      // 主页
      notice: '公告',
      noticeList: [],
      flowerList: [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}],
      // 购物车
      columns: [
        {
          type: 'selection',
          width: 60,
          align: 'center'
        },
        {
          title: '',
          slot: 'img',
          align: 'center'
        },
        {
          title: '名称',
          key: 'name',
          align: 'center'
        },
        {
          title: '详情',
          key: 'babel',
          align: 'center'
        },
        {
          title: '数量',
          key: 'num',
          slot: 'num',
          align: 'center'
        },
        {
          title: '总价',
          key: 'total',
          align: 'center'
        },
        {
          title: '操作',
          key: 'action',
          slot: 'action',
          align: 'center'
        }
      ],
      carFlowerList: [{}, {}, {}, {}, {}],
      // 订单
      orderColumns: [
        {
          title: '',
          slot: 'img',
          align: 'center'
        },
        {
          title: '名称',
          key: 'name',
          align: 'center'
        },
        {
          title: '详情',
          key: 'babel',
          align: 'center'
        },
        {
          title: '单价',
          key: 'price',
          align: 'center'
        },
        {
          title: '总价',
          key: 'total',
          align: 'center'
        }
      ],
      orderFlowerList: [
        {
          carFlowerList: [{}, {}, {}, {}, {}]
        },
        {
          carFlowerList: [{}, {}, {}, {}, {}]
        },
        {
          carFlowerList: [{}, {}, {}, {}, {}]
        },
        {
          carFlowerList: [{}, {}, {}, {}, {}]
        },
        {
          carFlowerList: [{}, {}, {}, {}, {}]
        }
      ],
      // 个人信息
      infoForm: {
        userName: '',
        password: '',
        rePassword: '',
        realName: '',
        phone: '',
        address: ''
      }
    }
  },
  watch: {
  },
  methods: {
    tabChange (val) {
      console.log(val)
      if (val === this.tabPage) return
      this.tabPage = val
      switch (val) {
        case 'home': {
          break
        }
        case 'car': {
          this.$nextTick(() => {
            this.tableHeight = document.getElementById('car-table').clientHeight
          })
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
    },
    addOrder (obj) {

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
        float: left;
        margin-top: 8px;
        list-style: none;
        width: calc(~'100% - 272px');
        height: 32px;
        line-height: 32px;
        background-color: rgba(255, 255, 255, 0.2);
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
      .home-page {
        .notice {
          padding: 0 8px;
          height: 32px;
          line-height: 32px;
          color: #fff;
          border: 1px solid #ccc;
          background-color: rgba(200, 255, 200, 0.3);
          margin-bottom: 16px;
        }
        .flower-book {
          margin-bottom: 16px;
          height: calc(~'100% - 96px');
          border-top: 1px solid #ccc;
          overflow: auto;
          .flower-item {
            margin: 16px 16px 0 12px;
            float: left;
            width: 320px;
            >img {
              display: block;
              cursor: pointer;
              width: 320px;
              height: 320px;
              border: 1px solid #ccc;
              border-radius: 2px;
              &:hover {
                border: 1px solid #fff;
              }
            }
            .flower-info {
              padding: 8px 0 0 8px;
              height: 24px;
              line-height: 24px;
              font-size: 14px;
              >span {
                margin-right: 20px;
              }
              .add-btn {
                display: inline-block;
                cursor: pointer;
                float: right;
                margin-right: 0;
                padding: 0 8px;
                border: 1px solid #fff;
                border-radius: 8px;
                &:hover {
                  border-color: green;
                  color: green;
                }
              }
            }
          }
        }
        .pagination-bar {
          text-align: right;
        }
      }
      .car-page {
        .car-table {
          margin-bottom: 16px;
          height: calc(~'100% - 64px');
          .flower-pic {
            margin-top: 5px;
            display: inline-block;
            width: 65px;
            height: 65px;
            background-color: yellow;
          }
        }
        .car-result {
          padding: 8px 16px;
          height: 48px;
          color: #000;
          text-align: right;
          background-color: #fff;
          >span:first-child {
            font-size: 14px;
            font-weight: bold;
            margin-right: 32px;
          }
        }
      }
      .order-page {
        .order-table {
          height: 100%;
          overflow: auto;
          .order-item {
            overflow: hidden;
            background-color: rgba(255, 255, 255, 0.8);
            margin-bottom: 16px;
            &:last-child {
              margin-bottom: 0;
            }
            .left-table {
              float: left;
              width: calc(~'100% - 160px');
              .flower-pic {
                margin-top: 5px;
                display: inline-block;
                width: 65px;
                height: 65px;
                background-color: yellow;
              }
            }
            .right-info {
              float: right;
              display: inline-block;
              width: 160px;
              background-color: antiquewhite;
            }
          }
        }
      }
      .info-page {
        padding: 48px 464px 0 8px;
        .ivu-form-item{
          margin-bottom: 32px;
          .ivu-form-item-label {
            padding-right: 16px;
            color: #fff;
          }
          .one-btn {
            margin-left: 30%;
            width: 30%;
          }
        }
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
