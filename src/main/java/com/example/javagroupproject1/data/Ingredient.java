package com.example.javagroupproject1.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ingredients")
public class Ingredient {
    //region Fields

    @DatabaseField(useGetSet = true, generatedId = true)
    private long ID;

    @DatabaseField(useGetSet = true, foreign = true, foreignAutoCreate = true)
    private IngredientType type;

    @DatabaseField(useGetSet = true)
    private String name;

    @DatabaseField(useGetSet = true)
    private int amount;

    @DatabaseField(useGetSet = true)
    private String amountOf;

    //endregion

    //region Properties

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAmountOf() {
        return amountOf;
    }

    public void setAmountOf(String amountOf) {
        this.amountOf = amountOf;
    }

    public IngredientType getType() {
        return type;
    }

    public void setType(IngredientType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion
}
