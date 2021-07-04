package com.example.springcloudrbac.service;


import com.example.springcloudrbac.pojo.dto.AddNewRoleDTO;
import com.example.springcloudrbac.pojo.dto.GetPermissionDTO;
import com.example.springcloudrbac.pojo.dto.UpdateUserIdentityDTO;
import com.example.springcloudrbac.pojo.vo.AddNewRoleVO;

import java.util.List;

/**
 * @Author: xqr
 * @Date: 2021/7/1 21:35
 */

public interface GetRbacService {

    public boolean addNewRole(AddNewRoleDTO addNewRoleDTO);
    public boolean updateUserIdentity(UpdateUserIdentityDTO updateUserIdentityDTO);
    public List<GetPermissionDTO> getRbacAll();
    public List<GetPermissionDTO> getRbacByUid(int uid);
    public List<Integer> getPidByUid(int uid);

}
