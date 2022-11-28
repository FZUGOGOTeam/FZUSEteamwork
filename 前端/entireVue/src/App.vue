<template>
  <NavBar />
  <router-view/>
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

  background-size: 100% 100%;
  min-width: 100vw;
  min-height: 100vh;
  background-repeat: no-repeat;
}
nav {
  padding: 30px;
  box-shadow: 1px 2px 18px 1px #42b983;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
  border-bottom: 4px solid #42b983;
}
</style>
