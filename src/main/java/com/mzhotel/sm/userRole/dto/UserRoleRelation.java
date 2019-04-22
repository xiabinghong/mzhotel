package com.mzhotel.sm.userRole.dto;

import com.mzhotel.sm.role.dto.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserRoleRelation implements Serializable {

    private String id;

    private List<Role> userHasRoleList;

    private List<Role> userNotHasRoleList;

    private String roleCode;

    private String userId;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private static final long serialVersionUID = 1L;
}