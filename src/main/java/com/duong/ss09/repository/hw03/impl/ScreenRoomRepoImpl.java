package com.duong.ss09.repository.hw03.impl;

import com.duong.ss09.model.ScreenRoom;
import com.duong.ss09.repository.hw03.ScreenRoomRepo;
import com.duong.ss09.utils.database_config.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ScreenRoomRepoImpl implements ScreenRoomRepo {

    @Override
    public List<ScreenRoom> findAll() {
        List<ScreenRoom> rooms = new ArrayList<>();
        try (
                Connection conn = DatabaseConnection.connectToDatabase();
                CallableStatement call = conn.prepareCall("{call sp_find_all_screen_rooms()}")
        ) {
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                rooms.add(new ScreenRoom(
                        rs.getLong("id"),
                        rs.getString("screen_room_name"),
                        rs.getInt("total_seat")
                ));
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi gọi sp_find_all_screen_rooms: " + e.getMessage());
        }
        return rooms;
    }

    @Override
    public Optional<ScreenRoom> findById(Long id) {
        try (
                Connection conn = DatabaseConnection.connectToDatabase();
                CallableStatement call = conn.prepareCall("{call sp_find_screen_room_by_id(?)}")
        ) {
            call.setLong(1, id);
            ResultSet rs = call.executeQuery();
            if (rs.next()) {
                ScreenRoom room = new ScreenRoom(
                        rs.getLong("id"),
                        rs.getString("screen_room_name"),
                        rs.getInt("total_seat")
                );
                return Optional.of(room);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi gọi sp_find_screen_room_by_id: " + e.getMessage());
        }
        return Optional.empty();
    }
}