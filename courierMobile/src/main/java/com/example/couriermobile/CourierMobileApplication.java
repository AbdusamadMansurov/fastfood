package com.example.couriermobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com/example/couriermobile/feign"})
@EnableFeignClients
public class CourierMobileApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourierMobileApplication.class, args);
    }

}
