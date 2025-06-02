package com.duong.ss16.repository.hw05;

import com.duong.ss16.connection.DatabaseConnection;
import com.duong.ss16.dto.hw05.CreateTicketDTO;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

@Repository
public class TicketRepoImpl implements TicketRepo {
    @Override
    public boolean insertTicket(CreateTicketDTO dto) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_ticket(?,?,?,?,?)}")
        ) {
            call.setInt(1, dto.getUserId());
            call.setInt(2, dto.getTripBusId());
            call.setString(3, dto.getListSeat());
            call.setDouble(4, dto.getTotalMoney());
            call.setDate(5, Date.valueOf(dto.getDepartureDate()));

            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Insert Ticket Failed: " + e.getMessage());
        }
        return false;
    }
}
