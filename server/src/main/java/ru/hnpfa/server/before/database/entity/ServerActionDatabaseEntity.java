package ru.hnpfa.server.before.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import ru.hnpfa.server.before.database.type.ServerStatusActionType;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * @since 1.0.0-RC1
 */
@Getter
@Entity(name = "action")
@Table(name = "actions")
public class ServerActionDatabaseEntity {

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
    @Column(nullable = false)
    private UUID account;

    /**
     * @since 1.0.0-RC1
     */
    @Column(nullable = false)
    private OffsetDateTime timestamp;

    /**
     * @since 1.0.0-RC1
     */
    @Column(nullable = false)
    private ServerStatusActionType action;

}
