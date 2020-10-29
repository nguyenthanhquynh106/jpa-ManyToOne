package com.example.webday10.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.webday10.entity.Faculty;
import com.example.webday10.repository.FacultyRepository;

@Repository
public class FacultyRepositoryImpl implements FacultyRepository {

	private EntityManager em;

	@Autowired
	public FacultyRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Faculty f) {
		em.persist(f);
	}

}
