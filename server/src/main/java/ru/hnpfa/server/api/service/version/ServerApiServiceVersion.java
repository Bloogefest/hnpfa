package ru.hnpfa.server.api.service.version;

/**
 * @since 1.0.0-RC1
 */
public record ServerApiServiceVersion(int major, int minor, int patch, ServerApiServiceVersionType type) {}
