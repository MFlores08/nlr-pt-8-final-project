<template>
    <section id="recipes">
        <h1 v-for="recipe in recipes" :key="recipe.id">
                {{ recipe.name }}
        </h1>
      <table id="recipe-table">
        <thead>
        <tr>
            <th>Ingredients</th>
            <th>Instructions</th>
        </tr>
        </thead>
        <tbody id="recipe-table-body">
          <tr v-for="recipe in recipes" :key="recipe.id">
            <td>{{ recipe.ingredients }}</td>
            <td>{{ recipe.directions }}</td>
          </tr>
        </tbody>
      </table>
    </section>
  </template>
  
  <script>
  export default {
    computed: {
      recipes() {
        return this.$store.state.recipes.filter((recipe) => {
          return recipe.collectionId == this.$store.state.currentCollectionId;
        });
      }
    }
  }
  </script>
  
  <style>
#recipes h1 {
  text-align: center;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  width: 100%;
}
#recipe-table {
  border-collapse: collapse;
  border: none;
  width: 100%;
}
#recipe-table th {
  position: sticky;
  top: 0;
  background-color: #D1ABAD;
  color: black;
  z-index: 1;
}
#recipe-table td {
  text-align: center;
  border: 1px #8783D1;
  padding: 2px 5px 2px 5px;
}
  </style>