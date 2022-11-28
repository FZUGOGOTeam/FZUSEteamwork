<template>

  <div id='building'>
  <div class="container">
    <div class="block1">
      <div class="row">
        <div class="subtit1">留洋明日之星TOP5</div>
    </div>
      <div class="row row-cols-1 row-cols-md-5">


            <div v-for="item in teaminfo.slice(0,5)">
              <div class="player_show">
                {{item.name}}
                <img :src="item.photo">
              </div>

                <p>荣誉：攻入巴萨球门</p>
            </div>
      </div>


    </div>


    <div class="row">
      <div class="col-md-8">
        <div class="block2">
          <div class="subtit1">
            留洋周报

          </div>
          <div>本周留洋球员各级别联赛出场情况：
            <div class="echart" id="mychart" style="width: 400px; height: 400px"> </div>
          <div>z</div>
        </div>


       </div>
      </div>
      <div class="col-md-4">
        <div class="block3">
              <div class="subtit1">
              留洋科普
              </div>
          <div>青年联赛级别：</div>

          <div>目前各级别联赛效力人数：</div>
        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import {useRoute} from "vue-router/dist/vue-router";
import {onMounted, ref} from "vue";
import abroadCharts from "@/components/AbroadCharts";
import $ from "jquery";
import * as echarts from "echarts";
export default {
  name: "AbroadView.vue",

  methods: {
    initEcharts() {
      // 基本柱状图
      const option = {
        xAxis: {
          data: this.xData
        },
        yAxis: {},
        series: [
          {
            type: "bar", //形状为柱状图
            data: this.yData
          }
        ]
      };
      const myChart = echarts.init(document.getElementById("mychart"));
      myChart.setOption(option);
      //随着屏幕大小调节图表

    }
  },
  mounted() {
   this.initEcharts();
  },
  setup() {
    const route = useRoute();
    let teaminfo = ref([

    ]);
    let xData = ["Level1", "Level2", "Level3", "Level4", "Level5", "Level6"]; //横坐标
    let yData = [23, 24, 18, 25, 27, 28, 25]; //数据
    let myChartStyle = { float: "left", width: "300px", height: "500px" }; //图表样式


    $.ajax({
      url: 'http://8.130.33.130:8080/gogo/selectDomesticByClub?clubName=广州',
      type: "get",
      data: {
        /* "id":xx */
      },
      dataType: "json",
      success(resp) {
        console.log(resp);
        teaminfo.value = resp;
        console.log(teaminfo.value);
      }
    });
    return {
      teaminfo,xData,yData,myChartStyle
    };
  }

}
</script>

<style scoped>
#building:before {
  margin-top: 0;
  width: 100%;
  height: 100%;
  border: 1px solid gray;
  background: url("../assets/bg2.jpeg");
  background-size: 1000px 600px;
  /*opacity设置半透明效果*/
  opacity: 0.8;
  /* content和：before搭配使用 */
  content: "";
  /* 使用绝对定位，z-index=-1设置为下层显示 */
  position: absolute;
  z-index: -1;
}

.container{
  background: rgb(101, 143, 101);
  border-radius: 10px;
  box-shadow: 10px 10px 10px 10px rgba(0, 0, 0, 0.2);
}
.player_show{
  text-align: center;
}
.block1{
  background: white;
  margin-top: 5px;
  border-radius: 5px;
  box-shadow: 0px 2px 5px 0px rgba(0, 0, 0, 0.2);

}
.block2{
  background: rgb(101, 143, 101);
  margin-top: 20px;
  border-radius: 5px;
  box-shadow: 2px 2px 5px 1px rgba(0, 0, 0, 0.2);

}
.block3{
  background: white;
  margin-top: 20px;
  border-radius: 5px;
  box-shadow: 1px 1px 5px 0px rgba(0, 0, 0, 0.2);

}
.subtit1{
  text-align: center;
  font-size: 30px;

}

</style>
