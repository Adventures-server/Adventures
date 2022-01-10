package ru.adventures.adventures.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DataManager {
    protected Connection connection;

    protected DataManager() {
        this.connection = null;
    }

    public Connection get() throws SQLException {
        return connection;
    }

    private boolean check() throws SQLException {
        return connection != null && !connection.isClosed();
    }

    public void close() throws SQLException {
        connection.close();
    }

    public ResultSet query(String query) throws SQLException {
        if (!check()) connection = get();

        PreparedStatement statement = connection.prepareStatement(query);

        return statement.executeQuery();
    }

    public void query(String query, SQLConsumer<ResultSet> consumer) throws SQLException {
        ResultSet resultSet = query(query);

        consumer.accept(resultSet);

        resultSet.close();
        resultSet.getStatement().close();
    }

    public int update(String update) throws SQLException {
        if (!check()) connection = get();

        PreparedStatement statement = connection.prepareStatement(update);
        int resultCode = statement.executeUpdate();

        statement.close();

        return resultCode;
    }
}
