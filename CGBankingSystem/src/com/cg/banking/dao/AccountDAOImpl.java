package com.cg.banking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.banking.beans.Account;

public class AccountDAOImpl implements AccountDAO {
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
    
    @Override
    public Account save(Account account) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        entityManager.close();
        return account;
    }

    @Override
    public boolean update(Account account) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(account);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public Account findOne(long accountNo) {
        return entityManagerFactory.createEntityManager().find(Account.class, accountNo);
    }

    @Override
    public List<Account> findAll() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Account a").getResultList();
    }
}
