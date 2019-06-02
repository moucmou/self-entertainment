<template>
  <div class="home">
    <div class="login-register">
      <div class="title">创意花坊</div>
      <Tabs v-if="loginFlag" type="card" v-model="loginType">
        <TabPane label="用户登录" name="user" icon="md-person">
          <div class="form-class">
            <Form :model="loginForm" :label-width="80" label-position="left">
              <FormItem label="用户名">
                <Input v-model="loginForm.userName" type="text"/>
              </FormItem>
              <FormItem label="密码">
                <Input v-model="loginForm.password" type="password"/>
              </FormItem>
            </Form>
            <div class="btn-group-class">
              <Button class="two-btn" type="primary" @click="loginCon">登录</Button>
              <Button class="two-btn" type="primary" @click="register">注册</Button>
            </div>
          </div>
        </TabPane>
        <TabPane label="管理员登录" name="admin" icon="md-person">
          <div class="form-class">
            <Form :model="loginForm" :label-width="80" label-position="left">
              <FormItem label="用户名">
                <Input v-model="loginForm.userName" type="text"/>
              </FormItem>
              <FormItem label="密码">
                <Input v-model="loginForm.password" type="password"/>
              </FormItem>
            </Form>
            <div class="btn-group-class">
              <Button class="one-btn" type="primary">登录</Button>
            </div>
          </div>
        </TabPane>
      </Tabs>
      <Tabs v-else type="card" class="register-tabs" v-model="loginType">
        <TabPane label="用户注册" name="register" icon="md-person-add">
          <div class="form-class">
            <Form :model="registerForm" :label-width="80" label-position="left">
              <FormItem label="用户名">
                <Input v-model="registerForm.userName" type="text"/>
              </FormItem>
              <FormItem label="密码">
                <Input v-model="registerForm.password" type="password"/>
              </FormItem>
              <FormItem label="确认密码">
                <Input v-model="registerForm.rePassword" type="password"/>
              </FormItem>
              <FormItem label="真实姓名">
                <Input v-model="registerForm.realName" type="text"/>
              </FormItem>
              <FormItem label="电话">
                <Input v-model="registerForm.phone" type="text"/>
              </FormItem>
              <FormItem label="地址">
                <Input v-model="registerForm.address" type="text"/>
              </FormItem>
            </Form>
            <div class="btn-group-class">
              <Button class="two-btn" type="primary">注册</Button>
              <Button class="two-btn" @click="registerCancel">取消</Button>
            </div>
          </div>
        </TabPane>
      </Tabs>
    </div>
  </div>
</template>

<script>
export default {
  name: '',
  components: {},
  data () {
    return {
      loginFlag: true,
      loginType: 'user',
      loginForm: {
        userName: '',
        password: ''
      },
      registerForm: {
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
    loginType (val) {
      (val === 'admin' || val === 'user') && this.resetObj(this.loginForm)
    }
  },
  methods: {
    loginCon () {},
    register () {
      this.resetObj(this.registerForm)
      this.loginType = 'register'
      this.loginFlag = false
    },
    registerCancel () {
      this.resetObj(this.loginForm)
      this.loginType = 'user'
      this.loginFlag = true
    },
    resetObj (obj) {
      for (let key in obj) {
        obj.hasOwnProperty(key) && (obj[key] = '')
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
.home {
  position: relative;
  top: 0;
  left: 0;
  width: 100% !important;
  height: 100% !important;
  .login-register {
    position: absolute;
    top: 50%;
    left: 50%;
    width: 500px;
    transform: translate(-250px, -220px);
    border: 1px solid transparent;
    border-bottom: none;
    border-radius: 8px;
    background: transparent;
    .title {
      height: 64px;
      line-height: 64px;
      font-size: 24px;
      font-weight: bold;
      color: #fff;
      text-align: center;
    }
    .ivu-tabs-bar {
      margin-bottom: 0;
    }
    .ivu-tabs-nav {
      width: 100%;
      text-align: center;
      background-color: #ccc;
      border-radius: 8px 8px 0 0;
      .ivu-tabs-tab {
        width: 50%;
        margin-right: 0 !important;
        border: 1px solid transparent !important;
        border-radius: 8px 8px 0 0 !important;
        background-color: #ccc !important;
        &.ivu-tabs-tab-active {
          border: 1px solid transparent;
          background-color: #fff !important;
        }
      }
    }
    .register-tabs .ivu-tabs-tab {
      width: 100%;
      border-bottom: 1px solid #1d3c40 !important;
    }
    .ivu-tabs-content .ivu-tabs-tabpane>.form-class {
      padding: 32px 32px 16px;
      border: 1px solid #fff;
      border-radius: 0 0 8px 8px;
      background-color: #fff;
      .btn-group-class {
        margin-top: 32px;
        .one-btn {
          width: 100%;
        }
        .two-btn {
          width: calc(~'50% - 16px');
          &:last-child {
            margin-left: 32px;
          }
        }
      }
    }
  }
}
</style>
