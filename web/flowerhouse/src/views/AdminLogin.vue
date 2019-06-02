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
      <div v-else-if="tabPage === 'product'" class="product-page">
      </div>
      <div v-else-if="tabPage === 'notice'" class="notice-page">
        <Form :model="noticeForm" :label-width="120" label-position="right">
          <FormItem label="公告内容">
            <Input v-model="noticeForm.msg" type="textarea" :rows="4"/>
          </FormItem>
          <FormItem>
            <Button class="one-btn" type="primary">保存</Button>
          </FormItem>
        </Form>
      </div>
    </template>
  </Flower>
</template>

<script>
import Flower from './Flower'
export default {
  name: 'AdminLogin',
  components: {
    Flower
  },
  data () {
    return {
      tabPage: 'product',
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
      // 公告
      noticeForm: {
        msg: ''
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
          break
        }
        case 'product': {
          break
        }
        case 'notice': {
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
  .product-page {
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
