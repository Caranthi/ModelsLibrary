<template>
  <div>
    <Header/>
    <Models/>
    <InfoPopup/>
    <ErrorForm/>
  </div>
</template>

<script>

import Header from "@/components/Header.vue";
import Models from "@/components/Models.vue";
import ErrorForm from "@/components/ErrorForm.vue";
import InfoPopup from "@/components/InfoPopup.vue";

export default {
  name: 'App',
  components: {
    InfoPopup,
    ErrorForm,
    Models,
    Header
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

div {
  font-family: "Abhaya Libre";
}
</style>
