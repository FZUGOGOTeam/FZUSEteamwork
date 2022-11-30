<template>

    <div id="content">
      <div class="container">
        <div class="card">
          <!--  v-for="player in playerinfo" :key="player.id" -->
          <div class="card-body">
            <div class="row">
              <div class="col-4">
                <!-- :src="player.photo"  https://gdc.hupucdn.com/gdc/nba/players/uploads/gamespace/players/844029fa1e83104a699ad14748a795bc.png-->
                <img :src="playerinfo.photo" class="img-fluid" alt="">
              </div>
              <div class="col-4">
                <!-- {{player.name}} -->
                <p class="name">{{ playerinfo.name }}</p>
                <!-- {{player.id}} -->
                <p class="attrs_col_1">球员id:</p>
                <!-- {{player.clubName}} -->
                <p class="attrs_col_1">俱乐部：{{ playerinfo.clubName }}</p>
                <p class="attrs_col_1">国籍：{{ playerinfo.country }}</p>
                <!-- {{player.height}} -->
                <p class="attrs_col_1">身高：{{ playerinfo.height }}</p>
                <!-- {{player.position}} -->
                <p class="attrs_col_1">位置：{{ playerinfo.position }}</p>
              </div>
              <div class="col-4">
                <!--   {{player.age}} -->
                <p class="attrs_col_2">年龄：{{ playerinfo.age }}</p>
                <!-- {{player.weight}} -->
                <p class="attrs_col_2">体重：{{ playerinfo.weight }}</p>
                <!-- {{player.number}} -->
                <p class="attrs_col_2">号码：{{ playerinfo.number }}</p>
                <!-- {{player.birthday}} -->
                <p class="attrs_col_2">生日：{{ playerinfo.birthday }}</p>
                <!-- {{player.preferredFoot}} -->
                <p class="attrs_col_2">惯用脚：{{ playerinfo.preferredFoot }}</p>
                <!-- {{player.score}} -->
                <p class="attrs_col_2">评分：
                  <!-- {{ playerinfo.name }} -->
                </p>
  
              </div>
  
            </div>
  
          </div>
        </div>  
  
          <!-- 放入比赛数据表 -->
          <div class="total">
              <div id="比赛数据">
                  <div class="比赛类型" @click="card_choice">      
                      <ul>
                          <li id="表格说明">比赛数据：</li>
                          <li class="compet" id="默认展示0">总计</li>
                          <li class="compet">联赛</li>
                          <li class="compet">杯赛</li>
                          <em id="分界线"></em>
                          <li class="compet">国家队</li>
                      </ul>
                  </div>
              </div>
  
              <div class="具体数据">
                  <div class="data" id="默认展示">
                      <!-- 在此插入表格 -->
                      <table>
                          <thead>
                              <tr class="table">
                                  <th class="table_head">赛季</th>
                                  <th class="table_head">俱乐部</th>
                                  <th class="table_head">上场</th>
                                  <th class="table_head">首发</th>
                                  <th class="table_head">进球</th>
                                  <th class="table_head">助攻</th>
                                  <th class="table_head">黄牌</th>
                                  <th class="table_head">红牌</th>
                              </tr>
                          </thead>
                          <div class="滚动框">
                          <tbody class="tbody">
                              <!-- 测试数据插入 -->
                              <tr v-for="game in gameinfo" :key="game.id">
                                  <td>{{game.season}}</td>
                                  <td>{{game.clubName}}</td>
                                  <td>{{game.playCount}}</td>
                                  <td>{{game.starterCount}}</td>
                                  <td>{{game.goal}}</td>
                                  <td>{{game.assists}}</td>
                                  <td>{{game.yellowCards}}</td>
                                  <td>{{game.redCards}}</td>
                              </tr>
                              <!-- 测试数据插入完毕 -->
                          </tbody>
                          </div>
                      </table>
                      <!-- 表格插入完毕 -->
                  </div>
                  <!-- 联赛数据 -->
                  <div class="data">
                      <table>
                          <thead>
                              <tr class="table">
                                  <th class="table_head">赛季</th>
                                  <th class="table_head">俱乐部</th>
                                  <th class="table_head">上场</th>
                                  <th class="table_head">首发</th>
                                  <th class="table_head">进球</th>
                                  <th class="table_head">助攻</th>
                                  <th class="table_head">黄牌</th>
                                  <th class="table_head">红牌</th>
                              </tr>
                          </thead>
                          <div class="滚动框">
                          <tbody class="tbody">
                              <!-- 插入表格数据 -->
                          </tbody>
                          </div>
                      </table>
                  </div>
                  <!-- 杯赛数据 -->
                  <div class="data">
                      <table>
                          <thead>
                              <tr class="table">
                                  <th class="table_head">赛季</th>
                                  <th class="table_head">俱乐部</th>
                                  <th class="table_head">上场</th>
                                  <th class="table_head">首发</th>
                                  <th class="table_head">进球</th>
                                  <th class="table_head">助攻</th>
                                  <th class="table_head">黄牌</th>
                                  <th class="table_head">红牌</th>
                              </tr>
                          </thead>
                          <div class="滚动框">
                          <tbody class="tbody">
                              <!-- 插入表格数据 -->
                          </tbody>
                          </div>
                      </table>
                  </div>
                  <!-- 国家队数据 -->
                  <div class="data">
                      <table>
                          <thead>
                              <tr class="table">
                                  <th class="table_head">赛季</th>
                                  <th class="table_head">国家队</th>
                                  <th class="table_head">上场</th>
                                  <th class="table_head">首发</th>
                                  <th class="table_head">进球</th>
                                  <th class="table_head">助攻</th>
                                  <th class="table_head">黄牌</th>
                                  <th class="table_head">红牌</th>
                              </tr>
                          </thead>
                          <div class="滚动框">
                          <tbody class="tbody">
                              <!-- 插入表格数据 -->
                          </tbody>
                          </div>
                      </table>
                  </div>
              </div>
          </div>
          <!-- 比赛数据表插入完毕 -->
  
      </div>
      
      <!-- 在此插入可视化数据展示模块 -->
      
        <div class="viewable">
            <!-- 球员评分展示 -->
            <div class="score">
                <div id="综合评价">
                    <img id="足球" src="../assets/足球.png"/>
                    <p class="文本">综合<br/>评价</p>
                </div>
                <div id="评价内容">
                    <p class="数值模板">能力评分：<span class="score_d">{{playerinfo.score}}</span></p>
                    <p class="数值模板">首发率：<span class="score_d">{{seen=F_rate(gameinfo)}}</span><span v-if="seen!='暂无'">%</span></p>
                    <p class="数值模板">生涯潜力：<span :class="rank_s(playerinfo.potential)">{{playerinfo.potential}}</span></p>
                </div>
            </div>
            <!-- 球员潜力曲线图 -->
            <div class="potential">
                <div id="p_chart" ref="pChart"></div>
            </div>
        </div>
      <!-- 可视化数据展示模块插入完毕 -->

    </div>
  
  </template>
  
  <script>
  
  import $ from 'jquery';
  import {onMounted, ref} from 'vue';
  import { useRouter,useRoute } from 'vue-router';
//   引入Echart表格
  import * as echarts from 'echarts'
import { labeledStatement } from '@babel/types';

  export default {
    name: 'PlayercardView',
    components: {
  
    },
    // 插入Echarts
    mounted(){
        // 1.选择对象进行初始化
        let pEcharts = echarts.init(this.$refs.pChart);
        // 2.设置数据
        let xData=['近期S1','S2','S3','未来S1','S2','S3','S4'];
        let yData_t=[31,24,35,'-','-','-','-','-'];
        let yData_f=['-','-',35,41,52,60,72];
        // 3.配置项
        let option ={
            xAxis:{
                type:'category',
                data:xData,
                axisLabel:{
                    interval:0 //X轴内容过多造成内容缺失时加上这个内容就会显示出来
                }
            },
            yAxis:{
                type:'value'
            },
            // 设置图例的显示
            legend:{
                show:true,
                bottom:'3%'
            },
            // 添加标题
            title:{
                show:true,
                text:'球员赛季潜力变动&预测',
                x:'center'
            },
            series:[
                {
                    name:'实际',
                    data:yData_t,
                    type:'line', //折线图
                    label:{
                        show:true,
                        position:'top'
                    },
                    lineStyle:{
                        normal:{
                            color:'red',
                        }
                    }
                },
                {
                    name:'预测',
                    data:yData_f,
                    type:'line', //折线图
                    label:{
                        show:true,
                        position:'top'
                    },
                    lineStyle:{
                        normal:{
                            color:'red',
                            type:'dashed'
                        }
                    }
                }                
            ]
        }
        // 4.设置配置项
        pEcharts.setOption(option);
    },
    methods:{
        // 利用球员比赛信息返回首发率
        F_rate(games){
            console.log('输出games');
            let rate = 0,t_count = 0,f_count = 0;
            for(let i=0;i<games.length;i++){
                t_count += parseInt(games[i].playCount);
                f_count += parseInt(games[i].starterCount);
            }
            console.log('f = '+f_count+';t = '+t_count);
            rate = f_count/t_count*100;         
            rate = parseInt(rate);
            if(!rate){
                rate = '暂无';
            }
            return rate;
        } ,
        // 利用rank_s函数返回数值对应的css渲染样式
        rank_s(potential){
            let cla = "rank_C";
            if(potential>=70){
                cla = "rank_A";
            }else if(potential>=60){
                cla = "rank_B";
            }
            return cla;
        },

        // 利用card_choice函数实现选项卡的效果
        card_choice(){
                // 获取需要操作的元素
                let lis = document.getElementsByClassName('compet');
                let items = document.getElementsByClassName('data');
                // 输出用于调试
                // console.log(lis);
                // console.log(items);
                // 遍历节点，给节点添加事件
                for(let i=0;i<lis.length;i++){
                    // 自定义index属性用于关联对应div展示
                    lis[i].index = i;
                    lis[i].onclick = function(){
                        let key = this.index;
                        for(let j=0;j<items.length;j++){
                            items[j].style.display = 'none';
                            lis[j].style.backgroundColor = 'rgba(0,0,0,0)';
                            if(key === j){
                                items[j].style.display = 'grid';
                                lis[j].style.backgroundColor = 'rgb(127, 255, 161)';
                            }
                        }
                    }
                }    
        }
    },    
    setup () {
        const route = useRoute();
        let seen = ref([]);
        let playerinfo = ref([
  
        ]);
        let x = route.query.name;
        $.ajax({
          url: 'http://8.130.33.130:8080/gogo/selectDomesticByName?name='+x,
          type: "get",
          data: {
            /* "id":xx */
          },
          dataType: "json",
          success(resp) {
            console.log(resp);
            playerinfo.value = resp;
            console.log(playerinfo.value);
          }
        });
        // 请求球员比赛数据
        let gameinfo = ref([

        ]);
        $.ajax({
            url: 'http://8.130.33.130:8080/gogo/selectGameDataByName?name='+x,
            type: "get",
            data: {
            /* "id":xx */
            },
            dataType: "json",
            success(resp) {
                console.log(resp);
                gameinfo.value = resp;
                console.log(gameinfo.value);
            }
        });

        // 请求添加完毕
        return {
          playerinfo,gameinfo
        };
    }
  }
  </script>
  
  <style scoped>

  #content {
    background: url("https://img2.baidu.com/it/u=2320728351,716210689&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=500");
    background-size: 100% 100%;
    width: 100vw;
    height: 100vh;
    /* content分区测试 */
    display: grid;
    grid-template-columns: 2fr 1.52fr; 
}
 .container{
    padding-left: 8%;
    padding-right:0% ;
    padding-top: 3%;
    grid-column-start: 1;
    grid-column-end: 2;
 }
        /* 调整板块占的区域,利用pdding留出视觉缓冲区 */

  /* content分区测试结束 */

    /* 可视化模块的CSS设计 */
.viewable{
    /* 大致定位 */
    grid-column-start: 2;
    grid-column-end: 3;
    width: 100%;
    height: 100%;
    /* 暂时将范围可视化 */
    /* background-color: rgba(240, 248, 255, 0.255); */
    /* 再次分区 */
    display: grid;
    grid-template-rows: 1fr 2fr;
    /* 整体下移 */
    padding-top: 7%;
    padding-bottom: 0%;
    padding-left: 7%;
    padding-right: 9%;
}
        /* 球员评分设计 */
.score{
    /* 用于将内容框定位 */
    grid-row-start: 1;
    grid-row-end:2;
    background-color: rgb(247, 247, 247);
    border-radius: 30px;
    /* 区隔两个展示模块 */
    margin-bottom: 3%;
    /* 分隔 */
    display: grid;
    grid-template-columns: 1fr 3fr;
}
#综合评价{
    grid-column-start: 1;
    grid-column-end: 2;
    background-color: rgb(127, 255, 161);
    border-bottom-left-radius: 30px;
    border-top-left-radius: 30px;
}
#足球{
    height: 100px;
    width: auto;
}
.文本{
    text-align: center;
    font-size: 35px;
    font-weight:900;
}
#评价内容{
    grid-column-start: 2;
    grid-column-end: 3;
    display: grid;
    border-bottom-right-radius: 30px;
    border-top-right-radius: 30px;
    grid-template-rows: 1fr 1fr 1fr;
}
.数值模板{
    position: relative;
    top: 10px;
    text-align: center;
    font-size: 30px;
}
        /* 根据不同的球员得分渲染不同的css效果，借助函数返回对应的css class */
.rank_A{
    color: yellow;
    font-size: 45px;
    font-weight: 700;
    -webkit-text-stroke: 2px gold;
}
.rank_B{
    color: aqua;
    font-size: 45px;
    font-weight: 700;
    -webkit-text-stroke: 2px silver;   
}
.rank_C{
    color: greenyellow;
    font-size: 45px;
    font-weight: 700;
    -webkit-text-stroke: 2px aquamarine
    ;
}
.score_d{
    font-size: 45px;
    font-weight: 700;
}
        /* 球员评分设计完成 */

        /* 球员潜力设计 */
.potential{
    grid-row-start: 2;
    grid-row-end:3;
    border-radius: 15px;
    margin-top: 3%;
    height: 420px;
    background-color:white;    
}

#p_chart{
    /* 预设表格的大小和定位 */
    position: relative;
    left:3%;
    top:5%;
    width: 94%;
    height: 90%;
    /* background-color: burlywood; */
}
        /* 球员潜力设计完成 */

    /* 可视化模块的CSS设计完成 */
  .card {
    width: auto;
    background-color: rgb(242, 242, 242);
    /* 设置下边距为0，视觉上将基本信息和比赛信息整合 */
    margin-bottom: 6px;
  }
  
  img {
    width: 11rem;
    margin: auto;
    display: flex;
    /*主轴-x轴：居中*/
    justify-content: center;
  }
  
  .name {
    font-size: 2rem;
    font-weight: bold;
    margin-bottom: 0;
  }
  
  .e_name {
    font-size: 1rem;
    font-style: italic;
    font-weight: bold;
    opacity: 0.5;
  }
  
  .attrs_col_2 {
    margin-bottom: 17px;
    font-weight: bold;
    opacity: 0.8;
    letter-spacing: 5px;
  }
  
  .attrs_col_1 {
    font-weight: bold;
    opacity: 0.8;
    letter-spacing: 5px;
    margin-bottom: 15px;
  
  }
  
  .btn {
    background-color: black;
    margin-left: 500px;
    color: aliceblue;
  }

  /* 以下为选项卡的CSS美化 */
/* 选项卡的css */

/* 设计选项卡中的字体样式 */
.比赛类型{
    font-size: 30px;
    font-weight: bolder;
    line-height: 60px;
    text-align: center;
}
.比赛类型 .compet{
    border-radius:15px;
    font-size: 25px;
}
/* 设计其它样式 */
/* 页面左侧的圆角风格 */
.total{
    background-color: white;
    /* 尝试给数据表添加圆角 */
    border-bottom-left-radius: 15px;
}
.card{
    border-top-left-radius: 15px;
    border-top-right-radius: 15px;
    border-bottom-left-radius: 0px;
    border-bottom-right-radius: 0px;
}

.total .比赛类型 li{
    display: inline-block;
    width: 20%;
    height: 100%;
}
.具体数据{
    width: 100%;
    height: 350px;
    /* 设置表格可滚动，需要尝试固定表头，应该在tbody设置 */
	/* overflow-y: scroll; */
    background-color: rgba(0,0,0,0.1);
}
.total .比赛类型 ul{
    padding: 0px;
    width: 100%;
    height: 60px;
    background-color: rgba(0,0,0,0.1);
}
.total #表格说明{
    float: left;
    border-left: 6px solid rgb(95, 255, 47);
}

.total .具体数据{
    position: relative;
}
/* 默认选中的标签 */
#默认展示0{
    background-color:rgb(127, 255, 161) ;
}
.具体数据 .data{
    display: none;
    /* position: absolute; */
}
.total #默认展示{
    display: grid;
}

/* 对数据表格进行样式设计 */
.table_head{
    font-size: 30px;
}

/* 对表格内的字体进行样式设计 */
.table_head{
    background-color: rgb(127, 255, 161);
    text-align: center;
}
.tbody{
    font-size: 16px;
    text-align: center;
    line-height: 50px;
}

#分界线{
    background-color: rgb(195, 236, 59);
}
/* 插入表格样式 */
			/* 调节表头宽度 */
			table thead {
				width: calc(100%);
			}

			/* 固定表头 */
			table thead,
			tbody tr {
				display: table;
				width: 100%;
				table-layout: fixed;
			}

			/* 控制表格滑动 */
			table tbody {
				display: block;
				height: 300px;
				overflow-y: scroll;
			}
            /* 调试每行的高度 */
  </style>
  