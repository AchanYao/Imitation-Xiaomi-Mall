import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue'
import BootStrapVue from 'bootstrap-vue'
// import { Message } from "element-ui";

Vue.use(VueRouter)
Vue.use(BootStrapVue)
// Vue.use(Message)

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

const routes = [
  {
    path: '/',
    name: 'home',
    component: Index
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/items/type/:typeId',
    name: "itemType",
    component: () => import('../views/TypeItems.vue'),
    props: true
  },
  {
    path: '/item/:id',
    name: 'item-detail',
    component: () => import('../views/ItemView.vue'),
    props: true
  },
  {
    path: '/loginPage',
    name: 'login-page',
    component: () => import('../views/LoginPage.vue')
  },
  {
    path: '/registerPage',
    name: 'register-page',
    component: () => import('../views/RegisterPage.vue')
  },
  {
    path: '/shoppingCar',
    name: 'shopping-cart',
    component: () => import('../views/Cart.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
