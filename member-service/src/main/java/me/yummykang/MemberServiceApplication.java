package me.yummykang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/4 11:21
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
public class MemberServiceApplication {
    @Bean
    public Sampler sampler() {
        return new AlwaysSampler();
    }

    public static void main(String[] args) {
        SpringApplication.run(MemberServiceApplication.class, args);
    }
}
