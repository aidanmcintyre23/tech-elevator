<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'login' }" v-if="!this.$store.state.token">Login</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
  router-link {
    color: black;
  }

  #nav {
    height: 0%;
    display: flex;
    justify-content: center;
    color: red;
  }
  
</style>