package com.example.javagroupproject1.data;

import com.example.javagroupproject1.repository.IEntity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "categories")
public class Category implements IEntity {
    public static final String DEFAULT_NAME_VALUE = "Не указанно";

    @DatabaseField(useGetSet = true, generatedId = true)
    private long ID;

    @DatabaseField(useGetSet = true, unique = true)
    private String name;

    public Category() {
    }

    public Category(String name){
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) return;

        this.name = name;
    }
}
