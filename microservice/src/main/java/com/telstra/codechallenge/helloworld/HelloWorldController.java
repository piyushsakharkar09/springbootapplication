package com.telstra.codechallenge.helloworld;

import com.telstra.codechallenge.quotes.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class HelloWorldController {
  private static final String TEMPLATE = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @Autowired
  private HelloWorldProxy proxy;

  @RequestMapping(path = "/hello", method = RequestMethod.GET)
  public HelloWorld hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new HelloWorld(counter.incrementAndGet(), String.format(TEMPLATE, name));
  }

  @RequestMapping(path = "/hello/{name}/quotes/{value}", method =  RequestMethod.GET)
  public HelloQuotesBean retrieveNameQuotes(@RequestParam(value = "name", defaultValue = "World") HelloWorld helloWorld,
                                            @RequestParam(value = "value")Quote quote){
    HelloQuotesBean response = proxy.retrieveName(quote);
    return new HelloQuotesBean(response.getHelloWorld(), response.getQuote());
  }
}
