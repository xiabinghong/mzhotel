package com.mzhotel.sm.security.dto;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import lombok.Data;
import org.apache.shiro.authz.Permission;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Data
public class ResourcePermission implements Permission, Serializable {

    private static final Joiner joinerId = Joiner.on(":");
    private static final Joiner joinAction = Joiner.on(",");

    private String resourceCode;
    private String permissionKey;
    private String resourceType;
    private String resourceDescribe;
    private Set<Action> actions = new HashSet<Action>();

    @Override
    public boolean implies(Permission permission) {
        if ((!(permission instanceof ResourcePermission)) || Strings.isNullOrEmpty(resourceCode)) {
            return false;
        }
        ResourcePermission rp = (ResourcePermission) permission;
        if (resourceCode.equals(rp.resourceCode) && resourceType.equals(rp.resourceType) && actions.containsAll(rp.actions)) {
            return true;
        }
        return false;
    }

    public ResourcePermission() {
    }

    public ResourcePermission(String resourceCode, String resourceType, Action... actions) {
        if (actions == null || actions.length == 0) {
            this.actions.add(Action.VIEW);
        } else {
            this.actions.addAll(Arrays.asList(actions));
        }
        this.resourceCode = resourceCode;
        this.resourceType = resourceType;
        String action = joinAction.join(actions);
        permissionKey = joinerId.join(resourceCode, resourceType, action);
    }

}
