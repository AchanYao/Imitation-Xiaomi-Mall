<template>
  <div>
    <site-header></site-header>
    <item-carousel></item-carousel>
    <item-list></item-list>
    <item-list v-bind:typeId="1"></item-list>
    <item-list v-bind:typeId="2"></item-list>
    <item-list v-bind:typeId="5"></item-list>
    <item-list v-bind:typeId="6"></item-list>
  </div>
</template>

<script>
import SiteHeader from "../components/SiteHeader";
import ItemCarousel from "../components/ItemCarousel";
import ItemList from "../components/ItemList";
export default {
  name: "Index",
  components: {
    SiteHeader,
    ItemCarousel,
    ItemList
  }
};
</script>

<style>
</style>