<template>
  <div class="book-container">
    <book-card
      v-for="book in bookList"
      v-bind:key="book.ibsn"
      v-bind:book="book"
    />

  </div>
</template>

<script>
import BookCard from './BookCard.vue';

export default {
  components: { BookCard },
    name: 'reading-list',
    computed: {
      bookList() {
        return this.$store.state.books;
      }
    }
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>