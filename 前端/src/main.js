import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import "@/assets/text/text.css"
import * as echarts from 'echarts'

const app = createApp(App).use(store).use(router)

app.config.globalProperties.$echarts = echarts

app.mount('#app')
/* createApp(App).use(store).use(router).mount('#app')
 */
