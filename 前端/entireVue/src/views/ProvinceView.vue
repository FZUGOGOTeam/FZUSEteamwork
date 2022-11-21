<template>
  <p>提示：{{this.pro}}</p>
</template>

<script>
import router from "@/router";
export default {
  name: "ProvinceView",
  data(){
    return {
      pro: this.$route.query.provinceName
    }
  },
  created(){
    let x = this.$route.query.provinceName;
    console.log(x);
  },
  setup() {
//     console.log(this.data.pro)
    //his.num = this.$route.query.num

  }
}
</script>

<style scoped>

</style>
