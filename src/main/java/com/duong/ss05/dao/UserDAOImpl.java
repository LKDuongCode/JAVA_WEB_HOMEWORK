package com.duong.ss05.dao;

import com.duong.ss05.model.User;
import com.duong.ss05.utils.DatabaseConnection;

import java.awt.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();

        String sql = "{CALL sp_get_all_user()}";
        try (Connection conn = DatabaseConnection.connectToDatabase();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                list.add(extractResult(rs));
            }

        } catch (SQLException e) {
            System.err.println("Lỗi khi gọi getAll: " + e.getMessage());
        }

        return list;
    }
    private User extractResult(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        return u;
    }
}
