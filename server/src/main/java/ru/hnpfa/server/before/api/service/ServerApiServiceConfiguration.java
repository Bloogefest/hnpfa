package ru.hnpfa.server.before.api.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.hnpfa.server.before.api.service.version.ServerApiServiceVersion;
import ru.hnpfa.server.before.api.service.version.ServerApiServiceVersionType;

/**
 * @since 1.0.0-RC1
 */
@Configuration
class ServerApiServiceConfiguration {

    /**
     * @since 1.0.0-RC1
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    ServerApiServiceVersion version() {
        // TODO: build ServerApiServiceVersion from build.gradle.kts or from properties
        return new ServerApiServiceVersion(1, 0, 0, ServerApiServiceVersionType.SNAPSHOT);
    }

}
