<template>
  <div id="app" class="main">
    <product-description/>
    <div class="well-display">
      <average-summary />
      <star-summary v-bind:rating="1"/>
      <star-summary v-bind:rating="2"/>
      <star-summary v-bind:rating="3"/>
      <star-summary v-bind:rating="4"/>
      <star-summary v-bind:rating="5"/>
    </div>
    <add-review />
    <review-list />
  </div>
</template>

<script>
import AverageSummary from "./components/AverageSummary.vue";
import StarSummary from "./components/StarSummary.vue";
import AddReview from "./components/AddReview.vue";
import ReviewList from "./components/ReviewList.vue";
import ProductDescription from './components/ProductDescription.vue';

export default {
  name: "app",
  components: {
    AverageSummary,
    StarSummary,
    AddReview,
    ReviewList,
    ProductDescription
  }
};
</script>

<style scoped>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
div.main {
  margin: 1rem 0;
}
div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.well-display div.well {
  cursor: pointer;
}
</style>
