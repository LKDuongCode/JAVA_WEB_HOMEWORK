package com.duong.ss12.repository.hw03;

import com.duong.ss12.config.database.DatabaseConnection;
import com.duong.ss12.dto.hw03.CreateBusDTO;
import com.duong.ss12.dto.hw03.UpdateBusDTO;
import com.duong.ss12.model.Bus;
import com.duong.ss12.model.BusType;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BusRepoImpl implements BusRepo {

    private Bus extractResult(ResultSet rs) throws SQLException {
        Bus b = new Bus();
        b.setId(rs.getInt("id"));
        b.setLicensePlate(rs.getString("license_plate"));
        b.setBusType(BusType.valueOf(rs.getString("bus_type")));
        b.setRowSeat(rs.getInt("row_seat"));
        b.setColSeat(rs.getInt("col_seat"));
        b.setTotalSeat(rs.getInt("total_seat"));
        b.setImage(rs.getString("image"));
        return b;
    }

    @Override
    public List<Bus> getAllBus() {
        List<Bus> list = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_all_bus()}")
        ) {
            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()) {
                    list.add(extractResult(rs));
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi getAllBus: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean insertBus(CreateBusDTO dto) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_bus(?,?,?,?,?)}")
        ) {
            call.setString(1, dto.getLicensePlate());
            call.setString(2, dto.getBusType().name());
            call.setInt(3, dto.getRowSeat());
            call.setInt(4, dto.getColSeat());
            call.setString(5, dto.getImage());

            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi insertBus: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateBus(UpdateBusDTO dto) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_update_bus(?,?,?,?,?,?)}")
        ) {
            call.setInt(1, dto.getId());
            call.setString(2, dto.getLicensePlate());
            call.setString(3, dto.getBusType().name());
            call.setInt(4, dto.getRowSeat());
            call.setInt(5, dto.getColSeat());
            call.setString(6, dto.getImage());

            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi updateBus: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteBus(int id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_delete_bus(?)}")
        ) {
            call.setInt(1, id);
            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi deleteBus: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<Bus> findById(int id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_find_bus_by_id(?)}")
        ) {
            call.setInt(1, id);
            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()) return Optional.of(extractResult(rs));
            }
        } catch (Exception e) {
            System.err.println("Lỗi findById: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Bus> findByLicensePlate(String licensePlate) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_find_bus_by_license_plate(?)}")
        ) {
            call.setString(1, licensePlate);
            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()) return Optional.of(extractResult(rs));
            }
        } catch (Exception e) {
            System.err.println("Lỗi findByLicensePlate: " + e.getMessage());
        }
        return Optional.empty();
    }
}
