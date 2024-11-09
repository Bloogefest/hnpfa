package ru.hnpfa.server.before.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import ru.hnpfa.server.before.database.type.ServerStatusDatabaseType;

import java.util.UUID;

/**
 * @since 1.0.0-RC1
 */
@Getter
@Entity(name = "account")
@Table(name = "accounts")
public class ServerAccountDatabaseEntity {

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
    private UUID group;

    /**
     * @since 1.0.0-RC1
     */
    @Column(nullable = false)
    private ServerStatusDatabaseType status;

}
