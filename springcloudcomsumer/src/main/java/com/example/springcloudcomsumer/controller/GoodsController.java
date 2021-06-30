package com.example.springcloudcomsumer.controller;

import com.example.springcloudapi.pojo.vo.LoginVO;
import com.example.springcloudapi.pojo.vo.ManageVo;
import com.example.springcloudcomsumer.common.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xqr
 * @Date: 2021/6/28 10:33
 */
@RestController
public class GoodsController {
    // 消费者不应该有service层
    //RestTemplate  直接调用远程服务

    @Autowired
    private RestTemplate restTemplate;

    // private static final String REST_URL_PREFIX="http://localhost:8081";
//http://localhost:8000/provide-dept/login

    private static final String REST_URL_PREFIX="http://provider-xqr";

    @PostMapping("/login")
    public ResultResponse login(@RequestBody LoginVO loginVO){
        return restTemplate.postForObject(REST_URL_PREFIX+"/login",loginVO,ResultResponse.class);
    }

    @PostMapping("/customer/manageCart")
    public ResultResponse manageCart(@RequestBody ManageVo manageVo){
        return restTemplate.postForObject(REST_URL_PREFIX+"/customer/manageCart",manageVo,ResultResponse.class);
    }

}
