<template>
  <section id="collections">
    <h2>Collections</h2>
    <ul id="collection-list">
      <li v-for="collection in collections" v-bind:key="collection.id" @click="selected(collection.id)">
        {{ collection.name }}
      <span id="icon-container" v-if="isAdmin">
        <router-link v-bind:to="{
          name: 'addRecipe',
          params: {collectionId:collection.id},
        }">
        <font-awesome-icon
        :icon="['fa', 'mug-hot']"
        class="icon"
        title="Add Recipe"/>
      </router-link>
      </span>
    </li>
    </ul>
  </section>
</template>

<script>
export default {
  computed: {
    collections() {
      return this.$store.state.collections;
    },
    isAdmin() {
      return (this.$store.state.user &&
      this.$store.state.user.role &&
      this.$store.state.user.role.includes("ROLE_ADMIN"));
    }
  },
  methods: {
    selected(collectionId) {
      this.$store.commit('SET_CURRENT_COLLECTION_ID', collectionId)
    }
  }
}
</script>

<style>
.icon {
  color: #8783D1;
}

#collections {
  grid-area: collections;
  border-right: 1px solid black;
  border-bottom: none;
}

#collections li {
  cursor: pointer;
  text-transform: capitalize;
}

#collections li:hover {
  background-color: #E3B9BC;
  color: black;
}

#collections h2 {
  background-color: #D1ABAD;
  color: black
}
</style>