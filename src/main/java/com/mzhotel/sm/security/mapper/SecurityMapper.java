package com.mzhotel.sm.security.mapper;

import com.mzhotel.sm.security.dto.ResourcePermissionDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecurityMapper {

    List<ResourcePermissionDTO> getResoucePermissionList(@Param(value="userId") String userId);

}
