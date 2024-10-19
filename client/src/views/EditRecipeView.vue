<template>
    <recipe-edit :collectionId="$route.params.collectionId" :recipeId="$route.params.recipeId"/>
    </template>
      
      <script>
      import RecipeEdit from "../components/RecipeEdit.vue";
      export default {
        components: {RecipeEdit},
      }
      </script>
      
      <style>
    
      </style>