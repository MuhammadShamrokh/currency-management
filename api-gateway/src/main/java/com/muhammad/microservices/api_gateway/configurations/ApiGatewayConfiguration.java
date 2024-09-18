package com.muhammad.microservices.api_gateway.configurations;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p.path("/currency-exchange/**")
                        .filters(f->
                                f.addRequestHeader("MyHeader", "NewHeader")
                                .addRequestParameter("MyParam", "NewParam"))
                        .uri("lb://currency-exchange"))
                .route(p->p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .build();
    }

}


