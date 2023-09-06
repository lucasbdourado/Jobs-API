package br.com.lucasbdourado.jobsapi.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    private static Connection connection;
    private static final String URL = "jdbc:mysql://ipcontainer:3306/jobs";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private ConnectionFactory(Connection connection){}

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = initConnection();
        } else if (connection != null && connection.isClosed()) {
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
