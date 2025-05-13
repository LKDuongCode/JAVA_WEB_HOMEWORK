package com.duong.ss06.dao.hw03;

import com.duong.ss06.model.Product;
import com.duong.ss06.utils.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call sp_get_all_products()}")
        ) {
            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()) {
                    products.add(new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getBigDecimal("price"),
                            rs.getString("image_url")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách sản phẩm: " + e.getMessage());
        }
        return products;
    }

}
