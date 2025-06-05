package com.duong.ss19.repository.theater;

import com.duong.ss19.entity.theater.Theater;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TheaterRepoImpl implements TheaterRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Theater> findAll() {
        return em.createQuery("SELECT t FROM Theater t", Theater.class).getResultList();
    }

    @Override
    public Theater findById(Long id) {
        return em.find(Theater.class, id);
    }

    @Override
    @Transactional
    public void save(Theater theater) {
        em.persist(theater);
    }

    @Override
    @Transactional
    public void update(Theater theater) {
        em.merge(theater);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Theater t = findById(id);
        if (t != null) {
            em.remove(t);
        }
    }

    @Override
    public boolean hasSchedule(Long theaterId) {
        Long count = em.createQuery("SELECT COUNT(s.id) FROM Schedule s WHERE s.screenRoom.theater.id = :id", Long.class)
                .setParameter("id", theaterId)
                .getSingleResult();
        return count > 0;
    }
}
