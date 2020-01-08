package com.achan.xiaomi_store.web.util;

import com.achan.xiaomi_store.model.jpa.entity.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;

public final class UserUtil {

    public static UserEntity getCurrentUser() {
        UserEntity user;
        try {
            user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (ClassCastException e) {
            if (e.getMessage().contains("cannot be cast to com.achan.xiaomi_store.model.jpa.entity.UserEntity")) {
                user = null;
            } else {
                throw e;
            }
        }
        return user;
    }

}
