<template>
    <!-- 选项卡插入 -->
  <div class="排名类型" @click="card_choice">      
      <ul>
        <li class="rank_type" id="默认展示0">国内排行</li>
        <li class="rank_type" >留洋排行</li>
      </ul>
  </div>
    <!-- 选项卡插入完毕 -->
    <!-- 国内球员分区 -->
  <div id="rank_block" class="ranking-page">
    <div class="rank1">
    <h2 class="titles">潜力值排行榜（国内）</h2>
  <table class="ranking-page-table">
    <thead>
    <tr>
      <th class="ranking-page-table__heading">排行</th>
      <th class="ranking-page-table__heading">姓名</th>
      <th class="ranking-page-table__heading">潜力值</th>
      <th class="ranking-page-table__heading">年龄</th>
      <th class="ranking-page-table__heading">俱乐部</th>
      <th class="ranking-page-table__heading">位置</th>
      <th class="ranking-page-table__heading">近期预测</th>
    </tr>
    </thead>
    <tbody>

      <tr v-for="player,key in p_native" class="ranking-page-table__row">
      <RouterLink :to="{ name: 'PlayercardView' ,query:{name: player.name}}" class="slink" style="text-decoration: none;color: orange;">
        <td>{{ key+1 }}</td>
      </RouterLink>           
        <td>{{ player.name }}</td>
        <td>{{ player.potential }}</td>
        <td>{{ player.age }}</td>
        <td>{{ player.clubName }}</td>
        <td>{{ player.position }}</td>
        <td>{{ player.futureScore1 }}</td>      
     

      </tr>
    </tbody>
  </table>
  </div>
  <!-- 同区域分隔线 -->
    <div class="rank2">
    <h2 class="titles">能力值排行榜（国内）</h2>
    <table class="ranking-page-table">
      <thead>
      <tr>
        <th class="ranking-page-table__heading">排行</th>
        <th class="ranking-page-table__heading">姓名</th>
        <th class="ranking-page-table__heading">能力值</th>
        <th class="ranking-page-table__heading">年龄</th>
        <th class="ranking-page-table__heading">俱乐部</th>
        <th class="ranking-page-table__heading">位置</th>
        <th class="ranking-page-table__heading">近期评价</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="player,key in s_native" class="ranking-page-table__row">
      <RouterLink :to="{ name: 'PlayercardView' ,query:{name: player.name}}" class="slink" style="text-decoration: none;color: gold;">
        <td>{{ key+1 }}</td>
      </RouterLink> 
        <td>{{ player.name }}</td>
        <td>{{ player.score }}</td>
        <td>{{ player.age }}</td>
        <td>{{ player.clubName }}</td>
        <td>{{ player.position }}</td>
        <td>{{ player.pastScore1 }}</td>
      </tr>
      </tbody>
    </table>
      </div>
  </div>
<!-- 国内/留洋分隔线 -->

    <!-- 留洋球员分区 -->
    <div id="rank_block1" class="ranking-page">
    <div class="rank1">
    <h2 class="titles">潜力值排行榜（留洋）</h2>
  <table class="ranking-page-table">
    <thead>
    <tr>
      <th class="ranking-page-table__heading">排行</th>
      <th class="ranking-page-table__heading">姓名</th>
      <th class="ranking-page-table__heading">潜力值</th>
      <th class="ranking-page-table__heading">年龄</th>
      <th class="ranking-page-table__heading">俱乐部</th>
      <th class="ranking-page-table__heading">位置</th>
      <th class="ranking-page-table__heading">近期预测</th>
    </tr>
    </thead>
    <tbody>
      <tr v-for="player,key in p_aboard" class="ranking-page-table__row">
      <RouterLink :to="{ name: 'PlayercardView' ,query:{name: player.name}}" class="slink" style="text-decoration: none;color: orange;">
        <td>{{ key+1 }}</td>
      </RouterLink> 
        <td>{{ player.name }}</td>
        <td>{{ player.potential }}</td>
        <td>{{ player.age }}</td>
        <td>{{ player.clubName }}</td>
        <td>{{ player.position }}</td>
        <td>{{ player.futureScore1 }}</td>
      </tr>
    </tbody>
  </table>
  </div>
  <!-- 同区域分隔线 -->
    <div class="rank2">
    <h2 class="titles">能力值排行榜（留洋）</h2>
    <table class="ranking-page-table">
      <thead>
      <tr>
        <th class="ranking-page-table__heading">排行</th>
        <th class="ranking-page-table__heading">姓名</th>
        <th class="ranking-page-table__heading">能力值</th>
        <th class="ranking-page-table__heading">年龄</th>
        <th class="ranking-page-table__heading">俱乐部</th>
        <th class="ranking-page-table__heading">位置</th>
        <th class="ranking-page-table__heading">近期评价</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="player,key in s_aboard" class="ranking-page-table__row">
      <RouterLink :to="{ name: 'PlayercardView' ,query:{name: player.name}}" class="slink" style="text-decoration: none;color: gold;">
        <td>{{ key+1 }}</td>
      </RouterLink> 
        <td>{{ player.name }}</td>
        <td>{{ player.score }}</td>
        <td>{{ player.age }}</td>
        <td>{{ player.clubName }}</td>
        <td>{{ player.position }}</td>
        <td>{{ player.pastScore1 }}</td>
      </tr>
      </tbody>
    </table>
      </div>
  </div>

</template>

<script>
import $ from 'jquery';
import {onMounted, ref} from 'vue';
export default {
  name: "RankTable.vue",
  beforeCreate () {
    document.querySelector('body').setAttribute('style', 'background: #3E3E3E;')
  },
  methods:{
        // 利用card_choice函数实现选项卡的效果
        card_choice(){
                // 获取需要操作的元素
                let lis = document.getElementsByClassName('rank_type');
                let items = document.getElementsByClassName('ranking-page');
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
  setup(){
    let p_aboard = ref([]);
    let s_aboard = ref([]);
    let p_native = ref([]);
    let s_native = ref([]);
    $.ajax({
          url: 'http://8.130.33.130:8080/gogo/selectTop100AbroadPlayersByPotential',
          type: "get",
          data: {
            /* "id":xx */
          },
          dataType: "json",
          success(resp) {
            console.log(resp);
            p_aboard.value = resp;
            console.log(p_aboard.value);
          }
        });  
        $.ajax({
          url: 'http://8.130.33.130:8080/gogo/selectTop100AbroadPlayersByScore',
          type: "get",
          data: {
            /* "id":xx */
          },
          dataType: "json",
          success(resp) {
            console.log(resp);
            s_aboard.value = resp;
            console.log(s_aboard.value);
          }
        });  
        $.ajax({
          url: 'http://8.130.33.130:8080/gogo/selectTop100NativePlayersByPotential',
          type: "get",
          data: {
            /* "id":xx */
          },
          dataType: "json",
          success(resp) {
            console.log(resp);
            p_native.value = resp;
            console.log(p_native.value);
          }
        }); 
        $.ajax({
          url: 'http://8.130.33.130:8080/gogo/selectTop100NativePlayersByScore',
          type: "get",
          data: {
            /* "id":xx */
          },
          dataType: "json",
          success(resp) {
            console.log(resp);
            s_native.value = resp;
            console.log(s_native.value);
          }
        }); 
        return {
          p_aboard,s_aboard,p_native,s_native
        };          
  }
}
</script>

<style scoped>

.router-link-active {
    text-decoration: none;
  }
/* 以下为选项卡的CSS美化 */
/* 选项卡的css */

/* 设计选项卡中的字体样式 */
.排名类型{
    width: 350px;
    position: absolute;
    z-index: 1;
    left: 0px;
    padding-top:15px;
    top: 70px;
    font-size: 30px;
    font-weight: bolder;
    line-height: 50px;
    text-align: center;
    border-radius: 50px;
    background-color: white;
}
li{
    width: 40%;
    display: inline-block;
}
 ul{
    padding: 0px;
}
#默认展示0{
  height: 100%;
  border-radius: 30px;
  background-color: rgb(127, 255, 161);
}
.rank_type{
  height: 100%;
  border-radius: 30px;
}
/* 大致定位 */
#rank_block{
  height: 100vh;
  width: 100%;
  display: grid;
  grid-template-rows: 1fr 1fr;
  background-image: url('../assets/bg3.jpg');
  background-size: cover;  
  background-attachment: fixed;
}
#rank_block1{
  height: 100vh;
  width: 100%;
  display: grid;
  grid-template-rows: 1fr 1fr;
  background-image: url('../assets/bg2.jpeg');
  background-size: cover;  
  background-attachment: fixed;
}
#rank1{
  display: grid;
  grid-row-start: 1;
  grid-row-end: 2;
}
#rank2{
  display: grid;
  grid-row-start: 2;
  grid-row-end: 3;
}
/* CSS美化 */
.titles{
  line-height: 70px;
  text-align: center;
}
.ranking-page-table {
  margin-left: 1%;
  transform: translateZ(0);
  width: 50%;
  min-width:1500px;
  white-space: nowrap;
  text-align: center;
  border-spacing: 0 3px;
  border-collapse: separate;
}
.rank1{
  margin-top: 2%;
  box-shadow: 0px 2px 10px 0px rgba(0, 0, 0, 0.2);
}
.ranking-page {
  color: #fff;
  font-size: 18px;
  overflow-x: auto;
  box-shadow: 0px 2px 5px 0px rgba(0, 0, 0, 0.2);
}
/* 对表头进行设计 */
thead{
  font-size: 27px;
  border-top-left-radius: 15px;
  border-top-right-radius: 15px;  
  color: #000;
  background-color: rgb(127, 255, 161);
}
tr{
  line-height: 50px;
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
				height: 260px;
				overflow-y: scroll;
			}
            /* 调试每行的高度 */
</style>
