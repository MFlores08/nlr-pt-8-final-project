<template>
  <section id="collections">
    <h2>Collections</h2>
    <ul id="collection-list">
      <li v-for="collection in collections" v-bind:key="collection.id" @click="selected(collection.id)">
        {{ collection.name }}
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  computed: {
    collections() {
      return this.$store.state.collections;
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
#collections {
    grid-area: collections;
    border-right: 1px solid black;
    border-bottom: none;
}
#collections li {
  cursor: pointer;
}
#collections li:hover{
  background-color: #E3B9BC;
  color: black;
}
#collections h2 {
  margin-top: 0;
  background-color: #D1ABAD;
  color:black
}

</style>