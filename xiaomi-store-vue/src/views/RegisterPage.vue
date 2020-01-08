<template>
  <div>
    <site-header></site-header>
    <div class="text-center mt-5">
      <div class="form-signin border">
        <img
          class="mb-4"
          src="https://account.xiaomi.com/static/res/349d9c1/account-static/respassport/acc-2014/img/milogo.png"
          alt
        />
        <h1 class="h3 mb-3 font-weight-normal">注册</h1>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input
          type="text"
          id="inputUsername"
          class="form-control"
          placeholder="用户名"
          required
          autofocus
          v-model="username"
        />
        <label for="inputPassword" class="sr-only">密码</label>
        <input
          type="password"
          id="inputPassword"
          class="form-control"
          placeholder="密码"
          v-model="password"
          required
        />
        <label for="inputCPassword" class="sr-only">确认密码</label>
        <input
          type="password"
          id="inputCPassword"
          class="form-control"
          placeholder="确认密码"
          required
          v-model="cpassword"
        />
        <div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me" disabled /> 记住密码
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" @click="register()">注册</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
      </div>
    </div>
  </div>
</template>

<script>
import qs from "qs";
import service from "../service";
import Toast from "../components/Toast";
import SiteHeader from "../components/SiteHeader";
export default {
  components: {
    SiteHeader
  },
  data() {
    return {
      username: "",
      password: "",
      cpassword: ""
    };
  },
  name: "RegisterPage",
  methods: {
    register() {
      if (this.password != this.cpassword) {
        Toast.warning(this.$bvToast, "两次密码需一致");
      }
      service({
        url: "/user/register",
        data: qs.stringify({
          username: this.username,
          password: this.password,
          cpassword: this.cpassword
        }),
        method: "POST"
      })
        .then(r => {
          Toast.success(this.$bvToast, r);
          this.$router.back();
        })
        .catch(e => {
          Toast.error(this.$bvToast, e);
        })
        .finally(() => {
          this.username = this.password = this.cpassword = "";
        });
    }
  }
};
</script>

<style scoped>
.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}

html,
body {
  height: 100%;
}

body {
  display: -ms-flexbox;
  display: flex;
  -ms-flex-align: center;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-signin .checkbox {
  margin-top: 10px;
  font-weight: 400;
}
.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="input"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>