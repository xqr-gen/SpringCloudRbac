package com.example.springcloudprovider2.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: xqr
 * @Date: 2021/7/3 21:27
 */
@Component
public class CompareRbac {
    @Autowired
    private RestTemplate restTemplate;
    private static final String REST_URL_PREFIX="http://rbac-xqr";

    public  boolean comepare(int n,int uid){
        List<Integer> list=restTemplate.postForObject(REST_URL_PREFIX+"/getRbac/getPidByuid",uid, List.class);
        try {
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i) == n) {
                    return true;
                }else {
                    return false;
                }
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

}
