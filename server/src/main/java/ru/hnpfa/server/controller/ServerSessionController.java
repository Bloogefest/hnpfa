package ru.hnpfa.server.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hnpfa.server.service.ServerAuthorizationService;

import java.util.UUID;

/**
 * @since 1.0.0-RC1
 */
@Controller
@RequestMapping("/v1/session")
class ServerSessionController {

    /**
     * @since 1.0.0-RC1
     */
    private final JwtParser jwtParser = Jwts.parser()
                                            .build(); // TODO: Получать jwtParser с помощью ServerConfiguration.

    /**
     * @since 1.0.0-RC1
     */
    private final ServerAuthorizationService authorizationService;

    /**
     * @since 1.0.0-RC1
     */
    ServerSessionController(final @Autowired ServerAuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    // Клиент:
    // 1. Получить JWT от Open API.
    // 2. Передать JWT, выполнив запрос: https://api.hnpfa.ru/v1/session/create?jwt=eyJhbGciOiJFUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJUaDhKTk1hRHA2ZmpFdzVDem5iRUpDMFA0RU4xVWIxeEY0N0gwMlhxcE9vIn0.eyJleHAiOjE3MzExNTEwNzEsImlhdCI6MTczMTE0OTI3MSwianRpIjoiMWU1MGI3YzUtM2JmNi00NGExLWIwMzgtMjliZmY2N2UyYTYwIiwiaXNzIjoiaHR0cHM6Ly9hdXRoLmJhbmtpbmdhcGkucnUvYXV0aC9yZWFsbXMva3ViZXJuZXRlcyIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJ0ZWFtMDg5IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoidGVhbTA4OSIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMta3ViZXJuZXRlcyJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoicHJvZmlsZSBncm91cHMgZW1haWwgb3BlbmlkIiwiY2xpZW50SG9zdCI6IjEyNy4wLjAuMSIsImNsaWVudElkIjoidGVhbTA4OSIsImdyb3VwcyI6W10sInByZWZlcnJlZF91c2VybmFtZSI6InNlcnZpY2UtYWNjb3VudC10ZWFtMDg5IiwiY2xpZW50QWRkcmVzcyI6IjEyNy4wLjAuMSJ9.qE_j1hWEr4lw3d36ftm3Wq7o4kMVDY9A2KvFO0Q-keZyK3x3TXBH90pNZmtG_lLcxQ17vhSeWqRwhGCZVx9cLg
    // 3. Получить собственные refresh и access JWT.
    // 4. Выполнить необходимые запросы.
    // ...

    // Сервер (https://api.hnpfa.ru/v1/session/create):
    // 1. Принять запрос с JWT.
    // 2. Выполнить запрос, чтобы получить access JWT: https://api.bankingapi.ru/sandbox/as/aft/connect/token
    // 3. Выполнить запрос: https://api.bankingapi.ru/

    /**
     * @since 1.0.0-RC1
     */
    @GetMapping("/create")
    void create(final @RequestParam("jwt") String refreshToken) {
        final Jws<Claims> refreshJwt = jwtParser.parseSignedClaims(refreshToken);
        final String userId = refreshJwt.getPayload().getSubject();
        // TODO: Получить от БД UUID записи аккаунта с userId в роли subject.
        final UUID account = UUID.randomUUID();
        // TODO: Получить от БД access JWT, если таковой имеется для account, иначе сделать его.
        final Jws<Claims> accessJwt = authorizationService.authorize(refreshJwt);
    }

}
