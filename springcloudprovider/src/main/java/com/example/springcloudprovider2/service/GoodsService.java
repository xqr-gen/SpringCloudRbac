package com.example.springcloudprovider2.service;

import com.example.springcloudapi.pojo.dto.LoginDTO;
import com.example.springcloudapi.pojo.dto.ManageDTO;
import com.example.springcloudapi.pojo.dto.UpdateUserIdentityDTO;

/**
 * @Author: xqr
 * @Date: 2021/6/28 10:19
 */
public interface GoodsService {

    public String manageGoods(ManageDTO manageDTO);

    public String manageCart(ManageDTO manageDTO);

    public boolean updateUserIdentity(UpdateUserIdentityDTO updateUserIdentityDTO);

    public boolean loginVerify(LoginDTO loginDTO);

    public String sign (LoginDTO loginDTO);
}
