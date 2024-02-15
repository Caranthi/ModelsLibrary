<template>
  <table>
    <tr>
      <th>Species</th>
      <th>Colour</th>
      <th>First Appearance</th>
      <th>Weight</th>
    </tr>
    <tr v-for="model in models" :key="model.id">
      <td>
        {{ model.species }}
      </td>
      <td>
        {{ model.colour }}
      </td>
      <td>
        {{ model.firstAppearance }}
      </td>
      <td>
        {{ model.weight }}
      </td>
    </tr>
  </table>
  <button class="btn btn-primary">ADD NEW</button>
</template>

<script>
import axios from 'axios'

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Models",
  data() {
    return {
      models: [],
    }
  },
  mounted() {
    axios.get('http://192.168.0.75:8080/').then((response) => {
      console.log('Models: ', response.data);
      this.models = response.data;
    })
  }
}
</script>

<style scoped>
table {
  margin: 1% auto auto;
  border: solid darkturquoise;
  width: 77%;
}

th {
  font-size: 30px;
  border: solid darkturquoise;
}

tr {
  font-size: 23px;
}

td{
  border: solid darkturquoise;
}

button{
  margin-top: 1%;
}
</style>
