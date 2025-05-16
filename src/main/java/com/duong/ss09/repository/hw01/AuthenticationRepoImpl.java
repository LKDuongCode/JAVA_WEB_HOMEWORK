package com.duong.ss09.repository.hw01;

import com.duong.ss09.model.Customer;
import com.duong.ss09.model.Gender;
import com.duong.ss09.utils.database_config.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class AuthenticationRepoImpl implements AuthenticationRepo{
    @Override
    public Optional<Customer> findByUsername(String username) {
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call sp_find_customer_by_username(?)}")
        ) {
            call.setString(1, username);
            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setUsername(rs.getString("username"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPassword(rs.getString("password"));
                    customer.setPhone(rs.getString("phone"));
                    customer.setGender(Gender.valueOf(rs.getString("gender")));
                    customer.setAddress(rs.getString("address"));
                    return Optional.of(customer);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm customer theo username: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi khác: " + e.getMessage());
        }
        return Optional.empty();
    }

}
