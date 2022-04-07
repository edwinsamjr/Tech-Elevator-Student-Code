<template>
  <div v-if="card">
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>
  </div>
</template>

<script>
import boardService from '@/services/BoardService.js';

export default {
  name: "card-detail",
  data() {
    return {
      card: null
    }
  },
  created() {
    const boardID = this.$route.params.boardID;
    const cardID = this.$route.params.cardID;
    boardService.getCard(boardID, cardID).then(card => {
      this.card = card;
    });
  }
};
</script>
