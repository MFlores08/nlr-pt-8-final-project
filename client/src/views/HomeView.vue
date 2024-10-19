<template>
  <div v-if="isLoading">
    <loading-spinner id="spinner" :spin="true"/>
  </div>
  <div id="main-div" v-else>

    <div class="view-toggle">
      <button @click="toggleView">Toggle View</button>
      <span>{{ isTileView ? 'Blue View' : 'Java View' }}</span>
    </div>
    <div id="collections" :class="{ tile: isTileView, list: !isTileView }">
      <collection-list :tile-view="isTileView" />
    </div>
    <div id="recipes" :class="{ tile: isTileView, list: !isTileView }">
      <recipe-table :tile-view="isTileView" />
    </div>
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
      isTileView: false,
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
  },
  methods: {
    toggleView() {
      this.isTileView = !this.isTileView;
    }
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

#collections,
#recipes {
  transition: all 0.3s ease;
}

.tile {
background-color: #b3b1e4;
}

.list {
  display: block;
}

.view-toggle {
  margin-bottom: 20px;
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