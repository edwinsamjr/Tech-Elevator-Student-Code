<template>
  <div>
      <ol>
          <li v-for="(planet, index) in $store.state.planets" :key="index" @click="placeFirstByIdx(index)" >{{planet}}</li>
      </ol>
      <input type="text" ref="planetInput" v-model="newPlanet" @keydown.enter="addPlanet('input')"/> <button @click="addPlanet('button')">Add Planet</button>
  </div>
</template>

<script>
export default {
    data() {
        return {
            newPlanet: ""
        }
    },
    methods: {
        placeFirst(planet) {
            let planetIdx = this.planets.indexOf(planet);
            this.planets.splice(planetIdx, 1);
            this.planets.unshift(planet);
        },
        placeFirstByIdx(idx) {
            // let planetToMove = this.planets[idx];
            // this.planets.splice(idx, 1);
            // this.planets.unshift(planetToMove);

            this.$store.commit('PLACE_FIRST', idx);
        },
        addPlanet(whereFrom) {
            console.log(whereFrom);
            this.$store.commit('ADD_PLANET', this.newPlanet);
            this.newPlanet = "";
            this.$refs.planetInput.focus();
            
        }
    }
}
</script>

<style>

</style>