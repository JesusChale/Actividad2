package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAdmin {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DBAdmin() throws SQLException {
        this.connect();
    }

    private void connect() throws SQLException{
        try {
            String url = "jdbc:mysql://localhost/animals";
            connection = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            connection = null;
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}
