import axios from 'axios'

const resourceService = {
  getRecipes() {
    return axios.get('/coffee_recipes');
  },
  getCollections() {
    return axios.get('/collections');
  },
  addRecipe(recipe) {
    return axios.post('/coffee_recipes', recipe);
  },
  updateRecipe(recipeId, recipe) {
    return axios.put(`/coffee_recipes/${recipeId}`, recipe);
  },
  deleteRecipe(recipeId) {
    return axios.delete(`/coffee_recipes/${recipeId}`);
  }
};

export { resourceService };
