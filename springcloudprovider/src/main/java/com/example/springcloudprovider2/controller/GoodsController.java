package com.example.springcloudprovider2.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.springcloudapi.pojo.dto.LoginDTO;
import com.example.springcloudapi.pojo.dto.ManageDTO;
import com.example.springcloudapi.pojo.dto.UpdateUserIdentityDTO;
import com.example.springcloudapi.pojo.vo.LoginVO;
import com.example.springcloudapi.pojo.vo.ManageVo;
import com.example.springcloudapi.pojo.vo.UpdateUserIdentityVO;
import com.example.springcloudprovider2.common.ResultResponse;
import com.example.springcloudprovider2.service.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xqr
 * @Date: 2021/6/28 10:19
 */
@RestController
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsService;

    @PostMapping("/login")
    public ResultResponse login(@RequestBody LoginVO loginVO){
        ResultResponse resultResponse = new ResultResponse();
        LoginDTO loginDTO =new LoginDTO();
        BeanUtil.copyProperties(loginVO, loginDTO);
        if(goodsService.loginVerify(loginDTO)){
            String token= goodsService.sign(loginDTO);
            resultResponse.setCode(20000);
            resultResponse.setMessage("登录成功");
            resultResponse.setObject(token);
        }else {
            resultResponse.setCode(500);
            resultResponse.setMessage("账号或密码不对");
        }
        return resultResponse;
    }


    @PostMapping("/customer/manageCart")
    public ResultResponse manageCart(@RequestBody ManageVo manageVo){
        ResultResponse resultResponse=new ResultResponse();
        ManageDTO manageDTO =new ManageDTO();
        BeanUtil.copyProperties(manageVo, manageDTO);

        String s=goodsService.manageCart(manageDTO);
        resultResponse.setCode(20000);
        resultResponse.setMessage("成功");
        resultResponse.setObject(s);
        return resultResponse;
    }

    // 更改User的身份，

    @PostMapping("/admin/updateUserIdentity")
    public ResultResponse updateUserIdentity(@RequestBody UpdateUserIdentityVO updateUserIdentityVO){
        ResultResponse resultResponse=new ResultResponse();
        UpdateUserIdentityDTO updateUserIdentityDTO =new UpdateUserIdentityDTO();
        BeanUtil.copyProperties(updateUserIdentityVO, updateUserIdentityDTO);

        if(goodsService.updateUserIdentity(updateUserIdentityDTO)){
            resultResponse.setCode(20000);
            resultResponse.setMessage("更新成功");

        }else {
            resultResponse.setCode(500);
            resultResponse.setMessage("更新失败");
        }
        return resultResponse;
    }
    @PostMapping("/merchant/manageGoods")
    public ResultResponse manageGoods(@RequestBody ManageVo manageVo){
        ResultResponse resultResponse=new ResultResponse();
        ManageDTO manageDTO =new ManageDTO();
        BeanUtil.copyProperties(manageVo, manageDTO);

        String s=goodsService.manageGoods(manageDTO);
        resultResponse.setCode(20000);
        resultResponse.setMessage("成功");
        resultResponse.setObject(s);

        return resultResponse;
    }


}
