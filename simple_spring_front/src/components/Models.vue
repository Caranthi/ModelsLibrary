<template>
<div>

</div>
</template>

<script>
import axios from 'axios'
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Models",
  data(){
    return{
      models: [],
    }
  },
  mounted() {
    axios.get('http://192.168.0.75:8080/').then((response) =>
    {
      console.log('Models: ', response.data);
      this.models = response.data;
    })
  }
}
</script>

<style scoped>

</style>
