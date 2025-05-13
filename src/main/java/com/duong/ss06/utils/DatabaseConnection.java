package com.duong.ss06.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection connectToDatabase() {
        Connection c = null;

        try {
            // Load cấu hình DB từ file
            Properties p = DatabaseConfig.load();
            if (p == null) {
                throw new IllegalArgumentException("Không load được cấu hình database.");
            }

            String url = p.getProperty("db.url");
            String username = p.getProperty("db.username");
            String password = p.getProperty("db.password");

            // Tải driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy driver MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến database: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định: " + e.getMessage());
        }

        return c;
    }

    public static void close(Connection c) {
        try {
            if (c != null && !c.isClosed()) c.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi đóng connection.");
        }
    }

    public static void close(CallableStatement c) {
        try {
            if (c != null && !c.isClosed()) c.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi đóng callableStatement");
        }
    }
}