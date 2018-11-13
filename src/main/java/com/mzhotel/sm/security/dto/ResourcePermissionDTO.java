package com.mzhotel.sm.security.dto;

import com.google.common.base.Joiner;
import lombok.Data;

@Data
public class ResourcePermissionDTO {

    private static final Joiner joinerId = Joiner.on(":");

    private String resourceCode;
    private String resourceName;
    private String resourceType;
    private String action;
    private String id;
    private String url;

    public String getJsonString() {
        return joinerId.join(resourceCode, resourceType, action);
    }
}
