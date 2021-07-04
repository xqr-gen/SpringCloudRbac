package com.example.springcloudapi.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqr
 * @Date: 2021/6/29 17:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private String uname;
    private String pwd;
}
