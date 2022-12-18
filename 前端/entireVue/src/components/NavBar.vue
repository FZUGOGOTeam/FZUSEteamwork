<template>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark navbar-transparent">
        <div class="container">
          <a class="navbar-brand ">
            <img src="https://cdn.acwing.com/media/user/profile/photo/222713_lg_d6fd8c4861.PNG">
          </a>

          <RouterLink :to="{ name: 'home' }" class="navbar-brand">首页</RouterLink>
          <RouterLink :to="{ name: 'NativeView' }" class="navbar-brand ">国内青训</RouterLink>


          <RouterLink :to="{name: 'AbroadView'}" class="navbar-brand ">留洋球员</RouterLink>
          <RouterLink :to="{name: 'RankTable'}" class="navbar-brand ">排行榜</RouterLink>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="输入球员姓名搜索" aria-label="Search">
                <button class="btn btn-primary" style="width: 100px" type="submit">搜索</button>
            </form>
        </div>
    </nav>

</template>

<script>



export default {
    name: "NavBar",
    components: {

    },


}




</script>

<style scoped>


.navbar-brand {
    font-size: 22px;
    hover:#42b983;
}
.d-flex{
  height: 35px;

}
.navbar-link {
  font-size: 35px;
}
img {
    width: 40px;
    border-radius: 30%;
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
    box-shadow: 0px 2px 2px 0px rgba(255, 255, 255, 0);
    overflow: auto;
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
