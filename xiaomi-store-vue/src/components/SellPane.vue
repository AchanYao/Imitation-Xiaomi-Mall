<template>
  <b-card :title="this.item.productName">
    <b-card-text style="color: #b0b0b0;">{{this.item.description}}</b-card-text>
    <b-card-text style="color: #ff6700;">{{this.item.price}}元起</b-card-text>
    <b-button
      href
      style="background: #ff6700; border-color: #ff6700; color: #fff"
      @click="addItem()"
    >加入购物车</b-button>
  </b-card>
</template>

<script>
import service from "../service";
import Toast from "./Toast.js";
export default {
  name: "SellPane",
  props: ["item"],
  methods: {
    addItem() {
      service({
        url: "/cart/add",
        params: {
          itemId: this.item.id,
          number: 1
        },
        method: "PUT"
      })
        .then(r => {
          console.log(r);
        })
        .catch(e => {
          if (e.response.status == 404) {
            Toast.error(this.$bvToast, e.response.message);
            this.$router.push("/loginPage");
          }
        });
    }
  }
};
</script>

<style>
</style>