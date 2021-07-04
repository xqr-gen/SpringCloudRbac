package com.example.springcloudprovider2.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.springcloudapi.pojo.dto.AddNewRoleDTO;
import com.example.springcloudapi.pojo.dto.LoginDTO;
import com.example.springcloudapi.pojo.dto.ManageDTO;
import com.example.springcloudapi.pojo.dto.UpdateUserIdentityDTO;
import com.example.springcloudprovider2.dao.RbacDao;
import com.example.springcloudprovider2.util.CompareRbac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: xqr
 * @Date: 2021/6/28 10:20
 */
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private RbacDao rbacDao;
    @Autowired
    private RestTemplate restTemplate;
    private static final String REST_URL_PREFIX="http://rbac-xqr";
    @Autowired
    private CompareRbac compareRbac;
    /**
     * 这个类实现 管理员在登录后 提供他可以修改授权的权限
     * @Param: [manageDTO]
     * @Return: java.util.List
     */

    @Override
    public boolean addNewRole(AddNewRoleDTO addNewRoleDTO){
        if(compareRbac.comepare(1,addNewRoleDTO.getUid())){
            //  操作 Cart
            return restTemplate.postForObject(REST_URL_PREFIX+"/manageRbac/addNewRole",addNewRoleDTO,boolean.class);
        }else {
            return restTemplate.postForObject(REST_URL_PREFIX+"/manageRbac/addNewRole",addNewRoleDTO,boolean.class);
        }
    }

    @Override
    public List<String> permissionInfo(ManageDTO manageDTO){
        if(compareRbac.comepare(1,manageDTO.getUid())){
            //  操作 Cart
            List<String> list=restTemplate.postForObject(REST_URL_PREFIX+"/getRbac/infoAll",null, List.class);
            return list;
        }else {
            return null;
        }
    }
    @Override
    public boolean  updateUserIdentity(UpdateUserIdentityDTO updateUserIdentityDTO) {
        if(compareRbac.comepare(1,updateUserIdentityDTO.getUid())){
            //  操作 Cart

            boolean b=restTemplate.postForObject(REST_URL_PREFIX+"/manageRbac/updateUserRole",updateUserIdentityDTO, boolean.class);
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean addGoods(ManageDTO manageDTO) {
        if(compareRbac.comepare(2,manageDTO.getUid())){
            //  操作 goods
            return compareRbac.comepare(2,manageDTO.getUid());
        }else {
            return compareRbac.comepare(2,manageDTO.getUid());
        }
    }

    @Override
    public boolean deleteGoods(ManageDTO manageDTO) {
        if(compareRbac.comepare(3,manageDTO.getUid())){
            //  操作 goods
            return compareRbac.comepare(3,manageDTO.getUid());
        }else {
            return compareRbac.comepare(3,manageDTO.getUid());
        }
    }

    @Override
    public boolean updateGoods(ManageDTO manageDTO) {
        if(compareRbac.comepare(4,manageDTO.getUid())){
            //  操作 goods
            return compareRbac.comepare(4,manageDTO.getUid());
        }else {
            return compareRbac.comepare(4,manageDTO.getUid());
        }
    }

    @Override
    public boolean addCart(ManageDTO manageDTO) {
        if(compareRbac.comepare(5,manageDTO.getUid())){
            //  操作 Cart
            return compareRbac.comepare(5,manageDTO.getUid());
        }else {
            return compareRbac.comepare(5,manageDTO.getUid());
        }
    }

    @Override
    public boolean deleteCart(ManageDTO manageDTO) {
        if(compareRbac.comepare(6,manageDTO.getUid())){
            //  操作 Cart
            return compareRbac.comepare(6,manageDTO.getUid());
        }else {
            return compareRbac.comepare(6,manageDTO.getUid());
        }
    }

    @Override
    public boolean payCart(ManageDTO manageDTO) {
        if(compareRbac.comepare(7,manageDTO.getUid())){
            //  操作 Cart
            return compareRbac.comepare(7,manageDTO.getUid());
        }else {
            return compareRbac.comepare(7,manageDTO.getUid());
        }
    }



    @Override
    public boolean loginVerify(LoginDTO loginDTO) {
        String p=rbacDao.getPwd(loginDTO);

        if (p.equals(loginDTO.getPwd())){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<String> sign (LoginDTO loginDTO){
        String TOKEN_LOGIN_NAME = "loginName";
        String TOKEN_LOGIN_ID = "userId";
        String TOKEN_SUCCESS = "success";
        String TOKEN_FAIL = "fail";

        HashMap<String, Object> map1 = new HashMap<>(2);
        int a=60*60*60*3;
        int uid=rbacDao.getUid(loginDTO);
        int rid=rbacDao.getRidByUid(uid);
        List<String> list=restTemplate.postForObject(REST_URL_PREFIX+"/getRbac/getRbacByuid",uid, List.class);

        map1.put("typ", "JWT");
        map1.put("alg", "HS256");
        Calendar instance =Calendar.getInstance();
        instance.add(Calendar.SECOND,a);
        String token = JWT.create().withHeader(map1)
                .withClaim("id",uid)
                .withClaim("name",loginDTO.getUname())
                .withClaim("rid",rid)
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("!@adhkajshd"));
        List<String> list2=new ArrayList<String>();
        list2.add(token);
        list.addAll(list2);
        //list.set(1,rname);
        return list;

    }


}
