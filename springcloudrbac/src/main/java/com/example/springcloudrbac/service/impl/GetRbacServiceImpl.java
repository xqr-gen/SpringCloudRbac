package com.example.springcloudrbac.service.impl;


import com.example.springcloudrbac.dao.RbacDao;
import com.example.springcloudrbac.pojo.dto.AddNewRoleDTO;
import com.example.springcloudrbac.pojo.dto.GetPermissionDTO;
import com.example.springcloudrbac.pojo.dto.InsertRPDTO;
import com.example.springcloudrbac.pojo.dto.UpdateUserIdentityDTO;
import com.example.springcloudrbac.service.GetRbacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: xqr
 * @Date: 2021/7/1 21:36
 */
@Service
public class GetRbacServiceImpl implements GetRbacService {
    @Autowired
    private RbacDao rbacDao;

    @Override
    public boolean addNewRole(AddNewRoleDTO addNewRoleDTO) {
        try {
            int i1 = rbacDao.addNewRole(addNewRoleDTO);
            int rid = rbacDao.getNewRid(addNewRoleDTO);
            InsertRPDTO insertRPDTO = new InsertRPDTO();
            insertRPDTO.setRid(rid);
            for (int i = 0; i < addNewRoleDTO.getListPid().size(); i++) {
                insertRPDTO.setPid(addNewRoleDTO.getListPid().get(i));
                rbacDao.addNewRP(insertRPDTO);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateUserIdentity(UpdateUserIdentityDTO updateUserIdentityDTO) {
        int version = rbacDao.searchVersion(updateUserIdentityDTO);
        updateUserIdentityDTO.setVersion(version);
        if (rbacDao.updateUserIdentity(updateUserIdentityDTO) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<GetPermissionDTO> getRbacAll() {
        return rbacDao.getRbacAll();
    }

    @Override
    public List<GetPermissionDTO> getRbacByUid(int uid) {
        return rbacDao.getRbacByUid(uid);
    }

    @Override
    public List<Integer> getPidByUid(int uid) {
        return rbacDao.getPidByUid(uid);
    }
}
