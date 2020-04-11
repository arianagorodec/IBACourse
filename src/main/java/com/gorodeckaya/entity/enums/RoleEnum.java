package com.gorodeckaya.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    ROLE_ANONYMOUS,
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_ACCOUNTANT;

    RoleEnum() {
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
