<template>
  <CRow>
    <CCol sm="6" lg="3">
      <CWidgetDropdown color="primary" :header="userCount" text="用户数量">
        <template #default>
          <CDropdown color="transparent p-0" placement="bottom-end">
            <template #toggler-content>
              <CIcon name="cil-settings" />
            </template>
            <CDropdownItem>Action</CDropdownItem>
            <CDropdownItem>Another action</CDropdownItem>
            <CDropdownItem>Something else here...</CDropdownItem>
            <CDropdownItem disabled>Disabled action</CDropdownItem>
          </CDropdown>
        </template>
        <template #footer>
          <CChartLineSimple
            pointed
            class="mt-3 mx-3"
            style="height:70px"
            :data-points="[65, 59, 84, 84, 51, 55, 40]"
            point-hover-background-color="primary"
            label="Members"
            labels="months"
          />
        </template>
      </CWidgetDropdown>
    </CCol>
    <CCol sm="6" lg="3">
      <CWidgetDropdown color="info" :header="itemCount" text="商品数量">
        <template #default>
          <CDropdown color="transparent p-0" placement="bottom-end" :caret="false">
            <template #toggler-content>
              <CIcon name="cil-location-pin" />
            </template>
            <CDropdownItem>Action</CDropdownItem>
            <CDropdownItem>Another action</CDropdownItem>
            <CDropdownItem>Something else here...</CDropdownItem>
            <CDropdownItem disabled>Disabled action</CDropdownItem>
          </CDropdown>
        </template>
        <template #footer>
          <CChartLineSimple
            pointed
            class="mt-3 mx-3"
            style="height:70px"
            :data-points="[1, 18, 9, 17, 34, 22, 11]"
            point-hover-background-color="info"
            :options="{ elements: { line: { tension: 0.00001 }}}"
            label="Members"
            labels="months"
          />
        </template>
      </CWidgetDropdown>
    </CCol>
  </CRow>
</template>

<script>
import { CChartLineSimple } from "../charts/index.js";
import service from "../../service";
export default {
  name: "WidgetsDropdown",
  components: { CChartLineSimple },
  mounted() {
    service
      .get("/u/items/count")
      .then(r => {
        this.itemCount = r.data + "";
      })
      .catch(e => {
        if (e.response.status == 403 || e.response.status == 404) {
          this.$router.push("/pages/login");
        }
      });
    service
      .get("/admin/user/count")
      .then(r => {
        this.userCount = r.data + "";
      })
      .catch(e => {
        if (e.response.status == 403 || e.response.status == 404) {
          this.$router.push("/pages/login");
        }
      });
  },
  data() {
    return {
      userCount: "0",
      itemCount: "0"
    };
  }
};
</script>
