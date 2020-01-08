<template>
  <div class="container" style="margin-top: 1rem; margin-bottom: 1rem;">
    <div class="m-1">
      <div class="head m-2">
        <span class="h3" @click="showAll()">{{title}}</span>
      </div>
      <div class="body row">
        <div class="col-sm-6 col-md-4 col-lg-3" v-for="item in items" :key="item.id">
          <ItemCard
            :id="item.id"
            :title="item.productName"
            :corver="item.picUrl"
            :description="item.description.substring(0, 11) + '...'"
            :price="item.price"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ItemCard from "../components/ItemCard";
import service from "../service";
import Toast from "../components/Toast"
export default {
  name: "ItemList",
  props: {
    count: {
      type: Number,
      default: 8
    },
    typeId: {
      default: 0
    }
  },
  data() {
    return {
      title: "",
      items: [],
      more: ""
    };
  },
  components: {
    ItemCard
  },
  mounted() {
    var typeItems = "/itemType/get/" + this.typeId;
    var allItems = "/items/all/type";
    if (this.typeId == 0) {
      allItems = "/items/all";
      this.title = "全部商品";
    } else {
      service({
        url: typeItems,
        method: "GET"
      })
        .then(r => {
          this.title = r.data.nameZh;
        })
        .catch(e => {
          Toast.error(this.$bvToast, e);
        });
    }
    service({
      url: allItems,
      params: {
        typeId: this.typeId,
        page: 0,
        pageSize: this.count
      }
    })
      .then(r => {
        this.items = r.data.content;
      })
      .catch(e => {
        Toast.error(this.$bvToast, e);
      });
  },
  methods: {
    showAll() {
      this.$router.push({ name: "itemType", params: { typeId: this.typeId } });
    }
  }
};
</script>

<style scoped>
div.head span.h3 {
  cursor: pointer;
}
</style>