package com.duong.ss14.repository.hw10;

import com.duong.ss14.connection.DatabaseConnection;
import com.duong.ss14.dto.hw10.CreateLangDTO;
import com.duong.ss14.model.Category;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getInt("id"),
                rs.getString("categoryName"),
                rs.getString("description")
        );
    }

    @Override
    public List<Category> getAllCategoriesVi() {
        List<Category> list = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_all_categories_vi()}")
        ) {
            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()) {
                    list.add(extractCategory(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Category> getAllCategoriesEn() {
        List<Category> list = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_all_categories_en()}")
        ) {
            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()) {
                    list.add(extractCategory(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean insertCategoryVi(CreateLangDTO dto) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_category_vi (?, ?)}")
        ) {
            call.setString(1, dto.getCategoryName());
            call.setString(2, dto.getDescription());
            return call.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean insertCategoryEn(CreateLangDTO dto) {

        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_category_en (?, ?)}")
        ) {
            call.setString(1, dto.getCategoryName());
            call.setString(2, dto.getDescription());
            return call.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
