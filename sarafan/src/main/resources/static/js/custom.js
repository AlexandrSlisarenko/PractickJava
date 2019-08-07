var app = new Vue({
  el: '#app',
  data: {
    message: 'Привет, Vue!'
  }
});

Vue.component('todo-item', {
  template: '<li>Это одна задача в списке</li>'
});