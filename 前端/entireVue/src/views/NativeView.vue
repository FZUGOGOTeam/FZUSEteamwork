<template>
  <div id="nativebg">
    <div id="map">
      <Chinamap ref="chart_China_map"/>
    </div>
    <div id="carousel">
      <h1 id="标题">青训球员概览</h1>
      <!-- 在此插入轮播图 -->
      <p class="province">{{pros[num0]}}</p>
      <div class="block text-center">    
        <el-carousel :interval="4000" type="card" height="200px">
          <el-carousel-item v-for="player in randompro0">
         
            <!-- 尝试链接跳转功能 -->
            <RouterLink :to="{ name: 'PlayercardView' ,query:{name: player.name}}" class="slink">
              <div class="cards">
                <img class="imgs" :src="player.photo"> 
                <span class="names" text="2xl" justify="center">{{ player.name }}</span>
                <p class="potential">潜力值:<span>{{player.potential}}</span></p>
                <p class="score">表现分:<span>{{player.score}}</span></p>
              </div>
            </RouterLink>
          </el-carousel-item>
        </el-carousel>
      </div>
      <!-- 添加两个不同省份的轮播位 -->
      <p class="province">{{pros[num1]}}</p>
      <div class="block text-center">    
        <el-carousel :interval="4000" type="card" height="200px">
          <el-carousel-item v-for="player in randompro1">
         
            <!-- 尝试链接跳转功能 -->
            <RouterLink :to="{ name: 'PlayercardView' ,query:{name: player.name}}" class="slink">
              <div class="cards">
                <img class="imgs" :src="player.photo"> 
                <span class="names" text="2xl" justify="center">{{ player.name }}</span>
                <p class="potential">潜力值:<span>{{player.potential}}</span></p>
                <p class="score">表现分:<span>{{player.score}}</span></p>
              </div>
            </RouterLink>
          </el-carousel-item>
        </el-carousel>
      </div>

      <p class="province">{{pros[num2]}}</p>
      <div class="block text-center">    
        <el-carousel :interval="4000" type="card" height="200px">
          <el-carousel-item v-for="player in randompro2">
         
            <!-- 尝试链接跳转功能 -->
            <RouterLink :to="{ name: 'PlayercardView' ,query:{name: player.name}}" class="slink">
              <div class="cards">
                <img class="imgs" :src="player.photo"> 
                <span class="names" text="2xl" justify="center">{{ player.name }}</span>
                <p class="potential">潜力值:<span>{{player.potential}}</span></p>
                <p class="score">表现分:<span>{{player.score}}</span></p>
              </div>
            </RouterLink>
          </el-carousel-item>
        </el-carousel>
      </div>

    </div>
  </div>
</template>

<script>
import Chinamap from "@/components/Chinamap";
import {ref} from "vue";
import $ from "jquery";
// 定义全局变量，用于确定随机展示的省份
// let provinces = ['河北','辽宁','吉林','江苏','浙江','福建','江西','山东','河南','湖北','湖南','广东','海南','四川','陕西','内蒙古','广西','新疆','北京','天津','上海'];
export default {
  name: "NativeView",
  components: {
    Chinamap
  },
  mounted() {
    let TodaysCases = []
    this.$refs.chart_China_map.initMap(TodaysCases)
  },
  setup(){
    // 首先进行一次测试请求,尝试在页面上展示球员姓名
    let pros = ['河北','辽宁','吉林','江苏','浙江','福建','江西','山东','河南','湖北','湖南','广东','海南','四川','陕西','内蒙古','广西','新疆','北京','天津','上海'];
    let num1 = 0;
    //随机数   
    function random(min, max) {
      return Math.floor(Math.random() * (max - min)) + min;
    }
    num1 = random(1, 20);
    let num0 = num1-1;
    let num2 = num1+1;
    let randompro0 = ref([

    ]);
    let randompro1 = ref([

  ]);
    let randompro2 = ref([

    ]);
    $.ajax({
      url: 'http://8.130.33.130:8080/gogo/select5RandomNativePlayersByProvince?province='+ pros[num0],
      type: "get",
      data: {
        /* "id":xx */
      },
      dataType: "json",
      success(resp) {
        console.log(resp);
        randompro0.value = resp;
        console.log(randompro0.value);
      }
    });    
    $.ajax({
      url: 'http://8.130.33.130:8080/gogo/select5RandomNativePlayersByProvince?province='+ pros[num1],
      type: "get",
      data: {
        /* "id":xx */
      },
      dataType: "json",
      success(resp) {
        console.log(resp);
        randompro1.value = resp;
        console.log(randompro1.value);
      }
    });  
    $.ajax({
      url: 'http://8.130.33.130:8080/gogo/select5RandomNativePlayersByProvince?province='+ pros[num2],
      type: "get",
      data: {
        /* "id":xx */
      },
      dataType: "json",
      success(resp) {
        console.log(resp);
        randompro2.value = resp;
        console.log(randompro2.value);
      }
    });  
    // 测试请求完毕
    return {
      pros,num0,num1,num2,randompro0,randompro1,randompro2
    };
  }

}
</script>

<style scoped>
/* 调试插入图片的格式 */
.potential{
  font-size: 15px;
  font-weight:bold;
  color: #333333;
  position: absolute;
  top: 100px;
  right: 2px;
}
.score{
  font-size: 15px;
  font-weight:bold;
  color: #333333;
  position: absolute;
  top: 125px;
  right: 2px;
}
.cards{
  position: relative;
}
.names{
  -webkit-text-stroke:1px #333333;
  color: #cac3c3;
  font-weight:bold;
  text-decoration: none;
  font-size: 27px;
  position: absolute;
  top: 160px;
  left:25%;
  text-align: center;
  z-index: 1;
}
.imgs{
  height: 200px;
  width: auto;
  position: relative;
  top: 0px;
  left: 0px;
  z-index: 0;
}
/* 消除链接的下划线 */
.slink{
  text-decoration: none;
}
#nativebg{
  display: grid;
  grid-template-columns: 2fr 1fr;
  background: #333333;
}
#map{
  grid-column-start: 1;
  grid-column-end: 2;
}
#carousel{
  /* background-color: aqua; */
  margin-top: 50px;
  /* position: fixed;
  right: 0px;
  top: 80px;
  /* width: 500px; */
  /* height: 900px; */ 
  grid-column-start: 2;
  grid-column-end: 3;
  /* 暂时以比较明显的背景色标记出，便于查看轮播模板效果 */
}
#标题{
  -webkit-text-stroke: 1px #42b983;
}
.province{
  /* text-align: center; */
  font-size: 25px;
  color: #42b983;
}

/* 轮播图的css */
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
