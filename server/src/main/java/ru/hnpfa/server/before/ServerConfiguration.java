package ru.hnpfa.server.before;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @since 1.0.0-RC1
 */
@Configuration
@ComponentScan
@EnableWebFluxSecurity
class ServerConfiguration {

    /**
     * @since 1.0.0-RC1
     */
    @Bean
    public SecurityWebFilterChain security(final ServerHttpSecurity security) {
        return security.csrf(Customizer.withDefaults()).build();
    }

}
