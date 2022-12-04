<template>
  <div id="nativebg">
  <div id="content">
    <div id="team_name">
      <span id="teamname" class="border border-3 rounded-pill">{{this.$route.query.clubName}}</span>
    </div>
    
    <div class="card context_area">

      <div id="notice" v-if="notice(teaminfo)">暂无数据，敬请期待</div>

      <div class="card-body">
        <div class="row row-cols-1 row-cols-md-4 g-4">
          <div class="player-list" v-for="player in teaminfo">
          <div class="col player_hover">
            <div class="card border border-4  bg-secondary mb-3 text-white">
              <img :src="player.photo"
                   class="card-img-top player_photo" alt="...">
              <div class="card-body card-title player_name">
                <RouterLink :to="{ name: 'PlayercardView' ,query:{name: player.name}}" class="navbar-brand">{{nameFix(player.name)}}
                </RouterLink>
              </div>
            </div>
          </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
/* import $ from 'jquery'; */
/* import { ref } from 'vue'; */
import {useRoute} from "vue-router/dist/vue-router";
import {ref} from "vue";
import $ from "jquery";

export default {
  name: "TeamView",
  components: {
  },
  methods:{
    notice(teaminfo){
      let show = false;      
      if(teaminfo.length==0){
        show = true;
      }
      return show;
    },
    nameFix(name){
      let test = name;
      let len = name.length - 5; //获得存姓名的长度
      // console.log(name+' length is '+len);
      if(len>5){
        let fin = name.slice(-5,-1);
        let n_dilever = name.split('');
        // console.log(n_dilever);
        test = n_dilever[0]+n_dilever[1]+n_dilever[2]+'...'+fin;
        // console.log(test);
        name = test;
      }
      return name;
    }
  },
  setup () {
    const route = useRoute();
    let teaminfo = ref([

    ]);
    let x = route.query.clubName;
    console.log(x)
    $.ajax({
      url: 'http://8.130.33.130:8080/gogo/selectDomesticByClub?clubName='+ x,
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
      teaminfo,
    };
  }
}




</script>

<style scoped>
#notice{
  font-size: 90px;
  color:white;
  line-height: 300px;
  text-align: center;
  height: 600px;
}

#nativebg{
  /* background: #333333; */
  background-image: url('../assets/bg2.jpeg');
  background-attachment: fixed;
}
.player_hover:hover {
  transform: scale(1.1);
  transition: all 0.3s;
}
.navbar-brand {
  font-size: 1.2rem;
  font-weight: bolder;
}
#team_name {
  margin-bottom: 20px;
  padding-top: 20px;
  text-align: center;
  color: rgba(255, 255, 255, 0.91);
  font-size: x-large;
}
#teamname {
  padding: 10px;
}

.player_photo {
  margin: 0 auto;
  border-radius: 10%;
}
.border-4{
  border-radius: 10%;
}
.context_area {
  background-color: #ffffff00;
  width: 55%;
  margin: 0 auto;
  border-color: #ffffff00;
  border-radius: 10%;
}

.player_name {
  margin: 0 auto;
  text-align: center;
}
</style>
