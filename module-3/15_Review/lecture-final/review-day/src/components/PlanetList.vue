<template>
  <div>
      <ol>
          <li v-for="(planet, index) in $store.state.planets" :key="index" v-on:click="placeOnTopByIdx(index)">{{ planet }}</li>
      </ol>
      <!-- v-on:keyup.enter="addPlanet('input')" -->
      <input type="text" ref="planetInput" v-model="newPlanet" v-on:keypress.enter="addPlanet('input')"/> 
      <button type="button" @click.stop="addPlanet('button')">Add Planet</button>
  </div>
</template>

<script>
export default {
    data() {
        return {
            newPlanet: ''
        }
    },
    methods: {
        placeOnTop(planet) {
            console.log(`In placeOnTop with ${planet}`);
            let planetIdx = this.planets.indexOf(planet);
            this.planets.splice(planetIdx, 1);
            this.planets.unshift(planet);
        },
        placeOnTopByIdx(idx) {
            // console.log(`In placeOnTopByIdx with ${idx}`);
            // let planetToMove = this.planets[idx];
            // this.planets.splice(idx, 1);
            // this.planets.unshift(planetToMove);
            this.$store.commit('PLACE_ON_TOP', idx);
        },
        sayHello() {
            console.log("Hi");
        },
        addPlanet(whereFrom) {
            console.log(`In addPlanet from ${whereFrom}`);
            //this.planets.unshift(this.newPlanet);
            this.$store.commit('ADD_PLANET', this.newPlanet);
            this.newPlanet = '';
            this.$refs.planetInput.focus();
        }
    }
}
</script>

<style>

</style>