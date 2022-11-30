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
          <div class="row">
                <div class="col-md-6">
                  <div><h5>本周留洋球员各级别联赛出场人数情况：</h5>
                  <div class="echart" id="mychart" style="width: 400px; height: 300px"> </div>
                  </div>
               </div>
                <div class="col-md-6">
                      <div><h5>赛季至今每周进球曲线：</h5>
                     <div class="echart" id="abroadCharts2" style="width: 400px; height: 300px"> </div>
                      </div>
                </div>
            <div class="col-md-6">
              <div><h5>本周取得进球的球员：</h5>

              </div>
            </div>
            <div class="col-md-6">
              <div><h5>本周首发超过60分钟的球员：</h5>
              </div>
            </div>
          </div>
       </div>
        <div class="block4">
          <div>
            <h2 style="text-align: center;">赛季数据</h2>
            </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="block3">
              <div class="subtit1">
              留洋科普
              </div>
          <div>
            <h5>青年联赛级别：</h5>
            <div class="echart" id="abroadCharts3" style="width: 400px; height: 300px"> </div>
            <p></p>
          </div>

          <div>
            <h5> 目前各级别联赛效力人数：</h5>
            <div class="echart" id="abroadCharts4" style="width: 400px; height: 300px"> </div>
          </div>
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
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
    //      color: "#000000",
          containLabel: true
        },
        xAxis: {
          type: "value",
          axisLabel: {
            formatter: "{value} ",
          },
        },
        yAxis: {
          type: "category",
          data: this.x1Data
        },
        series: [
          {
            type: "bar", //形状为柱状图
            data: this.yData,
            textStyle:{
              fontSize:20
            },
            label: {
              //数据显示的位置
              show: true, //数值是否显示

              color: "#2f5b48",
              position: "top", //数值相对于柱状图显示的位置
            },
            barWidth: "40%", //柱的宽度
            backgroundStyle: {
              color: 'rgba(111, 162, 135, 0.2)'
            },
            itemStyle: {
              emphasis: {
                barBorderRadius: 7
              },
              normal: {
                color: "#548854",
                barBorderRadius: 7
              },

            }
          }
        ]
      };
      const myChart = echarts.init(document.getElementById("mychart"));
      myChart.setOption(option);
      document.getElementById('mychart').setAttribute('_echarts_instance_', '');
      //随着屏幕大小调节图表

      // 基本柱状图
      const optioncharts2 = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          data: this.x2Data
        },
        yAxis: {


        },
        series: [
          {
            type: "line", //形状为柱状图
            data: this.yData,
            label: {
              //数据显示的位置
              show: true, //数值是否显示
              rotate: 60, //数值显示的角度
              color: "#ffffff",
              position: "top", //数值相对于柱状图显示的位置
            },
            barWidth: "30%", //柱的宽度

            itemStyle: {
              emphasis: {
                barBorderRadius: 7
              },
              normal: {
                barBorderRadius: 7
              }
            }
          }
        ]
      };
      const abroadCharts2 = echarts.init(document.getElementById("abroadCharts2"));
      abroadCharts2.setOption(optioncharts2);
      document.getElementById('abroadCharts2').setAttribute('_echarts_instance_', '');

      const abroadCharts3 = echarts.init(document.getElementById("abroadCharts3"));
      const optionCharts3 = {
        title: {

        },
        tooltip: {
          trigger: 'item',
          formatter: "{a} <br/>{b} : {c}%"
        },
        toolbox: {
          feature: {
    //        dataView: {readOnly: false},
    //        restore: {},
    //        saveAsImage: {}
          }
        },
        legend: {
          data: ['第五级别','第四级别','第三级别','第二级别','第一级别']
        },

        series: [
          {
            name:'漏斗图',
            type:'funnel',
            left: '10%',
            top: 60,
            bottom: 60,
            width: '80%',
            min: 0,
            max: 100,
            minSize: '0%',
            maxSize: '100%',
            gap: 2,
            label: {
              show: true,
              position: 'inside'
            },
            labelLine: {
              length: 10,
              lineStyle: {
                width: 1,
                type: 'solid'
              }
            },
            itemStyle: {
              borderColor: '#fff',
              borderWidth: 1
            },
            emphasis: {
              label: {
                fontSize: 20
              }
            },
            data: [
              {value: 60, name: '第三级别'},
              {value: 40, name: '西班牙U19全国联赛...'},
              {value: 20, name: '西班牙u19荣誉联赛'},
              {value: 80, name: '第四级别'},
              {value: 100, name: '第五级别'}
            ]
          }
        ]
      };
      abroadCharts3.setOption(optionCharts3);
      const abroadCharts4 = echarts.init(document.getElementById("abroadCharts4"));
      const optionCharts4 = {
        title: {

        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left',
        },
        series: [
          {
            name: '访问来源',
            type: 'pie',
            radius: '50%',
            data: [
              {value: 1048, name: 'Level1'},
              {value: 735, name: 'Level2'},
              {value: 580, name: 'Level3'},
              {value: 484, name: 'Level4'},
              {value: 300, name: 'Level5'}
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      abroadCharts4.setOption(optionCharts4);

    }
  },
  mounted() {

   this.initEcharts();
  },
  setup() {
    const route = useRoute();
    let teaminfo = ref([

    ]);
    let x1Data = ["level6", "level5", "level4", "level3", "level2", "level1"]; //横坐标
    let x2Data = ["9.18", "9.25", "10.2", "10.9", "10.16", "10.23"]; //横坐标
    let yData = [6, 12, 40, 55, 20, 28, 25]; //数据
    let myChartStyle = { float: "left", width: "300px", height: "300px" }; //图表样式
    console.log(1);

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
      teaminfo,x1Data,x2Data,yData,myChartStyle
    };
  }

}
</script>

<style scoped>
#building:before {
  margin-top: 0;
  width: 100%;
  height: 120%;
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
  background: rgb(255, 255, 255);
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
  background: rgb(255, 255, 255);
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
.block4{
  margin-top: 20px;
  border-radius: 5px;
  box-shadow: 1px 1px 5px 0px rgba(0, 0, 0, 0.2);
}
.subtit1{
  text-align: center;
  font-size: 30px;

}

</style>
