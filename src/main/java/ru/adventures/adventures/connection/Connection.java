package ru.adventures.adventures.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.adventures.adventures.operations.Configuration;

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
        return Configuration.string("Connection.address");
    }

    public static String port() {
        return Configuration.string("Connection.port");
    }

    public static String database() {
        return Configuration.string("Connection.database");
    }

    public static String username() {
        return Configuration.string("Connection.username");
    }

    public static String password() {
        return Configuration.string("Connection.password");
    }

    public static String ssl() {
        return Configuration.string("Connection.ssl");
    }

    public static Integer minimumIdle() {
        return Configuration.integer("Connection.minimumIdle");
    }

    public static Integer maximumPoolSize() {
        return Configuration.integer("Connection.maximumPoolSize");
    }

    public static Integer connectionTimeout() {
        return Configuration.integer("Connection.connectionTimeout");
    }

    public static String id() {
        return Configuration.integer("api-id").toString();
    }

    public static String server() {
        return Configuration.string("Server");
    }

    public static String mode() {
        return Configuration.string("Mode");
    }

}
