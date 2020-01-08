package com.achan.xiaomi_store.service.exception;

import com.achan.xiaomi_store.model.jpa.entity.ItemEntity;

public class InventoryShortageException extends StoreException {

    public InventoryShortageException() {super();}

    public InventoryShortageException(ItemEntity item) {super("库存不足：" + item.toString());}
}
