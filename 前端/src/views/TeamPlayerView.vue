<template>
    <div id="content">
        <div id="team_name">

            <span id="teamname" class="border border-3 rounded-pill">山东泰安</span>
        </div>
        <div class="card context_area">
            <div class="card-body">
                <div class="row row-cols-1 row-cols-md-5 g-4">

                    <div class="col player_hover">
                        <div class="card border border-4    rounded-pill  bg-secondary mb-3 text-white">

                            <img src="https://gdc.hupucdn.com/gdc/nba/players/uploads/gamespace/players/844029fa1e83104a699ad14748a795bc.png"
                                class="card-img-top player_photo" alt="...">
                            <div class="card-body card-title player_name">
                                <RouterLink :to="{ name: 'PlayercardView' }" class="navbar-brand">保罗乔治

                                </RouterLink>

                            </div>
                        </div>
                    </div>
                    <div class="col player_hover">
                        <div class="card border border-4    rounded-pill  bg-secondary mb-3 text-white">

                            <img src="https://gdc.hupucdn.com/gdc/nba/players/uploads/gamespace/players/844029fa1e83104a699ad14748a795bc.png"
                                class="card-img-top player_photo" alt="...">
                            <div class="card-body card-title player_name">
                                <RouterLink :to="{ name: 'PlayercardView' }" class="navbar-brand">保罗乔治

                                </RouterLink>

                            </div>
                        </div>
                    </div>
                    <div class="col player_hover">
                        <div class="card border border-4    rounded-pill  bg-secondary mb-3 text-white">

                            <img src="https://gdc.hupucdn.com/gdc/nba/players/uploads/gamespace/players/844029fa1e83104a699ad14748a795bc.png"
                                class="card-img-top player_photo" alt="...">
                            <div class="card-body card-title player_name">
                                <RouterLink :to="{ name: 'PlayercardView' }" class="navbar-brand">保罗乔治

                                </RouterLink>

                            </div>
                        </div>
                    </div>
                    <div class="col player_hover">
                        <div class="card border border-4    rounded-pill  bg-secondary mb-3 text-white">

                            <img src="https://gdc.hupucdn.com/gdc/nba/players/uploads/gamespace/players/844029fa1e83104a699ad14748a795bc.png"
                                class="card-img-top player_photo" alt="...">
                            <div class="card-body card-title player_name">
                                <RouterLink :to="{ name: 'PlayercardView' }" class="navbar-brand">保罗乔治

                                </RouterLink>

                            </div>
                        </div>
                    </div>
                    <div class="col player_hover">
                        <div class="card border border-4    rounded-pill  bg-secondary mb-3 text-white">

                            <img src="https://gdc.hupucdn.com/gdc/nba/players/uploads/gamespace/players/844029fa1e83104a699ad14748a795bc.png"
                                class="card-img-top player_photo" alt="...">
                            <div class="card-body card-title player_name">
                                <RouterLink :to="{ name: 'PlayercardView' }" class="navbar-brand">保罗乔治

                                </RouterLink>

                            </div>
                        </div>
                    </div>
                    <div class="col player_hover">
                        <div class="card border border-4    rounded-pill  bg-secondary mb-3 text-white">

                            <img src="https://gdc.hupucdn.com/gdc/nba/players/uploads/gamespace/players/844029fa1e83104a699ad14748a795bc.png"
                                class="card-img-top player_photo" alt="...">
                            <div class="card-body card-title player_name">
                                <RouterLink :to="{ name: 'PlayercardView' }" class="navbar-brand">保罗乔治

                                </RouterLink>

                            </div>
                        </div>
                    </div>
                    <div class="col player_hover">
                        <div class="card border border-4    rounded-pill  bg-secondary mb-3 text-white">

                            <img src="https://gdc.hupucdn.com/gdc/nba/players/uploads/gamespace/players/844029fa1e83104a699ad14748a795bc.png"
                                class="card-img-top player_photo" alt="...">
                            <div class="card-body card-title player_name">
                                <RouterLink :to="{ name: 'PlayercardView' }" class="navbar-brand">保罗乔治

                                </RouterLink>

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

export default {
    name: "TeamView",
    components: {

    },



}
</script>

<style scoped>
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
    color: #ffffff;
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