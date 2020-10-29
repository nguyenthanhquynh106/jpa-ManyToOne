package com.example.webday10.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.webday10.entity.Passport;
import com.example.webday10.repository.PassportRepository;

@Repository
public class PassportRepositoryImpl implements PassportRepository {

    private EntityManager em;

    @Autowired
    public PassportRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Passport findById(int id) {
        return em.find(Passport.class, id);
    }

    @Override
    public void insert(Passport p) {
        em.persist(p);
    }

}
