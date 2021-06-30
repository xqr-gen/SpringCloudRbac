package com.example.springcloudcomsumer.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqr
 * @Date: 2021/6/28 15:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse {
    private int code;
    private String message;
    private Object object;

}
