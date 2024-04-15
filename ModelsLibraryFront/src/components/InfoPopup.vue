<template>
  <div v-if="this.isShown" class="background">
    <div class="popup">
      <p>Click on the species name to read about it on Wikipedia!</p>
      <button class="btn btn-secondary" @click="onButtonClick">GOT IT!</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "InfoPopup",
  data() {
    return {
      isShown: true,
    }
  },
  methods:
      {
        onButtonClick() {
          console.log('Pop-up closed');
          this.isShown = false;
        }
      },
}
</script>

<style scoped>
.background {
  width: 100%;
  height: 100%;
  position: fixed;
  background-color: rgba(0, 0, 0, 0.5);
  top: 0;
  left: 0;
}

.popup {
  width: 30%;
  height: 30%;
  position: fixed;
  background-color: white;
  color: black;
  top: 20%;
  left: 35%;
  font-size: 30px;
}

.btn {
  margin-top: 5%;
  font-size: 30px;
  background-color: blue;
}
</style>
