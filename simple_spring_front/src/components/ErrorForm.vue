<template>
  <div class="container" v-if="this.isShown" v-on:click="closeError">
    <div class="alert alert-danger" role="alert" style="display: flex; justify-content: center">
      <strong/> {{ this.error }}
    </div>
  </div>
</template>

<script>
export default {
  name: "ErrorForm",
  data() {
    return {
      error: '',
      isShown: false,
    }
  },
  methods:
      {
        closeError() {
          this.isShown = false;
        }
      },
  mounted() {
    this.emitter.on('error', (data) => {
      this.error = data.error;
      this.isShown = true;
    })
  },
}
</script>

<style scoped>
div {
  display: flex;
  position: fixed;
  width: 75%;
  height: 75%;
  top: 25%;
  left: 25%;
}

.alert {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50%;
  height: 50%;
  font-size: 500%;
  background-color: rgba(255, 0, 0, 0.8);
}
</style>
