package ru.hnpfa.server.before.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.hnpfa.server.before.api.account.ServerApiAccountHandler;
import ru.hnpfa.server.before.api.service.ServerApiServiceHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * @since 1.0.0-RC1
 */
@Configuration(proxyBeanMethods = false)
@ComponentScan
class ServerApiRouter {

    /**
     * @since 1.0.0-RC1
     */
    private final ServerApiAccountHandler accountHandler;

    /**
     * @since 1.0.0-RC1
     */
    private final ServerApiServiceHandler serviceHandler;

    /**
     * @since 1.0.0-RC1
     */
    ServerApiRouter(@Autowired ServerApiAccountHandler accountHandler,
                    @Autowired ServerApiServiceHandler serviceHandler) {
        this.accountHandler = accountHandler;
        this.serviceHandler = serviceHandler;
    }

    /**
     * @since 1.0.0-RC1
     */
    @Bean
    RouterFunction<ServerResponse> route() {
        return RouterFunctions.route(GET("/service/version").and(accept(MediaType.APPLICATION_JSON)),
                                     serviceHandler::version);
    }

}
