<template>
  <div>
      <reading-list />
      <div><router-link :to="{name: 'addBook'}">Add Book to Reading List</router-link></div>
  </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue'
export default {
  components: { ReadingList },

}
</script>

<style>

</style>