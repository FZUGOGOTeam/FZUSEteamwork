<template>
    <div id="province_name">
        <!-- 这里插入省份名 -->
        <span id="provincename" class="border border-3 rounded-pill">山东省</span>
    </div>


    <div class="card context_area">
        <div class="card-body card_content">
            <div class="row">
                <div class="col-sm-3 ">
                    <div class="card-body">
                        <div class="card border-dark mb-3 card_hover">
                            <img src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbkimg.cdn.bcebos.com%2Fpic%2Fdcc451da81cb39dbb6fd13e950441e24ab18972b9a48&refer=http%3A%2F%2Fbkimg.cdn.bcebos.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671285133&t=5713bbfa5aa3ee49aad82a0927f7dc22"
                                class="card-img-top team_photo" alt="">
                            <div class="card-body">
                                <!-- 这里分别插入球队名、U21/23球员数 -->
                                <p class="card-text team_name">山东泰安</p>
                                <p class="card-text U">U21球员数:</p>
                                <p class="card-text U">U23球员数:</p>
                            </div>
                            <RouterLink :to="{ name: 'TeamPlayerView' }" class="btn btn-primary">查看该球队球员</RouterLink>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 ">
                    <div class="card-body">
                        <div class="card border-dark mb-3 card_hover">
                            <img src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jinantimes.com.cn%2F77532056ca0042a0bcc201947f264b1b.jpg&refer=http%3A%2F%2Fimg.jinantimes.com.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671285770&t=57aad780f80bdb6c76211dd84a170efcs"
                                class="card-img-top team_photo" alt="">
                            <div class="card-body">
                                <p class="card-text team_name">山东泰山</p>
                                <p class="card-text U">U21球员数:</p>
                                <p class="card-text U">U23球员数:</p>
                            </div>
                            <a href="#" class="btn btn-primary">查看该球队球员</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 ">
                    <div class="card-body">
                        <div class="card border-dark mb-3 card_hover">
                            <img src="https://img0.baidu.com/it/u=3055509967,647934446&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"
                                class="card-img-top team_photo" alt="">
                            <div class="card-body">
                                <p class="card-text team_name">山东太阳金店</p>
                                <p class="card-text U">U21球员数:</p>
                                <p class="card-text U">U23球员数:</p>
                            </div>
                            <a href="#" class="btn btn-primary">查看该球队球员</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 ">
                    <div class="card-body">
                        <div class="card border-dark mb-3 card_hover">
                            <img src="https://img2.baidu.com/it/u=556962387,3977635218&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"
                                class="card-img-top team_photo" alt="">
                            <div class="card-body">
                                <p class="card-text team_name">山东西王</p>
                                <p class="card-text U">U21球员数:</p>
                                <p class="card-text U">U23球员数:</p>
                            </div>
                            <a href="#" class="btn btn-primary">查看该球队球员</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 ">
                    <div class="card-body">
                        <div class="card border-dark mb-3 card_hover">
                            <img src="https://img2.baidu.com/it/u=556962387,3977635218&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"
                                class="card-img-top team_photo" alt="">
                            <div class="card-body">
                                <p class="card-text team_name">山东西王</p>
                                <p class="card-text U">U21球员数:</p>
                                <p class="card-text U">U23球员数:</p>
                            </div>
                            <a href="#" class="btn btn-primary">查看该球队球员</a>
                        </div>
                    </div>
                </div>




            </div>
        </div>
    </div>
</template>

<script>
</script>

<style scoped>
.card_hover {
    border-width: 0px;
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
}

.context_area {
    background-color: rgba(255, 255, 255, 0);
    width: 65%;
    margin: 0 auto;
    border-color: rgba(120, 118, 118, 0);
}
</style>