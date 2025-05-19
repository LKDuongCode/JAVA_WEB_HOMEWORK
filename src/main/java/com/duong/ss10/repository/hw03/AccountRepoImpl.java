package com.duong.ss10.repository.hw03;

import com.duong.ss10.config.database.DataBaseConnection;
import com.duong.ss10.model.Account;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class AccountRepoImpl implements AccountRepo {
    @Override
    public Optional<Account> insertAccount(Account a) {
        try (
                Connection c = DataBaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_user(?,?,?)}")
        ) {
            call.setString(1, a.getUsername());
            call.setString(2,a.getEmail());
            call.setString(3,a.getPassword());

            if(call.executeUpdate() > 0){
                return Optional.of(a);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
            e.fillInStackTrace();
        }
        return Optional.empty();
    }
}
