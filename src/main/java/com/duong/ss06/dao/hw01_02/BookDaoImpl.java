package com.duong.ss06.dao.hw01_02;

import com.duong.ss06.model.Book;
import com.duong.ss06.utils.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDAO {

    @Override
    public List<Book> getBooks() {
        List<Book> resultList = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call sp_get_all_book ()}")
        ) {
            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setCategory(rs.getString("category"));
                b.setQuantity(rs.getInt("quantity"));
                resultList.add(b);
            }

            if (resultList.isEmpty()) System.err.println("empty");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }

        return resultList;
    }

    @Override
    public boolean insert(Book b) {
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call sp_insert_book(?,?,?,?)}")
        ) {
            call.setString(1, b.getTitle());
            call.setString(2, b.getAuthor());
            call.setString(3, b.getCategory());
            call.setInt(4, b.getQuantity());

            int result = call.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean update(Book b) {
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call sp_update_book (?,?,?,?,?) }")
        ) {
            call.setInt(1, b.getId());
            call.setString(2, b.getTitle());
            call.setString(3, b.getAuthor());
            call.setString(4, b.getCategory());
            call.setInt(5, b.getQuantity());

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call sp_delete_book (?)}")
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
}
