package com.quest.buddy.security;

import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static com.quest.buddy.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(Sets.newHashSet(USER_READ)),
    ADMIN(Sets.newHashSet(USER_READ,USER_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions){
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }
    public Set<SimpleGrantedAuthority> grantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
        .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
