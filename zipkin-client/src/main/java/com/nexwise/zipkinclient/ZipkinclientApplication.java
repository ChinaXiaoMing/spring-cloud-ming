package com.nexwise.zipkinclient;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ZipkinclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinclientApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hi i'm zipkin client!";
    }

    @RequestMapping("/miya")
    public String miya(){
        return restTemplate.getForObject("http://localhost:8074/hello",String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }


}
