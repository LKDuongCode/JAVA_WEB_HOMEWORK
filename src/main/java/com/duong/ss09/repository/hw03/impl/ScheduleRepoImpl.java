package com.duong.ss09.repository.hw03.impl;

import com.duong.ss09.model.MovieFormat;
import com.duong.ss09.model.Schedule;
import com.duong.ss09.repository.hw03.ScheduleRepo;
import com.duong.ss09.utils.database_config.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleRepoImpl implements ScheduleRepo {

    @Override
    public List<Schedule> findAllScheduleByMovie(Long movieId) {
        List<Schedule> schedules = new ArrayList<>();
        try (
                Connection conn = DatabaseConnection.connectToDatabase();
                CallableStatement call = conn.prepareCall("{call sp_find_schedules_by_movie(?)}")
        ) {
            call.setLong(1, movieId);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule(
                        rs.getLong("id"),
                        rs.getLong("movie_id"),
                        rs.getTimestamp("show_time").toLocalDateTime(),
                        rs.getLong("screen_room_id"),
                        rs.getInt("available_seats"),
                        MovieFormat.valueOf(rs.getString("format"))
                );
                schedules.add(schedule);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi gọi sp_find_schedules_by_movie: " + e.getMessage());
        }
        return schedules;
    }


    @Override
    public Optional<Schedule> findById(Long id) {
        try (
                Connection conn = DatabaseConnection.connectToDatabase();
                CallableStatement call = conn.prepareCall("{call sp_find_schedule_by_id(?)}")
        ) {
            call.setLong(1, id);
            ResultSet rs = call.executeQuery();

            if (rs.next()) {
                Schedule schedule = new Schedule(
                        rs.getLong("id"),
                        rs.getLong("movie_id"),
                        rs.getTimestamp("show_time").toLocalDateTime(),
                        rs.getLong("screen_room_id"),
                        rs.getInt("available_seats"),
                        MovieFormat.valueOf(rs.getString("format"))
                );
                return Optional.of(schedule);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi gọi sp_find_schedule_by_id: " + e.getMessage());
        }

        return Optional.empty();
    }

}
