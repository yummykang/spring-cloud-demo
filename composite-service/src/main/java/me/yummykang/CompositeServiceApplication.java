package me.yummykang;

import me.yummykang.client.MemberClient;
import me.yummykang.client.OrderClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackageClasses = {MemberClient.class, OrderClient.class})
public class CompositeServiceApplication {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Sampler sampler() {
		return new AlwaysSampler();
	}

	public static void main(String[] args) {
		SpringApplication.run(CompositeServiceApplication.class, args);
	}
}
