package com.mzhotel.sm.security.subject;

import com.mzhotel.sm.security.dto.ResourcePermission;
import lombok.Data;
import org.apache.shiro.authz.SimpleAuthorizationInfo;

import java.util.Map;
import java.util.Set;

@Data
public class MzhotelAuthorizationInfo extends SimpleAuthorizationInfo{

    private Map<String,Set<ResourcePermission>> rolePermMap;

}
