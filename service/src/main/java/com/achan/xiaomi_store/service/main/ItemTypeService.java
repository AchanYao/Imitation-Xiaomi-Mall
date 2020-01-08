package com.achan.xiaomi_store.service.main;

import com.achan.xiaomi_store.dao.repository.ItemTypeRepository;
import com.achan.xiaomi_store.model.jpa.entity.ItemTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTypeService {

    @Autowired
    private ItemTypeRepository itemTypeRepository;

    public List<ItemTypeEntity> getAll() {
        return itemTypeRepository.findAll();
    }

    public ItemTypeEntity get(int id) {
        return itemTypeRepository.getOne(id);
    }
}
