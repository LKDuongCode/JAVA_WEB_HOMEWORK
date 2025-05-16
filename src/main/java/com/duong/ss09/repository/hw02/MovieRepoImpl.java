package com.duong.ss09.repository.hw02;


import com.duong.ss09.model.Movie;
import com.duong.ss09.utils.database_config.DatabaseConnection;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepoImpl implements MovieRepo {

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call sp_get_all_movies()}")
        ) {
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                movies.add(mapResultSetToMovie(rs));
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi gọi sp_get_all_movies: " + e.getMessage());
        }

        return movies;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        try (
                Connection c = DatabaseConnection.connectToDatabase();
                CallableStatement call = c.prepareCall("{call sp_find_movie_by_id(?)}")
        ) {
            call.setLong(1, id);
            ResultSet rs = call.executeQuery();

            if (rs.next()) {
                return Optional.of(mapResultSetToMovie(rs));
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi gọi sp_find_movie_by_id: " + e.getMessage());
        }

        return Optional.empty();
    }

    private Movie mapResultSetToMovie(ResultSet rs) throws SQLException {
        return new Movie(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("director"),
                rs.getString("genre"),
                rs.getString("description"),
                rs.getInt("duration"),
                rs.getString("language")
        );
    }
}
