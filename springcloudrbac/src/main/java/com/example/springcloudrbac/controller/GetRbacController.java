package com.example.springcloudrbac.controller;




import cn.hutool.core.bean.BeanUtil;


import com.example.springcloudrbac.pojo.dto.AddNewRoleDTO;
import com.example.springcloudrbac.pojo.dto.GetPermissionDTO;


import com.example.springcloudrbac.pojo.dto.UpdateUserIdentityDTO;
import com.example.springcloudrbac.pojo.vo.AddNewRoleVO;
import com.example.springcloudrbac.pojo.vo.UpdateUserIdentityVO;
import com.example.springcloudrbac.service.impl.GetRbacServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xqr
 * @Date: 2021/7/1 21:34
 */
@RestController
@Slf4j
public class GetRbacController {
    @Autowired
    private GetRbacServiceImpl getRbacService;

    /**
     *增加新角色
     * @Param: [addNewRoleVO]
     * @Return: boolean
     */
    @PostMapping("/manageRbac/addNewRole")
    public boolean addNewRole(@RequestBody AddNewRoleVO addNewRoleVO){
        AddNewRoleDTO addNewRoleDTO =new AddNewRoleDTO();
        BeanUtil.copyProperties(addNewRoleVO, addNewRoleDTO);
        return getRbacService.addNewRole(addNewRoleDTO);
    }
    /**
     *修改角色身份并授权
     * @Param: [updateUserIdentityVO]
     * @Return: boolean
     */
    @PostMapping("/manageRbac/updateUserRole")
    public boolean updateUserRole(@RequestBody UpdateUserIdentityVO updateUserIdentityVO){
        UpdateUserIdentityDTO updateUserIdentityDTO =new UpdateUserIdentityDTO();
        BeanUtil.copyProperties(updateUserIdentityVO, updateUserIdentityDTO);
        return getRbacService.updateUserIdentity(updateUserIdentityDTO);
    }

    @PostMapping("/getRbac/infoAll")
    public List<GetPermissionDTO> getRbacAll(){
        return getRbacService.getRbacAll();
    }

    @PostMapping("getRbac/getRbacByuid")
    public List<GetPermissionDTO> getRbacByuid(@RequestBody int id){

        return getRbacService.getRbacByUid(id);
    }

    @PostMapping("getRbac/getPidByuid")
    public List<Integer> getPidByuid(@RequestBody int id){
        return getRbacService.getPidByUid(id);
    }

}


