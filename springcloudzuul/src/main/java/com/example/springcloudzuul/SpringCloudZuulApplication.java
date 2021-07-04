package com.example.springcloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @Author: DEll
 * @Date: 2021/6/28 21:41
 */
@SpringBootApplication
@EnableZuulProxy
public class SpringCloudZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulApplication.class,args);
    }
}
/*


zuul:
  routes:
    mydept.serviceId: provide-dept
    mydept.path: /mydept/**
  ignored-services: "*"  #不能使用这个路径访问
  prefix: /xqr
 */