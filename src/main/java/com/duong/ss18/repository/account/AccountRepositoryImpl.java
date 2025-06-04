package com.duong.ss18.repository.account;

import com.duong.ss18.entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final SessionFactory sessionFactory;

    public AccountRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Account> findAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Account";
        return session.createQuery(hql, Account.class).getResultList();
    }

    @Override
    public Optional<Account> findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Account a WHERE a.id = :id";
        return session.createQuery(hql, Account.class)
                .setParameter("id", id)
                .uniqueResultOptional();
    }

    @Override
    public List<Account> findAllWithPagination(int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Account";
        return session.createQuery(hql, Account.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public List<Account> searchByUsername(String keyword, int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Account a WHERE a.username LIKE :keyword";
        return session.createQuery(hql, Account.class)
                .setParameter("keyword", "%" + keyword + "%")
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public void update(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(account);
    }
}


