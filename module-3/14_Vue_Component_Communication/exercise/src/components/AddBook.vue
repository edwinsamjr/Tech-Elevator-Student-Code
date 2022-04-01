<template>
    <div class="main">
        <form @submit.prevent="addNewBook" class="new-book-form">
            <div class="form-element">
                <label for="title">Title:</label>
                <input type="text" id="title" v-model="newBook.title" class="title-input" />
            </div>
            <div class="form-element">
                <label for="author">Author:</label>
                <input type="text" id="author" v-model="newBook.author" class="author-input" />
            </div>
            <div class="form-element">
                <label for="isbn">ISBN:</label>
                <input type="text" id="isbn" v-model="newBook.isbn" class="isbn-input" />
            </div>
            <input type="submit" value="Enter Review" />
        </form>
    </div>
</template>

<script>
export default {
    name: "add-book",
    data() {
        return {
            newBook: {

            }
        }
    },
    methods: {
        addNewBook() {
            this.$store.commit('ADD_NEW_BOOK', this.newBook);
        },
        resetForm() {
            this.newBook = {};
        }
    }
}
</script>