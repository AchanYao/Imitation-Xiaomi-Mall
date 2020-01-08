package com.achan.xiaomi_store.service.main;

import com.achan.xiaomi_store.dao.repository.AddressRepository;
import com.achan.xiaomi_store.dao.repository.ShoppingCartRepository;
import com.achan.xiaomi_store.dao.repository.UserDetailRepository;
import com.achan.xiaomi_store.dao.repository.UserRepository;
import com.achan.xiaomi_store.model.jpa.entity.AddressEntity;
import com.achan.xiaomi_store.model.jpa.entity.ShoppingCartEntity;
import com.achan.xiaomi_store.model.jpa.entity.UserDetailEntity;
import com.achan.xiaomi_store.model.jpa.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    public UserDetailEntity loadUserDetail(UserEntity userEntity) {
        return userDetailRepository.findByUserId(userEntity.getId());
    }

    public UserDetailEntity getUserDetail(int userDetailId) {
        return userDetailRepository.getOne(userDetailId);
    }

    @Transactional(rollbackFor = Exception.class)
    public UserEntity userRegister(UserEntity userEntity) {
        UserEntity newUser = null;
        newUser = userRepository.save(userEntity);
        userDetailRepository.save(new UserDetailEntity().setUserId(newUser.getId()));
        shoppingCartRepository.save(new ShoppingCartEntity().setUserId(newUser.getId()));
        return newUser;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateUserDetail(UserEntity userEntity, UserDetailEntity newDetail) {
        UserDetailEntity userDetailEntity = userDetailRepository.findByUserId(userEntity.getId());
        if (newDetail.getAddresses() != null)
            updateAddress(newDetail.getAddresses(), userDetailEntity);
        if (!newDetail.getEmail().equals(userDetailEntity.getEmail())) userDetailEntity.setEmail(newDetail.getEmail());
        if (newDetail.getRealName().equals(userDetailEntity.getRealName()))
            userDetailEntity.setRealName(newDetail.getRealName());
    }

    private void updateAddress(List<AddressEntity> newAddresses, UserDetailEntity userDetailEntity) {
        addressRepository.deleteAllByUserDetailId(userDetailEntity.getId());
        final int userId = userDetailEntity.getId();
        newAddresses.forEach(addressEntity -> {
            addressRepository.save(addressEntity.setUserDetailId(userId));
        });
    }
}
