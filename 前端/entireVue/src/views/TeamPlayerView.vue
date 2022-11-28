<template>
  <div id="nativebg">
  <div id="content">
    <div id="team_name">

      <span id="teamname" class="border border-3 rounded-pill">{{this.$route.query.clubName}}</span>
    </div>
    <div class="card context_area">
      <div class="card-body">
        <div class="row row-cols-1 row-cols-md-4 g-4">
          <div class="player-list" v-for="player in teaminfo">
          <div class="col player_hover">
            <div class="card border border-4  rounded-pill  bg-secondary mb-3 text-white">
              <img :src="player.photo"
                   class="card-img-top player_photo" alt="...">
              <div class="card-body card-title player_name">
                <RouterLink :to="{ name: 'PlayercardView' ,query:{name: player.name}}" class="navbar-brand">{{player.name}}
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

  <!-- <div class="card" style="width: 10rem; border: 0;">
      <img src="https://gdc.hupucdn.com/gdc/nba/players/uploads/gamespace/players/844029fa1e83104a699ad14748a795bc.png"
          class="card-img-top player_photo" alt="...">
      <div class="card-body">
          <p class="card-text player_name">保罗乔治</p>
      </div>
  </div> -->
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
#nativebg{
  background: #333333;
}
.player_hover:hover {
  transform: scale(1.05);
  transition: all 0.2s;
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
/* #content {
    background: url("https://img2.baidu.com/it/u=2320728351,716210689&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=500");
    background-size: 100% 100%;
} */
.player_photo {
  width: 10rem;
  margin: 0 auto;
  border-radius: 10%;
}
.context_area {
  background-color: #ffffff00;
  width: 65%;
  margin: 0 auto;
  border-color: #ffffff00;
}
.player_name {
  margin: 0 auto;
  text-align: center;
}
</style>
