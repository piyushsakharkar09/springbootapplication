package com.telstra.codechallenge.helloworld;

import com.telstra.codechallenge.quotes.Quote;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SpringBootQuotesController" , url = "http://gturnquist-quoters.cfapps.io")
public interface HelloWorldProxy {

    @GetMapping("/quotes/{value}")
    public HelloQuotesBean retrieveName(@RequestParam(value = "quoteId", defaultValue = "123") Quote quoteValue);
}
