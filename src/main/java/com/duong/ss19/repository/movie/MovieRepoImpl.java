package com.duong.ss19.repository.movie;

import com.duong.ss19.entity.movie.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepoImpl implements MovieRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Movie> findAll() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    @Override
    public Movie findById(Long id) {
        return em.find(Movie.class, id);
    }

    @Override
    @Transactional
    public void save(Movie movie) {
        em.persist(movie);
    }

    @Override
    @Transactional
    public void update(Movie movie) {
        em.merge(movie);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Movie movie = findById(id);
        if (movie != null) {
            em.remove(movie);
        }
    }

    @Override
    public boolean hasSchedule(Long movieId) {
        Long count = em.createQuery(
                        "SELECT COUNT(s.id) FROM Schedule s WHERE s.movie.id = :id", Long.class)
                .setParameter("id", movieId)
                .getSingleResult();
        return count > 0;
    }
}
