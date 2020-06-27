import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/processos/',
    name: 'processoIndex',
    component: () => import('../views/processos/Index.vue')
  },
  {
    path: '/processos/add',
    name: 'processoAdd',
    component: () => import('../views/processos/Add.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
