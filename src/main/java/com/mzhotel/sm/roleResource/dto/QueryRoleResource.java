package com.mzhotel.sm.roleResource.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryRoleResource implements Serializable{

    private String resourceName;

    private String roleCode;

    private String rsourceCode;

    private String queryType;

    private String hasResource;

    private String notHasResource;
}
