package com.mzhotel.sm.security.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mzhotel.sm.login.dto.QueryUserInfo;
import com.mzhotel.sm.security.dto.Action;
import com.mzhotel.sm.security.dto.ResourcePermission;
import com.mzhotel.sm.security.dto.ResourcePermissionDTO;
import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.security.mapper.SecurityMapper;
import com.mzhotel.sm.security.service.SecurityService;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.apache.shiro.authz.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service("securityService")
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    SecurityMapper securityMapper;

    @Override
    public Set<String> getRoles(String userId, String realm) {
        List<Role> list = getRoleInfo(userId);
        Set<String> roles = Sets.newHashSet();
        if (!CollectionUtils.isEmpty(list)) {
            for (Role role : list) {
                roles.add(role.getRoleCode());
            }
            return roles;
        } else {
            return null;
        }
    }

    private List<Role> getRoleInfo(String userId) {
        QueryUserInfo queryUserInfo = new QueryUserInfo();
        queryUserInfo.setUserId(userId);
        return userInfoService.getRoleInfo(queryUserInfo);
    }

    @Override
    public Set<Permission> getPermissions(String userId, String realm) {
        List<ResourcePermissionDTO> resourcePermissionDTOList = getResoucePermissionList(userId);
        Set<Permission> result = new HashSet<>();
        for (ResourcePermissionDTO item : resourcePermissionDTOList) {
            ResourcePermission p = new ResourcePermission(
                    item.getResourceCode(),
                    item.getResourceType(),
                    Action.build(item.getAction())
            );
            result.add(p);
        }
        return result;
    }

    @Override
    public List<ResourcePermissionDTO> getResoucePermissionList(String userId) {
        return securityMapper.getResoucePermissionList(userId);
    }

    @Override
    public Set<String> getPermissions(String userId) {
        List<ResourcePermissionDTO> resourcePermissionDTOList = getResoucePermissionList(userId);
        List<String> permissionStrings = Lists.transform(resourcePermissionDTOList, new Function<ResourcePermissionDTO, String>() {
            @Override
            public String apply(ResourcePermissionDTO resourcePermissionDTO) {
                return resourcePermissionDTO.getJsonString();
            }
        });
        Set<String> set = new TreeSet<>(permissionStrings);
        return set;
    }

    @Override
    public Map<String, Set<ResourcePermission>> getRolePermMap(String userId) {
        List<ResourcePermissionDTO> list = getResoucePermissionList(userId);
        final Map<String, Set<ResourcePermission>> result = new HashMap<>();
        list.stream().collect(Collectors.groupingBy(ResourcePermissionDTO::getResourceCode))
                .entrySet()
                .forEach(x -> {
                    Collection<ResourcePermission> perms = new LinkedList<>();
                    for (ResourcePermissionDTO item : x.getValue()) {
                        ResourcePermission p = new ResourcePermission(
                                item.getResourceCode(),
                                item.getResourceType(),
                                Action.build(item.getAction()));
                        perms.add(p);
                    }
                    result.put(x.getKey(), new HashSet<>(perms));
                });
        return result;
    }
}
