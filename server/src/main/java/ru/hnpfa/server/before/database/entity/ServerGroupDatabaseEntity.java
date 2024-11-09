package ru.hnpfa.server.before.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import ru.hnpfa.server.before.database.type.ServerStatusDatabaseType;
import ru.hnpfa.server.before.database.type.ServerStatusPermissionType;

import java.util.Set;
import java.util.UUID;

/**
 * @since 1.0.0-RC1
 */
@Getter
@Entity(name = "group")
@Table(name = "groups")
public class ServerGroupDatabaseEntity {

    /**
     * @since 1.0.0-RC1
     */
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identifier;

    /**
     * @since 1.0.0-RC1
     */
    @Column(nullable = false, length = 64)
    private String name;

    /**
     * @since 1.0.0-RC1
     */
    @Column(nullable = false)
    private ServerStatusDatabaseType status;

    /**
     * @since 1.0.0-RC1
     */
    private UUID parent;

    /**
     * @since 1.0.0-RC1
     */
    @ElementCollection
    @Column(nullable = false)
    private Set<ServerStatusPermissionType> permissions;

}
