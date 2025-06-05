package com.duong.ss19.repository.room;

import com.duong.ss19.entity.screenroom.ScreenRoom;
import com.duong.ss19.repository.theater.TheaterRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScreenRoomRepoImpl implements ScreenRoomRepo {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TheaterRepo theaterRepo;

    @Override
    public List<ScreenRoom> findAllActive() {
        return em.createQuery("SELECT s FROM ScreenRoom s WHERE s.status = true", ScreenRoom.class)
                .getResultList();
    }

    @Override
    public ScreenRoom findById(Long id) {
        return em.find(ScreenRoom.class, id);
    }

    @Override
    @Transactional
    public void save(ScreenRoom room) {
        em.persist(room);
    }

    @Override
    @Transactional
    public void update(ScreenRoom room) {
        em.merge(room);
    }

    @Override
    @Transactional
    public void deleteLogic(Long id) {
        ScreenRoom room = findById(id);
        if (room != null) {
            room.setStatus(false);
            update(room);
        }
    }
}
