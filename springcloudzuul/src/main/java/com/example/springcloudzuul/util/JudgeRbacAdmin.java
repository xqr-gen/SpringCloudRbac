package com.example.springcloudzuul.util;




/**
 * @Author: xqr
 * @Date: 2021/6/29 19:16
 */
public class JudgeRbacAdmin {


    public boolean play(int uid,int rid) {

        if(rid==1 ){
            return true;
        }

        return false;
    }
}
