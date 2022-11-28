<template>
  <div id="nativebg">
  <div id="province_name">
    <!-- 这里插入省份名 -->
    <span id="provincename" className="border border-3 rounded-pill">{{this.$route.query.provinceName}}省</span>
  </div>


  <div className="card context_area">
    <div className="card-body card_content">
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
import $ from 'jquery';
import { ref } from 'vue';
import {useRoute} from "vue-router/dist/vue-router";
export default {
  name: 'PlayercardView',
  components: {

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
  }

}

</script>

<style scoped>
.card_hover {
  border-width: 0px;
}
#nativebg{
  background: #333333;
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
  color: #111111;
}

.context_area {
  background-color: rgba(255, 255, 255, 0);
  width: 65%;
  margin: 0 auto;
  border-color: rgba(120, 118, 118, 0);
}
</style>
