package eurekaservice.eurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * spring clound 注册中心
 * 1 引入相应pom依赖
 * 2 增效相应配置，如注册中心端口，Eureka实例
 * 3 添加相应注解@EnableEurekaServer，代表这是一个注册中心，并启用

 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }

}
