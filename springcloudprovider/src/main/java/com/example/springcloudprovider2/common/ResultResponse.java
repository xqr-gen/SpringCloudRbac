package com.example.springcloudprovider2.common;

/**
 * @Author: xqr
 * @Date: 2021/6/27 16:27
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse {
    private int code;
    private String message;
    private Object object;

    public void make(int code,String message,Object object){
        this.code=code;
        this.message=message;
        this.object=object;
    }
}