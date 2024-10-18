import axios from 'axios'

const resourceService = {
  getRecipes() {
    return axios.get('/coffee_recipes');
  },
  getCollections() {
    return axios.get('/collections');
  },
  // getRecipeById(collectionId) {
  //   switch (collectionId) {
  //     case 10:
  //       return collectionId10;
  //     case 11:
  //       return collectionId11;
  //     case 12:
  //       return collectionId12;
  //     case 13:
  //       return collectionId13;
  //     default:
  //       return [];
  //   }
  // }
};

export { resourceService };
