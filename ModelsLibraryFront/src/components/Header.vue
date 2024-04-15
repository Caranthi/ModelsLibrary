<template>
  <div>
    <p @click="onTitleClick">Models Library</p>
    <input type="text" placeholder="Type model species..." v-model="species" @input="onInput">
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Header",
  data() {
    return {
      species: '',
    }
  },
  methods:
      {
        onTitleClick() {
          window.location.reload();
        },
        onInput() {
          this.emitter.emit('filter', {species: this.species});
        }
      },
}
</script>

<style scoped>
div {
  display: flex;
  background-image: url("~@/assets/HeaderImage.jpg");
  background-position: center;
  width: 74%;
  height: 150px;
  margin-left: 13%;
}

p {
  font-size: 42px;
  margin-top: 8%;
  margin-left: 3%;
  font-family: Alef;
  cursor: pointer;
}

input {
  height: 35%;
  margin-top: 8%;
  font-size: 30px;
  margin-left: 37%;
}
</style>
