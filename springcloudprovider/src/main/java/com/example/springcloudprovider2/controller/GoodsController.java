package com.example.springcloudprovider2.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.springcloudapi.pojo.dto.AddNewRoleDTO;
import com.example.springcloudapi.pojo.dto.LoginDTO;
import com.example.springcloudapi.pojo.dto.ManageDTO;
import com.example.springcloudapi.pojo.dto.UpdateUserIdentityDTO;
import com.example.springcloudapi.pojo.vo.AddNewRoleVO;
import com.example.springcloudapi.pojo.vo.LoginVO;
import com.example.springcloudapi.pojo.vo.ManageVO;
import com.example.springcloudapi.pojo.vo.UpdateUserIdentityVO;
import com.example.springcloudprovider2.common.ResultResponse;
import com.example.springcloudprovider2.service.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: xqr
 * @Date: 2021/6/28 10:19
 */
@RestController
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsService;
/**
 *登录验证 ，成功后返回token（jwt）
 * @Param: [loginVO]
 * @Return: com.example.springcloudprovider2.common.ResultResponse
 */

    @PostMapping("/login")
    public ResultResponse login(@RequestBody LoginVO loginVO){
        ResultResponse resultResponse = new ResultResponse();
        LoginDTO loginDTO =new LoginDTO();
        BeanUtil.copyProperties(loginVO, loginDTO);

        if(goodsService.loginVerify(loginDTO)){
            List<String> list=goodsService.sign(loginDTO);
            resultResponse.setCode(20000);
            resultResponse.setMessage("登录成功");
            resultResponse.setObject(list);
        }else {
            resultResponse.setCode(500);
            resultResponse.setMessage("账号或密码不对");
        }
        return resultResponse;
    }
    /**
     * 这个类实现 管理员在登录后 提供修改权限和授权的界面信息
     * @Param: [manageVo]
     * @Return: com.example.springcloudprovider2.common.ResultResponse
     */
    @PostMapping("/logined/admin/info")
    public ResultResponse permissionInfo(@RequestBody ManageVO manageVo){
        System.out.println("sss");
        ResultResponse resultResponse=new ResultResponse();
        ManageDTO manageDTO =new ManageDTO();
        BeanUtil.copyProperties(manageVo, manageDTO);
        List<String> list=goodsService.permissionInfo(manageDTO);
        if( list != null){
            resultResponse.make(2000,"导出成功",list);
        }else {
            resultResponse.make(500,"没有权限",null);
        }
        return resultResponse;
    }
    /**
     *添加新角色并授权
     * @Param: [addNewRoleVO]
     * @Return: com.example.springcloudprovider2.common.ResultResponse
     */
    @PostMapping("/logined/admin/addNewRole")
    public ResultResponse addNewRole(@RequestBody AddNewRoleVO addNewRoleVO){
        ResultResponse resultResponse=new ResultResponse();
        AddNewRoleDTO addNewRoleDTO =new AddNewRoleDTO();
        BeanUtil.copyProperties(addNewRoleVO, addNewRoleDTO);
        if(goodsService.addNewRole(addNewRoleDTO)){
            resultResponse.make(2000,"新建角色成功",null);
        }else {
            resultResponse.make(500,"没有权限",null);
        }
        return resultResponse;
    }
/**
 *修改角色身份
 * @Param: [updateUserIdentityVO]
 * @Return: com.example.springcloudprovider2.common.ResultResponse
 */
    @PostMapping("/logined/admin/updateUserRole")
    public ResultResponse updateUserRole(@RequestBody UpdateUserIdentityVO updateUserIdentityVO){
        ResultResponse resultResponse=new ResultResponse();
        UpdateUserIdentityDTO updateUserIdentityDTO =new UpdateUserIdentityDTO();
        BeanUtil.copyProperties(updateUserIdentityVO, updateUserIdentityDTO);
        if(goodsService.updateUserIdentity(updateUserIdentityDTO)){
            resultResponse.make(2000,"修改成功",null);
        }else {
            resultResponse.make(500,"没有权限",null);
        }
        return resultResponse;
    }


    @PostMapping("/logined/merchant/addGoods")
    public ResultResponse addGoods(@RequestBody ManageVO manageVo){
        ResultResponse resultResponse=new ResultResponse();
        ManageDTO manageDTO =new ManageDTO();
        BeanUtil.copyProperties(manageVo, manageDTO);

        if(goodsService.addGoods(manageDTO)){
            resultResponse.make(2000,"增加商品",null);
        }else {
            resultResponse.make(500,"没有权限",null);
        }
        return resultResponse;
    }
    @PostMapping("/logined/merchant/deleteGoods")
    public ResultResponse deleteGoods(@RequestBody ManageVO manageVo){
        ResultResponse resultResponse=new ResultResponse();
        ManageDTO manageDTO =new ManageDTO();
        BeanUtil.copyProperties(manageVo, manageDTO);

        if(goodsService.deleteGoods(manageDTO)){
            resultResponse.make(2000,"删除商品",null);
        }else {
            resultResponse.make(500,"没有权限",null);
        }
        return resultResponse;
    }
    @PostMapping("/logined/merchant/updateGoods")
    public ResultResponse updateGoods(@RequestBody ManageVO manageVo){
        ResultResponse resultResponse=new ResultResponse();
        ManageDTO manageDTO =new ManageDTO();
        BeanUtil.copyProperties(manageVo, manageDTO);

        if(goodsService.updateGoods(manageDTO)){
            resultResponse.make(2000,"修改商品",null);
        }else {
            resultResponse.make(500,"没有权限",null);
        }
        return resultResponse;
    }
    @PostMapping("/logined/customer/addCart")
    public ResultResponse addCart(@RequestBody ManageVO manageVo){
        ResultResponse resultResponse=new ResultResponse();
        ManageDTO manageDTO =new ManageDTO();
        BeanUtil.copyProperties(manageVo, manageDTO);
        if(goodsService.addCart(manageDTO)){
            resultResponse.make(2000,"添加商品到购物车",null);
        }else {
            resultResponse.make(500,"没有权限",null);
        }
        return resultResponse;
    }
    @PostMapping("/logined/customer/deleteCart")
    public ResultResponse deleteCart(@RequestBody ManageVO manageVo){
        ResultResponse resultResponse=new ResultResponse();
        ManageDTO manageDTO =new ManageDTO();
        BeanUtil.copyProperties(manageVo, manageDTO);
        if(goodsService.deleteCart(manageDTO)){
            resultResponse.make(2000,"从购物车删除商品",null);
        }else {
            resultResponse.make(500,"没有权限",null);
        }
        return resultResponse;
    }
    @PostMapping("/logined/customer/payCart")
    public ResultResponse payCart(@RequestBody ManageVO manageVo){
        ResultResponse resultResponse=new ResultResponse();
        ManageDTO manageDTO =new ManageDTO();
        BeanUtil.copyProperties(manageVo, manageDTO);
        if(goodsService.payCart(manageDTO)){
            resultResponse.make(2000,"购物车结算",null);
        }else {
            resultResponse.make(500,"没有权限",null);
        }
        return resultResponse;
    }
}
