<template>
<div :style="image" class="background-image">
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 style="margin-top: 100px;" class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
  </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    
    return {
      image: { backgroundImage: "url(https://www.thisiscleveland.com/getattachment/5e023d1b-903e-44c8-ac13-f3c3faafcff3/Cleveland-Ohio-in-the-early-evening.jpg)"},
    
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },

  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>

div.background-image {
        background-attachment: fixed;
        background-size: cover;
        height: 100vmax;
        background-repeat: no-repeat;
        margin: -100px;
    }

form.form-signin {
  display: flex;
  flex-direction: column;
  justify-items: center;
  align-items: center;
}
</style>
