package com.finki.lab1.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_USER, ROLE_ADMIN, LIBRARIAN, CUSTOMER;

    @Override
    public String getAuthority() {
        return name();
    }
}