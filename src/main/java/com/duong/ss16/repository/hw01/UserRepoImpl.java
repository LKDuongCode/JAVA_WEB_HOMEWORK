package com.duong.ss16.repository.hw01;

import com.duong.ss16.connection.DatabaseConnection;
import com.duong.ss16.dto.hw01.LoginUserDTO;
import com.duong.ss16.dto.hw01.RegisterUserDTO;
import com.duong.ss16.model.hw01.User;
import com.duong.ss16.model.hw01.UserRole;
import com.duong.ss16.model.hw01.UserStatus;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UserRepoImpl implements UserRepo{
    private User extractUser (ResultSet rs) throws SQLException{
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setEmail(rs.getString("email"));
        u.setPassword(rs.getString("password"));
        u.setRole(UserRole.valueOf(rs.getString("role")));
        u.setStatus(UserStatus.valueOf(rs.getString("status")));
        return u;
    }

    @Override
    public boolean insertUser(RegisterUserDTO registerUserDTO) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_user (?,?,?)}")
        ) {
            call.setString(1,registerUserDTO.getUsername());
            call.setString(2,registerUserDTO.getEmail());
            call.setString(3, registerUserDTO.getPassword());

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_find_user_by_email (?)}")
        ) {
            call.setString(1,email);

            try (ResultSet resultSet = call.executeQuery()){
                if(resultSet.next()){
                    return Optional.of(extractUser(resultSet));
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
    public Optional<User> findUserByEmailAndPassword(LoginUserDTO loginUserDTO) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_find_user_by_email_password (?,?)}")
        ) {
            call.setString(1,loginUserDTO.getEmail());
            call.setString(2,loginUserDTO.getPassword());

            try (ResultSet resultSet = call.executeQuery()){
                if(resultSet.next()){
                    return Optional.of(extractUser(resultSet));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return Optional.empty();
    }
}
