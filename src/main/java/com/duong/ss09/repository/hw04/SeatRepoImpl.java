package com.duong.ss09.repository.hw04;

import com.duong.ss09.model.Seat;
import com.duong.ss09.model.SeatStatus;
import com.duong.ss09.utils.database_config.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SeatRepoImpl implements SeatRepo {

    @Override
    public List<Seat> findByScreenRoomId(Long roomId) {
        List<Seat> seats = new ArrayList<>();

        try (
                Connection conn = DatabaseConnection.connectToDatabase();
                CallableStatement call = conn.prepareCall("{call sp_find_seats_by_screen_room(?)}")
        ) {
            call.setLong(1, roomId);
            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                Seat seat = new Seat();
                seat.setId(rs.getLong("id"));
                seat.setScreenRoomId(rs.getLong("screen_room_id"));
                seat.setPrice(rs.getDouble("price"));
                seat.setStatus(SeatStatus.valueOf(rs.getString("status")));

                seats.add(seat);
            }

        } catch (Exception e) {
            System.err.println("Lỗi khi lấy danh sách ghế: " + e.getMessage());
        }

        return seats;
    }
}