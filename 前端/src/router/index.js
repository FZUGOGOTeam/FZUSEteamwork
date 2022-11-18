import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue';
import PlayercardView from '../views/PlayercardView.vue';
import TeamView from '../views/TeamView.vue';
import TeamPlayerView from '../views/TeamPlayerView.vue';
import GuoneiView from '../views/GuoneiView.vue';


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/PlayercardView',
    name: 'PlayercardView',
    component: PlayercardView,

  },
  {
    path: '/TeamView',
    name: 'TeamView',
    component: TeamView,
  },
  {
    path: '/TeamPlayerView',
    name: 'TeamPlayerView',
    component: TeamPlayerView,
  },
  {
    path: '/GuoneiView',
    name: 'GuoneiView',
    component: GuoneiView,
  },

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
