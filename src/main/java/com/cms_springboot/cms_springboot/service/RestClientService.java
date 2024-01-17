package com.cms_springboot.cms_springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientService {
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/todos/";

    public String fetchDataFromEndpoint() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BASE_URL, String.class);
    }
}
