package com.zipcoder.cryptonator_api;

import com.zipcoder.cryptonator_api.tools.json.JSONUtils;
import com.zipcoder.cryptonator_api.tools.json.LSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            String uriString = "https://api.cryptonator.com/api/ticker/btc-usd";
            System.out.println("Fetching object from cryptonator.com");
            System.out.println("Attempting to retrieve object from URI...");
            System.out.println(uriString);
            Object jsonObject = restTemplate.getForObject(uriString, Object.class);
            List<JSONObject> jsonObject1 = JSONUtils.parseArray(jsonObject);
            LSONArray lsonArray = new LSONArray(jsonObject1);
            System.out.println(jsonObject.toString());
            System.out.println(lsonArray.toString());
        };
    }

    private void sampleFetch(RestTemplate restTemplate) {
        String uriString = "https://api.cryptonator.com/api/ticker/btc-usd";
        System.out.println("Fetching object from cryptonator.com");
        System.out.println("Attempting to retrieve object from URI...");
        System.out.println(uriString);
        Object jsonObject = restTemplate.getForObject(uriString, Object.class);
        List<JSONObject> jsonObject1 = JSONUtils.parseArray(jsonObject);
        LSONArray lsonArray = new LSONArray(jsonObject1);
        System.out.println(jsonObject.toString());
        System.out.println(lsonArray.toString());
    }
}