package com.duong.ss20.repository;

import com.duong.ss20.entity.Seed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class SeedRepoImpl implements SeedRepo{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Seed> getAll(int page, int pageSize) {
        int firstResult = (page- 1)*pageSize;
        return em.createQuery("from Seed",Seed.class)
                .setFirstResult(firstResult)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    public int count() {
        Long count =  em.createQuery("select count(s) from Seed s",Long.class).getSingleResult();
        return count != null ? count.intValue() : 0;
    }

    @Override
    public boolean insert(Seed seed) {
        try {
            em.persist(seed);
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Seed seed) {
        try {
             em.merge(seed);
             return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Seed seed) {
        try {
            em.remove(seed);
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<Seed> findByName(String name) {
        try {
            Seed seed = em.createQuery("from Seed where lower(name) = :p_name", Seed.class)
                    .setParameter("p_name", name.toLowerCase())
                    .getSingleResult();
            return Optional.of(seed);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }


    @Override
    public Optional<Seed> findById(int id) {
        Seed seed = em.find(Seed.class, id);
        return Optional.ofNullable(seed);
    }

    @Override
    public List<Seed> findByNameLike(String name) {
        return em.createQuery("from Seed where name like concat('%',:p_name,'%')",Seed.class)
                .setParameter("p_name",name)
                .getResultList();
    }

    @Override
    public List<Seed> searchByFilter(String name, double min, double max) {
        boolean hasName = name != null && !name.isBlank();
        boolean hasMin = min > 0;
        boolean hasMax = max > 0;

        StringBuilder jpql = new StringBuilder("from Seed where 1=1");

        if (hasName) {
            jpql.append(" and lower(name) like :name");
        }
        if (hasMin) {
            jpql.append(" and price >= :min");
        }
        if (hasMax) {
            jpql.append(" and price <= :max");
        }

        var query = em.createQuery(jpql.toString(), Seed.class);

        if (hasName) {
            query.setParameter("name", "%" + name.toLowerCase() + "%");
        }
        if (hasMin) {
            query.setParameter("min", min);
        }
        if (hasMax) {
            query.setParameter("max", max);
        }

        return query.getResultList();
    }

}
