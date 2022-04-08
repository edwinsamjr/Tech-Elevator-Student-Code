import axios from 'axios';

const http = axios.create({
    baseUrl: "https://api.dictionaryapi.dev/"
});

export default {

    //https://api.dictionaryapi.dev/api/v2/entries/en/
    getDefinition(word) {
        return http.get(`https://api.dictionaryapi.dev/api/v2/entries/en/${word}`);
    }
}