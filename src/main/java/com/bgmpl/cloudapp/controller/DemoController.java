package com.bgmpl.cloudapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoController {

    private static final Map<Integer, String> dataMap = new HashMap<>();

    static {
        dataMap.put(1, "AKS deployment Success");
        dataMap.put(2, "Github Actions Pipeline Active");
        dataMap.put(3, "Without deleting pods checking whether its deploying or not");
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("health")
    public String health() {
        return "Application is running";
    }

    @GetMapping("/records")
    public List<Map<String, Object>> getTwoRecords() {
        List<Map<String, Object>> response = new ArrayList<>();
        dataMap.forEach((id, message) -> {
            Map<String, Object> record = new HashMap<>();
            record.put("id", id);
            record.put("status", message);
            response.add(record);

        });
        return response;
    }
}
