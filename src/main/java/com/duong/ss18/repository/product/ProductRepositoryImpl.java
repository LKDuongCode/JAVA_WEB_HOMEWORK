package com.duong.ss18.repository.product;

import com.duong.ss18.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final SessionFactory sessionFactory;

    public ProductRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product";
        return session.createQuery(hql, Product.class).getResultList();
    }

    @Override
    public Optional<Product> findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product p WHERE p.id = :id";
        return session.createQuery(hql, Product.class)
                .setParameter("id", id)
                .uniqueResultOptional();
    }

    @Override
    public void save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(product);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.remove(product);
        }
    }

    @Override
    public List<Product> findAllWithPagination(int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product";
        return session.createQuery(hql, Product.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }
}
