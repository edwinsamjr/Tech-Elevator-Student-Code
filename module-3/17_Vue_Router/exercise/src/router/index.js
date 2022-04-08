import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home';
import MyBooks from '@/views/MyBooks';
import NewBookForm from '@/views/NewBook';
import BookDetails from '@/views/BookDetails';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/myBooks',
    name: 'myBooks',
    component: MyBooks
  },
  {
    path: '/addBook',
    name: 'addBook',
    component: NewBookForm
  },
  {
    path: '/book/:isbn',
    name: 'bookDetails',
    component: BookDetails
  }
];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
