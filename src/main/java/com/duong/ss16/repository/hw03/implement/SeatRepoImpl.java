package com.duong.ss16.repository.hw03.implement;

import com.duong.ss16.connection.DatabaseConnection;
import com.duong.ss16.dto.hw03.CreateSeatDTO;
import com.duong.ss16.repository.hw03.SeatRepo;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


@Repository
public class SeatRepoImpl implements SeatRepo {
    @Override
    public boolean insertSeat(CreateSeatDTO createSeatDTO) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_seat (?,?,?,?) }")
        ) {

            call.setString(1,createSeatDTO.getName());
            call.setDouble(2,createSeatDTO.getPrice());
            call.setString(3,createSeatDTO.getStatus().toString());
            call.setInt(4,createSeatDTO.getBusId());

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteSeatByBusId(int busId) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_delete_seat_by_bus_id (?)}")
        ) {
            call.setInt(1, busId);

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }
}
