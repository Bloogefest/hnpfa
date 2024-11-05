package ru.hnpfa.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.NonNull;

/**
 * @since 1.0.0-RC1
 */
@SpringBootApplication
class ServerApplication {

    /**
     * @since 1.0.0-RC1
     */
    public static void main(final @NonNull String... args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
