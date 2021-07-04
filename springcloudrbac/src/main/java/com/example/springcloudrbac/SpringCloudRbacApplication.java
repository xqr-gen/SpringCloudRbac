package com.example.springcloudrbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: xqr
 * @Date: 2021/7/1 21:30
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudRbacApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRbacApplication.class,args);
    }
}
