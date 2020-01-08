<template>
  <div>
    <site-header></site-header>
    <item-header :name="this.item.productName"></item-header>
    <div class="container mt-5 mb-5">
      <div class="d-lg-flex justify-content-around">
        <div class="col-sm-12 col-md-6 col-lg-6 mt-3 md-3">
          <b-img :src="this.item.picUrl" style="width: 100%" fluid alt="Fluid image"></b-img>
        </div>
        <div class="col-sm-12 col-md-6 col-lg-6 mt-3 md-3">
          <sell-pane style="width: 100%; border: none" :item="this.item"></sell-pane>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import service from "../service";
import ItemHeader from "../components/ItemHeader";
import SiteHeader from "../components/SiteHeader";
import Toast from "../components/Toast";
import SellPane from "../components/SellPane";
export default {
  name: "item-detail",
  props: ["id"],
  components: {
    ItemHeader,
    SiteHeader,
    SellPane
  },
  data() {
    return {
      item: {}
    };
  },
  mounted() {
    service({
      url: "/items/detail/" + this.id
    })
      .then(r => {
        this.item = r.data;
      })
      .catch(e => {
        Toast.error(this.$bvToast, e.toString());
      });
  }
};
</script>

<style>
</style>