package com.duong.ss11.repository.hw10;


import com.duong.ss11.config.database.DatabaseConnection;
import com.duong.ss11.model.Movie;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    public void insertMovie(Movie movie) {
        try (
                Connection conn = DatabaseConnection.connection();
                CallableStatement call = conn.prepareCall("{call sp_add_movie(?, ?, ?, ?, ?)}")
        ) {
            call.setString(1, movie.getTitle());
            call.setString(2, movie.getDirector());
            call.setDate(3, Date.valueOf(movie.getReleaseDate()));
            call.setString(4, movie.getGenre());
            call.setString(5, movie.getPoster());
            call.executeUpdate();
        } catch (Exception e) {
            System.err.println("Lỗi khi thêm movie: " + e.getMessage());
        }
    }

    public void updateMovie(Movie movie) {
        try (
                Connection conn = DatabaseConnection.connection();
                CallableStatement call = conn.prepareCall("{call sp_update_movie(?, ?, ?, ?, ?, ?)}")
        ) {
            call.setInt(1, movie.getId());
            call.setString(2, movie.getTitle());
            call.setString(3, movie.getDirector());
            call.setDate(4, Date.valueOf(movie.getReleaseDate()));
            call.setString(5, movie.getGenre());
            call.setString(6, movie.getPoster());
            call.executeUpdate();
        } catch (Exception e) {
            System.err.println("Lỗi khi cập nhật movie: " + e.getMessage());
        }
    }

    public void deleteMovie(int id) {
        try (
                Connection conn = DatabaseConnection.connection();
                CallableStatement call = conn.prepareCall("{call sp_delete_movie(?)}")
        ) {
            call.setInt(1, id);
            call.executeUpdate();
        } catch (Exception e) {
            System.err.println("Lỗi khi xoá movie: " + e.getMessage());
        }
    }

    public List<Movie> findAllMovies() {
        List<Movie> list = new ArrayList<>();
        try (
                Connection conn = DatabaseConnection.connection();
                CallableStatement call = conn.prepareCall("{call sp_get_all_movies()}")
        ) {
            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie();
                    movie.setId(rs.getInt("id"));
                    movie.setTitle(rs.getString("title"));
                    movie.setDirector(rs.getString("director"));
                    movie.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
                    movie.setGenre(rs.getString("genre"));
                    movie.setPoster(rs.getString("poster"));
                    list.add(movie);
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy danh sách movie: " + e.getMessage());
        }
        return list;
    }

    public Movie findMovieById(int id) {
        Movie movie = null;
        try (
                Connection conn = DatabaseConnection.connection();
                CallableStatement call = conn.prepareCall("{call sp_get_movie_by_id(?)}")
        ) {
            call.setInt(1, id);
            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()) {
                    movie = new Movie();
                    movie.setId(rs.getInt("id"));
                    movie.setTitle(rs.getString("title"));
                    movie.setDirector(rs.getString("director"));
                    movie.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
                    movie.setGenre(rs.getString("genre"));
                    movie.setPoster(rs.getString("poster"));
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy movie theo ID: " + e.getMessage());
        }
        return movie;
    }
}
