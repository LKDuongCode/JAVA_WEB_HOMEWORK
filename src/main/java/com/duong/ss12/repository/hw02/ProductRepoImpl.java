package com.duong.ss12.repository.hw02;

import com.duong.ss12.config.database.DatabaseConnection;
import com.duong.ss12.dto.hw02.CreateProductDTO;
import com.duong.ss12.dto.hw02.UpdateProductDTO;
import com.duong.ss12.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepoImpl implements ProductRepo{
    private Product extractResult (ResultSet rs) throws SQLException{
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setPrice(rs.getDouble("price"));
        p.setQuantity(rs.getInt("quantity"));
        p.setImage(rs.getString("image"));
        return p;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_all_product ()}")
        ) {
            try (ResultSet rs = call.executeQuery()){
                while(rs.next()){
                    products.add(extractResult(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }

        return products;
    }

    @Override
    public boolean insertProduct(CreateProductDTO createProductDTO) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_product(?,?,?,?)}")
        ) {
            call.setString(1,createProductDTO.getName());
            call.setDouble(2,createProductDTO.getPrice());
            call.setInt(3,createProductDTO.getQuantity());
            call.setString(4,createProductDTO.getFilename());

            return call.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateProduct(UpdateProductDTO updateProductDTO) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_update_product(?,?,?,?,?)}")
        ) {
            call.setInt(1,updateProductDTO.getId());
            call.setString(2,updateProductDTO.getName());
            call.setDouble(3,updateProductDTO.getPrice());
            call.setInt(4,updateProductDTO.getQuantity());
            call.setString(5,updateProductDTO.getImage());

            return call.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_delete_product (?)}")
        ) {
        call.setInt(1,id);

        return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<Product> findById(int id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_find_product_by_id (?)}")
        ) {
            call.setInt(1,id);

            try (ResultSet rs = call.executeQuery()){
                if(rs.next()) return Optional.of(extractResult(rs));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return Optional.empty();
    }
}
