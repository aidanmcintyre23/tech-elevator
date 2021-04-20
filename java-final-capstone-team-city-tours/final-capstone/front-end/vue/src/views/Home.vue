<template>
  <div :style="image" class="background-image">
    <h1></h1>
    <home />
  </div>
</template>

<script>
import Home from "@/components/Home.vue"
export default {
  components: {
    Home
  },
  data() {
    return {
      image: { backgroundImage: "url(https://www.thisiscleveland.com/getattachment/5e023d1b-903e-44c8-ac13-f3c3faafcff3/Cleveland-Ohio-in-the-early-evening.jpg)"}
    }
  }
};
</script>

<style scoped>


 div.background-image {
        background-size: cover;
        background-repeat: no-repeat;
        height: 100%;
    }


</style>

