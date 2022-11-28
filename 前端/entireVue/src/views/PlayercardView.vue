<template>
  <div id="nativebg">
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
</div>

</div>


</template>

<script>

import $ from 'jquery';
import {onMounted, ref} from 'vue';
import { useRouter,useRoute } from 'vue-router'

export default {
  name: 'PlayercardView',
  components: {

  },
  methods:{
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
}

.card {
  width: auto;
  background-color: rgb(242, 242, 242);
  margin-bottom: 5px;

}
#nativebg{
  background: #333333;
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
.total{
  background-color: white;
}
.total .比赛类型 li{
  display: inline-block;
  width: 20%;
  height: 100%;
}
.具体数据{
  width: 100%;
  height: 450px;
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
  font-size: 20px;
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
  height: 400px;
  overflow-y: scroll;
}
/* 调试每行的高度 */
</style>
