<template>
    <section id="recipes">
        <h1>
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
          <tr>
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
      recipe() {
        return this.$store.state.recipes.find((recipe) => {
          return recipe.recipeId == this.$route.params.recipeId;
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