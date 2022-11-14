package Gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

/**
 * Application main class.
 */
@SpringBootApplication
public class Application {

    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    public Application(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        ServiceInstance worker = discoveryClient.getInstances("worker").stream()
                .findFirst()
                .orElseThrow();
        ServiceInstance company = discoveryClient.getInstances("company").stream()
                .findFirst()
                .orElseThrow();

        return builder
                .routes()
                .route("companies", r -> r
                        .host("localhost:8080")
                        .and()
                        .path("/api/companies/{name}", "/api/companies")
                        .uri(company.getUri()))
                .route("workers", r -> r
                        .host("localhost:8080")
                        .and()
                        .path("/api/workers", "/api/workers/{name}")
                        .uri(worker.getUri()))
                .build();
        //return builder.routes().build();

    }

    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}
