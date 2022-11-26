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
<!-- https://img2.baidu.com/it/u=2320728351,716210689&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=500 -->
<!-- https://alifei01.cfp.cn/creative/vcg/nowarter800/new/VCG41N1152159637.jpg?x-oss-process=image/format,webp -->
<style>
/* body {
  background: url("https://img2.baidu.com/it/u=2320728351,716210689&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=500");
  background-size: 100% 100%;
  min-width: 100vw;
  min-height: 100vh;
  background-repeat: no-repeat;
} */
body {
  background: url(../src/assets/bg.jpg);
  background-size: 100% 100%;
  min-width: 100vw;
  min-height: 100vh;
  background-repeat: no-repeat;
  background-attachment: fixed;
}
</style>
