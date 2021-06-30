package com.example.springcloudproviders.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.springcloudapi.pojo.dto.LoginDTO;
import com.example.springcloudapi.pojo.dto.ManageDTO;
import com.example.springcloudapi.pojo.dto.UpdateUserIdentityDTO;

import com.example.springcloudproviders.dao.RbacDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @Author: xqr
 * @Date: 2021/6/28 10:20
 */
@Service
public class GoodsServiceImpl implements GoodsService{
 @Autowired
 private RbacDao rbacDao;

    @Override
    public String manageGoods(ManageDTO manageDTO) {
        return "您可以管理商品";
    }

    @Override
    public String manageCart(ManageDTO manageDTO) {
        return "您可以管理购物车了";
    }

    @Override
    public boolean  updateUserIdentity(UpdateUserIdentityDTO updateUserIdentityDTO) {
        int version =rbacDao.searchVersion(updateUserIdentityDTO);
        updateUserIdentityDTO.setVersion(version);
        if (rbacDao.updateUserIdentity(updateUserIdentityDTO) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean loginVerify(LoginDTO loginDTO) {
        int i=rbacDao.getRidByUid(1);

        String p=rbacDao.getPwd(loginDTO);

        if (p.equals(loginDTO.getPwd())){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public String sign (LoginDTO loginDTO){
        String TOKEN_LOGIN_NAME = "loginName";
        String TOKEN_LOGIN_ID = "userId";
        String TOKEN_SUCCESS = "success";
        String TOKEN_FAIL = "fail";

        HashMap<String, Object> map1 = new HashMap<>(2);
        int a=60*60*60*3;
        int uid=rbacDao.getUid(loginDTO);
        int id=rbacDao.getRidByUid(uid);
        map1.put("typ", "JWT");
        map1.put("alg", "HS256");
        Calendar instance =Calendar.getInstance();
        instance.add(Calendar.SECOND,a);
        String token = JWT.create().withHeader(map1)
                .withClaim("id",uid)
                .withClaim("name",loginDTO.getUname())
                .withClaim("rid",id)
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("!@adhkajshd"));
        return token;

    }
/*
    @Override
    public List<String> manageCart(ManageDTO manageDTO){
        List<Integer> s= rbacDao.searchRbacId(manageDTO.getUid());
        int sign=0;
        for (int i=0;i<s.size();i++){
            if(s.get(i) ==  manageDTO.getPnameid()){
                sign=1;
                break;
            }
        }
        if(sign == 1){
            List<String> s1 = rbacDao.searchRbacName(manageDTO.getUid());
            return s1;
        }else {
            return null;
        }
    }
*/

}
