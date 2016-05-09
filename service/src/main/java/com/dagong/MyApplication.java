package com.dagong;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by liuchang on 16/1/15.
 */


@SpringBootApplication
@ImportResource("classpath:base/all.xml")
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MyApplication.class);
        springApplication.setWebEnvironment(true);
        springApplication.run(MyApplication.class, args);
    }

}
