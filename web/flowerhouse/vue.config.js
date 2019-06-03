module.exports = {
  devServer: {
    proxy: {
      '/user': {
        target: 'http://10.16.80.22:8080',
        changeOrigin: true
      },
      '/admin': {
        target: 'http://10.16.80.22:8080',
        changeOrigin: true
      },
      '/anon': {
        target: 'http://10.16.80.22:8080',
        changeOrigin: true
      }
    }
  }
}
