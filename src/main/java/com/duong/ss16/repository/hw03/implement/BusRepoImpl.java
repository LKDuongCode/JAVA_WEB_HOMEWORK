package com.duong.ss16.repository.hw03.implement;

import com.duong.ss16.connection.DatabaseConnection;
import com.duong.ss16.dto.hw03.CreateBusDTO;
import com.duong.ss16.dto.hw03.UpdateBusDTO;
import com.duong.ss16.model.hw03.Bus;
import com.duong.ss16.model.hw03.BusType;
import com.duong.ss16.repository.hw03.BusRepo;
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
    private Bus extractResult (ResultSet rs) throws SQLException{
        Bus b = new Bus();
        b.setId(rs.getInt("id"));
        b.setLicensePlate(rs.getString("license_plate"));
        b.setType(BusType.valueOf(rs.getString("type")));
        b.setRowSeat(rs.getInt("row_seat"));
        b.setColSeat(rs.getInt("col_seat"));
        b.setImage(rs.getString("image"));
        return b;
    }

    @Override
    public List<Bus> getAll() {
        List<Bus> buses = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_all_bus ()}")
        ) {
            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()){
                    buses.add(extractResult(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return buses;
    }

    @Override
    public boolean insertBus(CreateBusDTO createBusDTO) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_bus(?,?,?,?,?)}")
        ) {
            call.setString(1, createBusDTO.getLicensePlate());
            call.setString(2, createBusDTO.getType().toString());
            call.setInt(3, createBusDTO.getRowSeat());
            call.setInt(4, createBusDTO.getColSeat());
            call.setString(5, createBusDTO.getImage());

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateBus(UpdateBusDTO updateBusDTO) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_update_bus(?,?,?,?,?,?)}")
        ) {
            call.setInt(1, updateBusDTO.getId());
            call.setString(2, updateBusDTO.getLicensePlate());
            call.setString(3, updateBusDTO.getType().toString());
            call.setInt(4, updateBusDTO.getRowSeat());
            call.setInt(5, updateBusDTO.getColSeat());
            call.setString(6, updateBusDTO.getImage());

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
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

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<Bus> getLastBus() {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_last_bus ()}")
        ) {
            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()){
                    return Optional.of(extractResult(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return Optional.empty();
    }


    @Override
    public Optional<Bus> findById(int id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_bus_by_id(?)}")
        ) {
            call.setInt(1, id);
            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()) {
                    Bus b = extractResult(rs);
                    return Optional.of(b);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }

        return Optional.empty();
    }

}
