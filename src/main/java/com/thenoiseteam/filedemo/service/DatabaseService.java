package com.thenoiseteam.filedemo.service;

import java.sql.*;

public class DatabaseService {

    //static final String DB_URL =  "jdbc:mysql://15.236.210.166:3306";

    Connection conn = null;
    Statement stmt = null;

    boolean connected = false;

    public void DBconnect(String user, String password) {

        try {
            // Open connection
            System.out.println("Connecting to database...");

            // Connection for prod database
            conn = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4403036", user, password);
            // Connection for local database
            // conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/mspr", user, password);
            System.out.println("Connection success");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public void checkConnection() {
        if (!connected) {
            DBconnect("sql4403036", "VuH83GZFAM");
            connected = true;
        }
    }

    public void InsertIntoDatabase(String table, int id, String name, String value) throws SQLException {
        checkConnection();
        stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO " + table + " VALUES ('" + id + "', '" + name + "', '" + value + "')");
    }

    public void deleteFromDatabase(String table, int id) throws SQLException {
        checkConnection();
        stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM " + table + " WHERE ID = " + id);
    }

    public void updateDatabase(String table, int id, String name, String value) throws SQLException {
        checkConnection();
        stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE " + table + " SET name='" + name + "', value='" + value + "' WHERE id=" + id);

    }

    public int countDatabaseResults(String table, int id) throws SQLException {
        int count = 0;

        checkConnection();
        stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT COUNT(*) AS count FROM " + table + " WHERE id=" + id);
        if(resultSet.next()) {
            count = resultSet.getInt("count");
        }

        return count;
    }

    public int executeQuery(String query) throws SQLException {
        return conn.createStatement().executeUpdate(query);
    }
}
