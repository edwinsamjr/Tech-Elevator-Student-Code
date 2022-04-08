<template>
    <div>
        <h1>Title: {{book.title}}</h1>
        <h2>Author: {{book.author}}</h2>

    </div>
</template>

<script>
export default {
    computed: {
        book() {
            return this.$store.state.books.find(b => b.isbn == this.$route.params.isbn);
        }
    }


}
</script>

<style>

</style>