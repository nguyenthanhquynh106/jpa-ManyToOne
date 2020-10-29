package com.example.webday10.repository;

import com.example.webday10.entity.Passport;

public interface PassportRepository {

    public Passport findById(int id);

    public void insert(Passport p);
}
