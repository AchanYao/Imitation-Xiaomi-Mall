<template>
  <div>
    <site-header></site-header>
    <div class="container mt-5">
      <div class="flex justify-content-end m-1">
        <b-button
          @click="updateCart()"
          :variant="canEdit ? 'success' : 'primary'"
        >{{ canEdit ? '保存' : '编辑' }}</b-button>
        <b-button
          variant="primary"
          style="background: rgb(255, 103, 0); border-color: rgb(255, 103, 0); color: rgb(255, 255, 255);"
          disabled
        >结算</b-button>
      </div>
      <b-table
        id="item-table"
        striped
        hover
        :items="items"
        :fields="fields"
        :busy="isBusy"
        :emptyText="empty.emptyText"
        :per-page="perPage"
        :current-page="page"
        show-empty
        :thead-class="headClass"
      >
        <template v-slot:cell(item.picUrl)="data">
          <b-img style="width: 50px" :src="data.value"></b-img>
        </template>
        <template v-slot:cell(item.description)="data">
          <!-- <b-img style="width: 50px" :src="data.value.substring(0, 20)"></b-img> -->
          <p style="color: rgb(176, 176, 176);">{{data.value.substring(0, 20)}}</p>
        </template>
        <template v-slot:cell(show_details)="row">
          <b-button
            size="sm"
            @click="row.toggleDetails"
            class="mr-2"
          >{{ row.detailsShowing ? '隐藏' : '编辑'}}</b-button>
        </template>

        <template v-slot:row-details="row">
          <b-card>
            <b-row class="mb-2">
              <b-col sm="3" class="text-sm-right">
                <b>商品介绍:</b>
              </b-col>
              <b-col>{{ row.item.item.description }}</b-col>
            </b-row>

            <b-row class="mb-2">
              <b-col sm="3" class="text-sm-right">
                <b>数量:</b>
              </b-col>
              <b-col>{{ row.item.itemNumber }}</b-col>
            </b-row>

            <div class="d-flex justify-content-lg-end">
              <b-button-group>
                <b-button
                  :disabled="!canEdit"
                  variant="outline-success"
                  @click="row.item.itemNumber--"
                >-</b-button>
                <b-button
                  :disabled="!canEdit"
                  variant="outline-success"
                  @click="row.item.itemNumber++"
                >+</b-button>
              </b-button-group>

              <b-button
                :disabled="!canEdit"
                variant="outline-danger"
                @click="removeItem(row.item)"
              >删除</b-button>
            </div>
          </b-card>
        </template>
        <div slot="table-busy" class="text-center text-danger my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Loading...</strong>
        </div>
        <template slot="empty" slot-scope="scope">
          <h4 class="text-center" style="font-family: 楷体;">{{ scope.emptyText }}</h4>
        </template>
      </b-table>
    </div>
    <div>
      <b-pagination
        v-model="page"
        :total-rows="rows"
        :per-page="perPage"
        aria-controls="item-table"
        align="center"
      ></b-pagination>
    </div>
  </div>
</template>

<script>
import SiteHeader from "../components/SiteHeader";
import service from "../service";
import Toast from "../components/Toast";
let _ = require("lodash");
export default {
  components: {
    SiteHeader
  },
  data() {
    return {
      items: [],
      page: 1,
      rows: 0,
      perPage: 3,
      fields: [
        {
          key: "item.picUrl",
          label: "预览"
        },
        {
          key: "item.productName",
          label: "名称"
        },
        {
          key: "item.price",
          label: "价格"
        },
        {
          key: "show_details",
          label: "详细"
        }
      ],
      empty: {
        emptyText: "暂无数据"
      },
      isBusy: true,
      headClass: ["thead-light"],
      canEdit: false
    };
  },
  mounted() {
    this.listItemOfCart(0);
  },
  methods: {
    listItemOfCart() {
      this.isBusy = true;
      service
        .get("/cart/list/item")
        .then(result => {
          this.items = result.data.items;
        })
        .catch(reason => {
          let status = reason.response.status;
          if (status == 403 || status == 404) {
            Toast.warning(this.$bvToast, "请先登录");
            this.$router.push("/loginPage");
          } else {
            Toast.error(this.$bvToast, reason.response.message);
          }
        })
        .finally((this.isBusy = false));
    },
    updateCart() {
      if (this.canEdit == true) {
        this.$bvModal
          .msgBoxConfirm("确认保存", {
            title: "确认？",
            size: "sm",
            buttonSize: "sm",
            okVariant: "danger",
            okTitle: "YES",
            cancelTitle: "NO",
            footerClass: "p-2",
            hideHeaderClose: false,
            centered: true
          })
          .then(value => {
            if (value == true) {
              this.isBusy = true;
              service
                .post("/cart/update", this.items)
                .then(() => {
                  this.listItemOfCart();
                })
                .catch(e => {
                  Toast.error(this.$bvToast, e.response.message);
                })
                .finally(() => {
                  this.isBusy = false;
                });
            }
          });
        this.canEdit = !this.canEdit;
      } else {
        this.canEdit = !this.canEdit;
      }
    },
    removeItem(item) {
      this.items = _.filter(this.items, function(i) {
        return !(i == item);
      });
    }
  },
  watch: {
    items() {
      this.rows = this.items.length;
    }
  }
};
</script>

<style>
</style>