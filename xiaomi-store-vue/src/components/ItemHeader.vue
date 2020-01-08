<template>
  <div class="bg">
    <!-- As a link -->
    <b-navbar type="light" variant="light">
      <div class="container">
        <b-navbar-brand>{{this.name}}</b-navbar-brand>
      </div>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "ItemHeader",
  props: ["name"]
};
</script>

<style scoped>
.bg {
  border-bottom: 1px solid #e0e0e0;
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
}
</style>