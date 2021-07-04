package com.example.springcloudzuul.util;

/**
 * @Author: xqr
 * @Date: 2021/6/29 22:27
 */
public class JudgeRbacMerchant {
    public boolean play(int uid,int rid) {

        if(rid==2||rid==1){
            return true;
        }

        return false;
    }

}
