package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: xqr
 * @Date: 2021/6/27 15:21
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaApplication_2 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaApplication_2.class,args);
    }

}
