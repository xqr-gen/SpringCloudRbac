package com.example.springcloudprovider2.dao;

import com.example.springcloudapi.pojo.dto.LoginDTO;
import com.example.springcloudapi.pojo.dto.UpdateUserIdentityDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xqr
 * @Date: 2021/6/29 10:21
 */
@Mapper
@Repository
public interface RbacDao {

    public List<Integer> searchRbacId(int id);
    public List<String> searchRbacName(int id);
    public int searchVersion(UpdateUserIdentityDTO updateUserIdentityDTO);
    public int updateUserIdentity(UpdateUserIdentityDTO updateUserIdentityDTO);
    public String getPwd(LoginDTO loginDTO);
    public int getUid(LoginDTO loginDTO);
    public int getRidByUid(int uid);

}
