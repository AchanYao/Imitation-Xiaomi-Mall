<template>
  <b-card
    :img-alt="title"
    :img-src="corver"
    img-top
    class="mb-4"
    :class="{'border border-secound shadow mouse': this.mouseIn}"
    @mouseenter="mouseIn=true"
    @mouseleave="mouseIn=false"
    @click="itemDetail()"
  >
    <h5>{{title}}</h5>
    <b-card-text>{{description}}</b-card-text>
    <b-card-text class="text-center" style="color: #ff6700">{{price}}元起</b-card-text>
  </b-card>
</template>

<script>
export default {
  name: "itemCard",
  props: ["title", "corver", "description", "time", "id", "price"],
  data() {
    return {
      mouseIn: false
    };
  },
  methods: {
    itemDetail() {
      this.$router.push({ name: "item-detail", params: { id: this.id } });
    }
  }
};
</script>

<style scope>
.mouse {
  /* margin: 3px; */
  cursor: pointer;
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
}
</style>