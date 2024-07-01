package com.springcloudgateway.externalServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("RATING-SERVICE")
public interface ApiGatewayService {

    @GetMapping("/users/{userId}")
    public String getUser(@PathVariable("userId") String userId, Integer s);
}
