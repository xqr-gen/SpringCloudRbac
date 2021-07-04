package com.example.springcloudrbac.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqr
 * @Date: 2021/6/29 15:11
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UpdateUserIdentityDTO {
    private int uid;
    private int updatedUserId;
    private int updatedRoleId;
    private int version;
}
