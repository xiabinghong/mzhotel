package com.mzhotel.sm.realm;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

abstract public class ResourceRealm extends AuthorizingRealm{

    public Set<String> getAllRoles(PrincipalCollection principals){
        AuthorizationInfo info = this.getAuthorizationInfo(principals);
        HashSet<String> roles = new HashSet<String>(info.getRoles());
        return roles;
    }

    public Collection<Permission> getAllPermission(PrincipalCollection princilals){
        AuthorizationInfo info = this.getAuthorizationInfo(princilals);
        return info.getObjectPermissions();
    }
}
