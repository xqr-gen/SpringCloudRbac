package com.example.springcloudrbac.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqr
 * @Date: 2021/7/3 20:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPermissionDTO {
    private String pname;
    private int pid;
}
