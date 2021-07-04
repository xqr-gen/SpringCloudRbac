package com.example.springcloudrbac.dao;


import com.example.springcloudrbac.pojo.dto.AddNewRoleDTO;
import com.example.springcloudrbac.pojo.dto.GetPermissionDTO;
import com.example.springcloudrbac.pojo.dto.InsertRPDTO;
import com.example.springcloudrbac.pojo.dto.UpdateUserIdentityDTO;
import com.example.springcloudrbac.pojo.vo.AddNewRoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: xqr
 * @Date: 2021/7/1 21:36
 */

@Mapper
@Repository
public interface RbacDao {
    public int getNewRid(AddNewRoleDTO addNewRoleDTO);
    public void addNewRP(InsertRPDTO insertRPDTO);
    public int addNewRole(AddNewRoleDTO addNewRoleDTO);
    public Integer searchVersion(UpdateUserIdentityDTO updateUserIdentityDTO);
    public int updateUserIdentity(UpdateUserIdentityDTO updateUserIdentityDTO);
    public List<GetPermissionDTO> getRbacAll();
    public List<GetPermissionDTO> getRbacByUid(int uid);
    public List<Integer> getPidByUid(int uid);
}
