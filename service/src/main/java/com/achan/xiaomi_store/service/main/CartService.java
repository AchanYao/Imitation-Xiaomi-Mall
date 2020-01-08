package com.achan.xiaomi_store.service.main;

import com.achan.xiaomi_store.dao.repository.CartItemsRepository;
import com.achan.xiaomi_store.dao.repository.ShoppingCartRepository;
import com.achan.xiaomi_store.model.jpa.entity.CartItems;
import com.achan.xiaomi_store.model.jpa.entity.ItemEntity;
import com.achan.xiaomi_store.model.jpa.entity.ShoppingCartEntity;
import com.achan.xiaomi_store.model.jpa.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class CartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private CartItemsRepository cartItemsRepository;
    @Autowired
    private ItemService itemService;

    public void addItem(int itemId, int itemNumber, UserEntity user) {
        shoppingCartRepository.findByUserId(user.getId()).ifPresent(cart -> {
            AtomicBoolean contain = new AtomicBoolean(false); // 标识购物车是否存在该商品
            // 遍历购物车所有商品
            cartItemsRepository.findAllByCartId(cart.getId()).forEach(cartItems -> {
                if (cartItems.getItemId() == itemId) {
                    // 该商品存在，更新商品数量
                    cartItemsRepository.save(cartItems.setItemNumber(cartItems.getItemNumber() + itemNumber));
                    contain.set(true);
                }
            });
            if (contain.get()) return;
            // 商品不存在
            cartItemsRepository.save(new CartItems().setCartId(cart.getId()).setItemId(itemId)
                    .setItemNumber(itemNumber));
        });
    }

    public void updateCart(List<CartItems> cartItems, UserEntity user) {
        shoppingCartRepository.findByUserId(user.getId()).ifPresent(cart -> {
            // 更新现有的
            cartItemsRepository.saveAll(cartItems);
            // 删除不存在的
            List<CartItems> dbItems = cartItemsRepository.findAllByCartId(cart.getId());

            // 设置cartItems中所有对象的商品实体为null，因为数据库中读取到的记录不含商品实体，无法匹配
            cartItems.forEach(c -> {
                c.setItem(null);
            });

            // 遍历数据库中记录
            dbItems.forEach(dbItem -> {
                if (!cartItems.contains(dbItem)) {
                    cartItemsRepository.delete(dbItem);
                }
            });
        });
    }

    public ShoppingCartEntity getShoppingCart(UserEntity user) {
        Optional<ShoppingCartEntity> cart = shoppingCartRepository.findByUserId(user.getId());
        List<CartItems> items = new ArrayList<>();
        cartItemsRepository.findAllByCartId(cart.get().getId()).forEach(cartItems -> {
            items.add(cartItems.setItem(itemService.findItemById(cartItems.getItemId())));
        });
        return cart.get().setItems(items);
    }

    public List<ItemEntity> items(int page, UserEntity user) {
        List<ItemEntity> items = new ArrayList<>(5);
        cartItemsRepository.findAllByCartId(shoppingCartRepository
                .findByUserId(user.getId()).get().getId(), PageRequest.of(page, 5)).forEach(cartItems -> {
            items.add(itemService.findItemById(cartItems.getItemId()));
        });
        return items;
    }
}
