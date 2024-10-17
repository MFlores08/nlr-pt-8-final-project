<template>
  <div id="main-div">
    <collection-list id="collections"/>
    <recipe-table id="recipes"/>
  </div>
</template>

<script>
import CollectionList from '../components/CollectionList.vue';
import RecipeTable from '../components/RecipeTable.vue';
import {resourceService} from '../services/ResourceService.js';
export default {
  components: { CollectionList, RecipeTable },
  created() {
    this.$store.commit('SET_COLLECTIONS', resourceService.getCollections());
    this.$store.commit('SET_RECIPES', resourceService.getRecipes());
  }
}
</script>

<style>
#main-div {
  grid-area: main;
  background-color: #CCB7B7;
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas: "collections recipes";
  overflow: auto;
}
#collections {
  grid-area: collections;
}
#recipes {
  grid-area: recipes;
}
@media (max-width: 425px) {
  #main-div {
    grid-template-columns: 1fr;
    grid-template-areas: 
    "collections"
    "recipes";
  }
}
</style>