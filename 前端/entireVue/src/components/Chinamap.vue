<template>

  <div id="map-china" style="width: 900px; height: 900px; text-align: center;"></div>
</template>


<script>
import echarts from 'echarts'
import "echarts/map/js/china.js"
export default {
  name: "Chinamap",
  methods:{

    initMap(TodayCases) {
      let that = this
      console.log("ok")
      // 初始化echarts实例
      this.chinachart = echarts.init(document.getElementById("map-china"));
      // 进行相关配置
      this.chartOption = {
        title:{
          text:'各省青年球员分布',
          left:'auto'
        },
        // geo配置详解： https://echarts.baidu.com/option.html#geo
        geo: {
          // 地理坐标系组件用于地图的绘制
          map: "china", // 表示中国地图
          // roam: true, // 是否开启鼠标缩放和平移漫游
          zoom: 1.2, // 当前视角的缩放比例（地图的放大比例）
          label: {
            show: true,
          },
          itemStyle: {
            // 地图区域的多边形 图形样式。
            borderColor: "rgba(0, 0, 0, 0.2)",
            emphasis: {
              // 高亮状态下的多边形和标签样式
              shadowBlur: 20,
              shadowColor: "rgba(0, 0, 0, 0.5)",
            },
          },
        },
        series: [
          {
            name: "各区域人数", // 浮动框的标题（上面的formatter自定义了提示框数据，所以这里可不写）
            type: "map",
            geoIndex: 0,
            label: {
              show: true,
            },
            // 这是需要配置地图上的某个地区的数据（下面是定义的假数据）
            data: [
              { name: '北京', value: '100' }, { name: '天津', value: '' },
              { name: '上海', value: '' }, { name: '重庆', value: '' },
              { name: '河北', value: ''}, { name: '河南', value: '' },
              { name: '云南', value:  ''}, { name: '辽宁', value:''},
              { name: '黑龙江', value: '' }, { name: '湖南', value: '' },
              { name: '安徽', value: '' }, { name: '山东', value: ''},
              { name: '新疆', value: '' }, { name: '江苏', value:'' },
              { name: '浙江', value: '' }, { name: '江西', value: '' },
              { name: '湖北', value: '' }, { name: '广西', value: '' },
              { name: '甘肃', value: ''}, { name: '山西', value: '' },
              { name: '内蒙古', value: '' }, { name: '陕西', value:'' },
              { name: '吉林', value: '' }, { name: '福建', value: '' },
              { name: '贵州', value: '' }, { name: '广东', value: '' },
              { name: '青海', value: '' }, { name: '西藏', value: '' },
              { name: '四川', value: ''}, { name: '宁夏', value: '' },
              { name: '海南', value: '' }, { name: '台湾', value: '' },
              { name: '香港', value: '' }, { name: '澳门', value: '' }
            ]
          },
        ],
        tooltip: {
          // 鼠标移到图里面的浮动提示框
          // formatter详细配置： https://echarts.baidu.com/option.html#tooltip.formatter
          formatter(params) {
            // params.data 就是series配置项中的data数据遍历
            let localValue;
            if (params.data) {
              localValue = params.data.value;
            } else {
              // 为了防止没有定义数据的时候报错写的
              localValue = 0;
            }
            let htmlStr = `
             <div style='font-size:18px;'> ${params.name}</div>
             <br>
             <p style='text-align:left;margin-top:-10px;'>
               青年球员人数：${localValue}人<br/>
             </p>
           `;
            return htmlStr;
          },
          backgroundColor:"#ff7f50",//提示标签背景颜色
          textStyle:{color:"#fff"} //提示标签字体颜色
        },
        // visualMap的详细配置解析：https://echarts.baidu.com/option.html#visualMap
        visualMap: {
          // 左下角的颜色区域
          type: "piecewise", // 定义为分段型 visualMap
          min: 0,
          max: 1000,
          itemWidth: 40,
          bottom: 10,
          left: 10,
          pieces: [
            // 自定义『分段式视觉映射组件（visualMapPiecewise）』的每一段的范围，
            // 以及每一段的文字，以及每一段的特别的样式
            { gt: 999, label: ">1000人", color: "#82121b" }, // (1000, ]
            { gt: 100, lte: 999, label: "100-999人", color: "#bb2222" }, // (100, 999]
            { gt: 10, lte: 99, label: "10-99人", color: "#fe7b6c" }, // (10, 99]
            { gt: 0, lte: 9, label: "1-9人", color: "#ffaa85" }, // (0, 9]
          ],
        },
      };
      this.chinachart.on('click', function (params) {

        that.$router.push({
          path: "/TeamView",
          query: { provinceName: params.data.name},
        });
      });
      // 使用刚指定的配置项和数据显示地图数据
      this.chinachart.setOption(this.chartOption);
    }
  }
}
</script>
<style>

</style>
