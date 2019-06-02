module.exports = {
  devServer: {
    proxy: {
      '/user': {
        target: 'http://119.3.10.221:8080',
        changeOrigin: true
      },
      '/admin': {
        target: 'http://119.3.10.221:8080',
        changeOrigin: true
      },
      '/anon': {
        target: 'http://119.3.10.221:8080',
        changeOrigin: true
      }
    }
  }
}
