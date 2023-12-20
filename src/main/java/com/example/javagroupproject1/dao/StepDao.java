package com.example.javagroupproject1.dao;

import com.example.javagroupproject1.data.Step;
import com.j256.ormlite.dao.BaseDaoImpl;

import java.sql.SQLException;

public class StepDao extends BaseDaoImpl<Step, Long> {
    protected StepDao(Class<Step> dataClass) throws SQLException {
        super(dataClass);
    }
}
