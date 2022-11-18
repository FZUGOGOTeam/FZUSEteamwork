<template>
  <NavBar />
  <router-view />
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';
import NavBar from './components/NavBar';

export default {
  name: "App",
  components: {
    NavBar
  }
}

</script>

<style>
body {
  background: url("https://img2.baidu.com/it/u=2320728351,716210689&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=500");
  background-size: 100% 100%;
  min-width: 100vw;
  min-height: 100vh;
  background-repeat: no-repeat;
}
</style>
