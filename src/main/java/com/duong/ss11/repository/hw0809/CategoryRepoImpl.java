package com.duong.ss11.repository.hw0809;

import com.duong.ss11.config.database.DatabaseConnection;
import com.duong.ss11.model.Category;
import com.duong.ss11.model.CategoryStatus;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepoImpl implements CategoryRepo {
    @Override
    public Optional<Category> findCategoryByName(String name) {
        try (
                Connection conn = DatabaseConnection.connection();
                CallableStatement call = conn.prepareCall("{call sp_check_category_exists(?)}")
        ) {
            call.setString(1, name);
            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()) {
                    Category category = new Category();
                    category.setId(rs.getInt("id"));
                    category.setName(rs.getString("name"));
                    category.setStatus(CategoryStatus.valueOf(rs.getString("status")));
                    return Optional.of(category);
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi tìm category theo tên: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void insertCategory(String name) {
        try (
                Connection conn = DatabaseConnection.connection();
                CallableStatement call = conn.prepareCall("{call sp_insert_category(?)}")
        ) {
            call.setString(1, name);
            call.executeUpdate();
        } catch (Exception e) {
            System.err.println("Lỗi khi thêm category: " + e.getMessage());
        }
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> list = new ArrayList<>();
        try (
                Connection conn = DatabaseConnection.connection();
                CallableStatement call = conn.prepareCall("{call sp_get_all_categories()}")
        ) {
            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()) {
                    Category category = new Category();
                    category.setId(rs.getInt("id"));
                    category.setName(rs.getString("name"));
                    category.setStatus(CategoryStatus.valueOf(rs.getString("status")));
                    list.add(category);
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy danh sách category: " + e.getMessage());
        }
        return list;
    }


    @Override
    public Optional<Category> findById(int id) {
        try (
                Connection conn = DatabaseConnection.connection();
                CallableStatement call = conn.prepareCall("{call sp_get_category_by_id(?)}")
        ) {
            call.setInt(1, id);
            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()) {
                    Category category = new Category();
                    category.setId(rs.getInt("id"));
                    category.setName(rs.getString("name"));
                    category.setStatus(CategoryStatus.valueOf(rs.getString("status")));
                    return Optional.of(category);
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi tìm category theo id: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void update(Category category) {
        try (
                Connection conn = DatabaseConnection.connection();
                CallableStatement call = conn.prepareCall("{call sp_update_category(?, ?)}")
        ) {
            call.setInt(1, category.getId());
            call.setString(2, category.getName());
            call.executeUpdate();
        } catch (Exception e) {
            System.err.println("Lỗi khi cập nhật category: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try (
                Connection conn = DatabaseConnection.connection();
                CallableStatement call = conn.prepareCall("{call sp_delete_category(?)}")
        ) {
            call.setInt(1, id);
            call.executeUpdate();
        } catch (Exception e) {
            System.err.println("Lỗi khi xoá category: " + e.getMessage());
        }
    }

}
