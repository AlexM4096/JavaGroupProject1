package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.dao.DaoContext;

public abstract class Repository {
    public final DaoContext dc;
    protected Repository(DaoContext dc){
        this.dc = dc;
    }
}
