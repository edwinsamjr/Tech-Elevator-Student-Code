<template>
  <div>
      <label for="word">Input the word to find:</label>
      <input type="text" id="word" v-model="word"/>
      <button @click="findDefinition"> Find Definition </button>
      <hr/>
      <div  v-if="definition">
        <div v-for="(meaning, index) in definition.meanings" v-bind:key="index">
            {{meaning.partOfSpeech}}
            <p v-for="(definition, idx) in meaning.definitions" v-bind:key="idx"> 
                {{definition.definition}}
            </p>
        </div>
      </div>
  </div>
</template>

<script>
import dictionaryService from '@/services/DictionaryService.js';

export default {
    name: 'dictionary',
    data() {
        return  {
            word: "",
            definition: null
        }
    },
    methods: {
        findDefinition() {
            dictionaryService.getDefinition(this.word).then(response => {
                this.definition = response.data[0];
            });
        }
    }
}
</script>

<style>

</style>