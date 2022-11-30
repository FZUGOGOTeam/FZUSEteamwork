<template>
  <header>
    <h1>球员数据概览</h1>
  </header>

  <section class="mainbox">

    <div class="column">

      <div class="panel">
        <h2>国内青训球员年龄分布</h2>
        <div id="myChart_1" :style="{ width: '400px', height: '240px' }"></div>
        <div class="panel-footer"></div>
      </div>

      <div class="panel">
        <h2>国内青训潜力值Top5</h2>
        <div id="myChart_2" :style="{ width: '400px', height: '200px' }"></div>
        <div class="panel-footer"></div>
      </div>

      <div class="panel_1">
        <h2>国内青训联赛级别分布</h2>
        <div id="myChart_3" :style="{ width: '400px', height: '280px' }"></div>
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
        <div id="mapChart" :style="{ width: '670px', height: '500px' }">

        </div>
      </div>

    </div>

    <div class="column">

      <div class="panel">
        <h2>留洋青训球员年龄分布</h2>
        <div id="myChart1" :style="{ width: '400px', height: '240px' }"></div>
        <div class="panel-footer"></div>
      </div>

      <div class="panel">
        <h2>留洋青训潜力值Top5</h2>
        <div id="myChart2" :style="{ width: '400px', height: '200px' }"></div>
        <div class="panel-footer"></div>
      </div>

      <div class="panel_1">
        <h2>留洋青训联赛级别分布</h2>
        <div id="myChart3" :style="{ width: '400px', height: '300px' }"></div>
        <div class="panel-footer"></div>
      </div>

    </div>
  </section>

</template>

<script>

import { defineComponent, toRefs, reactive, onMounted } from 'vue'
import * as echarts from 'echarts'



export default defineComponent({
  name: 'HomeView',

  components: {

  },
  setup() {
    //option_2所用data
    var charts = { // 按顺序排列从大到小
      cityList: ['player_1', 'player_2', 'player_3', 'player_4', 'player_5'],
      cityData: [135, 130, 125, 120, 100]
    }
    var top10CityList = charts.cityList
    var top10CityData = charts.cityData
    //option_3所用data
    // import echarts from 'echarts'
    var charts_1 = { // 按顺序排列从大到小
      cityList: ['player_1', 'player_2', 'player_3', 'player_4', 'player_5'],
      cityData: [80, 100, 120, 130, 135]
    }
    var top10CityList_1 = charts_1.cityList
    var top10CityData_1 = charts_1.cityData
    var color = ['rgba(248,195,248', 'rgba(100,255,249', 'rgba(135,183,255', 'rgba(248,195,248', 'rgba(100,255,249']

    let lineY = []
    for (var i = 0; i < charts_1.cityList.length; i++) {
      var x = i
      if (x > color.length - 1) {
        x = color.length - 1
      }
      var data = {
        name: charts_1.cityList[i],
        color: color[x] + ')',
        value: top10CityData_1[charts_1.cityList.length - 1 - i],
        itemStyle: {
          normal: {
            show: true,
            color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
              offset: 0,
              color: color[x] + ', 0.3)'
            }, {
              offset: 1,
              color: color[x] + ', 1)'
            }], false),
            barBorderRadius: 10
          },
          emphasis: {
            shadowBlur: 15,
            shadowColor: 'rgba(0, 0, 0, 0.1)'
          }
        }
      }
      lineY.push(data)
    }

    ////////////////////////////////////////////option_5所用data
    var giftImageUrl = "data:image/png;base64,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";
    /////////option_7所用data


    const state = reactive({
      option_1: {
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center',
          textStyle: {
            color: '#fff'
          }
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '40',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: [
              { value: 1048, name: 'U18' },
              { value: 735, name: 'U19' },
              { value: 580, name: 'U20' },
              { value: 484, name: 'U21' },
              { value: 300, name: 'U22' }
            ]
          }
        ]
      },
      option_2: {
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center',
          textStyle: {
            color: '#fff'
          }
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '40',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: [
              { value: 2000, name: 'U18' },
              { value: 300, name: 'U19' },
              { value: 1500, name: 'U20' },
              { value: 600, name: 'U21' },
              { value: 920, name: 'U22' }
            ]
          }
        ]
      },

      //////
      option_3: {
        backgroundColor: 'rgba(23,30,82)',
        title: {
          show: false
        },
        tooltip: {
          trigger: 'item'
        },
        grid: {
          borderWidth: 0,
          top: '8%',
          left: '5%',
          right: '8%',
          bottom: '0%'
        },
        color: '#fff',
        yAxis: [{
          type: 'category',
          inverse: true,
          axisLine: {
            show: false
          },
          splitLine: {
            show: false
          },
          axisTick: {
            show: false
          },
          axisLabel: {
            show: false
          },
          data: top10CityList
        }],
        xAxis: {
          type: 'value',
          axisTick: {
            show: false
          },
          axisLine: {
            show: false
          },
          splitLine: {
            show: false
          },
          axisLabel: {
            show: false
          }
        },
        series: [
          {
            name: '',
            type: 'bar',
            barWidth: '15px',
            itemStyle: {
              normal: {
                show: true,
                color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
                  offset: 0,
                  color: 'rgba(255,255,255,0.3)'
                }, {
                  offset: 1,
                  color: 'rgba(255,255,255,1)'
                }], false),
                barBorderRadius: 10
              },
              emphasis: {
                shadowBlur: 15,
                shadowColor: 'rgba(0, 0, 0, 0.1)'
              }
            },
            data: top10CityData,
            animationDuration: 1500,
            label: {
              normal: {
                color: '#fff',
                show: true,
                position: 'right',
                textStyle: {
                  fontSize: 20,
                  fontStyle: 'italic',
                  fontFamily: 'DINPro-Light'
                }
              }
            }
          },
          {
            type: 'bar',
            barGap: '1px',
            barWidth: 5,
            animation: false,
            itemStyle: {
              // color: 'rgba(255,255,255,0.2)'
              color: 'transparent'
            },
            tooltip: {
              show: false
            },
            label: {
              show: true,
              position: ['0', '-47px'],
              fontSize: 14,
              color: '#fff',
              formatter: function (param) {
                return param.name
              }
            },
            data: top10CityData
          }
        ],
        animationEasing: 'cubicOut'
      },
      //////////////////////////

      option_4: {
        backgroundColor: 'rgba(23,30,82)',
        title: {
          show: false
        },
        tooltip: {
          trigger: 'item'
        },
        grid: {
          borderWidth: 0,
          top: '8%',
          left: '5%',
          right: '15%',
          bottom: '0%'
        },
        color: color,
        yAxis: [{
          type: 'category',
          inverse: true,
          axisTick: {
            show: false
          },
          axisLine: {
            show: false
          },
          axisLabel: {
            show: false,
            inside: false
          },
          data: top10CityList_1
        }, {
          type: 'category',
          axisLine: {
            show: false
          },
          axisTick: {
            show: false
          },
          axisLabel: {
            show: true,
            inside: false,
            textStyle: {
              color: '#b3ccf8',
              fontSize: '15',
              fontFamily: 'PingFangSC-Regular'
            },
            formatter: function (val) {
              return `${val}`
            }
          },
          splitArea: {
            show: false
          },
          splitLine: {
            show: false
          },
          data: top10CityData_1
        }],
        xAxis: {
          type: 'value',
          axisTick: {
            show: false
          },
          axisLine: {
            show: false
          },
          splitLine: {
            show: false
          },
          axisLabel: {
            show: false
          }
        },
        series: [{
          name: '',
          type: 'bar',
          zlevel: 2,
          barWidth: '15px',
          data: lineY,
          animationDuration: 1500,
          label: {
            normal: {
              color: '#b3ccf8',
              show: true,
              position: [0, '-16px'],
              textStyle: {
                fontSize: 14
              },
              formatter: function (a) {
                return a.name
              }
            }
          }
        }],
        animationEasing: 'cubicOut'
      },
      //////
      option_5: {
        backgroundColor: '#031845',
        tooltip: {
          trigger: 'item',
          formatter: "{a} <br/>{b}: {c} ({d}%)",

        },
        graphic: {
          elements: [{
            type: 'image',
            style: {
              image: giftImageUrl,
              width: 70,
              height: 70
            },
            left: 'center',
            top: 'center'
          }]
        },
        title: {
          text: '级别分析',
          left: 'center',
          top: '53%',
          padding: [24, 0],
          textStyle: {
            color: '#fff',
            fontSize: 14,
            align: 'center'
          }
        },
        legend: {

          orient: 'horizontal',
          icon: 'circle',
          bottom: 0,
          x: 'center',
          data: ['中超', '中甲', '中乙', '中冠'],
          textStyle: {
            color: '#fff',
            fontSize: 20,
            fontWeight: 'bold'
          }
        },
        series: [{
          name: '联赛级别',
          type: 'pie',
          hoverAnimation: false,
          legendHoverLink: false,
          radius: ['38%', '45%'],
          color: ['#006495', '#1D5F84', '#255C6D', '#3C5C67', '#40486C', '#3F3C73', '#403D84', '#1F3A8D', '#0B3B77'],
          label: {
            normal: {
              position: 'inner'
            }
          },
          labelLine: {
            normal: {
              show: false
            },

          },
          tooltip: {
            show: false,


          },

          data: [{
            value: 100,
            name: ''
          },
          {
            value: 100,
            name: ''
          },
          {
            value: 100,
            name: ''
          },
          {
            value: 100,
            name: ''
          },
          {
            value: 100,
            name: ''
          },
          {
            value: 100,
            name: ''
          },
          {
            value: 100,
            name: ''
          },
          {
            value: 100,
            name: ''
          },
          {
            value: 100,
            name: ''
          }
          ]
        },
        {
          name: '联赛级别',
          type: 'pie',
          radius: ['43%', '55%'],
          color: ['#00FFFF', '#44EAB1', '#7BDD43', '#FEBE12', '#EBEC2F', '#FF7C44', '#FA3E5F', '#6635EF', '#FFAFDA'],
          labelLine: {
            normal: {
              show: true,
              length: 20,
              length2: 20,
              lineStyle: {
                width: 2
              }
            }
          },
          label: {
            normal: {
              formatter: '{c|{c}}\n{hr|}\n{d|{d}%}',
              rich: {
                b: {
                  fontSize: 20,
                  color: '#12EABE',
                  align: 'left',
                  padding: 4
                },
                hr: {
                  borderColor: '#12EABE',
                  width: '100%',
                  borderWidth: 2,
                  height: 0
                },
                d: {
                  fontSize: 20,
                  color: '#fff',
                  align: 'left',
                  padding: 4
                },
                c: {
                  fontSize: 20,
                  color: '#fff',
                  align: 'left',
                  padding: 4
                }
              }
            }
          },
          data: [{
            value: 50,
            name: '中超'
          },
          {
            value: 130,
            name: '中甲'
          },
          {
            value: 200,
            name: '中乙'
          },
          {
            value: 300,
            name: '中冠'
          },

          ]
        }
        ]
      },
      //////
      option_6: {
        backgroundColor: '#031845',
        "animation": true,
        "title": {
          "text": '留洋青训',
          "subtext": "级别分析",
          "x": "center",
          "y": "center",
          "textStyle": {
            "color": "#fff",
            "fontSize": 24,
            "fontWeight": "normal",
            "align": "center",
            "width": "200px"
          },
          "subtextStyle": {
            "color": "#fff",
            "fontSize": 16,
            "fontWeight": "normal",
            "align": "center"
          }
        },
        "legend": {
          "width": "100%",
          "left": "center",
          "textStyle": {
            "color": "#fff",
            "fontSize": 18,
            "fontWeight": 'bold',
          },
          "icon": "circle",
          "right": "0",
          "bottom": "0",
          "padding": [30, 60],
          "itemGap": 10,
          "data": ["德甲", "英超", "意大利", "西班牙", "法甲"]
        },
        "series": [{
          "type": "pie",
          "center": ["50%", "50%"],
          "radius": ["40%", "53%"],
          "color": ["#FEE449", "#00FFFF", "#00FFA8", "#9F17FF", "#FFE400", "#F76F01", "#01A4F7", "#FE2C8A"],
          "startAngle": 135,
          "labelLine": {
            "normal": {
              "length": 10
            }
          },
          "label": {
            "normal": {
              "formatter": "{per|{d}%} ",
              "backgroundColor": "rgba(255, 147, 38, 0)",
              "borderColor": "transparent",
              "borderRadius": 4,
              "rich": {
                "a": {
                  "color": "#999",
                  "lineHeight": 22,
                  "align": "center"
                },
                "hr": {
                  "borderColor": "#aaa",
                  "width": "100%",
                  "borderWidth": 1,
                  "height": 0
                },
                "b": {
                  "color": "#b3e5ff",
                  "fontSize": 25,
                  "lineHeight": 33
                },
                "c": {
                  "fontSize": 23,
                  "color": "#eee"
                },
                "per": {
                  "color": "#FDF44E",
                  "fontSize": 21,
                  "padding": [5, 8],
                  "borderRadius": 2
                }
              },
              "textStyle": {
                "color": "#fff",
                "fontSize": 16
              }
            }
          },
          "emphasis": {
            "label": {
              "show": true,
              "formatter": "{b|{b}:}{per|{d}%}  ",
              "backgroundColor": "rgba(255, 147, 38, 0)",
              "borderColor": "transparent",
              "borderRadius": 4,
              "rich": {
                "a": {
                  "color": "#999",
                  "lineHeight": 22,
                  "align": "center"
                },
                "hr": {
                  "borderColor": "#aaa",
                  "width": "100%",
                  "borderWidth": 1,
                  "height": 0
                },
                "b": {
                  "color": "#fff",
                  "fontSize": 18,
                  "lineHeight": 33
                },
                "c": {
                  "fontSize": 14,
                  "color": "#eee"
                },
                "per": {
                  "color": "#FDF44E",
                  "fontSize": 25,
                  "padding": [5, 6],
                  "borderRadius": 2
                }
              }
            }
          },
          "data": [{
            "name": "德甲",
            "value": 20
          }, {
            "name": "英超",
            "value": 2
          }, {
            "name": "意大利",
            "value": 26
          }, {
            "name": "西班牙",
            "value": 24
          }, {
            "name": "法甲",
            "value": 12
          },]
        }, {
          "type": "pie",
          "center": ["50%", "50%"],
          "radius": ["35%", "36%"],
          "label": {
            "show": false
          },
          "data": [{
            "value": 78,
            "name": "实例1",
            "itemStyle": {
              "normal": {
                "color": {
                  "x": 0,
                  "y": 0,
                  "x2": 1,
                  "y2": 0,
                  "type": "linear",
                  "global": false,
                  "colorStops": [{
                    "offset": 0,
                    "color": "#9F17FF"
                  }, {
                    "offset": 0.2,
                    "color": "#01A4F7"
                  }, {
                    "offset": 0.5,
                    "color": "#FE2C8A"
                  }, {
                    "offset": 0.8,
                    "color": "#FEE449"
                  }, {
                    "offset": 1,
                    "color": "#00FFA8"
                  }]
                }
              }
            }
          }]
        }]
      },
      //////
      option_7: {

      },
    })
    const initeCharts = () => {
      let myChart1 = echarts.init(document.getElementById('myChart_1'))
      let myChart_1 = echarts.init(document.getElementById('myChart1'))
      let myChart2 = echarts.init(document.getElementById('myChart_2'))
      let myChart_2 = echarts.init(document.getElementById('myChart2'))
      let myChart3 = echarts.init(document.getElementById('myChart_3'))
      let myChart_3 = echarts.init(document.getElementById('myChart3'))
      let mapChart = echarts.init(document.getElementById('mapChart'))

      // 绘制图表
      myChart1.setOption(state.option_1)
      myChart_1.setOption(state.option_2)
      myChart2.setOption(state.option_3)
      myChart_2.setOption(state.option_4)
      myChart3.setOption(state.option_5)
      myChart_3.setOption(state.option_6)
      mapChart.setOption(state.option_7)
    }

    onMounted(() => {
      initeCharts()
    })

    return {
      ...toRefs(state),
    }
  },

  /*   data() {
      return {
        imgUrl: require('../assets/bg.jpg'),
      }
    }, */
})
</script>


<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.mainbox {
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

.panel_1 {
  position: relative;
  border: 1px solid rgba(25, 186, 139, 0.17);
  height: 350px;
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

/* 
div {
  background: url("https://img2.baidu.com/it/u=2320728351,716210689&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=500");
  background-size: 100% 100%;
  min-width: 100vw;
  min-height: 100vh;
  background-repeat: no-repeat;
} */
</style>