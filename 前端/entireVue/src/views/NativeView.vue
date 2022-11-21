<template>
  <Chinamap ref="chart_China_map"/>
</template>

<script>
import Chinamap from "@/components/Chinamap";
export default {
  name: "NativeView",
  components: {
    Chinamap
  },

  mounted() {
    let TodaysCases = []
    this.$refs.chart_China_map.initMap(TodaysCases)
  }
}
</script>

<style scoped>

</style>
