package ru.adventures.adventures.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.adventures.adventures.operations.SettingsConfiguration;

import java.sql.SQLException;

public class Connection extends DataManager {

    private final HikariDataSource dataSource;

    public Connection() {
        String URL = "jdbc:mysql://%s:%s/%s?useSSL=%s";
        String PoolName = "Adventures-api-%s-%s-%s";
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(String.format(URL, address(), port(), database(), ssl()));
        config.setUsername(username());
        config.setPassword(password());
        config.setMinimumIdle(minimumIdle());
        config.setMaximumPoolSize(maximumPoolSize());
        config.setConnectionTimeout(connectionTimeout());
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");
        config.addDataSourceProperty("useLocalSessionState", "true");
        config.addDataSourceProperty("rewriteBatchedStatements", "true");
        config.addDataSourceProperty("cacheResultSetMetadata", "true");
        config.addDataSourceProperty("cacheServerConfiguration", "true");
        config.addDataSourceProperty("elideSetAutoCommits", "true");
        config.addDataSourceProperty("maintainTimeStats", "false");
        config.setPoolName(String.format(PoolName, id(), server(), mode()));
        dataSource = new HikariDataSource(config);
    }

    @Override
    public java.sql.Connection connection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = dataSource.getConnection();
        }
        return connection;
    }

    public static String address() {
        return SettingsConfiguration.string("Connection.address");
    }

    public static String port() {
        return SettingsConfiguration.string("Connection.port");
    }

    public static String database() {
        return SettingsConfiguration.string("Connection.database");
    }

    public static String username() {
        return SettingsConfiguration.string("Connection.username");
    }

    public static String password() {
        return SettingsConfiguration.string("Connection.password");
    }

    public static String ssl() {
        return SettingsConfiguration.string("Connection.ssl");
    }

    public static Integer minimumIdle() {
        return SettingsConfiguration.integer("Connection.minimumIdle");
    }

    public static Integer maximumPoolSize() {
        return SettingsConfiguration.integer("Connection.maximumPoolSize");
    }

    public static Integer connectionTimeout() {
        return SettingsConfiguration.integer("Connection.connectionTimeout");
    }

    public static String id() {
        return SettingsConfiguration.integer("api-id").toString();
    }

    public static String server() {
        return SettingsConfiguration.string("Server");
    }

    public static String mode() {
        return SettingsConfiguration.string("Mode");
    }

}
