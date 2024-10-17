<template>
  <section id="recipes">
    <h1></h1>
    <table id="recipe-table">
        <thead>
            <tr>
                <th>Recipes</th>
            </tr>
        </thead>
        <tbody id="recipe-table-body">
          <tr v-for="recipe in recipes" :key="recipe.id">
            <td>{{ recipe.name }}</td>
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
#recipes {
  grid-area: recipes;
  overflow: auto;
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
#recipe-table tr {
  background-color: #D5C3C3;
}
#recipe-table td {
  text-align: center;
  border: 1px #8783D1;
  padding: 2px 5px 2px 5px;
}
</style>