package com.example.javagroupproject1.data;

import com.example.javagroupproject1.repository.IEntity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ingredient-type")
public class IngredientType implements IEntity {

    public static final String INGREDIENT_ID_FIELD_NAME = "ingredientID";

    @DatabaseField(useGetSet = true, generatedId = true)
    private long ID;

    @DatabaseField(useGetSet = true, foreign = true, columnName = INGREDIENT_ID_FIELD_NAME)
    private Ingredient ingredient;

    @DatabaseField(useGetSet = true, unique = true)
    private String name;

    public IngredientType() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
