package com.example.springcloudzuul.util;

/**
 * @Author: DEll
 * @Date: 2021/6/29 21:21
 */
public class JudgeRbacCustomer {
    public boolean play(int uid,int rid) {

        if(rid==3||rid==1){
            return true;
        }

        return false;
    }
}
