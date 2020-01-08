package com.achan.xiaomi_store.service.main;

import com.achan.xiaomi_store.dao.repository.ItemRepository;
import com.achan.xiaomi_store.dao.repository.ItemTypeRepository;
import com.achan.xiaomi_store.model.jpa.entity.ItemEntity;
import com.achan.xiaomi_store.service.exception.IncompleteEntityException;
import com.achan.xiaomi_store.service.exception.StoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemTypeRepository itemTypeRepository;

    @Transactional(rollbackFor = StoreException.class)
    public void saveItem(ItemEntity entity) throws IncompleteEntityException {
        if (entity.getItemTypeEntity() == null && entity.getId() == null) {
            throw new IncompleteEntityException("不完整实体：" + entity.toString());
        }
        itemRepository.save(entity);
        itemTypeRepository.save(entity.getItemTypeEntity());
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateItem(ItemEntity entity) {
        itemRepository.save(entity);
    }

    public List<ItemEntity> findAllItem() {
        return itemRepository.findAll();
    }

    public ItemEntity findItemById(Integer id) {
        AtomicReference<ItemEntity> itemEntity = new AtomicReference<>();
        itemRepository.findById(id).ifPresent(entity -> {
            itemEntity.set(entity.setItemTypeEntity(itemTypeRepository.getOne(entity.getTypeId())));
        });
        return itemEntity.get();
    }

    public Page<ItemEntity> findAllByPage(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    public void delete(int itemId) {
        itemRepository.deleteById(itemId);
    }

    public Page<ItemEntity> findAllByType(int typeId, Pageable pageable) {
        return itemRepository.findAllByTypeId(typeId, pageable);
    }

    public Page<ItemEntity> findAllLike(String keyword) {
        return itemRepository.findAllByProductNameContainsOrDescriptionContains(keyword, keyword, PageRequest.of(1, 5));
    }

    public long count() {
        return itemRepository.count();
    }

    public List<ItemEntity> all() {
        return itemRepository.findAll();
    }
}
