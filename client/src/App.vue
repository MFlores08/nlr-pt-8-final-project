<template>
  <div id="coffee-app">
    <header>
      <img id="coffeeImage" src="./assets/coffee-generated.jpg" alt="">
      <h1 id="pageTitle">BrewKeeper</h1>
      <nav>
        <router-link v-bind:to="{ name: 'home' }">
          <button>Home</button>
        </router-link>
        <router-link v-bind:to="{ name: 'home' }">
          <button>About</button>
        </router-link>
        <router-link v-bind:to="{ name: 'home' }">
          <button>Contact Us</button>
        </router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token">
          <button>Logout</button>
        </router-link>
        <router-link v-bind:to="{ name: 'login' }" v-else>
          <button>Login</button>
        </router-link>
      </nav>
    </header>
    <main>
      <router-view />
    </main>
    <footer>&copy; 2024 All Rights Reserved</footer>
  </div>
</template>

<style>
body {
  background-color: #AA9ABA;
}

#coffee-app {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  height: 96vh;
  display: grid;
  grid-template-rows: auto 1fr auto;
  grid-template-areas:
    "header"
    "main"
    "footer";
  gap: 5px;
}

main,
header,
footer {
  border-radius: 3px;
  padding: 5px;
}

header {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  grid-area: header;
  display: flex;
  background-color: #CCB7B7;
  align-items: center;
  flex-direction: row;
}

#coffeeImage {
  height:55px;
  width: 55px;
  margin-left: 10px;
  background-blend-mode: color-burn;
}

header h1 {
  flex-grow: 1;
  text-align: center;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-size: 2em;
}

nav {
  flex-grow: 1;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: space-around;
}

nav button {
  width: auto;
  height: auto;
  background-color: #D1ABAD;
  border-radius: 5px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  text-align: center;
  line-height: 50px;
  box-shadow: 2px 2px 2px #777;
  cursor: pointer;
}

nav button:hover {
  background-color: #E3B9BC;
}

main {
  grid-area: main;
  background-color: #CCB7B7;
  overflow: auto;
}

footer {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  grid-area: footer;
  background-color: #CCB7B7;
}

/* @media (min-width: 1024px) {
    body {
        grid-template-rows: 240px 1fr 30px;
    }
    #top-header {
        flex-direction: column;
    }
} */
@media (max-width: 425px) {
  header {
    flex-wrap: wrap;
  }

  nav {
    align-self: stretch;
  }
}
</style>