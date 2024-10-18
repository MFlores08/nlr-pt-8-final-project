import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      collections: [],
      recipes: [],
      currentCollectionId: 10,
      token: currentToken || '',
      user: currentUser || {},
    },
    mutations: {
      SET_CURRENT_COLLECTION_ID(state, id) {
        state.currentCollectionId = id;
      },
      SET_COLLECTIONS(state, collections) {
        state.collections = collections;
      },
      SET_RECIPES(state, recipes) {
        state.recipes = recipes;
      },
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },

  })
  return store;
}