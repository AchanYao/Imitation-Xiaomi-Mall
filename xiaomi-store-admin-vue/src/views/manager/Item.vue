<template>
  <div>
    <CCol>
      <CCard>
        <CCardHeader>
          <strong>商品修改</strong>
        </CCardHeader>
        <CCardBody>
          <CForm>
            <CInput
              description="商品名称"
              label="商品名称"
              horizontal
              autocomplete="Product Name"
              placeholder="Product Name"
              v-model="item.productName"
              :is-valid="stringValidator"
            />
            <CInput
              label="价格"
              description="调整商品价格"
              placeholder="Price"
              v-model="item.price"
              horizontal
              :is-valid="numberValidator"
              type="number"
            />
            <CInput
              label="库存"
              description="调整商品库存"
              placeholder="Stock quantity"
              v-model="item.stockQuantity"
              horizontal
              :is-valid="numberValidator"
              type="number"
            />
            <div role="group" class="form-group form-row">
              <label class="col-form-label col-sm-3">商品类别</label>
              <div class="col-sm-9">
                <select class="form-control" v-model="typeId">
                  <option
                    value
                    selected="selected"
                    disabled="disabled"
                    hidden="hidden"
                  >Please select</option>
                  <option v-for="type in itemTypes" :value="type.id" :key="type.id">{{type.nameZh}}</option>
                </select>
              </div>
            </div>
            <!-- <CInput label="Date" type="date" horizontal /> -->
            <CTextarea
              label="商品介绍"
              placeholder="Description..."
              horizontal
              rows="9"
              v-model="item.description"
              :is-valid="stringValidator"
            />
            <div role="group" class="form-row">
              <label for="uploadImage" class="col-form-label col-sm-3">商品图片</label>
              <div class="col-sm-9">
                <!---->
                <input
                  id="uploadImage"
                  type="file"
                  accept="image/*"
                  class="custom-file-input"
                  v-on:change="uploadPicture($event)"
                />
                <label
                  id="uploadImage"
                  @click="document.getElementById('uploadImage').click()"
                  class="custom-file-label"
                  style="width: 100%;"
                >{{image == null ? 'Choose file' : image}}</label>
              </div>
            </div>
            <div class="mt-1">
              <img
                :src="item.picUrl"
                style="max-width: 200px; max-height: 200px;"
                :alt="item.productName"
              />
            </div>
          </CForm>
        </CCardBody>
        <CCardFooter>
          <CButton type="submit" size="sm" @click="submit" color="primary">
            <CIcon name="cil-check-circle" />Submit
          </CButton>
          <CButton type="reset" @click="reset()" size="sm" color="danger">
            <CIcon name="cil-ban" />Reset
          </CButton>
        </CCardFooter>
      </CCard>
    </CCol>
  </div>
</template>

<script>
import service from "../../service";
export default {
  props: ["id"],
  name: "Item",
  data() {
    return {
      item: {},
      itemTypes: [],
      typeId: 0,
      image: null
    };
  },
  methods: {
    getItem() {
      service
        .get("http://localhost:8080/api/items/detail/" + this.id)
        .then(r => {
          this.item = r.data;
          this.typeId = this.item.typeId;
        })
        .catch(e => {
          console.log(e);
        });
    },
    reset() {
      this.item = {
        id: 0,
        description: "",
        price: 0,
        stockQuantity: 0,
        picUrl: "",
        productName: "",
        typeId: 0,
        itemTypeEntity: {
          id: 0,
          name: "",
          nameZh: ""
        }
      };
      this.typeId = 0;
      this.image = null;
    },
    submit() {
      service
        .put("/item/add", this.item)
        .then(() => {
          this.$router.back();
        })
        .catch(e => {
          console.error(e);
        });
    },
    uploadPicture(value) {
      if (!value.target.files[0]) {
        this.image = null;
        return;
      }
      this.image = value.target.files[0].name;
      let formData = new FormData();
      formData.append("file", value.target.files[0]);
      service({
        url: "/image/upload",
        method: "POST",
        data: formData,
        headers: {
          "Content-Type": "multipart/form-data"
        }
      })
        .then(result => {
          this.item.picUrl = result.data;
        })
        .catch(e => {
          console.error(e);

          if (e.response.status == 404 || e.response.status == 403) {
            this.$router.push("/pages/login");
          }
        });
    },
    stringValidator(value) {
      return String(value).length >= 1;
    },
    numberValidator(value) {
      return Number(value) ? true : value === 0;
    }
  },
  mounted() {
    this.getItem();
    service.get("/u/itemType/all").then(r => {
      this.itemTypes = r.data;
    });
  },
  watch: {
    typeId() {
      this.item.typeId = this.typeId;
    },
    "item.price"(newValue, oldValue) {
      newValue = Number(newValue);
      if (newValue < 0) {
        this.item.price = oldValue;
      } else this.item.price = newValue;
    },
    "item.stockQuantity"(newValue, oldValue) {
      newValue = Number(newValue);
      if (newValue < 0) {
        this.item.price = oldValue;
      }
    }
  }
};
</script>

<style>
</style>