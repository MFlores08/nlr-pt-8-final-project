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
        <tr v-for="recipe in recipes" :key="recipe.recipeId">
          <td>
            <div id="recipe-name">
              <div>
                <router-link v-bind:to="{
                  name: 'recipe-detail',
                  params: { recipeId: recipe.recipeId },
                }">
                  {{ recipe.recipeName }}
                </router-link>
                <span class="icon-container" v-if="isAdmin">
                  <router-link v-bind:to="{
                    name: 'editRecipe',
                    params: {
                      collectionId: recipe.collectionId,
                      recipeId: recipe.recipeId,
                    },
                  }">
                    <font-awesome-icon :icon="['fas', 'edit']" class="icon" title="Edit Recipe" />
                  </router-link>
                </span>
              </div>
            </div>
          </td>
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
    },
    isAdmin() {
      return (this.$store.state.user &&
        this.$store.state.user.role &&
        this.$store.state.user.role.includes("ROLE_ADMIN"));
    }
  }
}
</script>

<style>
.icon {
  color: #8783D1;
}

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

#recipe-name {
  color: #544F96;
}
</style>