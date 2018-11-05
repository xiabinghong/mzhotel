package com.mzhotel.sm.security.subject;

import com.mzhotel.sm.security.dto.Action;
import com.mzhotel.sm.security.dto.ResourcePermission;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ResourcePermissionResolver implements PermissionResolver {

    @Override
    public Permission resolvePermission(String permissionString) {
        String[] s = StringUtils.split(permissionString, ':');
        String resourceCode = s[0];
        String rsourceType = s[1];
        String[] actionStrs = StringUtils.split(s[2], ',');
        Action[] actions = new Action[actionStrs.length];
        for (int i = 0; i < actionStrs.length; i++) {
            String actionStr = actionStrs[i];
            actions[i] = Action.valueOf(actionStr);
        }
        return new ResourcePermission(resourceCode, rsourceType, actions);
    }

}
