package ru.hnpfa.server.before.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.hnpfa.server.before.api.service.version.ServerApiServiceVersion;

/**
 * @since 1.0.0-RC1
 */
@Component
public class ServerApiServiceHandler {

    /**
     * @since 1.0.0-RC1
     */
    private final ServerApiServiceVersion version;

    /**
     * @since 1.0.0-RC1
     */
    ServerApiServiceHandler(@Autowired ServerApiServiceVersion version) {
        this.version = version;
    }

    /**
     * @since 1.0.0-RC1
     */
    public Mono<ServerResponse> version(final ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(version);
    }

}
