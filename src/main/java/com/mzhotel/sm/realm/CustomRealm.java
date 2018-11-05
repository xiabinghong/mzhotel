package com.mzhotel.sm.realm;

import com.mzhotel.sm.role.service.RoleService;
import com.mzhotel.sm.security.dto.ResourcePermission;
import com.mzhotel.sm.security.service.SecurityService;
import com.mzhotel.sm.security.subject.MzhotelAuthorizationInfo;
import com.mzhotel.sm.security.subject.MzhotelPrincipalCollection;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@lombok.extern.slf4j.Slf4j
public class CustomRealm extends ResourceRealm {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SecurityService securityService;

    public static final String MZHOTELREALM = "MZHOTELRealm";

    @Override
    public String getName() {
        return MZHOTELREALM;
    }

    public CustomRealm() {
        super();
        setName(MZHOTELREALM);
    }

    @Autowired
    private RoleService roleService;

    @Override
    @Resource
    public void setPermissionResolver(PermissionResolver permissionResolver) {
        super.setPermissionResolver(permissionResolver);
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*System.out.println("doGetAuthenticationInfo " + authenticationToken);
        // 1. 把AuthenticationToken 转换为UsernamePasswordToken
        UsernamePasswordToken up = (UsernamePasswordToken) authenticationToken;
        // 2. 从UsernamePasswordToken 中来获取username
        String username = up.getUsername();
        // 3. 调用数据库的方法，从数据库中查询username对应的用户记录
        System.out.println("从数据库中获取userName ：" + username + " 所对应的用户信息.");
        // 4. 若用户不存在，则可以抛出 UnknownAccoountException 异常
        if ("unknown".equals(username)) {
            throw new UnknownAccountException("用户不存在");
        }
        // 5. 根据用户信息的情况，决定是否需要抛出其他的AuthencationException 异常 假设用户被锁定
        if ("monster".equals(username)) {
            throw new LockedAccountException("用户被锁定");
        }
        // 6. 根据用户的情况，来构建AuthenticationInfo 对象并返回，通常使用的是
        // SimpleAuthenticationInfo
        // 以下信息是从数据库获取的.
        Object principal = username; // principal 认证的实体信息.
        // 可以是username，也可以是数据表对应的用户的实体类对象
//        String credentials = "fc1709d0a95a6be30bc5926fdb7f22f4"; // credentials：密码
        String credentials = null; // credentials：密码
        String realmName = getName();
        AuthenticationInfo info = null;new SimpleAuthenticationInfo(principal, credentials, realmName);
        credentials = "098d2c478e9c11555ce2823231e02ec1";
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);//这里的参数要给个唯一的;
        info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        return info;
    }
*/


        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        if (username == null) {
            throw new AccountException("Null username are not allowed by this realm.");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, username, getName());
        MzhotelPrincipalCollection mzhotelPrincipalCollection = new MzhotelPrincipalCollection(username, getName());
        authenticationInfo.setPrincipals(mzhotelPrincipalCollection);
        return authenticationInfo;
    }
    /**
     * 授权,当jsp页面遇到shiro标签会执行该方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) getAvailablePrincipal(principals);
        Map<String, Set<ResourcePermission>> rolePermMap = securityService.getRolePermMap(username);
        Set<String> roleIds = new HashSet<>(rolePermMap.keySet());
        Set<Permission> permissions = rolePermMap.values().stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toSet());
        MzhotelAuthorizationInfo info = new MzhotelAuthorizationInfo();
        info.setRolePermMap(rolePermMap);
        info.setRoles(roleIds);
        info.setObjectPermissions(permissions);
        return info;
    }

}
