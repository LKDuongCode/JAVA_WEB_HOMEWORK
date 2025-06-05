package com.duong.ss19.repository.account;


import com.duong.ss19.entity.account.Account;


import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public class AccountRepoCustomImpl implements AccountRepo {
    private final SessionFactory sessionFactory;

    public AccountRepoCustomImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession (){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Optional<Account> findById(int id) {
        return getSession().createQuery("from Account where id = :p_id",Account.class)
                .setParameter("p_id",id)
                .uniqueResultOptional();
    }

    @Override
    public List<Account> findAllWithPagination(int page, int size) {
        int firstResult = (page-1)*size;

        return getSession().createQuery("from Account ",Account.class)
                .setFirstResult(firstResult)
                .setMaxResults(size)
                .getResultList();
    }


    @Override
    public int countAccount() {
        Long count = getSession()
                .createQuery("select count(a.id) from Account a",Long.class)
                .uniqueResult();
        return count != null ? count.intValue() : 0;
    }

    @Override
    public boolean update(Account account) {
        MutationQuery query = getSession().createMutationQuery(
                "update Account a set a.status = :p_status where a.id = :p_id"
        );

        return query.setParameter("p_id", account.getId())
                .setParameter("p_status", account.getStatus())
                .executeUpdate() > 0;
    }



}
