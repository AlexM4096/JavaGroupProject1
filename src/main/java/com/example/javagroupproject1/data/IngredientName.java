package com.example.javagroupproject1.data;

import com.example.javagroupproject1.repository.IEntity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ingredient-names")
public class IngredientName implements IEntity {
    public static final String DEFAULT_NAME_VALUE = "Не указанно";

    @DatabaseField(useGetSet = true, generatedId = true)
    private long ID;

    @DatabaseField(useGetSet = true, unique = true)
    private String name;

    public IngredientName() {
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
        this.name = name;
    }
}
