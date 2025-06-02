package com.duong.ss16.repository.hw04;

import com.duong.ss16.connection.DatabaseConnection;
import com.duong.ss16.dto.hw04.CreateBusTripDTO;
import com.duong.ss16.dto.hw04.UpdateBusTripDTO;
import com.duong.ss16.model.hw04.BusTrip;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BusTripRepoImpl implements BusTripRepo {

    private BusTrip extractResult(ResultSet rs) throws SQLException {
        BusTrip trip = new BusTrip();
        trip.setId(rs.getInt("id"));
        trip.setDeparturePoint(rs.getString("departure_point"));
        trip.setDestination(rs.getString("destination"));
        trip.setDepartureTime(rs.getTimestamp("departure_time").toLocalDateTime());
        trip.setArrivalTime(rs.getTimestamp("arrival_time").toLocalDateTime());
        trip.setBusId(rs.getInt("bus_id"));
        trip.setSeatsAvailable(rs.getInt("seats_available"));
        trip.setImage(rs.getString("image"));
        return trip;
    }

    @Override
    public List<BusTrip> getAll() {
        List<BusTrip> trips = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_all_bus_trip()}")
        ) {
            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()) {
                    trips.add(extractResult(rs));
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi getAll BusTrip: " + e.getMessage());
        }
        return trips;
    }

    @Override
    public Optional<BusTrip> findById(int id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_bus_trip_by_id(?)}")
        ) {
            call.setInt(1, id);
            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(extractResult(rs));
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi findById BusTrip: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public boolean insertBusTrip(CreateBusTripDTO dto) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_bus_trip(?,?,?,?,?,?,?)}")
        ) {
            call.setString(1, dto.getDeparturePoint());
            call.setString(2, dto.getDestination());
            call.setTimestamp(3, Timestamp.valueOf(dto.getDepartureTime()));
            call.setTimestamp(4, Timestamp.valueOf(dto.getArrivalTime()));
            call.setInt(5, dto.getBusId());
            call.setInt(6, dto.getSeatsAvailable());
            call.setString(7, dto.getImage());

            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi insert BusTrip: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateBusTrip(UpdateBusTripDTO dto) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_update_bus_trip(?,?,?,?,?,?,?,?)}")
        ) {
            call.setInt(1, dto.getId());
            call.setString(2, dto.getDeparturePoint());
            call.setString(3, dto.getDestination());
            call.setTimestamp(4, Timestamp.valueOf(dto.getDepartureTime()));
            call.setTimestamp(5, Timestamp.valueOf(dto.getArrivalTime()));
            call.setInt(6, dto.getBusId());
            call.setInt(7, dto.getSeatsAvailable());
            call.setString(8, dto.getImage());

            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi update BusTrip: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteBusTrip(int id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_delete_bus_trip(?)}")
        ) {
            call.setInt(1, id);
            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi delete BusTrip: " + e.getMessage());
        }
        return false;
    }
}
