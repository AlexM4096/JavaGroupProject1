package com.example.javagroupproject1.repository;

import com.example.javagroupproject1.dao.DaoContext;

public abstract class RepositoryBase {
    public final DaoContext dc;
    protected RepositoryBase(DaoContext dc){
        this.dc = dc;
    }
}
