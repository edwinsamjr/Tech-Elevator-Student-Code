<template>
  <div id="app">
    <planet-list/>
    <planet-count/>
  </div>
</template>

<script>
import PlanetCount from './components/PlanetCount.vue'
import PlanetList from './components/PlanetList.vue'

export default {
  name: 'App',
  components: {
    PlanetList,
    PlanetCount
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
  margin-top: 60px;
}
</style>
