package com.example.springcloudproviders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: xqr
 * @Date: 2021/6/29 23:40
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudProvidersApplition {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProvidersApplition.class,args);

    }
}
