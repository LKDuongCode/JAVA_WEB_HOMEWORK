package com.duong.ss09.repository.hw04;

import com.duong.ss09.model.Ticket;
import com.duong.ss09.utils.database_config.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class TicketRepoImpl implements TicketRepo {

    @Override
    public void addTicket(Ticket ticket) {
        try (
                Connection conn = DatabaseConnection.connectToDatabase();
                CallableStatement call = conn.prepareCall("{call sp_add_ticket(?, ?, ?)}")
        ) {
            call.setLong(1, ticket.getCustomerId());
            call.setLong(2, ticket.getScheduleId());
            call.setDouble(3, ticket.getTotalMoney());

            call.executeUpdate();

        } catch (Exception e) {
            System.err.println("Lỗi khi thêm ticket: " + e.getMessage());
        }
    }
}