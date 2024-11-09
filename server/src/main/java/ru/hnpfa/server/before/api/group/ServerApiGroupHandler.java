package ru.hnpfa.server.before.api.group;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @since 1.0.0-RC1
 */
@Component
public class ServerApiGroupHandler {

    /**
     * @since 1.0.0-RC1
     */
    ServerApiGroupHandler() {}

    /**
     * @since 1.0.0-RC1
     */
    public Mono<ServerResponse> create(final ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
    }

}
