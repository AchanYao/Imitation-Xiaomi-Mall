package com.achan.xiaomi_store.service.main;

import com.achan.xiaomi_store.dao.repository.RoleRepository;
import com.achan.xiaomi_store.dao.repository.UserRepository;
import com.achan.xiaomi_store.dao.repository.UserRoleRepository;
import com.achan.xiaomi_store.model.jpa.entity.RoleEntity;
import com.achan.xiaomi_store.model.jpa.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity details = userRepository.findByUsername(s);
        if (details == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 设置用户角色
        List<RoleEntity> roles = new ArrayList<>();
        userRoleRepository.findAllByUserId(details.getId()).forEach(userAndRole -> {
            RoleEntity roleEntity = roleRepository.getById(userAndRole.getRoleId());
            roles.add(roleEntity);
        });
        details.setRoles(roles);
        return details;
    }

    public long count() {
        return userRepository.count();
    }

    public UserEntity disabledUser(int id) {
        UserEntity userEntity = userRepository.getOne(id);
        userEntity.setEnable(0);
        return userRepository.save(userEntity);
    }

    public List<UserEntity> allUsers() {
        return userRepository.findAll();
    }
}
