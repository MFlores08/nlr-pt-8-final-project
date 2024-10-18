<template>
  <div v-if="isLoading">
    <loading-spinner id="spinner" :spin="true"/>
  </div>
  <div id="main-div" v-else>
    <collection-list id="collections" />
    <recipe-table id="recipes" />
  </div>
</template>

<script>
import CollectionList from '../components/CollectionList.vue';
import RecipeTable from '../components/RecipeTable.vue';
import { resourceService } from '../services/ResourceService.js';
import LoadingSpinner from '../components/LoadingSpinner.vue';
export default {
  components: { CollectionList, RecipeTable, LoadingSpinner },
  data() {
    return {
      isLoading: false,
    };
  },
  created() {
    this.isLoading = true;
    Promise.all([resourceService.getCollections(), resourceService.getRecipes()])
      .then(([collectionResponse, recipeResponse]) => {
        this.$store.commit('SET_COLLECTIONS', collectionResponse.data);
        this.$store.commit('SET_RECIPES', recipeResponse.data);
      }).catch((error) => {
        console.log(error);
      }).finally(() => {
        this.isLoading = false;
      });
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