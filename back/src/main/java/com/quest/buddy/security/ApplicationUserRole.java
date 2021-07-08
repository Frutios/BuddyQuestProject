package com.quest.buddy.security;

import java.util.Set;

import com.google.common.collect.Sets;
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

}
