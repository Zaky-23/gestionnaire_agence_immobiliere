package com.application.db;

import java.sql.*;

import java.sql.*;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/agence";
    private static final String USER = "root";
    private static final String PASSWORD = "0123456789";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}