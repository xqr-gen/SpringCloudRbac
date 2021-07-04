package com.example.springcloudrbac.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqr
 * @Date: 2021/7/1 21:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRbacAllDTO {
    private int uid;
    private int rid;

}
