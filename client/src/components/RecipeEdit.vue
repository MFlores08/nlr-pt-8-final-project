<template>
    <div id="edit-div">
        <form v-on:submit.prevent="submitRecipe">
            <div>
                <label for="recipeName">Name: </label>
                <input type="text" id="recipeName" name="recipeName" v-model="recipe.recipeName" />
            </div>
            <div>
                <label for="recipeIngredients">Ingredients: </label>
                <input type="text" id="recipeIngredients" name="recipeIngredients" v-model="recipe.ingredients" />
            </div>
            <div>
                <label for="recipeInstructions">Instructions: </label>
                <input type="text" id="recipeInstructions" name="recipeInstructions" v-model="recipe.directions" />
            </div>
            <div>
                <label for="recipeCollection">Collection: </label>
                <select name="recipeCollection" id="recipeCollection" v-model="recipe.collectionId">
                    <option v-for="collection in $store.state.collections" :key="collection.id" :value="collection.id">
                        {{ collection.name }}
                    </option>
                </select>
            </div>
            <div>
                <button @click="cancel">Cancel</button>
                <button type="submit">Submit</button>
                <button v-if="recipeId" @click="deleteRecipe">Delete</button>
            </div>
        </form>
    </div>
</template>
      
<script>
import { resourceService } from '../services/ResourceService.js';
export default {
    props: ["recipeId", "collectionId"],
    data() {
        return {
            recipe: {
                recipeName: "",
                ingredients: "",
                directions: "",
                collectionId: this.collectionId,
            },
        };
    },
    methods: {
        submitRecipe() {
            if (this.recipeId) {
                //update
                resourceService.updateRecipe(this.recipeId, this.recipe).then((response) => {
                    this.clearForm();
                    this.$router.push({ name: "home" });
                }).catch((error) => {
                    console.log(error);
                });
            } else {
                //add
                resourceService.addRecipe(this.recipe).then((response) => {
                    this.clearForm();
                    this.$router.push({ name: "home" });
                }).catch((error) => {
                    console.log(error);
                });
            }
        },
        clearForm() {
            this.recipe = {
                recipeName: "",
                ingredients: "",
                directions: "",
                collectionId: this.collectionId,
            };
        },
        deleteRecipe() {
            if (confirm("Are you sure you want to delete this recipe?")) {
                resourceService.deleteRecipe(this.recipeId).then((response) => {
                    this.$router.push({ name: "home" });
                }).catch((error) => {
                    console.log(error);
                });
            }
        },
        cancel() {
            this.$router.push({ name: "home" });
        },

    },
    created() {
        if (this.recipeId) {
            this.recipe = this.$store.state.recipes.find((recipe) => {
                return recipe.recipeId == this.recipeId;
            });
        }
    },
}
</script>
      
<style>
div {
    margin-bottom: 5px;
}

label {
    margin-right: 10px;
}

input {
    background-color: #E3B9BC;
}

select {
    background-color: #E3B9BC;
    text-transform: capitalize;
}

option {
    text-transform: capitalize;
}

button {
    background-color: #AA9ABA;
    margin-right: 5px;
}</style>