import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(boardID, cardID) {
    return http.get(`/boards/${boardID}`).then((response) => {
      const cards = response.data.cards;
      // return cards.find(card => card.id == cardID);

      const card = cards.find(card => card.id == cardID);
      console.log(`Found card ${card}`);
      return card;
    });
  }

}
