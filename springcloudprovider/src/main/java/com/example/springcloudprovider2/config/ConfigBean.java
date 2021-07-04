package com.example.springcloudprovider2.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xqr
 * @Date: 2021/6/28 10:36
 */
@Configuration
public class ConfigBean {

    //没用负载均衡
/*
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
*/

    //使用负载均衡

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }



}
