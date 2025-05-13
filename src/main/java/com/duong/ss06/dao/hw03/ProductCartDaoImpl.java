package com.duong.ss06.dao.hw03;

import com.duong.ss06.model.ProductCart;
import com.duong.ss06.utils.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCartDaoImpl implements ProductCartDao{
    @Override
    public List<ProductCart> getCartByUserId(int userId) {
        List<ProductCart> cartItems = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call sp_get_cart_by_user(?)}");
        ) {
            call.setInt(1, userId);

            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()) {
                    cartItems.add(new ProductCart(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getInt("product_id"),
                            rs.getInt("quantity")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy giỏ hàng: " + e.getMessage());
        }
        return cartItems;
    }

    @Override
    public boolean addToCart(ProductCart cartItem) {
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call add_to_cart(?, ?, ?)}")
        ) {
            call.setInt(1, cartItem.getUserId());
            call.setInt(2, cartItem.getProductId());
            call.setInt(3, cartItem.getQuantity());

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm vào giỏ hàng: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removeFromCart(int cartId) {
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call remove_from_cart(?)}")
        ) {
            call.setInt(1, cartId);

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa khỏi giỏ hàng: " + e.getMessage());
        }
        return false;
    }

}
