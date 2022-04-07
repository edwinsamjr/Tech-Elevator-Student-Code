import axios from 'axios';

const http = axios.create({
    baseURL: "https://api.dictionaryapi.dev"
});

export default {

    //https://api.dictionaryapi.dev/api/v2/entries/en/$%7Bword%7D

    getDefinition(word) {
        return http.get(`/api/v2/entries/en/${word}`);
    }
}