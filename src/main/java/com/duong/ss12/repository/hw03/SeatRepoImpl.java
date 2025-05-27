package com.duong.ss12.repository.hw03;

import com.duong.ss12.config.database.DatabaseConnection;
import com.duong.ss12.dto.hw03.CreateSeatDTO;
import com.duong.ss12.dto.hw03.UpdateSeatDTO;
import com.duong.ss12.model.Seat;
import com.duong.ss12.model.SeatStatus;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SeatRepoImpl implements SeatRepo {

    private Seat extractResult(ResultSet rs) throws SQLException {
        Seat s = new Seat();
        s.setId(rs.getInt("id"));
        s.setNameSeat(rs.getString("name_seat"));
        s.setPrice(rs.getInt("price"));
        s.setBusId(rs.getInt("bus_id"));
        s.setStatus(SeatStatus.valueOf(rs.getString("status")));
        return s;
    }

    @Override
    public List<Seat> getSeatsByBusId(int busId) {
        List<Seat> list = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_seat_by_bus_id(?)}")
        ) {
            call.setInt(1, busId);
            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()) {
                    list.add(extractResult(rs));
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi getSeatsByBusId: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean insertSeat(CreateSeatDTO dto) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_seat(?,?,?,?)}")
        ) {
            call.setString(1, dto.getNameSeat());
            call.setInt(2, dto.getPrice());
            call.setInt(3, dto.getBusId());
            call.setString(4, dto.getStatus().name());

            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi insertSeat: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateSeat(UpdateSeatDTO dto) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_update_seat(?,?,?,?)}")
        ) {
            call.setInt(1, dto.getId());
            call.setString(2, dto.getNameSeat());
            call.setInt(3, dto.getPrice());
            call.setString(4, dto.getStatus().name());

            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi updateSeat: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteSeatById(int id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_delete_seat_by_id(?)}")
        ) {
            call.setInt(1, id);
            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi deleteSeatById: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteSeatsByBusId(int busId) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_delete_seat_by_bus_id(?)}")
        ) {
            call.setInt(1, busId);
            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi deleteSeatsByBusId: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<Seat> findById(int id) {
        try (
                Connection c = DatabaseConnection.connection();
                PreparedStatement ps = c.prepareStatement("SELECT * FROM seat WHERE id = ?")
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Seat s = extractResult(rs);
                    return Optional.of(s);
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi findById seat: " + e.getMessage());
        }
        return Optional.empty();
    }

}
