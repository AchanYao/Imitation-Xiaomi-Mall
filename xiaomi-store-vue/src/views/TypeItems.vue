<template>
  <div>
    <site-header></site-header>
    <item-list v-bind:typeId=this.typeId v-bind:count="100"></item-list>
  </div>
</template>

<script>
import SiteHeader from "../components/SiteHeader";
import ItemList from "../components/ItemList";
export default {
  name: "TypeItems",
  props: {
    typeId: {
    }
  },
  components: {
    SiteHeader,
    ItemList
  },
  data() {
    return {};
  }
};
</script>

<style>
</style>