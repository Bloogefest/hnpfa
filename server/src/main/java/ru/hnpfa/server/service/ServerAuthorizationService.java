package ru.hnpfa.server.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.stereotype.Component;

/**
 * @since 1.0.0-RC1
 */
@Component
public class ServerAuthorizationService {

    /**
     * @since 1.0.0-RC1
     */
    ServerAuthorizationService() {}

    /**
     * @param jwt внешний токен обновления.
     *
     * @return Внешний токен доступа.
     *
     * @since 1.0.0-RC1
     */
    public Jws<Claims> authorize(final Jws<Claims> jwt) {
        // TODO: Выполнить нормальный запрос, получить и вернуть access JWT.
        // TODO: 2Выполнить нормальный запрос, получить и вернуть access JWT.
        // TODO: 3Выполнить нормальный запрос, получить и вернуть access JWT.
        return refreshJwt;
    }

}
