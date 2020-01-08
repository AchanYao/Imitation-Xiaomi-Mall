<template>
  <div>
    <b-navbar toggleable="lg" type="light" variant="fade">
      <div class="container">
        <b-navbar-brand href="/">
          <img src="https://s02.mifile.cn/assets/static/image/logo-footer.png" alt="小米商城" />
        </b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item
              v-for="itemType in itemTypes"
              :key="itemType.id"
              :to="{name:'itemType', params: {typeId: itemType.id}}"
            >
              <!-- <b-link :to="{name:'itemType', params: {typeId: itemType.id}}">{{itemType.nameZh}}</b-link> -->
              {{itemType.nameZh}}
            </b-nav-item>
            <b-nav-item href="#">服务</b-nav-item>
            <b-nav-item href="#">社区</b-nav-item>
          </b-navbar-nav>

          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto" @blur="hideRequest()">
            <b-col>
              <b-form-input
                v-model="keyword"
                v-on:change="searchItem()"
                size="sm"
                class="mr-sm-2"
                @focus="showRequest()"
                placeholder="搜索商品"
              ></b-form-input>
              <div style="position:absolute;z-index:100">
                <b-list-group v-show="showSearch" @focus="showRequest()">
                  <b-list-group-item v-if="searching">
                    <b-spinner label="Spinning" small></b-spinner>
                  </b-list-group-item>
                  <b-list-group-item
                    v-for="item in searchResult"
                    :key="item.id"
                    :to="{path: '/item/' + item.id}"
                  >
                    <b-img style="max-width: 30px; max-height: 30px;" :src="item.picUrl"></b-img>
                    {{item.productName}}
                  </b-list-group-item>
                  <b-list-group-item v-if="searchResult.length==0 && !searching">没有更多结果</b-list-group-item>
                </b-list-group>
              </div>
            </b-col>

            <b-nav-item-dropdown right>
              <!-- Using 'button-content' slot -->
              <template v-slot:button-content>
                <em>用户</em>
              </template>
              <b-dropdown-item :to="{name: 'login-page'}" v-show="!this.isLogin">登录</b-dropdown-item>
              <b-dropdown-item v-show="this.isLogin">注销</b-dropdown-item>
              <b-dropdown-item :to="{name: 'shopping-cart'}" v-show="this.isLogin">购物车</b-dropdown-item>
            </b-nav-item-dropdown>
          </b-navbar-nav>
        </b-collapse>
      </div>
    </b-navbar>
  </div>
</template>

<script>
import service from "../service";
import Toast from "../components/Toast";
export default {
  name: "SiteHeader",
  data() {
    return {
      itemTypes: [],
      searching: false,
      searchResult: [],
      keyword: "",
      showSearch: false,
      isLogin: false
    };
  },
  methods: {
    getItemTypes() {
      service({
        url: "/itemType/all",
        method: "GET"
      })
        .then(request => {
          this.itemTypes = request.data;
        })
        .catch(e => {
          Toast.error(this.$bvToast, e);
        });
    },
    searchItem() {
      if (
        this.keyword == undefined ||
        this.keyword == null ||
        this.keyword == ""
      ) {
        this.searchResult = [];
        return;
      }
      this.searching = true;
      service({
        url: "/items/find",
        params: {
          keyword: this.keyword
        }
      })
        .then(r => {
          this.searchResult = r.data.content;
        })
        .catch(e => {
          Toast.error(this.$bvToast, e);
        })
        .finally(() => {
          this.searching = false;
        });
    },
    showRequest() {
      this.showSearch = true;
    },
    hideRequest() {
      this.showSearch = false;
    },
    toBuyItem(itemId) {
      this.$router.push("/item/" + itemId);
    },
    getCurrentUser() {
      service
        .post("/user/current")
        .then(r => {
          if (r != null || r != undefined) this.isLogin = true;
          else this.isLogin = false;
        })
        .catch(reason => {
          console.error(reason);
        });
    },
    logout() {
      service.post("/logout").finally(this.getCurrentUser());
    }
  },
  mounted() {
    this.getItemTypes();
    this.getCurrentUser();
  }
};
</script>

<style scope>
</style>