package com.jhokomari.bookapp.config;

import com.jhokomari.bookapp.client.InventoryClient;
import com.jhokomari.bookapp.client.ReviewClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {
    private final LoadBalancedExchangeFilterFunction exchangeFilterFunction;
    public WebClient inventoryWebClient(){
        return WebClient.builder().baseUrl("http://inventory-app")
                .filter(exchangeFilterFunction)
                .build();
    }
    @Bean
    public InventoryClient inventoryClient(){
        HttpServiceProxyFactory httpServiceProxyFactory=HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(inventoryWebClient()))
                .build();
        return  httpServiceProxyFactory.createClient(InventoryClient.class);
    }
    public WebClient reviewWebClient(){
        return WebClient.builder().baseUrl("http://review-app")
                .filter(exchangeFilterFunction)
                .build();
    }
    @Bean
    public ReviewClient reviewClient(){
        HttpServiceProxyFactory httpServiceProxyFactory=HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(reviewWebClient()))
                .build();
        return  httpServiceProxyFactory.createClient(ReviewClient.class);
    }
}
