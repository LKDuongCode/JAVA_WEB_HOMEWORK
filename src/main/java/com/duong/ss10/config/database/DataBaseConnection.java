package com.duong.ss10.config.database;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

public class DataBaseConnection {
    public static Connection connection (){
        Connection c = null;
        try {
            Properties p = Optional.ofNullable(DatabaseLoadProperties.load())
                    .orElseThrow(()-> new IllegalArgumentException("Không load được file cấu hình DB"));

            String ulr = p.getProperty("db.url");
            String username = p.getProperty("db.username");
            String password = p.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(ulr,username,password);
        }
        catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        catch (SQLException e){
            System.err.println("lỗi kết nối đến database.");
        }
        catch (Exception e){
            System.err.println("Lỗi bất định " + e.getMessage());
        }

        return c;
    }

    // Hàm test kết nối
//    public static void main(String[] args) {
//        Connection conn = connection();
//        if (conn != null) {
//            System.out.println(" Kết nối thành công đến database!");
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                System.err.println(" Lỗi khi đóng kết nối.");
//            }
//        } else {
//            System.out.println(" Không thể kết nối đến database.");
//        }
//    }
}
