<template>
  <Flower class="admin-login">
    <template slot="tabClass">
      <ul class="left" :class="{lleft: tabPage !== 'order'}">
        <li :class="{active: tabPage === 'order'}" @click="tabChange('order')">订单</li>
        <li :class="{active: tabPage === 'product'}" @click="tabChange('product')">产品</li>
        <li :class="{active: tabPage === 'notice'}" @click="tabChange('notice')">公告</li>
      </ul>
      <Input v-if="tabPage === 'order'" search placeholder="Enter something..."/>
    </template>
    <template slot="leftContain">
      <div v-if="tabPage === 'order'" class="aorder-page">
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
      <div v-else-if="tabPage === 'product'" class="product-page">
        <div id="product-table" class="product-table">
          <Table
            :columns="proColumns"
            :data="proFlowerList">
            <template slot-scope="{row}" slot="img">
              <img v-if="!row.editFlag" class="flower-pic" :src="row.picUrl" alt="">
              <input v-else id="file" type="file">
            </template>
            <template slot-scope="{row}" slot="flowerName">
              <span v-if="!row.editFlag">{{row.flowerName}}</span>
              <input v-else type="text" v-model="proForm.flowerName">
            </template>
            <template slot-scope="{row}" slot="flowerLanguage">
              <span v-if="!row.editFlag">{{row.flowerLanguage}}</span>
              <input v-else type="text" v-model="proForm.flowerLanguage">
            </template>
            <template slot-scope="{row}" slot="flowerInprice">
              <span v-if="!row.editFlag">{{row.flowerInprice}}</span>
              <input v-else type="number" v-model="proForm.flowerInprice">
            </template>
            <template slot-scope="{row}" slot="flowerOutprice">
              <span v-if="!row.editFlag">{{row.flowerOutprice}}</span>
              <input v-else type="number" v-model="proForm.flowerOutprice">
            </template>
            <template slot-scope="{row}" slot="flowerNumber">
              <span v-if="!row.editFlag">{{row.flowerNumber}}</span>
              <input v-else type="number" v-model="proForm.flowerNumber">
            </template>
            <template slot-scope="{row}" slot="action">
              <Button v-if="!row.editFlag" type="error" size="small" @click="downProduct(row.flowerId)">下架</Button>
              <Button v-else size="small" @click="upProduct">上架</Button>
            </template>
          </Table>
        </div>
      </div>
      <div v-else-if="tabPage === 'notice'" class="notice-page">
        <Form :model="noticeForm" :label-width="120" label-position="right">
          <FormItem label="公告内容">
            <Input v-model.trim="noticeForm.notice" type="textarea" :rows="4"/>
          </FormItem>
          <FormItem>
            <Button :disabled="noticeForm.notice === ''" class="one-btn" type="primary" @click="addNotice">发布</Button>
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
  name: 'AdminLogin',
  components: {
    Flower
  },
  data () {
    return {
      tabPage: 'order',
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
      // 产品
      proColumns: [
        {
          title: '',
          slot: 'img',
          align: 'center'
        },
        {
          title: '名称',
          key: 'flowerName',
          slot: 'flowerName',
          align: 'center'
        },
        {
          title: '花语',
          key: 'flowerLanguage',
          slot: 'flowerLanguage',
          align: 'center'
        },
        {
          title: '进价',
          key: 'flowerInprice',
          slot: 'flowerInprice',
          align: 'center'
        },
        {
          title: '单价',
          key: 'flowerOutprice',
          slot: 'flowerOutprice',
          align: 'center'
        },
        {
          title: '数量',
          key: 'flowerNumber',
          slot: 'flowerNumber',
          align: 'center'
        },
        {
          title: '操作',
          slot: 'action',
          align: 'center'
        }
      ],
      proFlowerList: [],
      proForm: {
        file: null,
        flowerInprice: 1,
        flowerOutprice: 1,
        flowerNumber: 1,
        flowerLanguage: '花语',
        flowerName: '花名'
      },
      // 公告
      noticeForm: {
        notice: ''
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
        case 'order': {
          this.getOrder()
          break
        }
        case 'product': {
          this.getProduct()
          break
        }
        case 'notice': {
          this.noticeForm.notice = ''
          break
        }
        default:
      }
    },
    // 订单
    getOrder () {
      this.$http.post('/admin/getAllOrder', {
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
    // 产品
    getProduct () {
      this.$http.post('/anon/getAllFlowers', {
        pageNo: 1,
        pageSize: 9999
      }).then((res) => {
        if (res.code === '0') {
          this.proFlowerList = res.data.content.concat({
            editFlag: true
          })
          this.proForm = {
            file: null,
            flowerInprice: 1,
            flowerOutprice: 1,
            flowerNumber: 1,
            flowerLanguage: '花语',
            flowerName: '花名'
          }
        } else {
          this.$Message.error(res.msg)
        }
      }).catch((err) => {
        console.error(err)
      })
    },
    upProduct () {
      try {
        let reader = new FileReader()
        reader.readAsDataURL(document.getElementById('file').files[0])
        reader.onload = () => {
          console.log(this.proForm)
          this.$http.post('/admin/addFlower', Object.assign(this.proForm, {
            file: reader.result
          })).then((res) => {
            if (res.code === '0') {
              this.$Message.success('上架成功')
              this.getProduct()
            } else {
              this.$Message.error(res.msg)
            }
          }).catch((err) => {
            console.error(err)
          })
        }
        reader.onerror = () => {
          this.$Message.error('图片上传失败')
        }
      } catch (e) {
        this.$Message.error('图片未选择或上传失败')
      }
    },
    downProduct (flowerId) {
      this.$http.post('/admin/delFlower', {
        flowerId: flowerId
      }).then((res) => {
        if (res.code === '0') {
          this.$Message.error('下架成功')
          this.getProduct()
        } else {
          this.$Message.error(res.msg)
        }
      }).catch((err) => {
        console.error(err)
      })
    },
    // 公告
    addNotice () {
      this.$http.post('/admin/addNoticce', this.noticeForm).then((res) => {
        if (res.code === '0') {
          this.$Message.success('发布成功')
          this.noticeForm.notice = ''
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
    this.getOrder()
  }
}
</script>

<style lang="less">
.admin-login {
  .lleft {
    width: 100% !important;
  }
  .aorder-page {
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
  .product-page {
    .product-table {
      height: 100%;
      overflow: auto;
      background-color: #fff;
      .flower-pic {
        margin-top: 5px;
        display: inline-block;
        width: 65px;
        height: 65px;
        background-color: #ccc;
      }
      input {
        width: 100%;
      }
    }
  }
  .notice-page {
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
