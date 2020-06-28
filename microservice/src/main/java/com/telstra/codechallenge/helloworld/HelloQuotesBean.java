package com.telstra.codechallenge.helloworld;

import com.telstra.codechallenge.quotes.Quote;

public class HelloQuotesBean {
    private final HelloWorld helloWorld;
    private final Quote quote;


    public HelloQuotesBean(HelloWorld helloWorld, Quote quote) {
        this.helloWorld = helloWorld;
        this.quote = quote;
    }

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public Quote getQuote() {
        return quote;
    }
}
