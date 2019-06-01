import Vue from 'vue'
import App from './App.vue'
import router from './router'

import iView from 'iview'
import 'iview/dist/styles/iview.css'
import axios from 'axios'
import qs from 'querystring'

// iView 组件库 引用
Vue.use(iView)

// axios ajaxhttp请求
const baseUrl = '/flowerhouse'
Vue.prototype.$http = axios.create({
  baseURL: baseUrl,
  headers: {
    post: { 'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8' }
  },
  validateStatus: function (status) {
    return status >= 200 && status < 300
  },
  transformRequest: [function (data) {
    data = qs.stringify(data)
    return data
  }],
  transformResponse: [function (data) {
    try {
      data = JSON.parse(data)
      if (data.code === 2170914 || data.code === 2183170) {
        // window.location.reload()
      } else if (data.code === '0x00235005') {
        Vue.prototype.$Message.error({
          showClose: true,
          duration: 0,
          message: data.msg
        })
      } else {
        return data
      }
    } catch (error) {
      return data
    }
  }]
})

// 添加请求拦截器
Vue.prototype.$http.interceptors.request.use(function (config) {
  // 在发送请求之前做某事
  return config
}, function (error) {
  // 请求错误时做些事
  Vue.prototype.$Message.error('服务器异常，请联系管理员！')
  return Promise.reject(error)
})

// 添加响应拦截器
Vue.prototype.$http.interceptors.response.use(function (response) {
  // 对响应数据做些事
  return response
}, function (error) {
  // 请求错误时做些事
  if (error && error.request && error.request.status === 0) {
    if (error.config.url.indexOf('loadapp') > -1) {
      Vue.prototype.$Message.error('请求超时，请确认已安装播放器！')
    } else {
      Vue.prototype.$Message.error('请求超时或服务器异常，请检查网络或联系管理员！')
    }
  } else {
    Vue.prototype.$Message.error('服务器异常，请联系管理员！')
  }
  return Promise.reject(error)
})

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
