package com.duong.ss18.repository.bill;

import com.duong.ss18.entity.Bill;
import com.duong.ss18.entity.enums.BillStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class BillRepositoryImpl implements BillRepository {

    private final SessionFactory sessionFactory;

    public BillRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Bill> findAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Bill";
        return session.createQuery(hql, Bill.class).getResultList();
    }

    @Override
    public Optional<Bill> findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Bill b WHERE b.id = :id";
        return session.createQuery(hql, Bill.class)
                .setParameter("id", id)
                .uniqueResultOptional();
    }

    @Override
    public List<Bill> findByAccountId(int accountId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Bill b WHERE b.account.id = :accountId";
        return session.createQuery(hql, Bill.class)
                .setParameter("accountId", accountId)
                .getResultList();
    }

    @Override
    public List<Bill> filter(String username, String status, LocalDate from, LocalDate to, int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder("FROM Bill b WHERE 1=1");

        if (username != null && !username.trim().isEmpty()) {
            hql.append(" AND lower(b.account.username) LIKE :username");
        }

        if (status != null && !status.trim().isEmpty()) {
            hql.append(" AND b.status = :status");
        }

        if (from != null) {
            hql.append(" AND b.createdAt >= :fromDate");
        }

        if (to != null) {
            hql.append(" AND b.createdAt <= :toDate");
        }

        Query<Bill> query = session.createQuery(hql.toString(), Bill.class);

        if (username != null && !username.trim().isEmpty()) {
            query.setParameter("username", "%" + username.toLowerCase() + "%");
        }

        if (status != null && !status.trim().isEmpty()) {
            query.setParameter("status", BillStatus.valueOf(status));
        }

        if (from != null) {
            query.setParameter("fromDate", from.atStartOfDay());
        }

        if (to != null) {
            query.setParameter("toDate", to.atTime(23, 59, 59));
        }

        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);

        return query.getResultList();
    }

    @Override
    public void update(Bill bill) {
        sessionFactory.getCurrentSession().merge(bill);
    }

}
