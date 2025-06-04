package com.duong.ss18.repository.order_detail;

import com.duong.ss18.entity.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderDetailRepositoryImpl implements OrderDetailRepository {

    private final SessionFactory sessionFactory;

    public OrderDetailRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<OrderDetail> findAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM OrderDetail";
        return session.createQuery(hql, OrderDetail.class).getResultList();
    }

    @Override
    public Optional<OrderDetail> findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM OrderDetail o WHERE o.id = :id";
        return session.createQuery(hql, OrderDetail.class)
                .setParameter("id", id)
                .uniqueResultOptional();
    }

    @Override
    public List<OrderDetail> findByBillId(int billId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM OrderDetail o WHERE o.bill.id = :billId";
        return session.createQuery(hql, OrderDetail.class)
                .setParameter("billId", billId)
                .getResultList();
    }
}

