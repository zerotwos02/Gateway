package org.ja.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
    @Bean
    public RouteLocator routeDefinitionLocator(RouteLocatorBulder builder){
        return builder.route()
                .route(r->r.path("/customers/**").uri("http//localhost:8081/")),
                .route(r->r.path("/products/**").uri("http//localhost:8082/"))
                .build();

    }
}
