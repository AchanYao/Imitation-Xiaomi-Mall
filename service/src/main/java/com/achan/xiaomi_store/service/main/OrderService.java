package com.achan.xiaomi_store.service.main;

import com.achan.xiaomi_store.dao.repository.AddressRepository;
import com.achan.xiaomi_store.dao.repository.ItemRepository;
import com.achan.xiaomi_store.dao.repository.OrderItemsRepository;
import com.achan.xiaomi_store.dao.repository.OrderRepository;
import com.achan.xiaomi_store.model.jpa.entity.ItemEntity;
import com.achan.xiaomi_store.model.jpa.entity.OrderEntity;
import com.achan.xiaomi_store.model.jpa.entity.OrderItems;
import com.achan.xiaomi_store.model.jpa.entity.UserDetailEntity;
import com.achan.xiaomi_store.service.exception.IncompleteEntityException;
import com.achan.xiaomi_store.service.exception.StoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemsRepository orderItemsRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Transactional(rollbackFor = StoreException.class)
    public void addOrder(UserDetailEntity userDetailEntity, OrderEntity orderEntity) throws IncompleteEntityException {
        orderEntity.setUserDetailId(userDetailEntity.getId());
        if (orderEntity.getItems() == null || orderEntity.getItems().size() == 0)
            throw new IncompleteEntityException(orderEntity);
        HashMap<Integer, Integer> map = new HashMap<>();
        orderEntity.getItems().forEach(entity -> {
            if (map.containsKey(entity.getId())) map.put(entity.getId(), map.get(entity) + 1);
            else map.put(entity.getId(), 1);
        });
        map.forEach((entityId, count) -> {
            // 修改订单与商品的映射关系
            orderItemsRepository.save(new OrderItems().setItemNumber(count)
                    .setOrderId(orderEntity.getId()).setItemId(entityId));
            // 更新库存数量
            ItemEntity item = itemRepository.getOne(entityId);
            int stockQuantity = item.getStockQuantity() - count;
            itemRepository.setStockQuantity(stockQuantity, entityId);
        });
        orderRepository.save(orderEntity);
    }

    public void updateAddress(int addressId, OrderEntity orderEntity) {
        orderRepository.save(orderEntity.setAddressId(addressId));
    }

    @Transactional(rollbackFor = StoreException.class)
    public void removeOrder(OrderEntity orderEntity) throws IncompleteEntityException {
        orderRepository.deleteById(orderEntity.getId());
        orderItemsRepository.deleteAllByOrderId(orderEntity.getId());
        // 恢复库存
        List<ItemEntity> itemEntities = orderEntity.getItems();
        if (itemEntities == null || itemEntities.size() == 0) throw new IncompleteEntityException(orderEntity);
        itemRepository.deleteAll(itemEntities);
    }

    public Page<OrderEntity> getOrders(int userDetailId, Pageable pageable) {
        return orderRepository.findAllByUserDetailId(userDetailId, pageable);
    }

    public OrderEntity loadAddress(OrderEntity orderEntity) {
        return orderEntity.setAddress(addressRepository.getOne(orderEntity.getAddressId()));
    }

    public OrderEntity loadItems(OrderEntity orderEntity) {
        List<OrderItems> itemIds = orderItemsRepository.findAllByOrderId(orderEntity.getId());
        List<ItemEntity> items = new ArrayList<>();
        itemIds.forEach(i -> {
            items.add(itemRepository.getOne(i.getItemId()));
        });
        return orderEntity.setItems(items);
    }

    public OrderEntity getFullOrderEntity(int orderId) {
        return loadItems(loadAddress(orderRepository.getOne(orderId)));
    }
}
