package com.example.springcloudapi.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqr
 * @Date: 2021/6/29 17:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO {
    private String uname;
    private String pwd;

}
