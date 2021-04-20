import Vue from 'vue'
import * as VueGoogleMaps from 'vue2-google-maps'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'



Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyCBm7oNFS6gCTFUEoylMOW5oAT1cgYYkcw',
    libraries: 'places',
  }
});


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
