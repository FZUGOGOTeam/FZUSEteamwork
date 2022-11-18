<template>

    <div id="content">
        <div class="container">
            <div class="card">
                <!--  v-for="player in playerinfo" :key="player.id" -->
                <div class="card-body">
                    <div class="row">
                        <div class="col-4">
                            <!-- :src="player.photo"  https://gdc.hupucdn.com/gdc/nba/players/uploads/gamespace/players/844029fa1e83104a699ad14748a795bc.png-->
                            <img :src="playerinfo.Picsrc" class="img-fluid" alt="">
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
                            <p class="attrs_col_2">生日：{{ playerinfo.bithday }}</p>
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
        </div>
        <button class="btn" @click="get_player_info()">获取球员信息</button>
    </div>

</template>

<script>

import $ from 'jquery';
import { ref } from 'vue';

export default {
    name: 'PlayercardView',
    components: {

    },
    setup() {
        let playerinfo = ref([

        ]);

        const get_player_info = (playername) => {
            $.ajax({
                url: 'http://124.222.161.184:5000/getplayerinfo',
                type: "get",
                data: {
                    "name": playername,
                },
                dataType: "json",
                success(resp) {
                    console.log(resp);
                    playerinfo.value = resp;
                    console.log(playerinfo.value);
                }

            });
        }
        return {
            playerinfo,
            get_player_info,

        };
    }
}

</script>

<style scoped>
/* #content {
    background: url("https://img2.baidu.com/it/u=2320728351,716210689&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=500");
    background-size: 100% 100%;
    width: 100vw;
    height: 100vh;
}
 */
.card {
    width: auto;
    background-color: rgb(242, 242, 242);
    margin-bottom: 5px;

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
</style>