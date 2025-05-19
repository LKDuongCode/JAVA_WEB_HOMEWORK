package com.duong.ss10.repository.hw06;

import com.duong.ss10.config.database.DataBaseConnection;
import com.duong.ss10.model.UploadFile;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UploadFileRepoImpl implements UploadFileRepo {
    @Override
    public Optional<UploadFile> insertUploadFile(UploadFile uploadFile) {
        try (
                Connection c = DataBaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_file_info (?,?) }")
        ) {
            call.setString(1,uploadFile.getUrl());
            call.setString(2, uploadFile.getDes());

            if(call.executeUpdate()>0){
                return Optional.of(uploadFile);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }

        return Optional.empty();
    }
}
