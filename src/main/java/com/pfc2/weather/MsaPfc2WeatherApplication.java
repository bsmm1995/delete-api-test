package com.pfc2.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsaPfc2WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaPfc2WeatherApplication.class, args);
    }

}
