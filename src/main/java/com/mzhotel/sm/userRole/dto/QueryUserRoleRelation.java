package com.mzhotel.sm.userRole.dto;

import lombok.Data;

@Data
public class QueryUserRoleRelation {

    private String roleName;

    private String userHasRole;

    private String userNotHasRole;

    private String queryType;

    private String userId;

}
