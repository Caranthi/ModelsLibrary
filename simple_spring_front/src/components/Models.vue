<template>
  <table>
    <tr>
      <th>Species</th>
      <th>Colour</th>
      <th>First Appearance</th>
      <th>Weight [g]</th>
      <th>Context action</th>
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
      <td>
        <button class="btn btn-secondary" v-on:click="deleteModel(model.id)">DELETE</button>
      </td>
    </tr>
    <tr>
      <td>
        <input type="text" placeholder="Species..." v-model="newSpecies">
      </td>
      <td>
        <input type="text" placeholder="Colour..." v-model="newColour">
      </td>
      <td>
        <input type="number" v-model="firstAppearance">
      </td>
      <td>
        <input type="number" v-model="newWeight">
      </td>
      <td>
        <button class="btn btn-primary" v-on:click="add">ADD</button>
      </td>
    </tr>
  </table>
</template>

<script>
import axios from 'axios'

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Models",
  data() {
    return {
      models: [],
      newSpecies: '',
      newColour: '',
      firstAppearance: 0,
      newWeight: 0,
    }
  },
  mounted() {
    axios.get('http://192.168.0.75:8080/').then((response) => {
      console.log('Models: ', response.data);
      this.models = response.data;
    });
  },
  methods: {
    deleteModel(id) {
      axios.delete(`http://192.168.0.75:8080/${id}`).then((response) => {
        console.log(response.data);

        axios.get('http://192.168.0.75:8080/').then((response) => {
          console.log('Models: ', response.data);
          this.models = response.data;
        });
      }).catch(error => {
        console.error('ERROR: ', error);
      });
    },
    add() {
      let modelData = {species: this.newSpecies, colour: this.newColour, firstAppearance: this.firstAppearance, weight: this.newWeight};

      axios.post('http://192.168.0.75:8080/', modelData).then((response) => {
        console.log('Added model: ', response.data);

        axios.get('http://192.168.0.75:8080/').then((response) => {
          console.log('Models: ', response.data);
          this.models = response.data;
        });
      }).catch(error => {
        console.error('ERROR: ', error);
      });
    }
  },
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

td {
  border: solid darkturquoise;
}

button {
  font-size: 18px;
}
</style>
