<template>
  <div id="main-div">
    <collection-list id="collections"/>
    <recipe-table id="recipes"/>
  </div>
</template>

<script>
import CollectionList from '../components/CollectionList.vue';
import RecipeTable from '../components/RecipeTable.vue';
export default {
  components: (CollectionList, RecipeTable),
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
</style>