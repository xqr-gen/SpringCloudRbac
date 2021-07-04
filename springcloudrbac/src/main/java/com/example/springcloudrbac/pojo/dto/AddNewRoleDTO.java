package com.example.springcloudrbac.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: xqr
 * @Date: 2021/7/3 23:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddNewRoleDTO {
    private int uid;
    private String newRname;
    private List<Integer> listPid;
}
