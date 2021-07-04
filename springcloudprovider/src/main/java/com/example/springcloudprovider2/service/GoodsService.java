package com.example.springcloudprovider2.service;

import com.example.springcloudapi.pojo.dto.AddNewRoleDTO;
import com.example.springcloudapi.pojo.dto.LoginDTO;
import com.example.springcloudapi.pojo.dto.ManageDTO;
import com.example.springcloudapi.pojo.dto.UpdateUserIdentityDTO;

import java.util.List;

/**
 * @Author: xqr
 * @Date: 2021/6/28 10:19
 */
public interface GoodsService {

    public boolean addGoods(ManageDTO manageDTO);
    public boolean deleteGoods(ManageDTO manageDTO);
    public boolean updateGoods(ManageDTO manageDTO);

    public boolean addCart(ManageDTO manageDTO);
    public boolean deleteCart(ManageDTO manageDTO);
    public boolean payCart(ManageDTO manageDTO);

    public boolean addNewRole(AddNewRoleDTO addNewRoleDTO);
    public List<String> permissionInfo(ManageDTO manageDTO);
    public boolean updateUserIdentity(UpdateUserIdentityDTO updateUserIdentityDTO);

    public boolean loginVerify(LoginDTO loginDTO);

    public List<String> sign (LoginDTO loginDTO);


}
