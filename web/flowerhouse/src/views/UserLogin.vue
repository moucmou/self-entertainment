<template>
  <Flower class="user-login">
    <template slot="tabClass">
      <ul class="left" :class="{lleft: tabPage !== 'home'}">
        <li :class="{active: tabPage === 'home'}" @click="tabChange('home')">主页</li>
        <li :class="{active: tabPage === 'car'}" @click="tabChange('car')">购物车</li>
        <li :class="{active: tabPage === 'order'}" @click="tabChange('order')">订单</li>
        <li :class="{active: tabPage === 'info'}" @click="tabChange('info')">个人信息</li>
      </ul>
      <Input v-if="tabPage === 'home'" search placeholder="Enter something..."/>
    </template>
    <template slot="leftContain">
      <div v-if="tabPage === 'home'" class="home-page">
        <div class="notice">{{notice}}</div>
        <div class="flower-book">
          <div
            :key="index"
            class="flower-item"
            v-for="(item, index) in flowerList">
            <img :src="item.picUrl" alt="">
            <div class="flower-info">
              <span>单价：{{item.flowerOutprice}}</span>
              <span>剩余量：{{item.flowerNumber}}</span>
              <span class="add-btn" @click="addToCar(item.flowerId, 1)">加入购物车</span>
            </div>
          </div>
        </div>
        <!--<div class="pagination-bar">-->
          <!--<Page :total="100" show-elevator show-total/>-->
        <!--</div>-->
      </div>
      <div v-else-if="tabPage === 'car'" class="car-page">
        <div id="car-table" class="car-table">
          <Table
            :height="tableHeight"
            ref="selection"
            :columns="columns"
            :data="carFlowerList"
            @on-selection-change="selectionChange">
            <template slot-scope="{row}" slot="img">
              <img class="flower-pic" :src="row.picUrl" alt="">
            </template>
            <template slot-scope="{row}" slot="num">
              <Button :disabled="row.num === 1" size="small" icon="ios-remove" shape="circle" @click="addToCar(row.flowerId, row.flowerNumber - 1, true)"></Button>
              {{row.flowerNumber}}
              <Button size="small" icon="ios-add" shape="circle" @click="addToCar(row.flowerId, row.flowerNumber + 1, true)"></Button>
            </template>
            <template slot-scope="{row}" slot="total">
              {{row.flowerNumber * row.flowerOutprice}}
            </template>
            <template slot-scope="{row}" slot="action">
              <Button type="error" size="small" icon="ios-trash" shape="circle" @click="delFormCar(row.flowerId)"></Button>
            </template>
          </Table>
        </div>
        <div class="car-result">
          <span>合计: {{priceTotal}}</span>
          <Button :disabled="selectionList.length === 0" @click="createOrder">结算</Button>
        </div>
      </div>
      <div v-else-if="tabPage === 'order'" class="order-page">
        <div class="order-table">
          <div
            class="order-item"
            :key="index"
            v-for="(item, index) in orderFlowerList">
            <div class="left-table">
              <Table :columns="orderColumns" :data="item.list">
                <template slot-scope="{ row }" slot="img">
                  <img class="flower-pic" :src="row.picUrl" alt="">
                </template>
                <template slot-scope="{row}" slot="total">
                  {{row.flowerNumber * row.flowerOutprice}}
                </template>
              </Table>
            </div>
            <div class="right-info">
              <p>订单号：{{item.orderId}}</p>
              <!--<p>订单总价：{{item.orderPs}}</p>-->
              <p>下单时间：{{item.orderTime}}</p>
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
            <Input v-model="infoForm.name" type="text"/>
          </FormItem>
          <FormItem label="电话">
            <Input v-model="infoForm.userPhone" type="text"/>
          </FormItem>
          <FormItem label="地址">
            <Input v-model="infoForm.userAddress" type="text"/>
          </FormItem>
          <FormItem>
            <Button class="one-btn" type="primary" @click="userUpdate">保存</Button>
          </FormItem>
        </Form>
      </div>
    </template>
  </Flower>
</template>

<script>
import moment from 'moment'
import Flower from './Flower'
export default {
  name: 'UserLogin',
  components: {
    Flower
  },
  data () {
    return {
      tabPage: 'home',
      tableHeight: 600,
      timer: null,
      // 主页
      notice: '公告',
      noticeList: [],
      flowerList: [],
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
          key: 'flowerName',
          align: 'center'
        },
        {
          title: '单价',
          key: 'flowerOutprice',
          align: 'center'
        },
        {
          title: '数量',
          key: 'flowerNumber',
          slot: 'num',
          align: 'center'
        },
        {
          title: '总价',
          slot: 'total',
          align: 'center'
        },
        {
          title: '操作',
          slot: 'action',
          align: 'center'
        }
      ],
      carFlowerList: [],
      priceTotal: 0,
      selectionList: [],
      // 订单
      orderColumns: [
        {
          title: '',
          slot: 'img',
          align: 'center'
        },
        {
          title: '名称',
          key: 'flowerName',
          align: 'center'
        },
        {
          title: '单价',
          key: 'flowerOutprice',
          align: 'center'
        },
        {
          title: '数量',
          key: 'flowerNumber',
          align: 'center'
        },
        {
          title: '总价',
          slot: 'total',
          align: 'center'
        }
      ],
      orderFlowerList: [],
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
      if (val === this.tabPage) return
      this.tabPage = val
      switch (val) {
        case 'home': {
          this.getFlowers()
          break
        }
        case 'car': {
          this.$nextTick(() => {
            this.tableHeight = document.getElementById('car-table').clientHeight
          })
          this.getCar()
          break
        }
        case 'order': {
          this.getOrder()
          break
        }
        case 'info': {
          this.getUser()
          break
        }
        default:
      }
    },
    // 公告
    getNotice () {
      this.$http.post('/anon/getNotice').then((res) => {
        if (res.code === '0') {
          this.noticeList = res.data
          this.notice = this.noticeList[0]
          this.noticeList.pop()
          this.timer = setInterval(() => {
            this.notice = this.noticeList[0]
            this.noticeList.pop()
          }, 10000)
        } else {
          this.$Message.error(res.msg)
        }
      }).catch((err) => {
        console.error(err)
      })
    },
    // 主页
    getFlowers () {
      this.$http.post('/anon/getAllFlowers', {
        pageNo: 1,
        pageSize: 9999
      }).then((res) => {
        if (res.code === '0') {
          this.flowerList = res.data.content
        } else {
          this.$Message.error(res.msg)
        }
      }).catch((err) => {
        console.error(err)
      })
    },
    addToCar (flowerId, num, flag) {
      this.$http.post('/user/addToCar', {
        flowerId: flowerId,
        number: num
      }).then((res) => {
        if (res.code === '0') {
          this.$Message.success('添加购物车成功')
          flag && this.getCar()
        } else {
          this.$Message.error(res.msg)
        }
      }).catch((err) => {
        console.error(err)
      })
    },
    // 购物车
    getCar () {
      this.$http.post('/user/getCar').then((res) => {
        if (res.code === '0') {
          this.carFlowerList = res.data.content
        } else {
          this.$Message.error(res.msg)
        }
      }).catch((err) => {
        console.error(err)
      })
    },
    delFormCar (flowerId) {
      this.$http.post('/user/delFromCar', {
        flowerId: flowerId
      }).then((res) => {
        if (res.code === '0') {
          this.$Message.success('删除成功')
          this.getCar()
        } else {
          this.$Message.error(res.msg)
        }
      }).catch((err) => {
        console.error(err)
      })
    },
    selectionChange (selection) {
      this.priceTotal = 0
      selection.forEach(item => {
        this.priceTotal += item.flowerOutprice * item.flowerNumber
      })
      this.selectionList = selection
    },
    createOrder () {
      this.$http.post('/user/createOrder', {
        ids: this.selectionList.map(item => item.flowerId)
      }).then((res) => {
        if (res.code === '0') {
          this.$Message.success('下单成功')
          this.getCar()
        } else {
          this.$Message.error(res.msg)
        }
      }).catch((err) => {
        console.error(err)
      })
    },
    // 订单
    getOrder () {
      this.$http.post('/user/getOrder', {
        pageNo: 1,
        pageSize: 9999
      }).then((res) => {
        if (res.code === '0') {
          this.orderFlowerList = res.data.content.map(item => {
            item.orderTime = moment(new Date(item.orderTime)).format('YYYY-MM-DD')
            return item
          })
        } else {
          this.$Message.error(res.msg)
        }
      }).catch((err) => {
        console.error(err)
      })
    },
    // 个人信息
    getUser () {
      this.$http.post('/user/getUser').then((res) => {
        if (res.code === '0') {
          this.infoForm = res.data
          this.infoForm.rePassword = res.data.password
        } else {
          this.$Message.error(res.msg)
        }
      }).catch((err) => {
        console.error(err)
      })
    },
    userUpdate () {
      if (this.infoForm.password !== this.infoForm.rePassword) {
        this.$Message.error('两次密码不一致')
        return
      }
      this.$http.post('/user/update', Object.assign(this.infoForm, {
        role: 0
      })).then((res) => {
        if (res.code === '0') {
          this.$Message.success('保存成功')
        } else {
          this.$Message.error(res.msg)
        }
      }).catch((err) => {
        console.error(err)
      })
    }
  },
  created () {
  },
  mounted () {
    this.getNotice()
    this.getFlowers()
  },
  destroyed () {
    this.timer && this.timer.close()
  }
}
</script>

<style lang="less">
.user-login {
  .lleft {
    width: 100% !important;
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
      padding-bottom: 8px;
      height: calc(~'100% - 48px');
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
    /*.pagination-bar {*/
      /*text-align: right;*/
    /*}*/
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
        background-color: #ccc;
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
            background-color: #ccc;
          }
        }
        .right-info {
          float: right;
          display: inline-block;
          font-size: 14px;
          font-weight: bold;
          color: #333;
          width: 160px;
          background-color: antiquewhite;
        }
      }
    }
  }
  .info-page {
    padding: 48px 464px 0 8px !important;
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
</style>
