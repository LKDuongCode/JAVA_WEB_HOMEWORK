package com.duong.ss06.dao.hw01_02;

import com.duong.ss06.model.User;
import com.duong.ss06.utils.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDAO {
    @Override
    public Optional<User> findByEmail(String email) {
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call find_user_by_email (?)}")
        ) {
            call.setString(1,email);

            try (ResultSet rs = call.executeQuery()){
                if(rs.next()){
                    User u = new User();
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setEmail(rs.getString("email"));
                    u.setPhone(rs.getString("phone"));
                    u.setPassword(rs.getString("password"));

                    return Optional.of(u);
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public boolean save(User user) {
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call register_new_account(?, ?, ?, ?)}")
        ) {
            call.setString(1, user.getUsername());
            call.setString(2, user.getPassword());
            call.setString(3, user.getEmail());
            call.setString(4, user.getPhone());

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Lỗi khi register: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định: " + e.getMessage());
        }

        return false;
    }

}
