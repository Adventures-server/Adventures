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

    public Connection connection() throws SQLException {
        return connection;
    }

    public void close() throws SQLException {
        connection.close();
    }

    public ResultSet query(String query) {
        ResultSet result = null;
        try {
            if (connection() != null) {
                connection = connection();
                result = connection.prepareStatement(query).executeQuery();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public ResultSet select(String query) {
        ResultSet result = null;
        try {
            if (connection() != null) {
                connection = connection();
                result = connection.prepareStatement(query).executeQuery();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public int update(String update) throws SQLException {
        if (connection() != null) connection = connection();

        PreparedStatement statement = connection.prepareStatement(update);
        int resultCode = statement.executeUpdate();

        statement.close();

        return resultCode;
    }
}
