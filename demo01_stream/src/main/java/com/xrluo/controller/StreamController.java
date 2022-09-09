package com.xrluo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stream")
public class StreamController {

    @GetMapping("/test_map")
    public String testMap(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> collect = integers.stream().map(i -> {
            return i;
        }).collect(Collectors.toList());
        return collect.toString();
    }
}
