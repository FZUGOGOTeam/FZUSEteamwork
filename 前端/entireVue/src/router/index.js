import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PlayercardView from '../views/PlayercardView.vue'
import TeamView from '../views/TeamView.vue'
import NativeView from '../views/NativeView'
import ProvinceView from "@/views/ProvinceView";
import TeamPlayerView from '../views/TeamPlayerView.vue';
import AbroadView from "@/views/AbroadView";
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/AbroadView',
    name: 'AbroadView',
    component: AbroadView
  },
  {
    path: '/Province',
    name: 'Province',
    component: ProvinceView
  },
  {
    path: '/TeamPlayerView',
    name: 'TeamPlayerView',
    component: TeamPlayerView,
  },

  {
    path: '/PlayercardView',
    name: 'PlayercardView',
    component: PlayercardView,
  },
  {
    path: '/NativeView',
    name: 'NativeView',
    component: NativeView,
  },
  {
    path: '/TeamView',
    name: 'TeamView',
    component: TeamView,
  },

  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
