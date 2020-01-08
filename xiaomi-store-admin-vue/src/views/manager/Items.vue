<template>
  <div>
    <CRow>
      <CCol col="12" xl="8">
        <transition name="slide">
          <CCard>
            <CCardHeader>Items</CCardHeader>
            <CCardBody>
              <CDataTable
                hover
                striped
                :items="items"
                :fields="fields"
                :items-per-page="perPage"
                @row-clicked="rowClicked"
                :pagination="$options.paginationProps"
                index-column
                clickable-rows
              >
                <template #username="data">
                  <td>
                    <strong>{{data.item.productName}}</strong>
                  </td>
                </template>

                <template #picture="data">
                  <td>
                    <img style="width:40px" :src="data.item.picUrl" />
                  </td>
                </template>

                <template #createTime="data">
                  <td>{{ formatDate(data.item.createTime) }}</td>
                </template>
                <!-- <template #status="data">
                  <td>
                    <CBadge :color="getBadge(data.item.status)">{{data.item.status}}</CBadge>
                  </td>
                </template>-->
              </CDataTable>
            </CCardBody>
          </CCard>
        </transition>
      </CCol>
    </CRow>
  </div>
</template>

<script>
import service from "../../service";
export default {
  name: "Items",
  data() {
    return {
      items: [],
      fields: [
        { key: "picture", label: "预览" },
        { key: "username", label: "商品名称" },
        { key: "createTime", label: "上架时间" },
        { key: "stockQuantity", label: "库存" }
      ],
      perPage: 5
    };
  },
  paginationProps: {
    align: "center",
    doubleArrows: false,
    previousButtonHtml: "prev",
    nextButtonHtml: "next"
  },
  methods: {
    loadItems() {
      service({
        url: "/u/items/all"
      })
        .then(r => {
          this.items = r.data.content;
        })
        .catch(e => {
          console.log(e);
        });
    },
    rowClicked(item) {
      const itemLink = this.itemLink(item.id);
      this.$router.push({ path: itemLink });
    },
    formatDate(long) {
      let date = new Date(long);
      let day = date.getDate();
      let mouth = date.getMonth() + 1;
      let year = date.getFullYear();
      let hour = date.getHours();
      let minute = date.getMinutes();
      let second = date.getSeconds();
      return (
        year +
        "/" +
        mouth +
        "/" +
        day +
        " " +
        hour +
        ":" +
        minute +
        ":" +
        second
      );
    },
    itemLink(id) {
      return `items/${id.toString()}`;
    }
  },
  mounted() {
    this.loadItems();
  }
};
</script>

<style>
</style>