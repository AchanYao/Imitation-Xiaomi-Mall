<template>
  <CRow>
    <CCol col="12" xl="8">
      <transition name="slide">
        <CCard>
          <CCardHeader>Users</CCardHeader>
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
                  <strong>{{data.item.username}}</strong>
                </td>
              </template>

              <template #status="data">
                <td>
                  <CBadge :color="getBadge(data.item).status">{{ getBadge(data.item).message }}</CBadge>
                </td>
              </template>

              <template #createTime="data">
                <td>{{ formatDate(data.item.createTime) }}</td>
              </template>
            </CDataTable>
          </CCardBody>
        </CCard>
      </transition>
    </CCol>
  </CRow>
</template>

<script>
import service from "../../service";
export default {
  name: "Users",
  data: () => {
    return {
      items: [],
      fields: [
        { key: "username", label: "用户名" },
        { key: "createTime", label: "注册时间" },
        { key: "status", label: "用户状态" }
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
    getBadge(user) {
      return user.enabled
        ? { message: "Active", status: "success" }
        : { message: "Locked", status: "danger" };
    },
    userLink(id) {
      return `users/${id.toString()}`;
    },
    rowClicked(item) {
      const userLink = this.userLink(item.id);
      this.$router.push({ path: userLink });
    },
    loadAllUser() {
      service({
        url: "/admin/user/all"
      })
        .then(r => {
          this.items = r.data;
        })
        .catch(e => {
          if (e.response.status == 403 || e.response.status == 404) {
            this.$router.push("/pages/login");
          }
        });
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
    }
  },
  mounted() {
    this.loadAllUser();
  }
};
</script>
