<template>
  <div class="card" :class="{read: book.read}" v-bind:key="book.ibsn">
    <h2 class="book-title">{{book.title}}</h2>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <h3 class="book-author">{{book.author}}</h3>
    <button @click="markBookRead" class="mark-read" v-if="!book.read">Mark Read</button>
    <button @click="markBookUnread" class="mark-unread" v-if="book.read">Mark Unread</button>
  </div>
</template>

<script>
export default {
    name: 'book-card',
    props: ["book"],
    methods: {
        markBookRead() {
            this.$store.commit('MARK_BOOK_READ', this.book);
        },
        markBookUnread() {
            this.$store.commit('MARK_BOOK_UNREAD', this.book);
        }
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}
</style>