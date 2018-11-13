package com.mzhotel.sm.security.service;


import com.mzhotel.sm.security.dto.ResourcePermission;
import com.mzhotel.sm.security.dto.ResourcePermissionDTO;
import org.apache.shiro.authz.Permission;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SecurityService {

    Set<String> getRoles(String user, String realm);

    Set<Permission> getPermissions(String user, String realm);

    List<ResourcePermissionDTO> getResoucePermissionList(String user);

    Set<String> getPermissions(String userId);

    Map<String, Set<ResourcePermission>> getRolePermMap(String userId);
}
