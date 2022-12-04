<template>
  <div :style="{height : heightFix(teamlist)}" id="forbg">
  <div id="nativebg">
  <div id="province_name">
    <!-- 这里插入省份名 -->
    <!-- <span id="provincename" className="border border-3 rounded-pill">{{this.$route.query.provinceName}}省</span> -->
    <!-- 测试根据省级地名显示省/自治区/直辖市 -->
    <span id="provincename" className="border border-3 rounded-pill">{{provinceName(this.$route.query.provinceName)}}</span>
  </div>


    <div className="card context_area" id="bgtest">
        <div className="row row-cols-1 row-cols-md-4">
            <div v-for="team in teamlist">
              <div className="card-body">
                <div className="card border-dark mb-3 card_hover">
                  <img
                      :src="team.picSrc" alt="">
                  <div className="card-body">
                    <!-- 这里分别插入球队名、U21/23球员数 -->
                    <p className="card-text team_name">{{team.clubName}}</p>
                    <p className="card-text U">U21球员数:</p>
                    <p className="card-text U">U23球员数:</p>
                  </div>
                  <RouterLink :to="{ name: 'TeamPlayerView',query:{clubName:team.clubName}}" class="btn btn-primary">查看该球队球员</RouterLink>
                </div>
            </div>
          </div>
        </div>     
    </div>
  </div>
  </div>

</template>

<script>
import { Collapse } from 'bootstrap';
import $ from 'jquery';
import { ref } from 'vue';
import {useRoute} from "vue-router/dist/vue-router";
export default {
  name: 'PlayercardView',
  components: {

  },
  methods:{
    heightFix(teamlist){
      let i  = teamlist.length;
      let lines = Math.ceil(i/4);
      let  cheight = 768;
      // console.log(lines); //测试完毕，可以计算出对应行数
      // 计算行数对应的页面高度,默认768px
      if(lines>1){
        cheight = 635 + (lines-1)*365;
      }
      cheight = cheight + 'px';
      // console.log(cheight);
      return cheight;
    },
    provinceName(name){
      // console.log(name=='上海');
      // console.log('是否包含'+['上海','北京'].includes(name));
      // 判断是否是直辖市
      if(['北京','天津','上海','重庆',].includes(name)){
        name = name + '市';
        return name; //为了便于理解，暂时不使用单一出口
      }
      // 判断是否为自治区
      if(['内蒙古','广西','西藏','宁夏','新疆',].includes(name)){
        if(name=='内蒙古'||name=='西藏'){
          name = name + '自治区';
        }else if(name=='新疆'){
          name = '新疆维吾尔自治区';
        }else if(name=='宁夏'){
          name = '宁夏回族自治区'
        }else if(name=='广西'){
          name = '广西壮族自治区';
        }
        return name;
      }
      // 不包含在以上情况，后缀为省
      name = name + '省';
      return name;
    }
  },  
  setup () {
    const route = useRoute();
    let teamlist = ref([

    ]);
    let x = route.query.provinceName;
    $.ajax({
      url: 'http://8.130.33.130:8080/gogo/selectClubByProvince?province='+x,
      type: "get",
      data: {
        /* "id":xx */
      },
      dataType: "json",
      success(resp) {
        console.log(resp);
        teamlist.value = resp;
        console.log(teamlist.value);
      }
    });
    return {
      teamlist,
    };
  },
}

</script>

<style scoped>
#function{
  display: none;
}
/* 尝试添加背景 */
body{
  background-image: url('../assets/bg3.jpg');
  background-size: cover;  
  background-attachment: fixed;  
}

#forbg{
  background-image: url('../assets/bg3.jpg');
  background-size: cover;  
  background-attachment: fixed;
  width: 100%;
  height: 768px;
  margin: 1px;
  padding: 1px;
}

/* 保留bgtest部分作定位用，在外套大框架用于居中，背景图 */
#bgtest{
  position: relative;
  top:5vh;
  left: 17.5%;
  /* background-color: yellowgreen; */
  background-color: #ffffff00;
  margin: 0px;
}

.card_hover {
  border-width: 0px;
}
/* 省名栏 */
#nativebg{
  /* background: #333333; */
  height:10vh;
  background-color: rgba(0, 255, 255, 0);
}
.card_hover:hover {
  transform: scale(1.1);
  transition: all 0.2s;

}

.team_photo {
  width: 191px;
  height: 160px;
  margin: 0 auto;

}

#province_name {
  padding-top: 20px;
  text-align: center;
  color: #ffffff;
  font-size: x-large;
}

.U {
  font-weight: bold;
}

.team_name {
  text-align: center;
  font-weight: bold;
}


#provincename {
  padding: 10px;
  /* color: #111111; */
}

.context_area {
  /* background-color: rgba(255, 255, 255, 0); */
  width: 65%;
  margin: 0 0;
  /* border-color: rgba(120, 118, 118, 0); */
}


</style>
