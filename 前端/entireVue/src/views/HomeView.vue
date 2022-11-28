<template>

  <section class="mainbox">

    <div class="column">

      <div class="panel">
        <h2>球员年龄分布-饼状图</h2>
        <div class="chart"></div>
        <div class="panel-footer"></div>
      </div>

      <div class="panel">
        <h2>球员潜力值-折线图</h2>
        <div class="chart"></div>
        <div class="panel-footer"></div>
      </div>

      <div class="panel">
        <div class="chart"></div>
        <div class="panel-footer"></div>
      </div>

    </div>

    <div class="column">

      <div class="no">
        <div class="no-hd">
          <ul>
            <li class="line">2158</li>
            <li>1329</li>
          </ul>
        </div>
        <div class="no-bd">
          <ul>
            <li>国内青训人数</li>
            <li>留洋青训人数</li>
          </ul>
        </div>
      </div>

      <div class="map">
        <div class="map1"></div>
        <div class="map2"></div>
        <div class="map3"></div>
        <div class="chart">
          放地图
        </div>
      </div>

    </div>

    <div class="column">

      <div class="panel">
        <div class="chart"></div>
        <div class="panel-footer"></div>
      </div>

      <div class="panel">
        <div class="chart"></div>
        <div class="panel-footer"></div>
      </div>

      <div class="panel">
        <div class="chart"></div>
        <div class="panel-footer"></div>
      </div>

    </div>
  </section>



</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {

  }
}
</script>






<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.mainbox {
  background: url(../assets/bg.jpg);
  display: flex;
  margin: 0 auto;
  padding: 1vh 1vh 0;
}
h2 {
  height: 5vh;
  color: #fff;
  line-height: 5vh;
  text-align: center;
  font-size: 2vh;
  font-weight: 400;
}
.column {
  flex: 3;
}
.column:nth-child(2) {
  flex: 5;
}
.chart {
  font-size: 50px;
  text-align: center;
  line-height: 500px;
  color: #fff;
}
.panel {
  position: relative;
  border: 1px solid rgba(25, 186, 139, 0.17);
  height: 250px;
  background-color: rgb(255, 255, 255, 0.04);
  padding: 0 10px 10px;
  margin-bottom: 10px;
}
.panel::before {
  position: absolute;
  top: 0;
  left: 0;
  width: 10px;
  height: 10px;
  border-left: 2px solid #02a6b5;
  border-top: 2px solid #02a6b5;
  content: "";
}
.panel::after {
  position: absolute;
  top: 0;
  right: 0;
  width: 10px;
  height: 10px;
  border-right: 2px solid #02a6b5;
  border-top: 2px solid #02a6b5;
  content: "";
}
.panel-footer {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
}
.panel-footer::before {
  position: absolute;
  left: 0;
  bottom: 0;
  width: 10px;
  height: 10px;
  border-left: 2px solid #02a6b5;
  border-bottom: 2px solid #02a6b5;
  content: "";
}
.panel-footer::after {
  position: absolute;
  bottom: 0;
  right: 0;
  width: 10px;
  height: 10px;
  border-right: 2px solid #02a6b5;
  border-bottom: 2px solid #02a6b5;
  content: "";
}
.no {
  background: rgba(101, 132, 226, 0.1);
  padding: 5px;
  height: 12vh;
}
.no-hd {
  position: relative;
  border: 1px solid rgba(25, 186, 139, 0.17);
  height: 6vh;
}
.no .no-hd::before {
  position: absolute;
  top: 0;
  left: 0;
  content: "";
  width: 30px;
  height: 15px;
  border-top: 2px solid #02a6b5;
  border-left: 2px solid #02a6b5;
}
.no .no-hd::after {
  position: absolute;
  bottom: 0;
  right: 0;
  content: "";
  width: 30px;
  height: 15px;
  border-right: 2px solid #02a6b5;
  border-bottom: 2px solid #02a6b5;
}
.no .no-hd ul {
  display: flex;
}
li {
  list-style: none;
}
.no .no-hd ul li {
  position: relative;
  flex: 1;
  line-height: 6vh;
  font-size: 30px;
  color: #ffeb7b;
  text-align: center;
  font-family: "electronicFont";
}
.line::after {
  content: "";
  position: absolute;
  top: 25%;
  right: 0;
  height: 50%;
  width: 1.5px;
  background: rgba(255, 255, 255, 0.3);
}
.no-bd {
  height: 6vh;
}
.no .no-bd ul {
  display: flex;
}
.no .no-bd ul li {
  flex: 1;
  text-align: center;
  color: rgba(255, 255, 255, 0.9);
  font-size: 2.5vh;
  height: 6vh;
  line-height: 6vh;
  padding-top: 0;
  font-weight: lighter;
}
.map {
  position: relative;
  height: 90vh;
}
.map .map1 {
  width: 80vh;
  height: 80vh;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background: url(../assets/map.png);
  background-size: 100% 100%;
  opacity: 0.3;
}
.map .map2 {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 85vh;
  height: 85vh;
  background: url(../assets/lbx.png);
  animation: rotate1 15s linear infinite;
  opacity: 0.6;
  background-size: 100% 100%;
}
.map .map3 {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 87vh;
  height: 87vh;
  background: url(../assets/jt.png);
  animation: rotate2 10s linear infinite;
  opacity: 0.6;
  background-size: 100% 100%;
}
@keyframes rotate1 {
  from {
    transform: translate(-50%, -50%) rotate(0deg);
  }
  to {
    transform: translate(-50%, -50%) rotate(360deg);
  }
}
@keyframes rotate2 {
  from {
    transform: translate(-50%, -50%) rotate(0deg);
  }
  to {
    transform: translate(-50%, -50%) rotate(-360deg);
  }
}
header h1 {
  font-size: 3vw;
  color: #fff;
  text-align: center;
  line-height: 8vh;
}
header {
  position: relative;
  height: 10vh;
  background: url(../assets/head_bg.png) no-repeat;
  background-size: 100% 100%;
}


</style>
