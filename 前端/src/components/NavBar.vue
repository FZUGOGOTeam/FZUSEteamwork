<template>
    <nav class="navbar navbar-dark bg-dark nav">
        <div class="container">
            <img src="https://cdn.acwing.com/media/user/profile/photo/222713_lg_d6fd8c4861.PNG">
            <RouterLink :to="{ name: 'home' }" class="navbar-brand dropbtn">首页</RouterLink>

            <div class="dropdown">
                <RouterLink :to="{ name: 'GuoneiView' }" class="dropbtn navbar-brand">国内青训</RouterLink>
                <!--   <div class="dropdown-content">
                    <RouterLink :to="{ name: 'TeamView' }">山东泰安</RouterLink>
                    <a href="#">球队名2</a>
                    <a href="#">球队名3</a>
                    <a href="#">球队名4</a>
                    <a href="#">球队名5</a>
                    <a href="#">球队名6</a>
                    <a href="#">球队名7</a>
                    <a href="#">球队名8</a>
                    <a href="#">......</a>
                </div> -->
            </div>

            <a class="navbar-brand dropbtn" style="">留洋球员</a>
            <a class="navbar-brand dropbtn">排行榜</a>
            <form class="d-flex search" role="search">
                <input class="form-control me-2" type="search" placeholder="输入球员姓名搜索" aria-label="Search">
                <button class="btn btn-primary" type="submit">搜索</button>
            </form>
        </div>
    </nav>

</template>

<script>

/* import $ from 'jquery'; */
/* import { ref } from 'vue'; */

export default {
    name: "NavBar",


};






</script>



<style scoped>
.search {
    width: 17vw;
}

.nav {
    height: 12vh;


}

.navbar-brand {
    font-size: 2vw;
}

img {
    width: 6vw;
    border-radius: 50%;
}

* {
    box-sizing: border-box;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

/* 为每个链接设定样式 */
.dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

/* 鼠标放置链接时改变样式 */
.dropbtn:hover {
    background-color: #111;
    color: red;
}

.dropdown {
    display: inline-block;

}

/* 下拉菜单设置样式 */
.dropdown-content {
    /* 隐藏菜单 */
    display: none;
    position: absolute;
    background-color: hsl(0, 0%, 98%);
    /* 设置链接元素的最小宽度 */
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(12, 12, 12, 0.2);
    overflow: auto;
    z-index: 1;
}

.dropdown-content a {
    display: block;
    color: black;
    padding: 12px 16px;
    text-decoration: none;

}

.dropdown-content a:hover {
    background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>