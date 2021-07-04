package com.example.springcloudrbac.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: xqr
 * @Date: 2021/7/3 23:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddNewRoleVO {
    private int uid;
    private String newRname;
    private List<Integer> listPid;
 }
