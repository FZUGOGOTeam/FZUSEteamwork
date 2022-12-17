<template>

  <div class="ranking-page">
    <div class="rank1">
    <h2>潜力值排行榜</h2>
  <table class="ranking-page-table">
    <thead>
    <tr>
      <th class="ranking-page-table__heading">姓名</th>
      <th class="ranking-page-table__heading">潜力值</th>
      <th class="ranking-page-table__heading">年龄</th>
      <th class="ranking-page-table__heading">联赛级别</th>
      <th class="ranking-page-table__heading">年龄</th>
      <th class="ranking-page-table__heading">进球</th>
      <th class="ranking-page-table__heading">助攻</th>
    </tr>
    </thead>
    <tbody>
      <tr class="ranking-page-table__row">
        <td>
            郭田雨
          {{}}
        </td>
        <td>
          90
        </td>
        <td>
          18
        </td>
        <td>
          20
        </td>
        <td>
          15
        </td>
        <td>
          20
        </td>
        <td>
          15
        </td>
      </tr>
    </tbody>
  </table>
  </div>
    <div class="rank2">
    <h2>能力值排行榜</h2>
    <table class="ranking-page-table">
      <thead>
      <tr>
        <th class="ranking-page-table__heading">姓名</th>
        <th class="ranking-page-table__heading">能力值</th>
        <th class="ranking-page-table__heading">年龄</th>
        <th class="ranking-page-table__heading">联赛级别</th>
        <th class="ranking-page-table__heading">年龄</th>
        <th class="ranking-page-table__heading">进球</th>
        <th class="ranking-page-table__heading">助攻</th>
      </tr>
      </thead>
      <tbody>
      <tr class="ranking-page-table__row">
        <td>
          郭田雨
          {{}}
        </td>
        <td>
          90
        </td>
        <td>
          18
        </td>
        <td>
          20
        </td>
        <td>
          15
        </td>
        <td>
          20
        </td>
        <td>
          15
        </td>
      </tr>
      </tbody>
    </table>
      </div>
  </div>
</template>

<script>
export default {
  name: "RankTable.vue",
  beforeCreate () {
    document.querySelector('body').setAttribute('style', 'background: #3E3E3E;')
  },
}
</script>

<style scoped>


.ranking-page-table {
  transform: translateZ(0);
  width: 50%;
  min-width: 650px;
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
</style>
