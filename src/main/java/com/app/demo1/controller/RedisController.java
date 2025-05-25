package com.app.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo1/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/set")
    public String set(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return "Key set successfully";
    }

    @GetMapping("/get")
    public String get(@RequestParam String key) {
        String value = redisTemplate.opsForValue().get(key);
        return value != null ? value : "Key not found";
    }
}
