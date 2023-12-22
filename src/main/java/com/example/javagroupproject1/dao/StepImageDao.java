package com.example.javagroupproject1.dao;

import com.example.javagroupproject1.data.StepImage;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class StepImageDao extends BaseDaoImpl<StepImage, Long> {
    public StepImageDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, StepImage.class);
    }
}
